package xsl.match.service;

import com.xsl.pojo.XslRewardRank;
import com.xsl.result.EasyUIDataGridResult;
import com.xsl.result.XslResult;

import java.util.List;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2019/4/25 14:56
 * @Description:
 */
public interface XslRewardRankService {
    /** 获取所有奖励等级 分页*/
    EasyUIDataGridResult getAllRewardRank(Integer page, Integer rows)throws RuntimeException;

    /** 获取所有奖励等级  不分页*/
    List<XslRewardRank> getAllRewardRank()throws RuntimeException;
    /** 根据RankId 获取奖励等级 */
    XslRewardRank getRewardRankByRewardRankId(String rewardRankId)throws RuntimeException;

    /** 根据Ids 逻辑删除一或多条奖励等级 */
    XslResult deleteByRewardRankIds(List<String> ids)throws RuntimeException;

    /** 添加一条奖励级别  */
    XslResult addRewardRank(XslRewardRank xslRewardRank)throws RuntimeException;
}
