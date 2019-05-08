package xsl.match.service;

import com.xsl.pojo.XslMatch;
import com.xsl.result.XslResult;

import java.util.HashMap;
import java.util.List;

/**
 * 说明：比赛信息相关操作
 *
 * @Auther: 11432_000
 * @Date: 2019/4/21 14:19
 * @Description:
 */
public interface XslMatchService {
    /** 获取所有的参赛形式 */
    List<HashMap<String,String>> getAllForm()throws RuntimeException;

    /** 添加一个比赛 */
    XslResult addMatch(XslMatch xslMatch)throws RuntimeException;

    /** 获取比赛列表(不分页) */
    XslResult getMatchList()throws RuntimeException;

    /** 获取比赛列表(分页) */
    XslResult getMatchPage(Integer page,Integer rows)throws RuntimeException;

    /** 根据 MatchId 修改一条比赛数据 */
    XslResult updateMatch(XslMatch xslMatch)throws RuntimeException;

    /** 获取所有比赛状态 */
    List<HashMap<String,String>> getAllState()throws RuntimeException;

    /** 根据 MatchId 逻辑删除多条记录 */
    XslResult deleteMatchByIds(List<String> matchIds)throws RuntimeException;

    /** 变更比赛状态 */
    XslResult updateMatchState(List<String> matchId,Integer state)throws RuntimeException;

    /** 根据比赛id 获取比赛信息 */
    XslResult selectMatchByMatchId(String matchId)throws RuntimeException;

    /** 获取指定分类的比赛 */
    XslResult selectAllMatchByCondition(String rankId,String typeId,Integer state,Integer page,Integer rows)throws RuntimeException;

    /** 根据matchId 获取比赛全部信息 */
    XslResult getMatchAllInfoByMatchId(String matchId)throws RuntimeException;
}
