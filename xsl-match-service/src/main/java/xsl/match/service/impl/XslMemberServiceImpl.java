package xsl.match.service.impl;

import com.xsl.Utils.IdUtils;
import com.xsl.Utils.MatchArrayUtils;
import com.xsl.Utils.ResultUtils;
import com.xsl.enums.MemberStatesEnum;
import com.xsl.enums.TeamStatesEnum;
import com.xsl.pojo.*;
import com.xsl.pojo.Example.XslTeamMemberExample;
import com.xsl.pojo.Vo.MemberInfoResVo;
import com.xsl.pojo.Vo.MemberListResVo;
import com.xsl.pojo.Vo.PositionDetailsResVo;
import com.xsl.pojo.Vo.UserDetailedResVo;
import com.xsl.result.XslResult;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import xsl.match.mapper.XslTeamMemberMapper;
import xsl.match.service.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2019/5/4 09:07
 * @Description:
 */
@Service
public class XslMemberServiceImpl implements XslMemberService {

    private static final Logger LOGGER = LoggerFactory.getLogger(XslMemberServiceImpl.class);

    @Autowired
    private XslTeamMemberMapper xslTeamMemberMapper;
    @Autowired
    private XslPositionService xslPositionService;
    @Autowired
    private XslUserService xslUserService;
    @Autowired
    private XslMatchTeamService xslMatchTeamService;
    @Autowired
    private XslMatchUserService xslMatchUserService;
    @Autowired
    private XslMatchService xslMatchService;
    @Autowired
    private XslMatchRankService xslMatchRankService;
    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Override
    public List<MemberListResVo> getAllMemberByTeamId(String teamId) throws RuntimeException {
        /**
         *
         * 功能描述: 获取成员信息
         *
         * @param: [teamId]
         * @return: com.xsl.result.XslResult
         * @auther: 11432_000
         * @date: 2019/5/4 15:21
         */
        try {
            //获取所有职位
            List<XslTeamPosition> allPositionByTeamId = xslPositionService.getAllPositionByTeamId(teamId);
            if (allPositionByTeamId.size() == 0){
                return (new ArrayList<MemberListResVo>());
            }
            List<MemberListResVo> memberInfos = new ArrayList<>();
            MemberListResVo memberInfo;
            //添加查询条件，获取所有有关成员
            XslTeamMemberExample xslTeamMemberExample = new XslTeamMemberExample();
            XslTeamMemberExample.Criteria criteria = xslTeamMemberExample.createCriteria();
            for (XslTeamPosition xslTeamPosition : allPositionByTeamId){
                xslTeamMemberExample.clear();
                //添加职位信息
                memberInfo = new MemberListResVo();
                BeanUtils.copyProperties(xslTeamPosition,memberInfo);
                //添加成员信息
                criteria.andPositionidEqualTo(xslTeamPosition.getPositionid()).andMemberstateNotEqualTo(MemberStatesEnum.DELETE.getCode());
                List<XslTeamMember> xslTeamMembers = xslTeamMemberMapper.selectByExample(xslTeamMemberExample);
                if (xslTeamMembers == null || xslTeamMembers.size() == 0){
                    continue;
                }
                MemberListResVo aMemberInfo = memberInfo;
                xslTeamMembers.forEach(member ->{
                    //添加用户信息
                    UserDetailedResVo userDetailedInfo = xslUserService.getUserDetailedInfo(member.getHunterid());
                    BeanUtils.copyProperties(userDetailedInfo, aMemberInfo);
                    memberInfos.add(aMemberInfo);
                });
            }
            return (memberInfos);
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    /** 获取指定职位的成员 */
    public List<XslTeamMember> getAllMemberByPositionId(String positionId) throws RuntimeException {
        List<XslTeamMember> members = getMembers(null, null, positionId,
                MemberStatesEnum.NORMAL.getCode(), MemberStatesEnum.FINISH.getCode());
        return members;
    }

    @Override
    public XslResult addMember(String positionId,String hunterId,String teamId) throws RuntimeException {
        List<XslTeamMember> members = getMembers(hunterId, teamId, positionId, MemberStatesEnum.NORMAL.getCode());
        if (members.size() > 0){
            return ResultUtils.ok();
        }
        XslTeamMember xslTeamMember = new XslTeamMember();
        xslTeamMember.setHunterid(hunterId);
        xslTeamMember.setPositionid(positionId);
        xslTeamMember.setTeamid(teamId);
        String uuid = IdUtils.getUuid();
        xslTeamMember.setMemberid(uuid);
        xslTeamMember.setMemberstate(MemberStatesEnum.NORMAL.getCode());
        int i = xslTeamMemberMapper.insertSelective(xslTeamMember);
        if (i <= 0){
            return ResultUtils.error();
        }
        return ResultUtils.ok();
    }

    @Override
    public XslResult updateMemberByTeamId(String teamId,Integer state) throws RuntimeException {
        List<XslTeamMember> members = getMembers(null, null, teamId);
        XslMatchTeam xslMatchTeam = xslMatchTeamService.getCurrentTeamByTeamId(teamId);
        members.forEach(member ->{
            XslResult xslResult = changeMemberState(member.getPositionid(), member.getHunterid(), state,xslMatchTeam);
        });
        return ResultUtils.ok();
    }

    @Override
    public XslResult changeMemberState(String positionId,String hunterId, Integer state) throws RuntimeException {
        return changeMemberState(positionId,hunterId,state,null);
    }

    public XslResult changeMemberState(String positionId,String hunterId, Integer state,XslMatchTeam xslMatchTeam) throws RuntimeException {
        XslTeamMemberExample xslTeamMemberExample = new XslTeamMemberExample();
        xslTeamMemberExample.createCriteria().andPositionidEqualTo(positionId).andHunteridEqualTo(hunterId)
                .andMemberstateEqualTo(MemberStatesEnum.NORMAL.getCode());
        XslTeamMember xslTeamMember = new XslTeamMember();
        int i = xslTeamMemberMapper.updateByExampleSelective(xslTeamMember, xslTeamMemberExample);
        if (i < 0){
            return ResultUtils.parameterError();
        }
        if (xslMatchTeam == null){
            XslTeamPosition xslTeamPosition = xslPositionService.getPositionByPositionId(positionId);
            xslMatchTeam = xslMatchTeamService.getCurrentTeamByTeamId(xslTeamPosition.getTeamid());
        }
        XslMatchTeam matchTeam = xslMatchTeam;
        threadPoolTaskExecutor.execute(() ->{
            deleteOperation(matchTeam,hunterId);
        });
        return ResultUtils.ok();
    }

    @Override
    /** 根据hunterId 查询成员 */
    public XslTeamMember getMemberByHunterId(String hunterId) throws RuntimeException {
        List<XslTeamMember> member = getMembers(hunterId, null, null, MemberStatesEnum.NORMAL.getCode(),
                MemberStatesEnum.FINISH.getCode());
        if (!MatchArrayUtils.isNotEmpty(member)){
            return new XslTeamMember();
        }
        return member.get(0);
    }

    /** 根据条件查询成员信息 */
    public List<XslTeamMember> getMembers(String hunterId,String teamId,String positionId,Integer... state) throws RuntimeException {
        try {
            XslTeamMemberExample xslTeamMemberExample = new XslTeamMemberExample();
            XslTeamMemberExample.Criteria criteria = xslTeamMemberExample.createCriteria();
            if (StringUtils.isNotBlank(hunterId)){
                criteria.andHunteridEqualTo(hunterId);
            }
            if (StringUtils.isNotBlank(teamId)){
                criteria.andTeamidEqualTo(teamId);
            }
            if (StringUtils.isNotBlank(positionId)){
                criteria.andPositionidEqualTo(positionId);
            }
            if (state != null && state.length > 0){
                criteria.andMemberstateIn(Arrays.asList(state));
            }
            List<XslTeamMember> xslTeamMembers = xslTeamMemberMapper.selectByExample(xslTeamMemberExample);
            return xslTeamMembers;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public MemberInfoResVo getDetailsByHunterId(String hunterId) throws RuntimeException {
        try {
            MemberInfoResVo memberInfoResVo = new MemberInfoResVo();
            XslTeamMember memberByHunterId = getMemberByHunterId(hunterId);
            if (StringUtils.isBlank(memberByHunterId.getHunterid()) && memberByHunterId.getMemberstate().equals(MemberStatesEnum.NORMAL.getCode())){
                return new MemberInfoResVo();
            }
            //添加成员信息
            BeanUtils.copyProperties(memberByHunterId,memberInfoResVo);
            //添加职位信息
            PositionDetailsResVo positionDetails = xslPositionService.getPositionDetails(memberByHunterId.getPositionid());
            BeanUtils.copyProperties(positionDetails,memberInfoResVo);
            //添加用户信息
            UserDetailedResVo userDetailedInfo = xslUserService.getUserDetailedInfo(hunterId);
            BeanUtils.copyProperties(userDetailedInfo,memberInfoResVo);
            return memberInfoResVo;
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<XslTeamMember> getAllMember(String teamId,Integer state) throws RuntimeException {
        try {
            XslTeamMemberExample xslTeamMemberExample = new XslTeamMemberExample();
            XslTeamMemberExample.Criteria criteria = xslTeamMemberExample.createCriteria();
            criteria.andTeamidEqualTo(teamId);
            if (state != null){
                criteria.andMemberstateEqualTo(state);
            }
            List<XslTeamMember> xslTeamMembers = xslTeamMemberMapper.selectByExample(xslTeamMemberExample);
            return xslTeamMembers;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    private void deleteOperation(XslMatchTeam xslMatchTeam,String hunterId){
        if (TeamStatesEnum.DISBANDED.getCode().equals(xslMatchTeam.getTeamstate()) || TeamStatesEnum.FINISH.getCode().equals(xslMatchTeam.getTeamstate())){
            //更新等级和信誉
            XslMatchUser xslMatchUser = xslMatchUserService.selectMatchUserInfoByHunterId(hunterId);
            Short after = getLevel(xslMatchUser.getLevel(), xslMatchTeam.getMatchid());
            Short credit = getCredit(xslMatchUser.getCredit());
            xslMatchUser.setCredit(credit);
            xslMatchUser.setLevel(after);
            XslResult xslResult = xslMatchUserService.updateMatchUserInfo(xslMatchUser.getHunterid(), xslMatchUser);
        }else if (TeamStatesEnum.NOT_RECRUIT.getCode().equals(xslMatchTeam.getTeamstate())){
            //信誉减少
            XslMatchUser xslMatchUser = xslMatchUserService.selectMatchUserInfoByHunterId(hunterId);
            xslMatchUser.setCredit((short)(xslMatchUser.getCredit() - 10));
            XslResult xslResult = xslMatchUserService.updateMatchUserInfo(xslMatchUser.getHunterid(), xslMatchUser);
        }
    }

    private Short getLevel(Short before,String matchId){
        XslMatch xslMatch = xslMatchService.selectMatchByMatchId(matchId);
        XslMatchRank rank = xslMatchRankService.getRank(xslMatch.getMatchrankid());
        String rankinfo = rank.getRankinfo();
        if (rankinfo.indexOf("世界") != -1){
            return (short)(before + 3);
        }
        else if ( rankinfo.indexOf("国家") != -1){
            return (short)(before + 2);
        }
        else{
            return (short)(before + 1);
        }
    }

    private Short getCredit(Short before){
        return before + 5 > 100 ? 100: (short)(before + 5);
    }
}
