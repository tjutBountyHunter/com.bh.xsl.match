package xsl.match.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xsl.Utils.JedisUtils;
import com.xsl.Utils.JsonUtils;
import com.xsl.Utils.MatchArrayUtils;
import com.xsl.Utils.ResultUtils;
import com.xsl.annotation.DeleteMatch;
import com.xsl.annotation.UpdateMatch;
import com.xsl.enums.DataStates;
import com.xsl.enums.MatchForm;
import com.xsl.enums.MatchState;
import com.xsl.enums.ResultCode;
import com.xsl.pojo.XslMatch;
import com.xsl.pojo.Example.XslMatchExample;
import com.xsl.result.EasyUIDataGridResult;
import com.xsl.result.XslResult;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import xsl.match.mapper.XslMatchMapper;
import xsl.match.service.XslMatchService;

import java.util.*;

/**
 * 说明：比赛信息相关操作
 *
 * @Auther: 11432_000
 * @Date: 2019/4/21 14:19
 * @Description:
 */
@Service
public class XslMatchServiceImpl implements XslMatchService {

    private static final Logger LOGGER = LoggerFactory.getLogger(XslMatchServiceImpl.class);

    private static final String FORM_KEY = "matchForm";
    private static final String FORM_INFO = "matchFormName";

    private static final String MATCH_STATE_KEY = "matchState";
    private static final String MATCH_STATE_INFO = "matchStateInfo";

    @Autowired
    XslMatchMapper xslMatchMapper;

    @Value("MATCH_BUFFER_PREFIX")
    private String MATCH_BUFFER_PREFIX;
    @Value("${MATCH_LIST}")
    private String MATCH_LIST;
    @Value("${MATCH_LIST_BY_TYPE}")
    private String MATCH_LIST_BY_TYPE;
    @Value("${MATCH_LIST_BY_RANK}")
    private String MATCH_LIST_BY_RANK;
    @Value("${MATCH_LIST_BY_STATE}")
    private String MATCH_LIST_BY_STATE;


    /**
     *
     * 功能描述: 获取所有参赛形式
     *
     * @param: []
     * @return: java.util.List<java.util.HashMap<java.lang.String,java.lang.String>>
     * @auther: 11432_000
     * @date: 2019/4/21 14:25
     */
    @Override
    public List<HashMap<String,String>> getAllForm() throws RuntimeException{
        ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> map;
        for (MatchForm matchForm : MatchForm.values()){
            map = new HashMap<String, String>(2);
            map.put(FORM_KEY,"" + matchForm.getKey());
            map.put(FORM_INFO,matchForm.getValue());
            list.add(map);
        }
        return list;
    }
    /**
     *
     * 功能描述: 添加一条比赛信息 200 - 成功  500 - 失败
     *
     * @param: [xslMatch]
     * @return: com.xsl.result.XslResult
     * @auther: 11432_000
     * @date: 2019/4/21 20:38
     */
    @Override
    @UpdateMatch
    public XslResult addMatch(XslMatch xslMatch)throws RuntimeException {
        //生成比赛ID
        String uuid = UUID.randomUUID().toString();
        String matchId = "M" + uuid;
        xslMatch.setMatchid(matchId);
        //根据当前时间设置比赛状态
        if (xslMatch.getMatchsignupstarttime().compareTo(new Date()) <= 0){
            xslMatch.setMatchstate(MatchState.SIGN_UP.getKey());
        }else {
            xslMatch.setMatchstate(MatchState.BEFORE_SIGN_UP.getKey());
        }
        try{
            int insert = xslMatchMapper.insert(xslMatch);
            if (insert <= 0){
                LOGGER.error("addAMatch() 添加数据失败");
                return ResultUtils.isError("XslMatch插入失败");
            }
            LOGGER.info("添加数据 matchId =" + matchId + " 成功");
            return ResultUtils.isOk(matchId);
        }catch (Exception e){
            throw new RuntimeException("添加比赛信息异常:"+ e.getMessage());
        }
    }

    /**
     *
     * 功能描述: 获取比赛列表(分页)
     *
     * @param: [page, rows]
     * @return: com.xsl.result.EasyUIDataGridResult
     * @auther: 11432_000
     * @date: 2019/4/22 13:35
     */
    @Override
    public XslResult getMatchPage(Integer page, Integer rows)throws RuntimeException {
        //查询所有比赛信息
        try {
            ArrayList<XslMatch> matchPage = new ArrayList<>();
            List<XslMatch> allMatch = getAllMatch(MATCH_LIST);
            EasyUIDataGridResult result = new EasyUIDataGridResult();
            for (int i = (page - 1) * rows; i < page * rows && i < allMatch.size(); i++) {
                matchPage.add(allMatch.get(i));
            }
            result.setRows(matchPage);
            //获取记录数
            result.setTotal(allMatch.size());
            return ResultUtils.isOk(result);
        }catch (Exception e){
            throw new RuntimeException("获取比赛信息列表异常:"  + e.getMessage());
        }
    }
    @Override
    public XslResult getMatchList() throws RuntimeException {
        /**
         *
         * 功能描述: 获取比赛列表(不分页)
         *
         * @param: []
         * @return: com.xsl.result.XslResult
         * @auther: 11432_000
         * @date: 2019/4/28 11:27
         */
        try {
            List<XslMatch> xslMatches = getAllMatch(MATCH_LIST);
            return ResultUtils.isOk(xslMatches);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     *
     * 功能描述: 更新一条比赛信息
     *
     * @param: [xslMatch]
     * @return: com.xsl.result.XslResult
     * @auther: 11432_000
     * @date: 2019/4/22 19:26
     */
    @Override
    @UpdateMatch
    public XslResult updateMatchInfo(XslMatch xslMatch) throws RuntimeException{
        try{
            XslMatchExample xslMatchExample = new XslMatchExample();
            XslMatchExample.Criteria criteria = xslMatchExample.createCriteria();
            criteria.andMatchidEqualTo(xslMatch.getMatchid());

            int i = xslMatchMapper.updateByExampleSelective(xslMatch,xslMatchExample);
            if (i <= 0){
                LOGGER.error("updateAMatchInfo 更新数据 matchId =" + xslMatch.getMatchid() + " 失败");
                return ResultUtils.isError("更新数据失败");
            }
            LOGGER.info("更新数据 matchId =" + xslMatch.getMatchid() + " 成功");
            return ResultUtils.isOk(xslMatch.getMatchid());
        }catch (Exception e){
            throw new RuntimeException("更新比赛信息异常:"  + e.getMessage());
        }

    }

    /**
     *
     * 功能描述: 获取所有比赛状态
     *
     * @param: []
     * @return: java.util.List<java.util.HashMap<java.lang.String,java.lang.String>>
     * @auther: 11432_000
     * @date: 2019/4/22 20:02
     */
    @Override
    public List<HashMap<String, String>> getAllState()throws RuntimeException {
        ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> map;
        for (MatchState matchState : MatchState.values()){
            map = new HashMap<String, String>(2);
            map.put(MATCH_STATE_KEY,matchState.getKey()+ "");
            map.put(MATCH_STATE_INFO,matchState.getMessage());
            list.add(map);
        }
        return list;
    }

    /**
     *
     * 功能描述: 逻辑删除一条或多条数据
     *
     * @param: [matchIds]
     * @return: com.xsl.result.XslResult
     * @auther: 11432_000
     * @date: 2019/4/23 14:48
     */
    @Override
    @DeleteMatch
    public XslResult deleteMatchInfoByIds(List<String> matchIds) throws RuntimeException{
        try{
            XslResult result = updateMatchState(matchIds, DataStates.DELETE.getCode());
            if (ResultUtils.isSuccess(result)){
                LOGGER.info("删除数据 matchId = [" +  matchIds + "] 成功");
                return ResultUtils.isOk(matchIds);
            }
            return ResultUtils.isError();
        }catch (Exception e){
            throw new RuntimeException("删除比赛信息异常：" + e.getMessage());
        }
    }

    /**
     *
     * 功能描述: 根据matchId修改比赛状态
     *
     * @param: [matchId, state]
     * @return: com.xsl.result.XslResult
     * @auther: 11432_000
     * @date: 2019/4/23 16:24
     */
    @Override
    @UpdateMatch
    public XslResult updateMatchState(List<String> matchIds,Integer state)throws RuntimeException {
        if (matchIds == null){
            LOGGER.info("更新比赛状态 matchId 为null");
            return ResultUtils.isParameterError();
        }
        try{
            XslMatch xslMatch = new XslMatch();
            XslMatchExample xslMatchExample = new XslMatchExample();
            XslMatchExample.Criteria criteria = xslMatchExample.createCriteria();
            criteria.andMatchidIn(matchIds);

            xslMatch.setMatchstate(state);
            int i = xslMatchMapper.updateByExampleSelective(xslMatch,xslMatchExample);
            if (i <= 0){
                LOGGER.error("updateMatchState 更新比赛状态部分失败");
            }
            LOGGER.info("更新比赛状态 matchId = [" +  matchIds + "] 成功");
            return ResultUtils.isOk(matchIds);
        }catch (Exception e){
            throw new RuntimeException("更新比赛状态异常:" + e.getMessage());
        }
    }
    @Override
    public XslResult selectAllMatchByMatchType(String matchTypeId) throws RuntimeException {
        /**
         *
         * 功能描述: 获取某一类型的所有比赛
         *
         * @param: [matchTypeId]
         * @return: com.xsl.result.XslResult
         * @auther: 11432_000
         * @date: 2019/4/27 13:54
         */
        try {
            return ResultUtils.isOk(getAllMatch(MATCH_LIST_BY_TYPE + ":" + matchTypeId));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public XslResult selectMatchInfoByMatchId(String matchId) throws RuntimeException {
        /**
         *
         * 功能描述: 根据比赛id 获取比赛信息
         *
         * @param: [matchId]
         * @return: com.xsl.result.XslResult
         * @auther: 11432_000
         * @date: 2019/4/28 20:49
         */
        String json = null;
        try {
            json = JedisUtils.get(MATCH_BUFFER_PREFIX + ":" + matchId);
            XslMatch xslMatch = JsonUtils.jsonToPojo(json,XslMatch.class);
            return ResultUtils.isOk(xslMatch);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public XslResult selectAllMatchByState(Integer state) throws RuntimeException {
        /**
         *
         * 功能描述: 获取某一状态的所有比赛
         *
         * @param: [state]
         * @return: com.xsl.result.XslResult
         * @auther: 11432_000
         * @date: 2019/5/5 16:57
         */
        try {
            return ResultUtils.isOk(getAllMatch(MATCH_LIST_BY_STATE + ":" + state));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public XslResult selectAllMatchByRank(String rankId) throws RuntimeException {
        /**
         *
         * 功能描述: 获取某一等级的所有比赛
         *
         * @param: [rankId]
         * @return: com.xsl.result.XslResult
         * @auther: 11432_000
         * @date: 2019/5/5 16:57
         */
        try {
            return ResultUtils.isOk(getAllMatch(MATCH_LIST_BY_RANK + ":" + rankId));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    /** 获取指定比赛列表 */
    private List<XslMatch> getAllMatch(String key){
        /**
         *
         * 功能描述:从redis 获取所有比赛
         *
         * @param: []
         * @return: java.util.List<com.xsl.pojo.XslMatch>
         * @auther: 11432_000
         * @date: 2019/4/28 14:22
         */
        String json = JedisUtils.get(key);
        List<XslMatch> xslMatches = JsonUtils.jsonToList(json, XslMatch.class);
        return xslMatches;
    }

    @Override
    public XslResult selectAllMatchByCondition(String rankId, String typeId, Integer state) throws RuntimeException {
        /**
         *
         * 功能描述: 获取指定分类的比赛
         *
         * @param: [rankId, typeId, state]
         * @return: com.xsl.result.XslResult
         * @auther: 11432_000
         * @date: 2019/5/5 20:17
         */
        try {
            List<XslMatch> allMatch = getAllMatch(MATCH_LIST);
            if (StringUtils.isNotBlank(rankId)){
                List<XslMatch> rankMatch = getAllMatch(MATCH_LIST_BY_RANK + ":" + rankId);
                allMatch = MatchArrayUtils.getIntersection(allMatch,rankMatch);
            }
            if (StringUtils.isNotBlank(typeId)){
                List<XslMatch> typeMatch = getAllMatch(MATCH_LIST_BY_TYPE + ":" + typeId);
                allMatch = MatchArrayUtils.getIntersection(allMatch,typeMatch);
            }
            if (state != null){
                List<XslMatch> stateMatch = getAllMatch(MATCH_LIST_BY_STATE + ":" + state);
                allMatch = MatchArrayUtils.getIntersection(allMatch,stateMatch);
            }
            return ResultUtils.isOk(allMatch);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
