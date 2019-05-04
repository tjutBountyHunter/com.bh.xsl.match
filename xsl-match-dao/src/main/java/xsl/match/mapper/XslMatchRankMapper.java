package xsl.match.mapper;

import com.xsl.pojo.XslMatchRank;
import com.xsl.pojo.Example.XslMatchRankExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface XslMatchRankMapper {
    long countByExample(XslMatchRankExample example);

    int deleteByExample(XslMatchRankExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(XslMatchRank record);

    int insertSelective(XslMatchRank record);

    List<XslMatchRank> selectByExample(XslMatchRankExample example);

    XslMatchRank selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") XslMatchRank record, @Param("example") XslMatchRankExample example);

    int updateByExample(@Param("record") XslMatchRank record, @Param("example") XslMatchRankExample example);

    int updateByPrimaryKeySelective(XslMatchRank record);

    int updateByPrimaryKey(XslMatchRank record);
}