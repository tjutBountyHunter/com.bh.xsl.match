package xsl.match.mapper;

import com.xsl.pojo.XslMatchRemark;
import com.xsl.pojo.Example.XslMatchRemarkExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface XslMatchRemarkMapper {
    long countByExample(XslMatchRemarkExample example);

    int deleteByExample(XslMatchRemarkExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(XslMatchRemark record);

    int insertSelective(XslMatchRemark record);

    List<XslMatchRemark> selectByExample(XslMatchRemarkExample example);

    XslMatchRemark selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") XslMatchRemark record, @Param("example") XslMatchRemarkExample example);

    int updateByExample(@Param("record") XslMatchRemark record, @Param("example") XslMatchRemarkExample example);

    int updateByPrimaryKeySelective(XslMatchRemark record);

    int updateByPrimaryKey(XslMatchRemark record);
}