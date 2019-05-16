package xsl.match.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xsl.Utils.ResultUtils;
import com.xsl.enums.PositionApplicationStatesEnum;
import com.xsl.pojo.Example.XslPositionApplicationExample;
import com.xsl.pojo.Vo.UserDetailedResVo;
import com.xsl.pojo.Vo.XslApplyResVo;
import com.xsl.pojo.XslPositionApplication;
import com.xsl.pojo.XslTeamPosition;
import com.xsl.result.XslResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xsl.match.mapper.XslPositionApplicationMapper;
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
 * @Date: 2019/5/10 19:07
 * @Description:
 */
@Service
public class XslPositionApplicationServiceImpl implements XslPositionApplicationService {

    @Autowired
    private XslPositionApplicationMapper xslPositionApplicationMapper;
    @Autowired
    private XslUserService xslUserService;
    @Autowired
    private XslPositionService xslPositionService;

    @Override
    public XslResult commitApply(String positionId, String hunterId) throws RuntimeException {
        /**
         *
         * 功能描述: 提交申请
         *
         * @param: [positionId, hunterId]
         * @return: com.xsl.result.XslResult
         * @auther: 11432_000
         * @date: 2019/5/10 19:12
         */
        try {
            XslPositionApplication xslPositionApplication = new XslPositionApplication();
            xslPositionApplication.setApplicationstate(PositionApplicationStatesEnum.UNDER_PPLICATION.getCode());
            xslPositionApplication.setPositionid(positionId);
            xslPositionApplication.setHunterid(hunterId);
            int i = xslPositionApplicationMapper.insertSelective(xslPositionApplication);
            if (i <= 0){
                return ResultUtils.error("提交申请失败");
            }
            return ResultUtils.ok();
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public XslResult changeApplyState(String positionId, String userId, Integer state) throws RuntimeException {
        /**
         *
         * 功能描述: 更改申请状态 userId为空则更新该职位的所有申请
         *
         * @param: [positionId, userId, state]
         * @return: com.xsl.result.XslResult
         * @auther: 11432_000
         * @date: 2019/5/10 19:17
         */
        try {
            XslPositionApplication xslPositionApplication = new XslPositionApplication();
            xslPositionApplication.setApplicationstate(state);
            XslPositionApplicationExample xslPositionApplicationExample = new XslPositionApplicationExample();
            XslPositionApplicationExample.Criteria criteria = xslPositionApplicationExample.createCriteria();
            if (userId != null){
                criteria.andHunteridEqualTo(userId);
            }
            criteria.andPositionidEqualTo(positionId).andApplicationstateEqualTo(PositionApplicationStatesEnum.UNDER_PPLICATION.getCode());
            int i = xslPositionApplicationMapper.updateByExampleSelective(xslPositionApplication, xslPositionApplicationExample);
            if (i == 0){
                return ResultUtils.error("修改申请失败");
            }
            return ResultUtils.ok();
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    /** 查询指定职位的所有申请 */
    public List<XslApplyResVo> getAllApplyByPosition(String positionId,Integer page,Integer rows) throws RuntimeException {
        List<XslPositionApplication> application = getApplication(page,rows,positionId, null,null,
                PositionApplicationStatesEnum.UNDER_PPLICATION.getCode());
        return getUserList(application);
    }

    @Override
    /** 查询指定用户的所有申请 */
    public List<XslApplyResVo> getAllApplyByUser(String userId,Integer page,Integer rows) throws RuntimeException {
        List<XslPositionApplication> application = getApplication(page,rows,null,null,userId);
        return getUserList(application);
    }

    @Override
    /** 获取队伍的所有申请 */
    public List<XslApplyResVo> getAllApplyByTeam(String teamId,Integer page,Integer rows) throws RuntimeException {
        List<XslPositionApplication> application = getApplication(page,rows,null,null,teamId,
                PositionApplicationStatesEnum.UNDER_PPLICATION.getCode());
        return getUserList(application);
    }

    /** 获取申请列表 */
    private List<XslApplyResVo> getUserList(List<XslPositionApplication> application){
        ArrayList<XslApplyResVo> xslApplyResVos = new ArrayList<>();
        for (XslPositionApplication xslPositionApplication : application){
            //添加用户信息
            UserDetailedResVo userDetailedInfo = xslUserService.getUserDetailedInfo(xslPositionApplication.getHunterid());
            XslApplyResVo xslApplyResVo = new XslApplyResVo();
            BeanUtils.copyProperties(userDetailedInfo,xslApplyResVo);
            //添加职位信息
            XslTeamPosition positionByPositionId = xslPositionService.getPositionByPositionId(xslPositionApplication.getPositionid());
            BeanUtils.copyProperties(positionByPositionId,xslApplyResVo);
            xslApplyResVos.add(xslApplyResVo);
        }
        return xslApplyResVos;
    }

    /** 根据职位、用户、状态获取申请  (可分页)*/
    public List<XslPositionApplication> getApplication(Integer page,Integer rows,String positionId,String hunterId,String teamId,Integer... state)throws RuntimeException{
        try {
            if (page != null && rows != null){
                PageHelper.startPage(page,rows);
            }
            XslPositionApplicationExample xslPositionApplicationExample = new XslPositionApplicationExample();
            XslPositionApplicationExample.Criteria criteria = xslPositionApplicationExample.createCriteria();
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
            List<XslPositionApplication> xslPositionApplications = xslPositionApplicationMapper.selectByExample(xslPositionApplicationExample);
            return xslPositionApplications;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
