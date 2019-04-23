package xsl.match.service;

import com.xsl.pojo.XslMatchRank;
import com.xsl.result.XslResult;

import java.util.List;

/**
 * 说明：比赛等级相关操作
 *
 * @Auther: 11432_000
 * @Date: 2019/4/20 20:50
 * @Description:
 */
public interface XslMatchRankService {
    /** 获取所有比赛等级 */
    List<XslMatchRank> getAllRank();
    /** 根据id 获取等级信息 */
    XslMatchRank getRank(Integer rankId);
    /** 更新比赛等级 */
    XslResult updateMatchRankInfo(XslMatchRank xslMatchRank);
}
