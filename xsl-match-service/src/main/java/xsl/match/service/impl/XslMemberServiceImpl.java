package xsl.match.service.impl;

import com.xsl.Utils.IdUtils;
import com.xsl.Utils.MatchArrayUtils;
import com.xsl.Utils.ResultUtils;
import com.xsl.enums.MemberStatesEnum;
import com.xsl.pojo.Example.XslTeamMemberExample;
import com.xsl.pojo.Vo.MemberInfoResVo;
import com.xsl.pojo.XslMatch;
import com.xsl.pojo.XslTeamMember;
import com.xsl.pojo.XslTeamPosition;
import com.xsl.pojo.XslUser;
import com.xsl.result.XslResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xsl.match.mapper.XslTeamMemberMapper;
import xsl.match.service.XslMemberService;
import xsl.match.service.XslPositionService;
import xsl.match.service.XslUserService;

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

    @Autowired
    private XslTeamMemberMapper xslTeamMemberMapper;
    @Autowired
    private XslPositionService xslPositionService;
    @Autowired
    private XslUserService xslUserService;

    @Override
    public List<MemberInfoResVo> getAllMemberByTeamId(String teamId) throws RuntimeException {
        /**
         *
         * 功能描述: 获取队伍的职位及成员信息
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
                return (new ArrayList<MemberInfoResVo>());
            }
            List<MemberInfoResVo> memberInfos = new ArrayList<>();
            MemberInfoResVo memberInfo;
            //添加查询条件，获取所有有关成员
            XslTeamMemberExample xslTeamMemberExample = new XslTeamMemberExample();
            XslTeamMemberExample.Criteria criteria = xslTeamMemberExample.createCriteria();
            for (XslTeamPosition xslTeamPosition : allPositionByTeamId){
                xslTeamMemberExample.clear();
                //添加职位信息
                memberInfo = new MemberInfoResVo();
                BeanUtils.copyProperties(xslTeamPosition,memberInfo);
                //添加成员信息
                criteria.andPositionidEqualTo(xslTeamPosition.getPositionid());
                List<XslTeamMember> xslTeamMembers = xslTeamMemberMapper.selectByExample(xslTeamMemberExample);
                if (xslTeamMembers == null || xslTeamMembers.size() == 0){
                    continue;
                }
                BeanUtils.copyProperties(memberInfo,xslTeamMembers.get(0));
                //添加用户信息
                XslUser userByHunterId = xslUserService.getUserByHunterId(xslTeamMembers.get(0).getHunterid());
                BeanUtils.copyProperties(memberInfo,userByHunterId);

                memberInfos.add(memberInfo);
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
    public XslResult removeMemberByTeamId(String teamId) throws RuntimeException {
        return null;
    }

    @Override
    public XslResult changeMemberState(String memberId, Integer state) throws RuntimeException {
        return null;
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
}
