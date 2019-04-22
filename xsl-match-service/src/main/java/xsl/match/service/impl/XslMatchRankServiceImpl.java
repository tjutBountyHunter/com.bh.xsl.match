package xsl.match.service.impl;

import com.xsl.enums.MatchForm;
import com.xsl.pojo.XslMatchRank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xsl.match.mapper.XslMatchRankMapper;
import xsl.match.service.XslMatchRankService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2019/4/20 20:51
 * @Description:
 */
@Service
public class XslMatchRankServiceImpl implements XslMatchRankService {

    @Autowired
    XslMatchRankMapper xslMatchRankMapper;

    /**
     *
     * 功能描述: 获取所有比赛等级
     *
     * @param: []
     * @return: java.util.List<com.xsl.pojo.XslMatchRank>
     * @auther: 11432_000
     * @date: 2019/4/21 14:24
     */
    public List<XslMatchRank> getAllRank() {
        List<XslMatchRank> xslMatchRanks = xslMatchRankMapper.selectAll();
        return xslMatchRanks;
    }

    /**
     *
     * 功能描述: 根据id获取的你信息
     *
     * @param: [rankId]
     * @return: java.util.List<com.xsl.pojo.XslMatchRank>
     * @auther: 11432_000
     * @date: 2019/4/22 14:53
     */
    public XslMatchRank getRank(Integer rankId) {
        return xslMatchRankMapper.selectByRankId(rankId).get(0);
    }
}
