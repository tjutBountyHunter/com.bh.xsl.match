package xsl.match.service.impl;

import com.xsl.Utils.ResultUtils;
import com.xsl.enums.PositonApplicationStates;
import com.xsl.pojo.Example.XslPositionApplicationExample;
import com.xsl.pojo.XslPositionApplication;
import com.xsl.result.XslResult;
import javafx.geometry.Pos;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xsl.match.mapper.XslPositionApplicationMapper;
import xsl.match.service.XslPositionApplicationService;

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
            xslPositionApplication.setApplicationstate(PositonApplicationStates.UNDER_PPLICATION.getCode());
            xslPositionApplication.setPositionid(positionId);
            xslPositionApplication.setUserid(hunterId);
            int i = xslPositionApplicationMapper.insertSelective(xslPositionApplication);
            if (i <= 0){
                return ResultUtils.isError("提交申请失败");
            }
            return ResultUtils.isOk();
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
                criteria.andUseridEqualTo(userId);
            }
            criteria.andPositionidEqualTo(positionId);
            int i = xslPositionApplicationMapper.updateByExampleSelective(xslPositionApplication, xslPositionApplicationExample);
            if (i == 0){
                return ResultUtils.isError("修改申请失败");
            }
            return ResultUtils.isOk();
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    /** 查询指定职位的所有申请 */
    public List<XslPositionApplication> getAllApplyByPosition(String positionId) throws RuntimeException {
        return getApplition(positionId,null,PositonApplicationStates.UNDER_PPLICATION.getCode());
    }

    @Override
    /** 查询指定用户的所有申请 */
    public List<XslPositionApplication> getAllApplyByUser(String userId) throws RuntimeException {
        return getApplition(null,userId);
    }

    /** 根据职位、用户、状态获取申请 */
    public List<XslPositionApplication> getApplition(String positionId,String userId,Integer... state)throws RuntimeException{
        try {
            XslPositionApplicationExample xslPositionApplicationExample = new XslPositionApplicationExample();
            XslPositionApplicationExample.Criteria criteria = xslPositionApplicationExample.createCriteria();
            if (StringUtils.isNotBlank(positionId)){
                criteria.andPositionidEqualTo(positionId);
            }
            if (StringUtils.isNotBlank(userId)){
                criteria.andUseridEqualTo(userId);
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
