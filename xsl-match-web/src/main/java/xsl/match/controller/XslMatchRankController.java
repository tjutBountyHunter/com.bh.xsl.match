package xsl.match.controller;

import com.xsl.pojo.XslMatchRank;
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
    XslMatchRankService rankService;

    @RequestMapping("/selectAll")
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
    public List<XslMatchRank> getAllRank(){
        ArrayList<XslMatchRank> allRank =(ArrayList<XslMatchRank>) rankService.getAllRank();
        return allRank;
    }


    @RequestMapping("/select")
    @ResponseBody
    public XslMatchRank getRank(@Param("rankId") Integer rankId){
        XslMatchRank allRank = rankService.getRank(rankId);
        return allRank;
    }

    @RequestMapping("/edit")
    @ResponseBody
    public XslResult editMatchRankInfo(@RequestBody XslMatchRank xslMatchRank){
        XslResult xslResult = rankService.updateMatchRankInfo(xslMatchRank);
        return xslResult;
    }

}
