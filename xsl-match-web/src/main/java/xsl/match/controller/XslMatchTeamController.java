package xsl.match.controller;

import com.xsl.pojo.XslMatchTeam;
import com.xsl.result.EasyUIDataGridResult;
import com.xsl.result.XslResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xsl.match.service.XslMatchTeamService;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2019/4/27 18:07
 * @Description:
 */
@Controller
@RequestMapping("match/team")
public class XslMatchTeamController {

    @Autowired
    XslMatchTeamService xslMatchTeamService;

    @RequestMapping("/add")
    @ResponseBody
    XslResult addMtachTeam(@RequestBody XslMatchTeam xslMatchTeam){
        XslResult result = xslMatchTeamService.addATeam(xslMatchTeam);
        return result;
    }

    @RequestMapping("/delete")
    @ResponseBody
    XslResult removeMtachTeam(@Param("teamIds") String teamIds){
        XslResult result = xslMatchTeamService.deleteTeamInfoByIds(teamIds);
        return result;
    }

    @RequestMapping("/edit")
    @ResponseBody
    XslResult editMtachTeam(@RequestBody XslMatchTeam xslMatchTeam){
        XslResult result = xslMatchTeamService.updateATeamInfo(xslMatchTeam);
        return result;
    }

    @RequestMapping("/selectAll/page")
    @ResponseBody
    EasyUIDataGridResult getAllMtachTeamPage(Integer page, Integer rows){
        XslResult teamPage = xslMatchTeamService.getTeamPage(page, rows);
        return (EasyUIDataGridResult) teamPage.getData();
    }


}
