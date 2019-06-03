package xsl.match.controller;

import com.xsl.Utils.ResultUtils;
import com.xsl.pojo.XslUser;
import com.xsl.result.XslResult;
import com.xsl.search.export.vo.GxzdSearchReqVo;
import com.xsl.search.export.vo.MatchSearchVo;
import com.xsl.search.export.vo.MatchTeamSearchVo;
import com.xsl.search.export.vo.MatchUserSearchVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xsl.match.service.GxzdESService;

import java.util.List;

/**
 * @ClassName GxzdSearchController
 * @Description TODO
 * @Author 11432
 * @DATE 2019/6/1 17:56
 */
@Controller
@RequestMapping("gxzd/search")
public class GxzdSearchController {

    @Autowired
    private GxzdESService gxzdESService;

    @RequestMapping("/user")
    @ResponseBody
    /** 搜索用户 */
    public XslResult searchUser(@RequestBody GxzdSearchReqVo gxzdSearchReqVo){
        List<MatchUserSearchVo> matchUserSearchVos = gxzdESService.searchUser(gxzdSearchReqVo.getKeyWord(), gxzdSearchReqVo.getIds(), gxzdSearchReqVo.getSize());
        return ResultUtils.ok(matchUserSearchVos);
    }

    @RequestMapping("/match")
    @ResponseBody
    /** 搜索比赛 */
    public XslResult searchMatch(@RequestBody GxzdSearchReqVo gxzdSearchReqVo){
        List<MatchSearchVo> matchSearchVos = gxzdESService.searchMatch(gxzdSearchReqVo.getKeyWord(), gxzdSearchReqVo.getIds(), gxzdSearchReqVo.getSize());
        return ResultUtils.ok(matchSearchVos);
    }

    @RequestMapping("/team")
    @ResponseBody
    /** 搜索队伍 */
    public XslResult searchTeam(@RequestBody GxzdSearchReqVo gxzdSearchReqVo){
        List<MatchTeamSearchVo> matchTeamSearchVos = gxzdESService.searchTeam(gxzdSearchReqVo.getKeyWord(), gxzdSearchReqVo.getIds(), gxzdSearchReqVo.getSize());
        return ResultUtils.ok(matchTeamSearchVos);
    }
}
