package xsl.match.mapper;


import com.xsl.pojo.XslMatch;

import java.util.List;

public interface XslMatchMapper {
    /** 根据比赛ID查询数据 */
    XslMatch selectByMatchId(String matchId);
    /** 根据 非比赛ID的字段 查询数据 */
    /** 查询所有数据 根据指定属性排序 默认为matchCreateTime*/
    List<XslMatch> selectAll(String orderBy);
    /** 根据比赛ID删除数据 */
    int deleteByMatchId(String matchId);
    /** 根据比赛ID更新数据 */
    int updateByMatchId(XslMatch xslMatch);
    /** 添加一条数据 */
    int insert(XslMatch xslMatch);
    /** 更新比赛状态 */
    int updateMatchState(XslMatch xslMatch);
}