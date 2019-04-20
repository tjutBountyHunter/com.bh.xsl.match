package xsl.match.controller;

import com.xsl.pojo.XslMatchRank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xsl.match.service.XslMatchRankService;


import java.util.List;

/**
 * 说明：比赛等级Controller
 *
 * @Auther: 11432_000
 * @Date: 2019/4/20 20:54
 * @Description:
 */
@Controller
public class XslMatchRankController {

    @Autowired
    XslMatchRankService rankService;

    @RequestMapping("match/select/rank")
    @ResponseBody
    public List<XslMatchRank> getAllRank(){
        List<XslMatchRank> allRank = rankService.getAllRank();
        return allRank;
    }
}
