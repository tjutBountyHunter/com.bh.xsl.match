package xsl.match.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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

    @RequestMapping("/match-rank-add")
    public String addMatchRank(){
        return "match-rank-add";
    }

    @RequestMapping("match-oriented-list")
    public String getOrientedList(){
        return "match-oriented-list";
    }

    @RequestMapping("match-oriented-add")
    public String addOriented(){
        return "match-oriented-add";
    }

    @RequestMapping("match-oriented-edit")
    public String editOriented(){
        return "match-oriented-edit";
    }

    @RequestMapping("match-reward-list")
    public String rewardList(){
        return "match-reward-list";
    }

    @RequestMapping("match-reward-add")
    public String rewardAdd(){
        return "match-reward-add";
    }

    @RequestMapping("match-reward-edit")
    public String rewardEdit(){
        return "match-reward-edit";
    }

    @RequestMapping("match-reward-rank-list")
    public String rewardRankList(){
        return "match-reward-rank-list";
    }

    @RequestMapping("match-reward-rank-add")
    public String rewardRankAdd(){
        return "match-reward-rank-add";
    }

    @RequestMapping("match-reward-list-index")
    public String rewardRankList_index(){
        return "match-reward-list-index";
    }

    @RequestMapping("match-type-list")
    public String matchTypeList(){
        return "match-type-list";
    }

    @RequestMapping("match-type-edit")
    public String matchTypeEdit(){
        return "match-type-edit";
    }

    @RequestMapping("match-type-add")
    public String matchTypeAdd(){
        return "match-type-add";
    }

    @RequestMapping("match-team-add")
    public String teamAdd(){
        return "match-team-add";
    }

    @RequestMapping("match-team-list")
    public String teamList(){
        return "match-team-list";
    }

    @RequestMapping("match-tag-list")
    public String tagList(){
        return "match-tag-list";
    }
    @RequestMapping("match-tag-edit")
    public String tagEdit(){
        return "match-tag-edit";
    }
    @RequestMapping("match-tag-add")
    public String tagAdd(){
        return "match-tag-add";
    }
}
