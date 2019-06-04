package xsl.match.controller;

import com.xsl.Utils.MYStringUtils;
import com.xsl.Utils.ResultUtils;
import com.xsl.enums.MemberStatesEnum;
import com.xsl.enums.ResultCodeEnum;
import com.xsl.pojo.Vo.MemberInfoResVo;
import com.xsl.pojo.Vo.MemberListResVo;
import com.xsl.pojo.XslMatch;
import com.xsl.pojo.XslMatchTeam;
import com.xsl.pojo.XslTeamMember;
import com.xsl.result.EasyUIDataGridResult;
import com.xsl.result.XslResult;
import com.xsl.search.export.vo.MatchTeamSearchVo;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xsl.match.service.GxzdESService;
import xsl.match.service.XslMatchTeamService;
import xsl.match.service.XslMemberService;

import java.util.List;

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
    private XslMatchTeamService xslMatchTeamService;
    @Autowired
    private XslMemberService xslMemberService;
    @Autowired
    private GxzdESService gxzdESService;

    @RequestMapping("/add")
    @ResponseBody
    XslResult addMtachTeam(@RequestBody XslMatchTeam xslMatchTeam){
        XslResult result = xslMatchTeamService.addATeam(xslMatchTeam);
        if (!ResultUtils.isSuccess(result) && ResultCodeEnum.RESOURCE_DUPLICATION.getCode().equals(result.getCode())){
            return result;
        }
        XslMatchTeam currentTeamByTeamId = xslMatchTeamService.getCurrentTeamByTeamId((String) result.getData());
        if (StringUtils.isNotBlank(currentTeamByTeamId.getTeamid())){
            return result;
        }
        return ResultUtils.parameterError();
    }

    @RequestMapping("/delete")
    @ResponseBody
    XslResult removeMtachTeam(@Param("teamIds") String teamIds){
        List<String> stringList = MYStringUtils.getStringList(teamIds, ",");
        XslResult result = xslMatchTeamService.deleteTeamInfoByIds(stringList);
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
        EasyUIDataGridResult teamPage = xslMatchTeamService.getTeamPage(page, rows);
        return teamPage;
    }

    @RequestMapping("/get/team/byHunter")
    @ResponseBody
    /** 根据hunterId获取所在队伍信息 */
    XslResult getTeamInfoByHunterId(@Param("hunterId")String hunterId){
        //检查是否为成员
        XslTeamMember memberByHunterId = xslMemberService.getMemberByHunterId(hunterId);
        if (StringUtils.isBlank(memberByHunterId.getTeamid())){
            return ResultUtils.parameterError();
        }
        XslMatchTeam currentTeamByTeamId = xslMatchTeamService.getCurrentTeamByTeamId(memberByHunterId.getTeamid());
        if (currentTeamByTeamId.getTeamid() == null){
            return ResultUtils.parameterError();
        }
        return ResultUtils.ok(currentTeamByTeamId);
    }

    @RequestMapping("/get/team/member")
    @ResponseBody
    /**  */
    XslResult getTeamMembers(@Param("teamId")String teamId){
        List<MemberListResVo> allMemberByTeamId = xslMemberService.getAllMemberByTeamId(teamId);
        return ResultUtils.ok(allMemberByTeamId);
    }

    @RequestMapping("/get/member/info")
    @ResponseBody
    /** 根据teamId获取队伍成员 */
    XslResult getMemberInfo(@Param("hunterId")String hunterId){
        MemberInfoResVo detailsByHunterId = xslMemberService.getDetailsByHunterId(hunterId);
        return ResultUtils.ok(detailsByHunterId);
    }

    @RequestMapping("/get/team/byTeamId")
    @ResponseBody
    /** 根据hunterId获取所在队伍信息 */
    XslResult getTeam(@Param("teamId")String teamId){
        XslMatchTeam currentTeamByTeamId = xslMatchTeamService.getCurrentTeamByTeamId(teamId);
        return ResultUtils.ok(currentTeamByTeamId);
    }


    @RequestMapping("/get/team/byMatchId")
    @ResponseBody
    /** 根据hunterId获取所在队伍信息 */
    XslResult getTeams(@Param("matchId")String matchId){
        List<XslMatchTeam> xslMatchTeams = xslMatchTeamService.selectAllTeamByMatch(matchId);
        return ResultUtils.ok(xslMatchTeams);
    }
}
