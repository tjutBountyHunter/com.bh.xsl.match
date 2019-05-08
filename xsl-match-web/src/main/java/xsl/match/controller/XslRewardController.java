package xsl.match.controller;

import com.xsl.Utils.MYStringUtils;
import com.xsl.Utils.ResultUtils;
import com.xsl.enums.ResultCode;
import com.xsl.pojo.Vo.XslMatchRewardReqVo;
import com.xsl.pojo.XslMatchReward;
import com.xsl.pojo.XslReward;
import com.xsl.result.EasyUIDataGridResult;
import com.xsl.result.XslResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xsl.match.service.XslMatchRewardService;
import xsl.match.service.XslRewardService;

import java.util.List;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2019/4/25 17:00
 * @Description:
 */
@Controller
@RequestMapping("match/reward")
public class XslRewardController {

    @Autowired
    XslMatchRewardService xslMatchRewardService;
    @Autowired
    XslRewardService xslRewardService;

    @RequestMapping("/select/info")
    @ResponseBody
    public EasyUIDataGridResult getMatchRewardList(@Param("matchId") String matchId, Integer page, Integer rows){
        /**
         *
         * 功能描述: 获取比赛的所有奖励
         *
         * @param: [matchId, page, rows]
         * @return: com.xsl.result.EasyUIDataGridResult
         * @auther: 11432_000
         * @date: 2019/4/26 11:30
         */
        if (matchId == null){
            EasyUIDataGridResult allReward = xslRewardService.getAllReward(page, rows);
            return allReward;
        }
        EasyUIDataGridResult reward = xslMatchRewardService.getReward(matchId, page, rows);
        return reward;
    }

    @RequestMapping("/add")
    @ResponseBody
    public XslResult setMatchReward(@RequestBody XslMatchRewardReqVo xslMatchRewardReqVo){
        /**
         *
         * 功能描述: 为比赛添加一条奖励
         *
         * @param: [xslMatchRewardReqVo]
         * @return: com.xsl.result.XslResult
         * @auther: 11432_000
         * @date: 2019/4/26 11:30
         */
        XslMatchReward xslMatchReward = new XslMatchReward();
        XslReward xslReward =  new XslReward();
        BeanUtils.copyProperties(xslMatchRewardReqVo,xslMatchReward);
        BeanUtils.copyProperties(xslMatchRewardReqVo,xslReward);
        XslResult result = xslRewardService.addReward(xslReward);
        if (!result.getCode().equals(ResultCode.SUCCESS.getCode())){
            return ResultUtils.isError();
        }
        xslMatchReward.setRewardid(result.getData().toString());
        XslResult result_1 = xslMatchRewardService.addRewardToMatch(xslMatchReward);
        if (!result_1.getCode().equals(ResultCode.SUCCESS.getCode())){
            return ResultUtils.isError();
        }
        return ResultUtils.isOk();
    }


    @RequestMapping("/edit")
    @ResponseBody
    public XslResult editMatchReward(@RequestBody XslMatchRewardReqVo xslMatchRewardReqVo){
        /**
         *
         * 功能描述: 修改奖励信息
         *
         * @param: [xslMatchRewardReqVo]
         * @return: com.xsl.result.XslResult
         * @auther: 11432_000
         * @date: 2019/4/26 11:30
         */
        XslReward xslReward =  new XslReward();
        BeanUtils.copyProperties(xslMatchRewardReqVo,xslReward);
        XslResult result = xslRewardService.updateReward(xslReward);
        return result;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public XslResult removeMatchReward(@Param("rewardIds") String rewardIds,@Param("matchId") String matchId){
        List<String> stringList = MYStringUtils.getStringList(rewardIds, ",");
        XslResult result = xslMatchRewardService.deleteByRewardIdAndMatchId(stringList, matchId);
        return result;
    }
}
