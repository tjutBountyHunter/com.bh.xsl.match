package xsl.match.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xsl.Utils.IdUtils;
import com.xsl.Utils.ResultUtils;
import com.xsl.enums.DataStates;
import com.xsl.pojo.Example.XslRewardExample;
import com.xsl.pojo.XslReward;
import com.xsl.result.EasyUIDataGridResult;
import com.xsl.result.XslResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xsl.match.mapper.XslRewardMapper;
import xsl.match.service.XslRewardService;

import java.util.List;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2019/4/25 14:31
 * @Description:
 */
@Service
public class XslRewardServiceImpl implements XslRewardService {

    private static final Logger LOGGER = LoggerFactory.getLogger(XslRewardServiceImpl.class);

    @Autowired
    XslRewardMapper xslRewardMapper;
    @Override
    public XslReward selectRewardInfoByRewardId(String rewardId) throws RuntimeException{
        /**
         *
         * 功能描述: 根据RewardId 查询奖励信息
         *
         * @param: [rewardId]
         * @return: com.xsl.result.XslResult
         * @auther: 11432_000
         * @date: 2019/4/25 14:35
         */
        try{
            if (rewardId == null){
                LOGGER.error("selectRewardInfoByRewardId 参数为null");
                throw new RuntimeException("参数为null");
            }
            XslRewardExample xslRewardExample = new XslRewardExample();
            XslRewardExample.Criteria criteria = xslRewardExample.createCriteria();
            criteria.andRewardidEqualTo(rewardId);
            List<XslReward> xslRewards = xslRewardMapper.selectByExample(xslRewardExample);
            if (xslRewards == null || xslRewards.size() == 0){
                throw new RuntimeException("奖励不存在");
            }
            return (xslRewards.get(0));
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
    @Override
    public XslResult addReward(XslReward xslReward) throws RuntimeException {
        /**
         *
         * 功能描述: 添加一条奖励
         *
         * @param: [xslReward]
         * @return: com.xsl.result.XslResult
         * @auther: 11432_000
         * @date: 2019/4/26 10:22
         */
        try {
            String uuid = IdUtils.getUuid("R");
            xslReward.setRewardid(uuid);
            xslReward.setRewardstate(DataStates.NORMAL.getCode());
            int insert = xslRewardMapper.insertSelective(xslReward);
            if (insert <= 0){
                LOGGER.error("addReward 添加奖励失败");
                return ResultUtils.isError();
            }
            return ResultUtils.isOk(uuid);
        } catch (Exception e) {
            throw new RuntimeException("异常：" + e.getMessage());
        }
    }
    @Override
    public XslResult updateReward(XslReward xslReward) throws RuntimeException {
        /**
         *
         * 功能描述: 根据RewardId修改奖励
         *
         * @param: [xslReward]
         * @return: com.xsl.result.XslResult
         * @auther: 11432_000
         * @date: 2019/4/26 11:28
         */
        try {
            XslRewardExample xslRewardExample = new XslRewardExample();
            XslRewardExample.Criteria criteria = xslRewardExample.createCriteria();
            criteria.andRewardidEqualTo(xslReward.getRewardid());

            int i = xslRewardMapper.updateByExampleSelective(xslReward,xslRewardExample);
            if (i <= 0){
                LOGGER.error("updateReward 修改奖励失败");
                return ResultUtils.isError();
            }
            return ResultUtils.isOk();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    @Override
    public XslResult deleteReward(List<String> rewardIds) throws RuntimeException {
        /**
         *
         * 功能描述: 逻辑删除一条或多条奖励
         *
         * @param: [rewardIds]
         * @return: com.xsl.result.XslResult
         * @auther: 11432_000
         * @date: 2019/4/26 18:46
         */
        if (rewardIds == null){
            LOGGER.info("删除数据为null");
            return ResultUtils.isParameterError();
        }
        try {
            XslReward xslReward = new XslReward();
            XslRewardExample xslRewardExample = new XslRewardExample();
            XslRewardExample.Criteria criteria = xslRewardExample.createCriteria();
            criteria.andRewardidIn(rewardIds);
            xslReward.setRewardstate(DataStates.DELETE.getCode());

            int i = xslRewardMapper.updateByExampleSelective(xslReward,xslRewardExample);
            if (i < rewardIds.size() - 1){
                LOGGER.error("deleteReward 删除奖励部分失败");
            }
            return ResultUtils.isOk();
        } catch (Exception e) {
           throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public EasyUIDataGridResult getAllReward(Integer page,Integer rows) throws RuntimeException {
        /**
         *
         * 功能描述: 获取所有奖励  分页
         *
         * @param: []
         * @return: com.xsl.result.XslResult
         * @auther: 11432_000
         * @date: 2019/4/26 18:47
         */
        PageHelper.startPage(page,rows);
        try {
            XslRewardExample xslRewardExample = new XslRewardExample();
            xslRewardExample.createCriteria().andRewardstateNotEqualTo(DataStates.DELETE.getCode());
            List<XslReward> xslRewards = xslRewardMapper.selectByExample(xslRewardExample);
            PageInfo<XslReward> xslRewardPageInfo = new PageInfo<XslReward>(xslRewards);
            EasyUIDataGridResult result = new EasyUIDataGridResult();
            result.setRows(xslRewards);
            result.setTotal(xslRewardPageInfo.getTotal());
            return (result);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<XslReward> getAllReward() throws RuntimeException {
        /**
         *
         * 功能描述: 获取所有奖励  不分页
         *
         * @param: []
         * @return: java.util.List<com.xsl.pojo.XslReward>
         * @auther: 11432_000
         * @date: 2019/5/8 14:57
         */
        try {
            XslRewardExample xslRewardExample = new XslRewardExample();
            xslRewardExample.createCriteria().andRewardstateNotEqualTo(DataStates.DELETE.getCode());
            List<XslReward> xslRewards = xslRewardMapper.selectByExample(xslRewardExample);
            return xslRewards;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
