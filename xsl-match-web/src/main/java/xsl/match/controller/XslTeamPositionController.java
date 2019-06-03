package xsl.match.controller;

import com.xsl.Utils.ResultUtils;
import com.xsl.enums.PositionStatesEnum;
import com.xsl.pojo.Vo.PositionDetailsResVo;
import com.xsl.pojo.Vo.PositionTagResVo;
import com.xsl.pojo.Vo.PositionUpdateReqVo;
import com.xsl.pojo.Vo.RecommendResVo;
import com.xsl.pojo.XslTeamPosition;
import com.xsl.result.XslResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xsl.match.service.MatchUserRecommend;
import xsl.match.service.XslPositionService;
import xsl.match.service.XslPositionTagService;

import java.util.ArrayList;
import java.util.List;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2019/5/13 15:37
 * @Description:
 */
@Controller
@RequestMapping("position/")
public class XslTeamPositionController {

	@Autowired
	XslPositionService xslPositionService;
	@Autowired
	XslPositionTagService xslPositionTagService;
	@Autowired
	MatchUserRecommend matchUserRecommend;

	@RequestMapping("get/info")
	@ResponseBody
	/** 获取职位信息 */
	public XslResult getPositionInfo(@Param("positionId") String positionId){
		XslTeamPosition positionByPositionId = xslPositionService.getPositionByPositionId(positionId);
		List<PositionTagResVo> allTagInfoByPositionId = xslPositionTagService.getAllTagInfoByPositionId(positionId);
		PositionDetailsResVo xslResult = new PositionDetailsResVo();
		BeanUtils.copyProperties(positionByPositionId,xslResult);
		xslResult.setTags(allTagInfoByPositionId);
		return ResultUtils.ok(xslResult);
	}

	@RequestMapping("get/list")
	@ResponseBody
	/** 获取职位信息 */
	public XslResult getPositionList(@Param("teamId") String teamId){
		List<XslTeamPosition> allPositionByTeamId = xslPositionService.getAllPositionByTeamId(teamId);
		return ResultUtils.ok(allPositionByTeamId);
	}


	@RequestMapping("edit/info")
	@ResponseBody
	/** 更改职位信息 */
	public XslResult editPositionInfo(@RequestBody PositionUpdateReqVo positionUpdateReqVo){
		XslTeamPosition xslTeamPosition = new XslTeamPosition();
		BeanUtils.copyProperties(positionUpdateReqVo,xslTeamPosition);
		XslResult xslResult = xslPositionService.updatePosition(xslTeamPosition.getPositionid(),xslTeamPosition);
		if (!ResultUtils.isSuccess(xslResult)){
			return xslResult;
		}
		List<String> tags = new ArrayList<>();
		if (positionUpdateReqVo.getTagIds() != null){
			tags = positionUpdateReqVo.getTagIds();
		}
		XslResult xslResult1 = xslPositionTagService.updateTags(positionUpdateReqVo.getPositionid(), tags);
		if (!ResultUtils.isSuccess(xslResult1)){
			//重新生成推荐
			matchUserRecommend.recommended(positionUpdateReqVo.getPositionid());
			return xslResult1;
		}
		return ResultUtils.ok();
	}


	@RequestMapping("add/info")
	@ResponseBody
	/** 添加职位信息 */
	public XslResult addPositionInfo(@RequestBody PositionUpdateReqVo positionUpdateReqVo){
		XslTeamPosition xslTeamPosition = new XslTeamPosition();
		BeanUtils.copyProperties(positionUpdateReqVo,xslTeamPosition);
		XslResult xslResult = xslPositionService.addPosition(xslTeamPosition);
		if (!ResultUtils.isSuccess(xslResult)){
			return xslResult;
		}
		if (positionUpdateReqVo.getTagIds() != null && positionUpdateReqVo.getTagIds().size() != 0){
			List<String> tags = positionUpdateReqVo.getTagIds();
			String positionId = xslResult.getData().toString();
			XslResult xslResult1 = xslPositionTagService.addPositionTags(positionId, tags);
			if (!ResultUtils.isSuccess(xslResult1)){
				//启动推荐
				matchUserRecommend.recommended(positionId);
				return xslResult1;
			}
		}
		return ResultUtils.ok();
	}

	@RequestMapping("get/recommended")
	@ResponseBody
	/** 获取推荐 */
	public XslResult getRecommended(@Param("positionId")String positionId){
		List<RecommendResVo> recommend = xslPositionService.getRecommend(positionId);
		if (recommend.size() == 0){
			return ResultUtils.notHave();
		}
		return ResultUtils.ok(recommend);
	}



	@RequestMapping("get/null")
	@ResponseBody
	/** 获取空闲职位 */
	public XslResult getNullPosition(@Param("teamId")String teamId){
		List<XslTeamPosition> xslTeamPositions = xslPositionService.getAllPositionByTeamIdAndState(teamId, PositionStatesEnum.RECRUITMENT.getCode());
		return ResultUtils.ok(xslTeamPositions);
	}
}
