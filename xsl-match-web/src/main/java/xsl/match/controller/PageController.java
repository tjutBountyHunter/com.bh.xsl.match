package xsl.match.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 说明：页面导航
 *
 * @Auther: 11432_000
 * @Date: 2019/4/20 18:14
 * @Description:
 */
@Controller
public class PageController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/match-add")
    public String matchAdd(){
        return "match-add";
    }

    @RequestMapping("/match-list")
    public String matchList(){
        return "match-list";
    }

    @RequestMapping("/match-edit")
    public String editMatch(){
        return "match-edit";
    }

    @RequestMapping("/match-rank-list")
    public String matchRankList(){
        return "match-rank-list";
    }

    @RequestMapping("/match-rank-edit")
    public String editMatchRank(){
        return "match-rank-edit";
    }
}
