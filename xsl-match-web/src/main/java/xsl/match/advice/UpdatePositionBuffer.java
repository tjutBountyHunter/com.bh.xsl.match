package xsl.match.advice;

import com.xsl.Utils.JedisUtils;
import com.xsl.Utils.JsonUtils;
import com.xsl.Utils.ResultUtils;
import com.xsl.pojo.Vo.PositionDetailsResVo;
import com.xsl.pojo.Vo.PositionTagResVo;
import com.xsl.pojo.XslTeamPosition;
import com.xsl.result.XslResult;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import xsl.match.service.XslPositionService;
import xsl.match.service.XslPositionTagService;

import java.util.List;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2019/5/15 17:45
 * @Description:
 */
@Aspect
@Component
public class UpdatePositionBuffer {

	@Autowired
	private XslPositionTagService xslPositionTagService;
	@Autowired
	private XslPositionService xslPositionService;

	@Value("${POSITION_DETAILED_INFO}")
	private String POSITION_DETAILED_INFO;
	@Value("${POSITION_TAG_MAX_NUM}")
	private Integer POSITION_TAG_MAX_NUM;
	@Value("${POSITION_TAG_BUFFER}")
	private String POSITION_TAG_BUFFER;
	@Value("${POSITION_INFO_LIFETIME}")
	private Integer POSITION_INFO_LIFETIME;


	@AfterReturning(pointcut = "@annotation(com.xsl.annotation.UpdatePosition)" ,returning = "xslResult")
	public void updatePosition(JoinPoint joinPoint, XslResult xslResult){
		if (!ResultUtils.isSuccess(xslResult)){
			return;
		}
		Object[] args = joinPoint.getArgs();
		String positionId = (String) args[0];
		XslTeamPosition positionByPositionId = xslPositionService.getPositionByPositionId(positionId);
		if (StringUtils.isBlank(positionByPositionId.getPositionid())){
			JedisUtils.delete(POSITION_DETAILED_INFO + ":" + positionId);
		}
		PositionDetailsResVo positionDetailsResVo = new PositionDetailsResVo();
		//添加职位信息
		BeanUtils.copyProperties(positionByPositionId,positionDetailsResVo);
		//添加职位标签
		List<PositionTagResVo> allTagInfoByPositionId = xslPositionTagService.getAllTagInfoByPositionId(positionId);
		positionDetailsResVo.setTags(allTagInfoByPositionId);
		//添加缓存
		String toJson = JsonUtils.objectToJson(positionDetailsResVo);
		JedisUtils.set(POSITION_DETAILED_INFO + ":" + positionId,toJson);
		JedisUtils.expire(POSITION_DETAILED_INFO + ":" + positionId,POSITION_INFO_LIFETIME);
	}
}
