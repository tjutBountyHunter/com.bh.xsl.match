package xsl.match.mapper;

import com.xsl.pojo.XslMatchHonor;
import com.xsl.pojo.Example.XslMatchHonorExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface XslMatchHonorMapper {
    long countByExample(XslMatchHonorExample example);

    int deleteByExample(XslMatchHonorExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(XslMatchHonor record);

    int insertSelective(XslMatchHonor record);

    List<XslMatchHonor> selectByExample(XslMatchHonorExample example);

    XslMatchHonor selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") XslMatchHonor record, @Param("example") XslMatchHonorExample example);

    int updateByExample(@Param("record") XslMatchHonor record, @Param("example") XslMatchHonorExample example);

    int updateByPrimaryKeySelective(XslMatchHonor record);

    int updateByPrimaryKey(XslMatchHonor record);
}