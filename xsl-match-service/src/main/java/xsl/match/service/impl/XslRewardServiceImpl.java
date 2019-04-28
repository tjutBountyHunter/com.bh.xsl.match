package xsl.match.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xsl.Utils.IdUtils;
import com.xsl.Utils.ResultUtils;
import com.xsl.enums.DataStates;
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
    public XslResult selectRewardInfoByRewardId(String rewardId) throws RuntimeException{
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
                return ResultUtils.isParameterError("参数为null");
            }
            XslReward xslReward = xslRewardMapper.selectRewardByRewardId(rewardId);
            return ResultUtils.isOk(xslReward);
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
            xslReward.setRewardId(uuid);
            xslReward.setRewardState(DataStates.NORMAL.getCode());
            int insert = xslRewardMapper.insert(xslReward);
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
            int i = xslRewardMapper.updateByRewardId(xslReward);
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
    public XslResult deleteReward(String rewardIds) throws RuntimeException {
        /**
         *
         * 功能描述: 逻辑删除一条奖励
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
        //拆分多个id
        String[] split = rewardIds.split(",");
        if (split.length == 0){
            return ResultUtils.isParameterError();
        }
        try {
            XslReward xslReward = new XslReward();
            for (String rewardId : split){
                xslReward.setRewardId(rewardId);
                xslReward.setRewardState(DataStates.DELETE.getCode());
                int i = xslRewardMapper.updateRewardStateByRewardId(xslReward);
                if (i <= 0){
                    LOGGER.error("deleteReward 删除奖励失败");
                    return ResultUtils.isError();
                }
            }
            return ResultUtils.isOk();
        } catch (Exception e) {
           throw new RuntimeException(e.getMessage());
        }
    }
    @Override
    public XslResult getAllReward(Integer page,Integer rows) throws RuntimeException {
        /**
         *
         * 功能描述: 获取所有奖励
         *
         * @param: []
         * @return: com.xsl.result.XslResult
         * @auther: 11432_000
         * @date: 2019/4/26 18:47
         */
        try {
            List<XslReward> xslRewards = xslRewardMapper.selectAllReward();
            PageHelper.startPage(page,rows);
            PageInfo<XslReward> xslRewardPageInfo = new PageInfo<XslReward>(xslRewards);
            EasyUIDataGridResult result = new EasyUIDataGridResult();
            result.setRows(xslRewards);
            result.setTotal(xslRewardPageInfo.getTotal());
            return ResultUtils.isOk(result);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
