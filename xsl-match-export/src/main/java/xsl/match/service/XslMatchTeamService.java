package xsl.match.service;

import com.xsl.pojo.XslMatchTeam;
import com.xsl.result.EasyUIDataGridResult;
import com.xsl.result.XslResult;

import java.util.List;

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

    /** 获取队伍列表(分页) */
    EasyUIDataGridResult getTeamPage(Integer page, Integer rows)throws RuntimeException;

    /** 获取队伍列表(不分页) */
    List<XslMatchTeam> getTeamList()throws RuntimeException;

    /** 根据 Id 修改一条队伍数据 */
    XslResult updateATeamInfo(XslMatchTeam xslMatchTeam)throws RuntimeException;

    /** 根据 Id 逻辑删除一个或多个队伍 */
    XslResult deleteTeamInfoByIds(List<String> teamIds)throws RuntimeException;

    /** 变更队伍状态 */
    XslResult updateTeamState(String teamId,Integer state)throws RuntimeException;

    /** 获取某一比赛的所有队伍 */
    List<XslMatchTeam> selectAllTeamByMatch(String matchId)throws RuntimeException;

    /** 根据队伍Id 获取队伍信息 */
    XslMatchTeam getCurrentTeamByTeamId(String teamId)throws RuntimeException;

    /** 根据创见者获取队伍信息 */
    XslMatchTeam getCurrentTeamByCreater(String hunterId)throws RuntimeException;
}
