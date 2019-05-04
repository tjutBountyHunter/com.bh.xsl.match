package xsl.match.mapper;

import com.xsl.pojo.XslFile;
import com.xsl.pojo.Example.XslFileExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface XslFileMapper {
    long countByExample(XslFileExample example);

    int deleteByExample(XslFileExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(XslFile record);

    int insertSelective(XslFile record);

    List<XslFile> selectByExample(XslFileExample example);

    XslFile selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") XslFile record, @Param("example") XslFileExample example);

    int updateByExample(@Param("record") XslFile record, @Param("example") XslFileExample example);

    int updateByPrimaryKeySelective(XslFile record);

    int updateByPrimaryKey(XslFile record);
}