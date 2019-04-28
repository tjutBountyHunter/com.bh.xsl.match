package xsl.match.service;

import com.xsl.pojo.XslReward;
import com.xsl.result.XslResult;

/**
 * 说明：比赛奖励相关操作
 *
 * @Auther: 11432_000
 * @Date: 2019/4/25 14:26
 * @Description:
 */
public interface XslRewardService {

    /** 根据RewardId 查询奖励信息 */
    XslResult selectRewardInfoByRewardId(String rewardId)throws RuntimeException;

    /** 添加一条奖励 */
    XslResult addReward(XslReward xslReward)throws RuntimeException;

    /** 根据RewardId修改奖励 */
    XslResult updateReward(XslReward xslReward)throws RuntimeException;

    /** 逻辑删除一条奖励 */
    XslResult deleteReward(String rewardIds)throws RuntimeException;

    /** 获取所有奖励 */
    XslResult getAllReward(Integer page,Integer rows)throws RuntimeException;

}
