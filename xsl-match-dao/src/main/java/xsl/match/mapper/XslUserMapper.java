package xsl.match.mapper;

import com.xsl.pojo.Example.XslUserExample;
import com.xsl.pojo.XslUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface XslUserMapper {
    long countByExample(XslUserExample example);

    int deleteByExample(XslUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(XslUser record);

    int insertSelective(XslUser record);

    List<XslUser> selectByExample(XslUserExample example);

    XslUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") XslUser record, @Param("example") XslUserExample example);

    int updateByExample(@Param("record") XslUser record, @Param("example") XslUserExample example);

    int updateByPrimaryKeySelective(XslUser record);

    int updateByPrimaryKey(XslUser record);
}