package xsl.match.service;

import com.xsl.pojo.XslReward;
import com.xsl.result.EasyUIDataGridResult;
import com.xsl.result.XslResult;

import java.util.List;

/**
 * 说明：比赛奖励相关操作
 *
 * @Auther: 11432_000
 * @Date: 2019/4/25 14:26
 * @Description:
 */
public interface XslRewardService {

    /** 根据RewardId 查询奖励信息 */
    XslReward selectRewardInfoByRewardId(String rewardId)throws RuntimeException;

    /** 添加一条奖励 */
    XslResult addReward(XslReward xslReward)throws RuntimeException;

    /** 根据RewardId修改奖励 */
    XslResult updateReward(XslReward xslReward)throws RuntimeException;

    /** 逻辑删除一条奖励 */
    XslResult deleteReward(List<String> rewardIds)throws RuntimeException;

    /** 获取所有奖励 分页 */
    EasyUIDataGridResult getAllReward(Integer page, Integer rows)throws RuntimeException;
    /** 获取所有奖励  不分页 */
    List<XslReward> getAllReward()throws RuntimeException;

}
