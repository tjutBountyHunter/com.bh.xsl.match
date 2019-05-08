package xsl.match.service;

import com.xsl.pojo.XslTeamPosition;
import com.xsl.result.XslResult;

import java.util.List;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2019/5/4 09:14
 * @Description:
 */
public interface XslPositionService {

    /** 获取某个队伍的全部职位 */
    List<XslTeamPosition> getAllPositionByTeamId(String teamId)throws RuntimeException;
    /** 添加职位 */
    XslResult addPositionForTeam(XslTeamPosition xslTeamPosition)throws RuntimeException;
    /** 删除职位 */
    XslResult deletePosition(String positionId)throws RuntimeException;
    /** 更改职位 */
    XslResult changPosition(XslTeamPosition xslTeamPosition)throws RuntimeException;
    /** 根据职位ID 获取指定职位 */
    XslTeamPosition getPositionByPositionId(String positionId)throws RuntimeException;
}
