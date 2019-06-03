package xsl.match.advice;

import com.xsl.Utils.JedisUtils;
import com.xsl.Utils.JsonUtils;
import com.xsl.Utils.ResultUtils;
import com.xsl.pojo.Example.XslUserExample;
import com.xsl.pojo.Vo.HunterTagResVo;
import com.xsl.pojo.Vo.UserDetailedResVo;
import com.xsl.pojo.XslMatchUser;
import com.xsl.pojo.XslSchoolinfo;
import com.xsl.pojo.XslUser;
import com.xsl.result.XslResult;
import com.xsl.search.export.vo.MatchUserSearchVo;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;
import xsl.match.mapper.XslFileMapper;
import xsl.match.mapper.XslSchoolinfoMapper;
import xsl.match.mapper.XslUserFileMapper;
import xsl.match.mapper.XslUserMapper;
import xsl.match.service.GxzdESService;
import xsl.match.service.XslMatchUserService;
import xsl.match.service.XslUserService;
import xsl.match.service.impl.XslUserServiceImpl;

import java.util.List;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2019/5/15 14:07
 * @Description:
 */
@Aspect
@Component
public class UpdateUserBuffer {

	@Autowired
	private XslUserMapper xslUserMapper;
	@Autowired
	private XslMatchUserService xslMatchUserService;
	@Autowired
	private XslUserService xslUserService;
	@Autowired
	private ThreadPoolTaskExecutor threadPoolTaskExecutor;
	@Autowired
	private GxzdESService gxzdESService;

	private static final Logger LOGGER = LoggerFactory.getLogger(XslUserServiceImpl.class);

	@Value("${MATCH_HUNTER_PREFIX}")
	private String MATCH_HUNTER_PREFIX;
	@Value("${MATCH_TAG_PREFIX}")
	private String MATCH_TAG_PREFIX;
	@Value("${USER_DETAILED_INFO}")
	private String USER_DETAILED_INFO;
	@Value("${USER_INFO_LIFETIME}")
	private Integer USER_INFO_LIFETIME;

	@AfterReturning(pointcut = "@annotation(com.xsl.annotation.UpdateUser)" ,returning = "xslResult")
	public void updateUser(JoinPoint joinPoint, XslResult xslResult){
		if (!ResultUtils.isSuccess(xslResult)){
			return;
		}
		threadPoolTaskExecutor.execute(() -> {
			Object[] args = joinPoint.getArgs();
			String userId = (String) args[0];
			XslUserExample xslUserExample = new XslUserExample();
			XslUserExample.Criteria criteria = xslUserExample.createCriteria();
			if (!userId.startsWith(MATCH_HUNTER_PREFIX)){
				criteria.andUseridEqualTo(userId);
			}else {
				userId = userId.replaceFirst(MATCH_HUNTER_PREFIX,"");
				criteria.andHunteridEqualTo(userId);
			}
			List<XslUser> xslUsers = xslUserMapper.selectByExample(xslUserExample);
			if (xslUsers.size() == 0){
				throw new RuntimeException("用户信息不存在");
			}
			//添加基本信息
			XslUser xslUser = xslUsers.get(0);
			String hunterId = MATCH_HUNTER_PREFIX + xslUser.getHunterid();
			UserDetailedResVo userDetailedResVo = new UserDetailedResVo();
			BeanUtils.copyProperties(xslUser,userDetailedResVo);
			//添加补充信息
			XslMatchUser xslMatchUser = xslMatchUserService.selectMatchUserInfoByUserId(hunterId);
			BeanUtils.copyProperties(xslMatchUser,userDetailedResVo);
			// 添加标签
			List<HunterTagResVo> allTagsInfoByHunterId = xslMatchUserService.getAllTagsInfoByHunterId(xslUser.getHunterid());
			userDetailedResVo.setTags(allTagsInfoByHunterId);
			//添加学校信息
			XslSchoolinfo schoolInfo = xslUserService.getSchoolInfo(xslUser.getSchoolinfo());
			BeanUtils.copyProperties(schoolInfo,userDetailedResVo);
			//更新缓存
			String toJson = JsonUtils.objectToJson(userDetailedResVo);
			JedisUtils.set(USER_DETAILED_INFO + ":" + userDetailedResVo.getHunterid(),toJson);
			JedisUtils.expire(USER_DETAILED_INFO + ":" + userDetailedResVo.getHunterid(),USER_INFO_LIFETIME);
			//更新搜索库
			boolean success = false;
			MatchUserSearchVo matchUserSearchVo = new MatchUserSearchVo();
			BeanUtils.copyProperties(userDetailedResVo,matchUserSearchVo);
			success = gxzdESService.addUser(matchUserSearchVo);
		});
	}
}
