package xsl.match.service;

import com.xsl.pojo.XslMatchReward;
import com.xsl.pojo.XslReward;
import com.xsl.result.EasyUIDataGridResult;
import com.xsl.result.XslResult;

import java.util.List;

/**
 * 说明：比赛和奖励的关联
 *
 * @Auther: 11432_000
 * @Date: 2019/4/25 14:16
 * @Description:
 */
public interface XslMatchRewardService {

    /** 根据比赛ID 查询所有奖励 分页  */
    EasyUIDataGridResult getReward(String matchId, Integer page, Integer rows)throws RuntimeException;
    /** 根据比赛ID 查询所有奖励  不分页  */
    List<XslReward> getReward(String matchId)throws RuntimeException;
    /** 为比赛添加一条奖励 */
    XslResult addRewardToMatch(XslMatchReward xslMatchReward)throws RuntimeException;
    /** 逻辑删除比赛的一条奖励 */
    XslResult deleteByRewardIdAndMatchId(List<String> rewardIds, String matchId)throws RuntimeException;
}
