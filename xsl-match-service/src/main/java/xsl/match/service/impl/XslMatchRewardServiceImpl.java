package xsl.match.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xsl.Utils.ResultUtils;
import com.xsl.enums.DataStates;
import com.xsl.enums.ResultCode;
import com.xsl.pojo.Example.XslMatchRewardExample;
import com.xsl.pojo.XslMatchReward;
import com.xsl.pojo.XslReward;
import com.xsl.result.EasyUIDataGridResult;
import com.xsl.result.XslResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xsl.match.mapper.XslMatchRewardMapper;
import xsl.match.service.XslMatchRewardService;
import xsl.match.service.XslRewardService;

import java.util.ArrayList;
import java.util.List;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2019/4/25 14:19
 * @Description:
 */
@Service
public class XslMatchRewardServiceImpl implements XslMatchRewardService {

    private static final Logger LOGGER = LoggerFactory.getLogger(XslMatchRewardServiceImpl.class);

    @Autowired
    XslMatchRewardMapper xslMatchRewardMapper;
    @Autowired
    XslRewardService xslRewardService;

    @Override
    public XslResult getReward(String matchId,Integer page,Integer rows) throws RuntimeException {
        /**
         *
         * 功能描述: 根据比赛ID 查询所有奖励，若ID为空则查询所有
         *
         * @param: [matchId]
         * @return: com.xsl.result.XslResult
         * @auther: 11432_000
         * @date: 2019/4/25 14:35
         */
        if (matchId == null){
            LOGGER.error("getRewardId 参数为null");
            return ResultUtils.isParameterError("参数为null");
        }
        List<XslMatchReward> xslMatchRewards;
        try{
            XslMatchRewardExample xslMatchRewardExample = new XslMatchRewardExample();
            XslMatchRewardExample.Criteria criteria = xslMatchRewardExample.createCriteria();
            if (matchId != null){
                criteria.andMatchidEqualTo(matchId);
            }
            criteria.andMatchrewardstateNotEqualTo(DataStates.DELETE.getCode());
            //获取该比赛的所有奖励Id
            xslMatchRewards = xslMatchRewardMapper.selectByExample(xslMatchRewardExample);
            ArrayList<XslReward> xslRewards = new ArrayList<XslReward>();
            for (XslMatchReward reward : xslMatchRewards){
                XslResult xslResult = xslRewardService.selectRewardInfoByRewardId(reward.getRewardid());
                if (!xslResult.getCode().equals(ResultCode.SUCCESS.getCode())){
                    LOGGER.error("getRewardId 查询失败 ");
                    return ResultUtils.isError();
                }
                xslRewards.add((XslReward) xslResult.getData());
            }
            EasyUIDataGridResult result = new EasyUIDataGridResult();
            result.setRows(xslRewards);
            //若没有分页信息
            if (page == null && rows == null ){
                return ResultUtils.isOk(result);
            }
            //设置分页
            PageHelper.startPage(page,rows);
            PageInfo<XslReward> xslRewardPageInfo = new PageInfo<XslReward>(xslRewards);
            result.setTotal(xslRewardPageInfo.getTotal());
            return ResultUtils.isOk(result);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
    @Override
    public XslResult addRewardToMatch(XslMatchReward xslMatchReward) {
        /**
         *
         * 功能描述: 为比赛添加一条奖励
         *
         * @param: [xslMatchReward]
         * @return: com.xsl.result.XslResult
         * @auther: 11432_000
         * @date: 2019/4/25 14:50
         */
        try {
            xslMatchReward.setMatchrewardstate(DataStates.NORMAL.getCode());
            int insert = xslMatchRewardMapper.insertSelective(xslMatchReward);
            if (insert <= 0){
                LOGGER.error("addRewardToMatch 添加数据失败 ");
                return ResultUtils.isError();
            }
            return ResultUtils.isOk();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    @Override
    public XslResult deleteByRewardIdAndMatchId(List<String> rewardIds,String matchId) throws RuntimeException {
        /**
         *
         * 功能描述: 逻辑删除比赛的一或多条奖励
         *
         * @param: [xslMatchReward]
         * @return: com.xsl.result.XslResult
         * @auther: 11432_000
         * @date: 2019/4/25 14:53
         */
        if (rewardIds == null || matchId == null){
            LOGGER.info("删除数据为null");
            return ResultUtils.isParameterError();
        }
        try {
            XslMatchReward xslMatchReward = new XslMatchReward();
            XslMatchRewardExample xslMatchRewardExample = new XslMatchRewardExample();
            XslMatchRewardExample.Criteria criteria = xslMatchRewardExample.createCriteria();
            criteria.andMatchidEqualTo(matchId).andRewardidIn(rewardIds);
            xslMatchReward.setMatchrewardstate(DataStates.DELETE.getCode());
            //逻辑删除关联数据
            int i = xslMatchRewardMapper.updateByExampleSelective(xslMatchReward, xslMatchRewardExample);
            //逻辑删除奖励数据
            XslResult result = xslRewardService.deleteReward(rewardIds);
            if (!ResultUtils.isSuccess(result) || i < rewardIds.size() - 1){
                return ResultUtils.isParameterError();
            }
            return ResultUtils.isOk();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }


}
