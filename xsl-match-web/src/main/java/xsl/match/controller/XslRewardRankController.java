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
        XslResult result = xslRewardRankService.getRewardRankByRewardRankId(rewardRankId);
        return (XslRewardRank) result.getData();
    }

    @RequestMapping("/selectAll")
    @ResponseBody
    public List<XslRewardRank> getAllRewardRank(){
        XslResult allRewardRank = xslRewardRankService.getAllRewardRank(null,null);
        return (List<XslRewardRank>) allRewardRank.getData();
    }

    @RequestMapping("/selectAll/page")
    @ResponseBody
    public EasyUIDataGridResult getAllRewardRank(Integer page,Integer rows){
        XslResult allRewardRank = xslRewardRankService.getAllRewardRank(page,rows);
        return ((EasyUIDataGridResult) allRewardRank.getData());
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
