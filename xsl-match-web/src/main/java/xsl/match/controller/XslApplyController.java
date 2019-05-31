package xsl.match.controller;

import com.xsl.Utils.ResultUtils;
import com.xsl.enums.PositionApplicationStatesEnum;
import com.xsl.pojo.Vo.XslApplyResVo;
import com.xsl.pojo.XslPositionApplication;
import com.xsl.result.XslResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xsl.match.service.XslMemberService;
import xsl.match.service.XslPositionApplicationService;

import java.util.List;

/**
 * 说明：申请处理
 *
 * @Auther: 11432_000
 * @Date: 2019/5/15 10:54
 * @Description:
 */
@Controller
@RequestMapping("apply")
public class XslApplyController {

	@Autowired
	XslPositionApplicationService xslPositionApplicationService;
	@Autowired
	XslMemberService xslMemberService;

	@RequestMapping("/join/position")
	@ResponseBody
	/** 申请加入职位 */
	public XslResult addApply(@RequestBody XslPositionApplication xslPositionApplication){
		XslResult xslResult = xslPositionApplicationService.commitApply(xslPositionApplication.getPositionid(), xslPositionApplication.getHunterid(),
				xslPositionApplication.getTeamid());
		return xslResult;
	}

	@RequestMapping("/revoke")
	@ResponseBody
	/** 撤销申请 */
	public XslResult revokeApply(@RequestBody XslPositionApplication xslPositionApplication){
		XslResult xslResult = xslPositionApplicationService.changeApplyState(xslPositionApplication.getPositionid(),xslPositionApplication.getHunterid(),
				PositionApplicationStatesEnum.DELETE.getCode());
		return xslResult;
	}

	@RequestMapping("/refuse")
	@ResponseBody
	/** 拒绝申请 */
	public XslResult refuseApply(@RequestBody XslPositionApplication xslPositionApplication){
		XslResult xslResult = xslPositionApplicationService.changeApplyState(xslPositionApplication.getPositionid(),xslPositionApplication.getHunterid(),
				PositionApplicationStatesEnum.FAIL.getCode());
		return xslResult;
	}

	@RequestMapping("/agree")
	@ResponseBody
	/** 通过申请 */
	public XslResult agreeApply(@RequestBody XslPositionApplication xslPositionApplication){
		XslResult xslResult = xslPositionApplicationService.changeApplyState(xslPositionApplication.getPositionid(),xslPositionApplication.getHunterid(),
				PositionApplicationStatesEnum.SUCCESS.getCode());
		if (ResultUtils.isSuccess(xslResult)){
			XslResult xslResult1 = xslMemberService.addMember(xslPositionApplication.getPositionid(), xslPositionApplication.getHunterid(),
					xslPositionApplication.getTeamid());
			if (ResultUtils.isSuccess(xslResult1)){
				return ResultUtils.ok();
			}
		}
		return xslResult;
	}

	@RequestMapping("/get/list/byTeam")
	@ResponseBody
	/** 获取申请 */
	public XslResult revokeApply(@Param("teamId")String teamId,@Param("page")Integer page,@Param("rows")Integer rows){
		List<XslApplyResVo> allApplyByTeam = xslPositionApplicationService.getAllApplyByTeam(teamId,page,rows);
		return ResultUtils.ok(allApplyByTeam);
	}

}
