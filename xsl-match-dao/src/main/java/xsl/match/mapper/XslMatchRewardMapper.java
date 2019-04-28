package xsl.match.mapper;


import com.xsl.pojo.XslMatchReward;

import java.util.List;

public interface XslMatchRewardMapper {

    List<XslMatchReward> selectRewardListByMatchId(XslMatchReward xslMatchReward);

    int insert(XslMatchReward xslMatchReward);

    int deleteByRewardIdAndMatchId(XslMatchReward xslMatchReward);

    int updateByRewardIdAndMatchId(XslMatchReward xslMatchReward);

    List<XslMatchReward> selectAll(String orderBy);
}