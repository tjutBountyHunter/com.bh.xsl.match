package xsl.match.mapper;

import com.xsl.pojo.Example.XslPositionApplicationExample;
import com.xsl.pojo.XslPositionApplication;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface XslPositionApplicationMapper {
    long countByExample(XslPositionApplicationExample example);

    int deleteByExample(XslPositionApplicationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(XslPositionApplication record);

    int insertSelective(XslPositionApplication record);

    List<XslPositionApplication> selectByExample(XslPositionApplicationExample example);

    XslPositionApplication selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") XslPositionApplication record, @Param("example") XslPositionApplicationExample example);

    int updateByExample(@Param("record") XslPositionApplication record, @Param("example") XslPositionApplicationExample example);

    int updateByPrimaryKeySelective(XslPositionApplication record);

    int updateByPrimaryKey(XslPositionApplication record);
}