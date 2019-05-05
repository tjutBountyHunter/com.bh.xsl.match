package xsl.match.service;

import com.xsl.pojo.XslTeamMember;
import com.xsl.result.XslResult;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2019/5/4 09:02
 * @Description:
 */
public interface XslMemberService {
    /** 根据队伍ID 获取所有成员信息 */
    XslResult getAllMemberByTeamId(String teamId)throws RuntimeException;
    /** 添加一位新成员 */
    XslResult addMemberByTeamId(XslTeamMember xslTeamMember)throws RuntimeException;
    /** 删除成员 */
    XslResult addMemberByTeamId(String teamId)throws RuntimeException;
    /** 更改成员状态 */
    XslResult changeMemberState(String memberId,Integer state)throws RuntimeException;
}
