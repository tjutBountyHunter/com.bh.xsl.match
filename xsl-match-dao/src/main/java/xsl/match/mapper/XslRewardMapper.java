package xsl.match.mapper;

import com.xsl.pojo.Example.XslRewardExample;
import com.xsl.pojo.XslReward;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface XslRewardMapper {
    long countByExample(XslRewardExample example);

    int deleteByExample(XslRewardExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(XslReward record);

    int insertSelective(XslReward record);

    List<XslReward> selectByExample(XslRewardExample example);

    XslReward selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") XslReward record, @Param("example") XslRewardExample example);

    int updateByExample(@Param("record") XslReward record, @Param("example") XslRewardExample example);

    int updateByPrimaryKeySelective(XslReward record);

    int updateByPrimaryKey(XslReward record);
}