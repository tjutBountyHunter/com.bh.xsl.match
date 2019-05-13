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
import org.springframework.util.StringUtils;
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
    private XslMatchRewardMapper xslMatchRewardMapper;
    @Autowired
    private XslRewardService xslRewardService;

    @Override
    public EasyUIDataGridResult getReward(String matchId,Integer page,Integer rows) throws RuntimeException {
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
            throw new RuntimeException("参数为null");
        }
        //设置分页
        PageHelper.startPage(page,rows);
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
            for (XslMatchReward xslMatchReward : xslMatchRewards){
                XslReward rewardById = getRewardById(xslMatchReward.getRewardid());
                xslRewards.add(rewardById);
            }
            EasyUIDataGridResult result = new EasyUIDataGridResult();
            result.setRows(xslRewards);
            //若没有分页信息
            PageInfo<XslMatchReward> pageInfo = new PageInfo<XslMatchReward>(xslMatchRewards);
            result.setTotal(pageInfo.getTotal());
            return result;
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public  List<XslReward> getReward(String matchId) throws RuntimeException {
        /**
         *
         * 功能描述: 根据比赛ID 查询所有奖励，若ID为空则查询所有 不分页
         *
         * @param: [matchId]
         * @return: com.xsl.result.XslResult
         * @auther: 11432_000
         * @date: 2019/4/25 14:35
         */
        if (matchId == null){
            LOGGER.error("getRewardId 参数为null");
            throw new RuntimeException("参数为null");
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
            List<XslReward> xslRewards = new ArrayList<XslReward>();
            for (XslMatchReward xslMatchReward : xslMatchRewards){
                XslReward rewardById = getRewardById(xslMatchReward.getRewardid());
                xslRewards.add(rewardById);
            }
            return xslRewards;
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public XslReward getRewardById(String rewardId)throws RuntimeException{
        XslReward xslReward = xslRewardService.selectRewardInfoByRewardId(rewardId);
        return xslReward;
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
