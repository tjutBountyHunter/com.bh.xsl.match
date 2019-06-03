package xsl.match.service;

import com.xsl.pojo.Vo.MemberInfoResVo;
import com.xsl.pojo.Vo.MemberListResVo;
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
    List<MemberListResVo> getAllMemberByTeamId(String teamId)throws RuntimeException;
    /** 根据职位ID 获取所有成员 */
    List<XslTeamMember> getAllMemberByPositionId(String positionId)throws RuntimeException;
    /** 添加一位新成员 */
    XslResult addMember(String positionId,String hunterId,String teamId)throws RuntimeException;
    /** 更改所有成员 */
    XslResult updateMemberByTeamId(String teamId,Integer state)throws RuntimeException;
    /** 更改成员状态 */
    XslResult changeMemberState(String positionId,String hunterId,Integer state)throws RuntimeException;
    /** 根据hunterId 查询成员 */
    XslTeamMember getMemberByHunterId(String hunterId)throws RuntimeException;
    /** 根据hunterId 获取成员详情 */
    MemberInfoResVo getDetailsByHunterId(String hunterId)throws RuntimeException;
    /** 获取队伍的所有成员 */
    List<XslTeamMember> getAllMember(String teamId,Integer state)throws RuntimeException;

}
