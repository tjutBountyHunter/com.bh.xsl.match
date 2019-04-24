package xsl.match.service;

import com.xsl.pojo.XslMatch;
import com.xsl.pojo.XslMatchRank;
import com.xsl.result.EasyUIDataGridResult;
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
    EasyUIDataGridResult getAllRank(Integer page,Integer rows) throws RuntimeException;
    /** 根据id 获取等级信息 */
    XslResult getRank(Integer rankId)throws RuntimeException;
    /** 更新比赛等级 */
    XslResult updateMatchRankInfo(XslMatchRank xslMatchRank)throws RuntimeException;
    /** 添加一条比赛记录 */
    XslResult addMatchRank(XslMatchRank xslMatchRank)throws RuntimeException;
    /** 删除一条或多条比赛等级 */
    XslResult deleteMatchRanks(String matchRankIds)throws RuntimeException;

}
