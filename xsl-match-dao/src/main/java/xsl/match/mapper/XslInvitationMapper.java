package xsl.match.mapper;

import com.xsl.pojo.XslInvitation;
import com.xsl.pojo.Example.XslInvitationExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface XslInvitationMapper {
    long countByExample(XslInvitationExample example);

    int deleteByExample(XslInvitationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(XslInvitation record);

    int insertSelective(XslInvitation record);

    List<XslInvitation> selectByExample(XslInvitationExample example);

    XslInvitation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") XslInvitation record, @Param("example") XslInvitationExample example);

    int updateByExample(@Param("record") XslInvitation record, @Param("example") XslInvitationExample example);

    int updateByPrimaryKeySelective(XslInvitation record);

    int updateByPrimaryKey(XslInvitation record);
}