package xsl.match.service;

import com.xsl.pojo.XslRewardRank;
import com.xsl.result.XslResult;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2019/4/25 14:56
 * @Description:
 */
public interface XslRewardRankService {
    /** 获取所有奖励等级 */
    XslResult getAllRewardRank(Integer page,Integer rows)throws RuntimeException;

    /** 根据RankId 获取奖励等级 */
    XslResult getRewardRankByRewardRankId(String rewardRankId)throws RuntimeException;

    /** 根据Ids 逻辑删除一或多条奖励等级 */
    XslResult deleteByRewardRankIds(String ids)throws RuntimeException;

    /** 添加一条奖励级别  */
    XslResult addRewardRank(XslRewardRank xslRewardRank)throws RuntimeException;
}
