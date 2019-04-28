package xsl.match.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xsl.Utils.JedisUtils;
import com.xsl.Utils.JsonUtils;
import com.xsl.Utils.ResultUtils;
import com.xsl.annotation.DeleteMatch;
import com.xsl.annotation.SelectMatch;
import com.xsl.annotation.UpdateMatch;
import com.xsl.enums.DataStates;
import com.xsl.enums.MatchForm;
import com.xsl.enums.MatchState;
import com.xsl.enums.ResultCode;
import com.xsl.pojo.XslMatch;
import com.xsl.result.EasyUIDataGridResult;
import com.xsl.result.XslResult;
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
        xslMatch.setMatchId(matchId);
        //根据当前时间设置比赛状态
        if (xslMatch.getMatchSignUpStartTime().compareTo(new Date()) <= 0){
            xslMatch.setMatchState(MatchState.SIGN_UP.getKey());
        }else {
            xslMatch.setMatchState(MatchState.BEFORE_SIGN_UP.getKey());
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
            List<XslMatch> xslMatches = getAllMatch();
            EasyUIDataGridResult result = new EasyUIDataGridResult();
            result.setRows(xslMatches);
            //设置分页数和每页记录数
            PageHelper.startPage(page,rows);
            //获取分页结果
            PageInfo<XslMatch> pageInfo = new PageInfo(xslMatches);
            //获取记录数
            result.setTotal(pageInfo.getTotal());
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
            List<XslMatch> xslMatches = getAllMatch();
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
            int i = xslMatchMapper.updateByMatchId(xslMatch);
            if (i <= 0){
                LOGGER.error("updateAMatchInfo 更新数据 matchId =" + xslMatch.getMatchId() + " 失败");
                return ResultUtils.isError("更新数据失败");
            }
            LOGGER.info("更新数据 matchId =" + xslMatch.getMatchId() + " 成功");
            return ResultUtils.isOk(xslMatch.getMatchId());
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
    public XslResult deleteMatchInfoByIds(String matchIds) throws RuntimeException{
        try{
            XslResult result = updateMatchState(matchIds, DataStates.DELETE.getCode());
            if (result.getCode().equals(ResultCode.SUCCESS.getCode())){
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
    public XslResult updateMatchState(String matchIds,Integer state)throws RuntimeException {
        if (matchIds == null){
            LOGGER.info("更新比赛状态 matchId 为null");
            return ResultUtils.isParameterError();
        }
        //拆分多个id
        String[] split = matchIds.split(",");
        if (split.length == 0){
            return ResultUtils.isParameterError();
        }
        try{
            XslMatch xslMatch = new XslMatch();
            for (String matchId : split){
                xslMatch.setMatchId(matchId);
                xslMatch.setMatchState(state);
                int i = xslMatchMapper.updateMatchState(xslMatch);
                if (i <= 0){
                    LOGGER.error("updateMatchState 更新比赛状态 matchId =" +  matchId + " 失败");
                    return ResultUtils.isError();
                }
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
            List<XslMatch> xslMatches = xslMatchMapper.selectAllByMatchTypeId(matchTypeId);
            return ResultUtils.isOk(xslMatches);
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

    private List<XslMatch> getAllMatch(){
        /**
         *
         * 功能描述:从redis 获取所有比赛
         *
         * @param: []
         * @return: java.util.List<com.xsl.pojo.XslMatch>
         * @auther: 11432_000
         * @date: 2019/4/28 14:22
         */
        List<XslMatch> xslMatches = new ArrayList<XslMatch>();
        Set<String> keys = JedisUtils.keys(MATCH_BUFFER_PREFIX);
        for (String key : keys){
            xslMatches.add(JsonUtils.jsonToPojo(JedisUtils.get(key),XslMatch.class));
        }
        return xslMatches;
    }
}
