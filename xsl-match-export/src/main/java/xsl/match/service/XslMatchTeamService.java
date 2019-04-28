package xsl.match.service;

import com.xsl.pojo.XslMatchTeam;
import com.xsl.result.XslResult;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2019/4/27 17:10
 * @Description:
 */
public interface XslMatchTeamService {

    /** 添加一个队伍*/
    XslResult addATeam(XslMatchTeam xslMatchTeam)throws RuntimeException;

    /** 获取比赛列表(分页) */
    XslResult getTeamPage(Integer page,Integer rows)throws RuntimeException;

    /** 获取比赛列表(不分页) */
    XslResult getTeamList()throws RuntimeException;

    /** 根据 MatchId 修改一条比赛数据 */
    XslResult updateATeamInfo(XslMatchTeam xslMatchTeam)throws RuntimeException;

    /** 根据 Id 逻辑删除一个或多个队伍 */
    XslResult deleteTeamInfoByIds(String teamIds)throws RuntimeException;

    /** 变更比赛状态 */
    XslResult updateTeamState(String teamId,Integer state)throws RuntimeException;

    /** 获取某一比赛的所有队伍 */
    XslResult selectAllTeamByMatch(String matchId)throws RuntimeException;
}
