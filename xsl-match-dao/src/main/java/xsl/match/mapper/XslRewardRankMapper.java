package xsl.match.mapper;


import com.xsl.pojo.XslRewardRank;

import java.util.List;

public interface XslRewardRankMapper {
    List<XslRewardRank> selectAllRewardRank();

    XslRewardRank selectRewardRankByRewardRankId(String rewardRankId);

    int insert(XslRewardRank xslReward);

    int updateByRewardRankId(XslRewardRank xslReward);

    int deleteByRewardRankId(String rewardRankId);

    int updateRewardRankStateByRewardRankId(XslRewardRank xslReward);
}