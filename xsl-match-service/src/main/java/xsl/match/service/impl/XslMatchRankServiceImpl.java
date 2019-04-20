package xsl.match.service.impl;

import com.xsl.pojo.XslMatchRank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xsl.match.mapper.XslMatchRankMapper;
import xsl.match.service.XslMatchRankService;

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

    public List<XslMatchRank> getAllRank() {
        List<XslMatchRank> xslMatchRanks = xslMatchRankMapper.selectAll();
        return xslMatchRanks;
    }
}
