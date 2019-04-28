package xsl.match.mapper;


import com.xsl.pojo.XslReward;

import java.util.List;

public interface XslRewardMapper {
    List<XslReward> selectAllReward();

    List<XslReward> selectAllRewardByRankId(String rewardRankId);

    XslReward selectRewardByRewardId(String rewardId);

    int insert(XslReward xslReward);

    int updateByRewardId(XslReward xslReward);

    int deleteByRewardId(String rewardId);

    int updateRewardStateByRewardId(XslReward xslReward);
}