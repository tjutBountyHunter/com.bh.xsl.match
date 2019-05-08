package xsl.match.controller;

import com.xsl.Utils.MYStringUtils;
import com.xsl.Utils.ResultUtils;
import com.xsl.pojo.XslRewardRank;
import com.xsl.result.EasyUIDataGridResult;
import com.xsl.result.XslResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xsl.match.service.XslRewardRankService;

import java.util.List;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2019/4/25 17:58
 * @Description:
 */
@Controller
@RequestMapping("match/reward/rank")
public class XslRewardRankController {

    @Autowired
    XslRewardRankService xslRewardRankService;

    @RequestMapping("/select")
    @ResponseBody
    public XslRewardRank getRewardRankInfo(@Param("rewardRankId") String rewardRankId){
        XslRewardRank rewardRankByRewardRankId = xslRewardRankService.getRewardRankByRewardRankId(rewardRankId);
        return rewardRankByRewardRankId;
    }

    @RequestMapping("/selectAll")
    @ResponseBody
    public List<XslRewardRank> getAllRewardRank(){
        List<XslRewardRank> allRewardRank = xslRewardRankService.getAllRewardRank();
        return allRewardRank;
    }

    @RequestMapping("/selectAll/page")
    @ResponseBody
    public EasyUIDataGridResult getAllRewardRank(Integer page,Integer rows){
        EasyUIDataGridResult allRewardRank = xslRewardRankService.getAllRewardRank(page, rows);
        return allRewardRank;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public XslResult removeRewardRank(@Param("rewardRankIds") String rewardRankIds){
        List<String> stringList = MYStringUtils.getStringList(rewardRankIds, ",");
        return xslRewardRankService.deleteByRewardRankIds(stringList);
    }

    @RequestMapping("/add")
    @ResponseBody
    public XslResult removeRewardRank(@RequestBody XslRewardRank xslRewardRank){
        return xslRewardRankService.addRewardRank(xslRewardRank);
    }
}
