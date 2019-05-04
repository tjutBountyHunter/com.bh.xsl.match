package xsl.match.mapper;

import com.xsl.pojo.Example.XslMatchTeamExample;
import com.xsl.pojo.XslMatchTeam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface XslMatchTeamMapper {
    long countByExample(XslMatchTeamExample example);

    int deleteByExample(XslMatchTeamExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(XslMatchTeam record);

    int insertSelective(XslMatchTeam record);

    List<XslMatchTeam> selectByExample(XslMatchTeamExample example);

    XslMatchTeam selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") XslMatchTeam record, @Param("example") XslMatchTeamExample example);

    int updateByExample(@Param("record") XslMatchTeam record, @Param("example") XslMatchTeamExample example);

    int updateByPrimaryKeySelective(XslMatchTeam record);

    int updateByPrimaryKey(XslMatchTeam record);
}