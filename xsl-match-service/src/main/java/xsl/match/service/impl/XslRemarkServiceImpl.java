package xsl.match.service.impl;

import com.xsl.Utils.ResultUtils;
import com.xsl.enums.RemarkStateEnum;
import com.xsl.pojo.Example.XslMatchRemarkExample;
import com.xsl.pojo.XslMatchRemark;;
import com.xsl.pojo.XslMatchUser;
import com.xsl.result.XslResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import xsl.match.mapper.XslMatchRemarkMapper;
import xsl.match.service.XslMatchUserService;
import xsl.match.service.XslRemarkService;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName XslRemarkServiceImpl
 * @Description TODO
 * @Author 11432
 * @DATE 2019/6/2 19:06
 */
@Service
public class XslRemarkServiceImpl implements XslRemarkService {

    @Autowired
    private XslMatchRemarkMapper xslMatchRemarkMapper;
    @Autowired
    private XslMatchUserService xslMatchUserService;
    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Override
    /** 添加评论 */
    public XslResult addRemark(XslMatchRemark xslMatchRemark) throws RuntimeException {
        if (check(xslMatchRemark)){
            return ResultUtils.parameterError("评论已存在");
        }
        xslMatchRemark.setState(RemarkStateEnum.NORMAL.getCode());
        int i = xslMatchRemarkMapper.insertSelective(xslMatchRemark);
        if (i < 0){
            return ResultUtils.error();
        }
        XslMatchRemark remark = xslMatchRemark;
        threadPoolTaskExecutor.execute(()->{
            updateFeatures(remark.getTargetid(),remark);
        });
        return ResultUtils.ok();
    }

    @Override
    /** 删除评论 */
    public XslResult removeRemark(String commentatorId,String targetId,String teamId) throws RuntimeException {
        XslMatchRemarkExample xslMatchRemarkExample = new XslMatchRemarkExample();
        xslMatchRemarkExample.createCriteria().andTeamidEqualTo(teamId).andCommentatoridEqualTo(commentatorId).andTargetidEqualTo(targetId);
        int i = xslMatchRemarkMapper.deleteByExample(xslMatchRemarkExample);
        if (i < 0){
            return ResultUtils.error();
        }
        return ResultUtils.ok();
    }

    @Override
    public List<XslMatchRemark> selectRemarkByCommentatorIdAndTargetId(String commentatorId, String targetId,String teamId) throws RuntimeException {
        return getRemarks(commentatorId,targetId,teamId);
    }

    @Override
    public List<XslMatchRemark> selectRemarkByTargetId(String targetId) throws RuntimeException {
        return getRemarks(null,targetId,null);
    }

    /** 获取评论 */
    private List<XslMatchRemark> getRemarks(String commentatorId, String targetId,String teamId,Integer... state){
        XslMatchRemarkExample xslMatchRemarkExample = new XslMatchRemarkExample();
        XslMatchRemarkExample.Criteria criteria = xslMatchRemarkExample.createCriteria();
        if (StringUtils.isNoneBlank(commentatorId)){
            criteria.andCommentatoridEqualTo(commentatorId);
        }
        if (StringUtils.isNoneBlank(targetId)){
            criteria.andTargetidEqualTo(targetId);
        }
        if (StringUtils.isNotBlank(teamId)){
            criteria.andTeamidEqualTo(teamId);
        }
        if (state != null && state.length > 0){
            criteria.andStateIn(Arrays.asList(state));
        }
        List<XslMatchRemark> xslMatchRemarks = xslMatchRemarkMapper.selectByExample(xslMatchRemarkExample);
        return xslMatchRemarks;
    }
    /** 校验评论是否合法 */
    private boolean check(XslMatchRemark xslMatchRemark){
        //检验评论是否重复
        XslMatchRemarkExample xslMatchRemarkExample = new XslMatchRemarkExample();
        xslMatchRemarkExample.createCriteria().andCommentatoridEqualTo(xslMatchRemark.getCommentatorid()).andTeamidEqualTo(xslMatchRemark.getTeamid()).
                andTargetidEqualTo(xslMatchRemark.getTargetid()).andStateEqualTo(RemarkStateEnum.NORMAL.getCode());
        List<XslMatchRemark> xslMatchRemarks = xslMatchRemarkMapper.selectByExample(xslMatchRemarkExample);
        if (xslMatchRemarks.size() > 0){
            return false;
        }
        return true;
        //校验时间是否合法
//        XslMatchTeam currentTeamByTeamId = xslMatchTeamService.getCurrentTeamByTeamId(xslMatchRemark.getTeamid());
//        Integer teamState = currentTeamByTeamId.getTeamstate();
//        if (TeamStatesEnum.DISBANDED.getCode().equals(teamState) || TeamStatesEnum.FINISH.getCode().equals(teamState)){
//            return true;
//        }
//        return false;
    }
    /** 更新特征属性 */
    private void updateFeatures(String targetId,XslMatchRemark xslMatchRemark){
        XslMatchUser xslMatchUser = xslMatchUserService.selectMatchUserInfoByHunterId(targetId);
        if (StringUtils.isNotBlank(xslMatchUser.getHunterid())){
            Integer after = getTaskAccNum(xslMatchUser.getTaskaccnum(), xslMatchRemark.getScore());
            xslMatchUser.setTaskaccnum(after);
            if (xslMatchRemark.getScore() <= 2){
                Short credit = getCredit(xslMatchUser.getCredit(), xslMatchRemark.getScore());
                xslMatchUser.setCredit(credit);
            }
            XslResult xslResult = xslMatchUserService.updateMatchUserInfo(xslMatchUser.getHunterid(), xslMatchUser);
        }
    }

    private Integer getTaskAccNum(Integer before,Integer score){
        switch (score){
            case 1:
            case 2:
            case 3:
                return before + 2;
            case 4:
                return before + 3;
            case 5:
                return before + 5;
                default:
                    return before;
        }
    }

    private Short getCredit(Short before,Integer score){
       return (short)(before - 2 > 0 ? (before - 2) : 0);
    }
}
