package xsl.match.service;

import com.xsl.pojo.Vo.XslApplyResVo;
import com.xsl.result.XslResult;

import java.util.List;

/**
 * 说明：邀请处理
 *
 * @Auther: 11432_000
 * @Date: 2019/5/10 17:57
 * @Description:
 */
public interface XslInvitationService {

    /** 提交邀请 */
    XslResult commitInvitation(String positionId,String hunterId,String teamId)throws RuntimeException;
    /** 更改邀请状态 */
    XslResult changeInvitationState(String positionId, String hunterId, Integer state)throws RuntimeException;
    /** 查询指定职位的所有邀请 */
    List<XslApplyResVo> getAllInvitationByPosition(String positionId, Integer page, Integer rows)throws RuntimeException;
    /** 查询指定用户的所有邀请 */
    List<XslApplyResVo> getAllInvitationByUser(String userId, Integer page, Integer rows)throws RuntimeException;
    /** 查询指定队伍的所有邀请 */
    List<XslApplyResVo> getAllInvitationByTeam(String teamId, Integer page, Integer rows)throws RuntimeException;
}
