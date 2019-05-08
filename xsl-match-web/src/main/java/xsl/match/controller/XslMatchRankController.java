package xsl.match.controller;

import com.xsl.pojo.XslMatchRank;
import com.xsl.result.EasyUIDataGridResult;
import com.xsl.result.XslResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xsl.match.service.XslMatchRankService;


import java.util.ArrayList;
import java.util.List;

/**
 * 说明：比赛等级Controller
 *
 * @Auther: 11432_000
 * @Date: 2019/4/20 20:54
 * @Description:
 */
@Controller
@RequestMapping("match/rank")
public class XslMatchRankController {

    @Autowired
    XslMatchRankService xslMatchRankService;

    @RequestMapping("/selectAll/page")
    @ResponseBody
    /**
     *
     * 功能描述: 获取所有比赛等级
     *
     * @param: []
     * @return: java.util.List<com.xsl.pojo.XslMatchRank>
     * @auther: 11432_000
     * @date: 2019/4/21 14:26
     */
    public EasyUIDataGridResult getAllRankPage(Integer page,Integer rows){
        XslResult allRank = xslMatchRankService.getAllRank(page, rows);
        EasyUIDataGridResult data = (EasyUIDataGridResult) allRank.getData();
        return data;
    }

    @RequestMapping("/selectAll/list")
    @ResponseBody
    /**
     *
     * 功能描述: 获取所有比赛等级
     *
     * @param: []
     * @return: java.util.List<com.xsl.pojo.XslMatchRank>
     * @auther: 11432_000
     * @date: 2019/4/21 14:26
     */
    public List<XslMatchRank> getAllRankList(){
        XslResult allRank = xslMatchRankService.getAllRank();
        return (List<XslMatchRank>) allRank.getData();
    }


    @RequestMapping("/selectAll/list/app")
    @ResponseBody
    /**
     * 功能描述: 获取所有比赛等级
     */
    public XslResult getAllRankListApp(){
        XslResult allRank = xslMatchRankService.getAllRank();
        return allRank;
    }


    @RequestMapping("/select")
    @ResponseBody
    public XslMatchRank getRank(@Param("rankId") String rankId){
        XslMatchRank allRank =(XslMatchRank) xslMatchRankService.getRank(rankId).getData();
        return allRank;
    }

    @RequestMapping("/edit")
    @ResponseBody
    public XslResult editMatchRankInfo(@RequestBody XslMatchRank xslMatchRank){
        XslResult xslResult = xslMatchRankService.updateMatchRankInfo(xslMatchRank);
        return xslResult;
    }

    @RequestMapping("/add")
    @ResponseBody
    public XslResult addMatchRank(@RequestBody XslMatchRank xslMatchRank){
        return xslMatchRankService.addMatchRank(xslMatchRank);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public  XslResult deleteMatchRanks(@Param("matchRankIds") String matchRankIds){
        return xslMatchRankService.deleteMatchRanks(matchRankIds);
    }

}
