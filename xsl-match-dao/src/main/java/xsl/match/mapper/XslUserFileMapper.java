package xsl.match.mapper;

import com.xsl.pojo.XslUserFile;
import com.xsl.pojo.Example.XslUserFileExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface XslUserFileMapper {
    long countByExample(XslUserFileExample example);

    int deleteByExample(XslUserFileExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(XslUserFile record);

    int insertSelective(XslUserFile record);

    List<XslUserFile> selectByExample(XslUserFileExample example);

    XslUserFile selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") XslUserFile record, @Param("example") XslUserFileExample example);

    int updateByExample(@Param("record") XslUserFile record, @Param("example") XslUserFileExample example);

    int updateByPrimaryKeySelective(XslUserFile record);

    int updateByPrimaryKey(XslUserFile record);
}