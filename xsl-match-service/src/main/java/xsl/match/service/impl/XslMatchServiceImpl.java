package xsl.match.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xsl.Utils.ResultUtils;
import com.xsl.enums.MatchForm;
import com.xsl.enums.MatchState;
import com.xsl.pojo.XslMatch;
import com.xsl.pojo.XslMatchRank;
import com.xsl.result.EasyUIDataGridResult;
import com.xsl.result.XslResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xsl.match.mapper.XslMatchMapper;
import xsl.match.service.XslMatchService;

import java.util.*;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2019/4/21 14:19
 * @Description:
 */
@Service
public class XslMatchServiceImpl implements XslMatchService {

    private static final String FORM_KEY = "matchForm";
    private static final String FORM_INFO = "matchFormName";

    private static final String MATCH_STATE_KEY = "matchState";
    private static final String MATCH_STATE_INFO = "matchStateInfo";
    @Autowired
    XslMatchMapper xslMatchMapper;


    /**
     *
     * 功能描述: 获取所有参赛形式
     *
     * @param: []
     * @return: java.util.List<java.util.HashMap<java.lang.String,java.lang.String>>
     * @auther: 11432_000
     * @date: 2019/4/21 14:25
     */
    public List<HashMap<String,String>> getAllForm(){
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
    public XslResult addAMatch(XslMatch xslMatch) {
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
        int insert = xslMatchMapper.insert(xslMatch);
        if (insert <= 0){
            return ResultUtils.isError("XslMatch插入失败");
        }
        return ResultUtils.isOk();
    }

    /**
     *
     * 功能描述: 获取比赛列表
     *
     * @param: [page, rows]
     * @return: com.xsl.result.EasyUIDataGridResult
     * @auther: 11432_000
     * @date: 2019/4/22 13:35
     */
    public EasyUIDataGridResult getMatchList(Integer page, Integer rows) {
        //设置分页数和每页记录数
        PageHelper.startPage(page,rows);
        //查询所有比赛信息
        List<XslMatch> xslMatches = xslMatchMapper.selectAll(null);
        EasyUIDataGridResult result = new EasyUIDataGridResult();
        result.setRows(xslMatches);
        //获取分页结果
        PageInfo<XslMatch> pageInfo = new PageInfo(xslMatches);
        //获取记录数
        result.setTotal(pageInfo.getTotal());
        return result;
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
    public XslResult updateAMatchInfo(XslMatch xslMatch) {

        int i = xslMatchMapper.updateByMatchId(xslMatch);
        if (i <= 0){
            return ResultUtils.isError("更新数据失败");
        }
        return ResultUtils.isOk();
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
    public List<HashMap<String, String>> getAllState() {
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
}
