package xsl.match.mapper;

import com.xsl.pojo.Example.XslMatchTypeExample;
import com.xsl.pojo.XslMatchType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface XslMatchTypeMapper {
    long countByExample(XslMatchTypeExample example);

    int deleteByExample(XslMatchTypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(XslMatchType record);

    int insertSelective(XslMatchType record);

    List<XslMatchType> selectByExample(XslMatchTypeExample example);

    XslMatchType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") XslMatchType record, @Param("example") XslMatchTypeExample example);

    int updateByExample(@Param("record") XslMatchType record, @Param("example") XslMatchTypeExample example);

    int updateByPrimaryKeySelective(XslMatchType record);

    int updateByPrimaryKey(XslMatchType record);
}