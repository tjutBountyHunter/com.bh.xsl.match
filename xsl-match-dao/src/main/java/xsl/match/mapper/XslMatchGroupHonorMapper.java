package xsl.match.mapper;

import com.xsl.pojo.Example.XslMatchGroupHonorExample;
import com.xsl.pojo.XslMatchGroupHonor;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface XslMatchGroupHonorMapper {
    long countByExample(XslMatchGroupHonorExample example);

    int deleteByExample(XslMatchGroupHonorExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(XslMatchGroupHonor record);

    int insertSelective(XslMatchGroupHonor record);

    List<XslMatchGroupHonor> selectByExample(XslMatchGroupHonorExample example);

    XslMatchGroupHonor selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") XslMatchGroupHonor record, @Param("example") XslMatchGroupHonorExample example);

    int updateByExample(@Param("record") XslMatchGroupHonor record, @Param("example") XslMatchGroupHonorExample example);

    int updateByPrimaryKeySelective(XslMatchGroupHonor record);

    int updateByPrimaryKey(XslMatchGroupHonor record);
}