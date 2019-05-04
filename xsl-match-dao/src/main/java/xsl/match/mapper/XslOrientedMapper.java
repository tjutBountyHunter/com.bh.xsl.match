package xsl.match.mapper;

import com.xsl.pojo.Example.XslOrientedExample;
import com.xsl.pojo.XslOriented;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface XslOrientedMapper {
    long countByExample(XslOrientedExample example);

    int deleteByExample(XslOrientedExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(XslOriented record);

    int insertSelective(XslOriented record);

    List<XslOriented> selectByExample(XslOrientedExample example);

    XslOriented selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") XslOriented record, @Param("example") XslOrientedExample example);

    int updateByExample(@Param("record") XslOriented record, @Param("example") XslOrientedExample example);

    int updateByPrimaryKeySelective(XslOriented record);

    int updateByPrimaryKey(XslOriented record);
}