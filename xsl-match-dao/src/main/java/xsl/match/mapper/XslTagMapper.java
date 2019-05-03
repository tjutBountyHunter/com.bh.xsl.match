package xsl.match.mapper;

import com.xsl.pojo.XslTag;
import com.xsl.pojo.XslTagExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface XslTagMapper {
    int countByExample(XslTagExample example);

    int deleteByExample(XslTagExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(XslTag record);

    int insertSelective(XslTag record);

    List<XslTag> selectByExample(XslTagExample example);

    XslTag selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") XslTag record, @Param("example") XslTagExample example);

    int updateByExample(@Param("record") XslTag record, @Param("example") XslTagExample example);

    int updateByPrimaryKeySelective(XslTag record);

    int updateByPrimaryKey(XslTag record);
}