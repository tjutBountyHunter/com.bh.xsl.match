package xsl.match.service.impl;

import com.github.pagehelper.PageHelper;
import com.xsl.Utils.ResultUtils;
import com.xsl.enums.XslInvitationEnum;
import com.xsl.pojo.Example.XslInvitationExample;
import com.xsl.pojo.Vo.UserDetailedResVo;
import com.xsl.pojo.Vo.XslApplyResVo;
import com.xsl.pojo.XslInvitation;
import com.xsl.pojo.XslTeamPosition;
import com.xsl.result.XslResult;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xsl.match.mapper.XslInvitationMapper;
import xsl.match.service.XslInvitationService;
import xsl.match.service.XslPositionApplicationService;
import xsl.match.service.XslPositionService;
import xsl.match.service.XslUserService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2019/5/17 16:04
 * @Description:
 */
@Service
public class XslInvitationServiceImpl implements XslInvitationService {

	private static final Logger LOGGER = LoggerFactory.getLogger(XslInvitationServiceImpl.class);

	@Autowired
	private XslInvitationMapper xslInvitationMapper;
	@Autowired
	private XslUserService xslUserService;
	@Autowired
	private XslPositionService xslPositionService;

	@Override
	public XslResult commitInvitation(String positionId, String hunterId, String teamId) throws RuntimeException {
		/**
		 *
		 * 功能描述: 提交邀请
		 *
		 * @param: [positionId, hunterId]
		 * @return: com.xsl.result.XslResult
		 * @auther: 11432_000
		 * @date: 2019/5/10 19:12
		 */
		try {
			XslInvitation xslPositionApplication = new XslInvitation();
			xslPositionApplication.setApplicationstate(XslInvitationEnum.UNDER_PPLICATION.getCode());
			xslPositionApplication.setPositionid(positionId);
			xslPositionApplication.setHunterid(hunterId);
			xslPositionApplication.setTeamid(teamId);
			int i = xslInvitationMapper.insertSelective(xslPositionApplication);
			if (i <= 0){
				return ResultUtils.error("提交申请失败");
			}
			return ResultUtils.ok();
		} catch (RuntimeException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public XslResult changeInvitationState(String positionId, String hunterId, Integer state) throws RuntimeException {
		/**
		 *
		 * 功能描述: 更改邀请状态 userId为空则更新该职位的所有邀请
		 *
		 * @param: [positionId, userId, state]
		 * @return: com.xsl.result.XslResult
		 * @auther: 11432_000
		 * @date: 2019/5/10 19:17
		 */
		try {
			XslInvitation xslInvitation = new XslInvitation();
			xslInvitation.setApplicationstate(state);
			XslInvitationExample xslPositionApplicationExample = new XslInvitationExample();
			XslInvitationExample.Criteria criteria = xslPositionApplicationExample.createCriteria();
			if (hunterId != null){
				criteria.andHunteridEqualTo(hunterId);
			}
			criteria.andPositionidEqualTo(positionId).andApplicationstateEqualTo(XslInvitationEnum.UNDER_PPLICATION.getCode());
			int i = xslInvitationMapper.updateByExampleSelective(xslInvitation, xslPositionApplicationExample);
			if (i == 0){
				return ResultUtils.error("修改邀请失败");
			}
			return ResultUtils.ok();
		} catch (RuntimeException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	/** 查询指定职位的所有邀请 */
	public List<XslApplyResVo> getAllInvitationByPosition(String positionId, Integer page, Integer rows) throws RuntimeException {
		List<XslInvitation> application = getApplication(page,rows,positionId, null,null,
				XslInvitationEnum.UNDER_PPLICATION.getCode());
		return getUserList(application);
	}

	@Override
	/** 查询指定用户的所有邀请 */
	public List<XslApplyResVo> getAllInvitationByUser(String userId, Integer page, Integer rows) throws RuntimeException {
		List<XslInvitation> application = getApplication(page,rows,null,null,userId,XslInvitationEnum.UNDER_PPLICATION.getCode());
		return getUserList(application);
	}

	@Override
	/** 查询指定队伍的所有邀请 */
	public List<XslApplyResVo> getAllInvitationByTeam(String teamId, Integer page, Integer rows) throws RuntimeException {
		List<XslInvitation> application = getApplication(page,rows,null,null,teamId,
				XslInvitationEnum.UNDER_PPLICATION.getCode());
		return getUserList(application);
	}

	/** 获取邀请列表 */
	private List<XslApplyResVo> getUserList(List<XslInvitation> application){
		ArrayList<XslApplyResVo> xslApplyResVos = new ArrayList<>();
		for (XslInvitation xslInvitation : application){
			XslApplyResVo xslApplyResVo = new XslApplyResVo();
			//添加职位信息
			XslTeamPosition positionByPositionId = xslPositionService.getPositionByPositionId(xslInvitation.getPositionid());
			BeanUtils.copyProperties(positionByPositionId,xslApplyResVo);
			//添加用户信息
			UserDetailedResVo userDetailedInfo = xslUserService.getUserDetailedInfo(xslInvitation.getHunterid());
			BeanUtils.copyProperties(userDetailedInfo,xslApplyResVo);

		}
		return xslApplyResVos;
	}


	/** 根据职位、用户、状态获取邀请 (可分页)*/
	public List<XslInvitation> getApplication(Integer page,Integer rows,String positionId,String hunterId,String teamId,Integer... state)throws RuntimeException{
		try {
			if (page != null && rows != null){
				PageHelper.startPage(page,rows);
			}
			XslInvitationExample xslInvitationExample = new XslInvitationExample();
			XslInvitationExample.Criteria criteria = xslInvitationExample.createCriteria();
			if (StringUtils.isNotBlank(positionId)){
				criteria.andPositionidEqualTo(positionId);
			}
			if (StringUtils.isNotBlank(hunterId)){
				criteria.andHunteridEqualTo(hunterId);
			}
			if (StringUtils.isNotBlank(teamId)){
				criteria.andTeamidEqualTo(teamId);
			}
			if (state != null && state.length > 0){
				criteria.andApplicationstateIn(Arrays.asList(state));
			}
			List<XslInvitation> xslPositionApplications = xslInvitationMapper.selectByExample(xslInvitationExample);
			return xslPositionApplications;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
}
