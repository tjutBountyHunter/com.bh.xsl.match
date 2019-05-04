package xsl.match.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xsl.Utils.IdUtils;
import com.xsl.Utils.ResultUtils;
import com.xsl.enums.DataStates;
import com.xsl.enums.ResultCode;
import com.xsl.pojo.Example.XslRewardRankExample;
import com.xsl.pojo.XslMatch;
import com.xsl.pojo.XslRewardRank;
import com.xsl.result.EasyUIDataGridResult;
import com.xsl.result.XslResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xsl.match.mapper.XslRewardRankMapper;
import xsl.match.service.XslMatchRewardService;
import xsl.match.service.XslRewardRankService;

import java.util.List;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2019/4/25 14:57
 * @Description:
 */
@Service
public class XslRewardRankServiceImpl implements XslRewardRankService {

    private static final Logger LOGGER = LoggerFactory.getLogger(XslRewardRankServiceImpl.class);

    @Autowired
    XslRewardRankMapper xslRewardRankMapper;
    @Override
    public XslResult getAllRewardRank(Integer page,Integer rows) throws RuntimeException {
        /**
         *
         * 功能描述: 获取所有奖励等级
         *
         * @param: []
         * @return: com.xsl.result.XslResult
         * @auther: 11432_000
         * @date: 2019/4/25 15:01
         */
        try {
            XslRewardRankExample xslRewardRankExample = new XslRewardRankExample();
            XslRewardRankExample.Criteria criteria = xslRewardRankExample.createCriteria();
            criteria.andRewardrankstateNotEqualTo(DataStates.DELETE.getCode());
            List<XslRewardRank> xslRewardRanks = xslRewardRankMapper.selectByExample(xslRewardRankExample);

            if (page == null || rows == null){
                return ResultUtils.isOk(xslRewardRanks);
            }
            EasyUIDataGridResult result = new EasyUIDataGridResult();
            result.setRows(xslRewardRanks);
            //设置分页
            PageHelper.startPage(page,rows);
            PageInfo<XslRewardRank> xslRewardRankPageInfo = new PageInfo<XslRewardRank>(xslRewardRanks);
            result.setTotal(xslRewardRankPageInfo.getTotal());
            return ResultUtils.isOk(result);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public XslResult getRewardRankByRewardRankId(String rewardRankId) throws RuntimeException {
        /**
         *
         * 功能描述: 根据RankId 获取奖励等级
         *
         * @param: [rewardRankId]
         * @return: com.xsl.result.XslResult
         * @auther: 11432_000
         * @date: 2019/4/25 18:32
         */
        try {
            XslRewardRankExample xslRewardRankExample = new XslRewardRankExample();
            XslRewardRankExample.Criteria criteria = xslRewardRankExample.createCriteria();
            criteria.andRewardrankidEqualTo(rewardRankId);
            List<XslRewardRank> xslRewardRanks = xslRewardRankMapper.selectByExample(xslRewardRankExample);
            if (xslRewardRanks == null || xslRewardRanks.size() == 0){
                return ResultUtils.isParameterError();
            }
            return ResultUtils.isOk(xslRewardRanks.get(0));
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
    @Override
    public XslResult deleteByRewardRankIds(List<String> ids) throws RuntimeException {
        /**
         *
         * 功能描述: 逻辑删除一或多条级别
         *
         * @param: [ids]
         * @return: com.xsl.result.XslResult
         * @auther: 11432_000
         * @date: 2019/4/26 18:01
         */
        if (ids == null){
            LOGGER.info("删除数据为null");
            return ResultUtils.isParameterError();
        }
        XslRewardRankExample xslRewardRankExample = new XslRewardRankExample();
        XslRewardRankExample.Criteria criteria = xslRewardRankExample.createCriteria();
        try {
            XslRewardRank xslRewardRank = new XslRewardRank();
            for (String rewardRankId : ids){
                xslRewardRankExample.clear();
                criteria.andRewardrankidEqualTo(rewardRankId);
                xslRewardRank.setRewardrankstate(DataStates.DELETE.getCode());
                int i = xslRewardRankMapper.updateByExampleSelective(xslRewardRank,xslRewardRankExample);
                if (i <= 0){
                    LOGGER.error("deleteByRewardRankIds 删除奖励等级失败");
                    return ResultUtils.isError();
                }
            }
            return ResultUtils.isOk();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    @Override
    public XslResult addRewardRank(XslRewardRank xslRewardRank) throws RuntimeException {
        String uuid = IdUtils.getUuid("RR");
        xslRewardRank.setRewardrankid(uuid);
        xslRewardRank.setRewardrankstate(DataStates.NORMAL.getCode());
        try {
            int insert = xslRewardRankMapper.insertSelective(xslRewardRank);
            if (insert <= 0){
                LOGGER.error("addRewardRank 添加数据失败");
                return ResultUtils.isError();
            }
            return ResultUtils.isOk();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
