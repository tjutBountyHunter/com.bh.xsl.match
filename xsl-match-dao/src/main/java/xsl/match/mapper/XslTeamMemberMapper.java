package xsl.match.mapper;

import com.xsl.pojo.XslTeamMember;
import com.xsl.pojo.Example.XslTeamMemberExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface XslTeamMemberMapper {
    long countByExample(XslTeamMemberExample example);

    int deleteByExample(XslTeamMemberExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(XslTeamMember record);

    int insertSelective(XslTeamMember record);

    List<XslTeamMember> selectByExample(XslTeamMemberExample example);

    XslTeamMember selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") XslTeamMember record, @Param("example") XslTeamMemberExample example);

    int updateByExample(@Param("record") XslTeamMember record, @Param("example") XslTeamMemberExample example);

    int updateByPrimaryKeySelective(XslTeamMember record);

    int updateByPrimaryKey(XslTeamMember record);
}