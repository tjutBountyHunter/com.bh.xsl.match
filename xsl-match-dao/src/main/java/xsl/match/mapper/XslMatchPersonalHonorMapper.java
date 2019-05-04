package xsl.match.mapper;

import com.xsl.pojo.Example.XslMatchPersonalHonorExample;
import com.xsl.pojo.XslMatchPersonalHonor;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface XslMatchPersonalHonorMapper {
    long countByExample(XslMatchPersonalHonorExample example);

    int deleteByExample(XslMatchPersonalHonorExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(XslMatchPersonalHonor record);

    int insertSelective(XslMatchPersonalHonor record);

    List<XslMatchPersonalHonor> selectByExample(XslMatchPersonalHonorExample example);

    XslMatchPersonalHonor selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") XslMatchPersonalHonor record, @Param("example") XslMatchPersonalHonorExample example);

    int updateByExample(@Param("record") XslMatchPersonalHonor record, @Param("example") XslMatchPersonalHonorExample example);

    int updateByPrimaryKeySelective(XslMatchPersonalHonor record);

    int updateByPrimaryKey(XslMatchPersonalHonor record);
}