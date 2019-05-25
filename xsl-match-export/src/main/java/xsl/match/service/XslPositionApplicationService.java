package xsl.match.service;

import com.xsl.pojo.Vo.XslApplyResVo;
import com.xsl.pojo.XslPositionApplication;
import com.xsl.result.XslResult;

import java.util.List;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2019/5/10 17:57
 * @Description:
 */
public interface XslPositionApplicationService {

    /** 提交申请 */
    XslResult commitApply(String positionId,String hunterId,String teamId)throws RuntimeException;
    /** 更改申请状态 */
    XslResult changeApplyState(String positionId,String hunterId,Integer state)throws RuntimeException;
    /** 查询指定职位的所有申请 */
    List<XslApplyResVo> getAllApplyByPosition(String positionId,Integer page,Integer rows)throws RuntimeException;
    /** 查询指定用户的所有申请 */
    List<XslApplyResVo> getAllApplyByUser(String userId,Integer page,Integer rows)throws RuntimeException;
    /** 查询指定队伍的所有申请 */
    List<XslApplyResVo> getAllApplyByTeam(String teamId,Integer page,Integer rows)throws RuntimeException;
}
