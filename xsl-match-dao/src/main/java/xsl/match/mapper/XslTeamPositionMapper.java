package xsl.match.mapper;

import com.xsl.pojo.Example.XslTeamPositionExample;
import com.xsl.pojo.XslTeamPosition;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface XslTeamPositionMapper {
    long countByExample(XslTeamPositionExample example);

    int deleteByExample(XslTeamPositionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(XslTeamPosition record);

    int insertSelective(XslTeamPosition record);

    List<XslTeamPosition> selectByExample(XslTeamPositionExample example);

    XslTeamPosition selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") XslTeamPosition record, @Param("example") XslTeamPositionExample example);

    int updateByExample(@Param("record") XslTeamPosition record, @Param("example") XslTeamPositionExample example);

    int updateByPrimaryKeySelective(XslTeamPosition record);

    int updateByPrimaryKey(XslTeamPosition record);

    /** 自定义 */
    int getPositionNumByTeam(String teamId);
}