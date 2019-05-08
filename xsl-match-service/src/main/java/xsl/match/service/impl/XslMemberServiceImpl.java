package xsl.match.service.impl;

import com.xsl.Utils.IdUtils;
import com.xsl.Utils.ResultUtils;
import com.xsl.pojo.Example.XslTeamMemberExample;
import com.xsl.pojo.Vo.MemberInfoResVo;
import com.xsl.pojo.XslMatch;
import com.xsl.pojo.XslTeamMember;
import com.xsl.pojo.XslTeamPosition;
import com.xsl.pojo.XslUser;
import com.xsl.result.XslResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import xsl.match.mapper.XslTeamMemberMapper;
import xsl.match.service.XslMemberService;
import xsl.match.service.XslPositionService;
import xsl.match.service.XslUserService;

import java.util.ArrayList;
import java.util.List;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2019/5/4 09:07
 * @Description:
 */
public class XslMemberServiceImpl implements XslMemberService {

    @Autowired
    XslTeamMemberMapper xslTeamMemberMapper;
    @Autowired
    XslPositionService xslPositionService;
    @Autowired
    XslUserService xslUserService;

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
            throw new RuntimeException(e.getCause());
        }
    }

    @Override
    public XslResult addMemberByTeamId(XslTeamMember xslTeamMember) throws RuntimeException {
        String uuid = IdUtils.getUuid("MM:");
        xslTeamMember.setMemberid(uuid);
        return null;
    }

    @Override
    public XslResult addMemberByTeamId(String teamId) throws RuntimeException {
        return null;
    }

    @Override
    public XslResult changeMemberState(String memberId, Integer state) throws RuntimeException {
        return null;
    }
}
