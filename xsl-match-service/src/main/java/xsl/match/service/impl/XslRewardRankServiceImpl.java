package xsl.match.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xsl.Utils.IdUtils;
import com.xsl.Utils.ResultUtils;
import com.xsl.enums.DataStatesEnum;
import com.xsl.pojo.Example.XslRewardRankExample;
import com.xsl.pojo.XslRewardRank;
import com.xsl.result.EasyUIDataGridResult;
import com.xsl.result.XslResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xsl.match.mapper.XslRewardRankMapper;
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
    private XslRewardRankMapper xslRewardRankMapper;
    @Override
    public EasyUIDataGridResult getAllRewardRank(Integer page,Integer rows) throws RuntimeException {
        /**
         *
         * 功能描述: 获取所有奖励等级  分页
         *
         * @param: []
         * @return: com.xsl.result.XslResult
         * @auther: 11432_000
         * @date: 2019/4/25 15:01
         */
        //设置分页
        PageHelper.startPage(page,rows);
        try {
            XslRewardRankExample xslRewardRankExample = new XslRewardRankExample();
            XslRewardRankExample.Criteria criteria = xslRewardRankExample.createCriteria();
            criteria.andRewardrankstateNotEqualTo(DataStatesEnum.DELETE.getCode());
            List<XslRewardRank> xslRewardRanks = xslRewardRankMapper.selectByExample(xslRewardRankExample);
            EasyUIDataGridResult result = new EasyUIDataGridResult();
            result.setRows(xslRewardRanks);
            PageInfo<XslRewardRank> xslRewardRankPageInfo = new PageInfo<XslRewardRank>(xslRewardRanks);
            result.setTotal(xslRewardRankPageInfo.getTotal());
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<XslRewardRank> getAllRewardRank() throws RuntimeException {
        /**
         *
         * 功能描述:  获取所有奖励等级  不分页
         *
         * @param: []
         * @return: java.util.List<com.xsl.pojo.XslRewardRank>
         * @auther: 11432_000
         * @date: 2019/5/8 14:55
         */
        try {
            XslRewardRankExample xslRewardRankExample = new XslRewardRankExample();
            xslRewardRankExample.createCriteria().andRewardrankstateNotEqualTo(DataStatesEnum.DELETE.getCode());
            List<XslRewardRank> xslRewardRanks = xslRewardRankMapper.selectByExample(xslRewardRankExample);
            return xslRewardRanks;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public XslRewardRank getRewardRankByRewardRankId(String rewardRankId) throws RuntimeException {
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
                return new XslRewardRank();
            }
            return (xslRewardRanks.get(0));
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
            return ResultUtils.parameterError();
        }
        XslRewardRankExample xslRewardRankExample = new XslRewardRankExample();
        XslRewardRankExample.Criteria criteria = xslRewardRankExample.createCriteria();
        try {
            XslRewardRank xslRewardRank = new XslRewardRank();
            for (String rewardRankId : ids){
                xslRewardRankExample.clear();
                criteria.andRewardrankidEqualTo(rewardRankId);
                xslRewardRank.setRewardrankstate(DataStatesEnum.DELETE.getCode());
                int i = xslRewardRankMapper.updateByExampleSelective(xslRewardRank,xslRewardRankExample);
                if (i <= 0){
                    LOGGER.error("deleteByRewardRankIds 删除奖励等级失败");
                    return ResultUtils.error();
                }
            }
            return ResultUtils.ok();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    @Override
    public XslResult addRewardRank(XslRewardRank xslRewardRank) throws RuntimeException {
        String uuid = IdUtils.getUuid("RR");
        xslRewardRank.setRewardrankid(uuid);
        xslRewardRank.setRewardrankstate(DataStatesEnum.NORMAL.getCode());
        try {
            int insert = xslRewardRankMapper.insertSelective(xslRewardRank);
            if (insert <= 0){
                LOGGER.error("addRewardRank 添加数据失败");
                return ResultUtils.error();
            }
            return ResultUtils.ok();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
