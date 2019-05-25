package xsl.match.controller;

import com.xsl.Utils.ResultUtils;
import com.xsl.enums.PositionApplicationStatesEnum;
import com.xsl.pojo.Vo.XslApplyResVo;
import com.xsl.pojo.XslInvitation;
import com.xsl.pojo.XslPositionApplication;
import com.xsl.result.XslResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xsl.match.service.XslInvitationService;
import xsl.match.service.XslMemberService;
import xsl.match.service.XslPositionApplicationService;

import java.util.List;

/**
 * 说明：邀请处理
 *
 * @Auther: 11432_000
 * @Date: 2019/5/15 10:54
 * @Description:
 */
@Controller
@RequestMapping("invitation")
public class XslInvitationController {

	@Autowired
	XslInvitationService xslInvitationService;
	@Autowired
	XslMemberService xslMemberService;

	@RequestMapping("/join/position")
	@ResponseBody
	/** 邀请加入职位 */
	public XslResult addApply(@RequestBody XslInvitation xslInvitation){
		XslResult xslResult = xslInvitationService.commitInvitation(xslInvitation.getPositionid(), xslInvitation.getHunterid(),
				xslInvitation.getTeamid());
		return xslResult;
	}

	@RequestMapping("/revoke")
	@ResponseBody
	/** 撤销邀请 */
	public XslResult revokeApply(@RequestBody XslInvitation xslInvitation){
		XslResult xslResult = xslInvitationService.changeInvitationState(xslInvitation.getPositionid(),xslInvitation.getHunterid(),
				PositionApplicationStatesEnum.DELETE.getCode());
		return xslResult;
	}

	@RequestMapping("/agree")
	@ResponseBody
	/** 通过邀请 */
	public XslResult agreeApply(@RequestBody XslInvitation xslInvitation){
		XslResult xslResult = xslInvitationService.changeInvitationState(xslInvitation.getPositionid(),xslInvitation.getHunterid(),
				PositionApplicationStatesEnum.SUCCESS.getCode());
		if (ResultUtils.isSuccess(xslResult)){
			XslResult xslResult1 = xslMemberService.addMember(xslInvitation.getPositionid(), xslInvitation.getHunterid(),
					xslInvitation.getTeamid());
			if (ResultUtils.isSuccess(xslResult1)){
				return ResultUtils.ok();
			}
		}
		return xslResult;
	}

	@RequestMapping("/get/list/byTeam")
	@ResponseBody
	/** 获取邀请 */
	public XslResult getListByTeam(@Param("teamId")String teamId,@Param("page")Integer page,@Param("rows")Integer rows){
		List<XslApplyResVo> allApplyByTeam = xslInvitationService.getAllInvitationByTeam(teamId,page,rows);
		return ResultUtils.ok(allApplyByTeam);
	}

	@RequestMapping("/get/list/byHunter")
	@ResponseBody
	/** 获取邀请 */
	public XslResult getListByHunter(@Param("hunterId")String hunterId,@Param("page")Integer page,@Param("rows")Integer rows){
		List<XslApplyResVo> allApplyByTeam = xslInvitationService.getAllInvitationByUser(hunterId,page,rows);
		return ResultUtils.ok(allApplyByTeam);
	}

}
