package xsl.match.service;

import com.xsl.pojo.Vo.MemberInfoResVo;
import com.xsl.pojo.XslTeamMember;
import com.xsl.result.XslResult;

import java.util.List;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2019/5/4 09:02
 * @Description:
 */
public interface XslMemberService {
    /** 根据队伍ID 获取所有成员信息 */
    List<MemberInfoResVo> getAllMemberByTeamId(String teamId)throws RuntimeException;
    /** 根据职位ID 获取所有成员 */
    List<XslTeamMember> getAllMemberByPositionId(String positionId)throws RuntimeException;
    /** 添加一位新成员 */
    XslResult addMember(String positionId,String hunterId,String teamId)throws RuntimeException;
    /** 删除成员 */
    XslResult removeMemberByTeamId(String teamId)throws RuntimeException;
    /** 更改成员状态 */
    XslResult changeMemberState(String memberId,Integer state)throws RuntimeException;
    /** 根据hunterId 查询成员 */
    XslTeamMember getMemberByHunterId(String hunterId)throws RuntimeException;
}
