package xsl.match.mapper;


import com.xsl.pojo.XslMatchTeam;

import java.util.List;

public interface XslMatchTeamMapper {
    /** 根据队伍ID查询数据 */
    XslMatchTeam selectByTeamId(String teamId);
    /** 查询所有数据 根据指定属性排序 默认为CreateTime*/
    List<XslMatchTeam> selectAll(String orderBy);
    /** 根据比赛ID获取比赛 */
    List<XslMatchTeam> selectAllByMatchId(String matchId);
    /** 根据队伍ID删除数据 */
    int deleteByTeamId(String teamId);
    /** 根据队伍ID更新数据 */
    int updateByTeamId(XslMatchTeam xslMatchTeam);
    /** 添加一条数据 */
    int insert(XslMatchTeam xslMatch);
    /** 更新队伍状态 */
    int updateTeamState(XslMatchTeam xslMatchTeam);
}