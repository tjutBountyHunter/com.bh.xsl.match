package xsl.match.mapper;

import com.xsl.pojo.Example.XslMatchUserExample;
import com.xsl.pojo.XslMatchUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface XslMatchUserMapper {
    long countByExample(XslMatchUserExample example);

    int deleteByExample(XslMatchUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(XslMatchUser record);

    int insertSelective(XslMatchUser record);

    List<XslMatchUser> selectByExample(XslMatchUserExample example);

    XslMatchUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") XslMatchUser record, @Param("example") XslMatchUserExample example);

    int updateByExample(@Param("record") XslMatchUser record, @Param("example") XslMatchUserExample example);

    int updateByPrimaryKeySelective(XslMatchUser record);

    int updateByPrimaryKey(XslMatchUser record);
}