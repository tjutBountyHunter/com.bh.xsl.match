package xsl.match.mapper;

import com.xsl.pojo.Example.XslRewardRankExample;
import com.xsl.pojo.XslRewardRank;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface XslRewardRankMapper {
    long countByExample(XslRewardRankExample example);

    int deleteByExample(XslRewardRankExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(XslRewardRank record);

    int insertSelective(XslRewardRank record);

    List<XslRewardRank> selectByExample(XslRewardRankExample example);

    XslRewardRank selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") XslRewardRank record, @Param("example") XslRewardRankExample example);

    int updateByExample(@Param("record") XslRewardRank record, @Param("example") XslRewardRankExample example);

    int updateByPrimaryKeySelective(XslRewardRank record);

    int updateByPrimaryKey(XslRewardRank record);
}