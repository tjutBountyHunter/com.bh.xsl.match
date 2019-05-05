package xsl.match.service.impl;

import com.xsl.enums.DataStates;
import com.xsl.enums.ResultUtils;
import com.xsl.pojo.Example.XslTeamPositionExample;
import com.xsl.pojo.XslTeamPosition;
import com.xsl.result.XslResult;
import org.springframework.beans.factory.annotation.Autowired;
import xsl.match.mapper.XslTeamPositionMapper;
import xsl.match.service.XslPositionService;

import java.util.List;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2019/5/4 09:17
 * @Description:
 */
public class XslPositionServiceImpl implements XslPositionService {

    @Autowired
    XslTeamPositionMapper xslTeamPositionMapper;

    @Override
    public XslResult getAllPositionByTeamId(String teamId) throws RuntimeException {
        /**
         *
         * 功能描述: 获取全部未删除职位
         *
         * @param: [teamId]
         * @return: com.xsl.result.XslResult
         * @auther: 11432_000
         * @date: 2019/5/4 9:35
         */
        try {
            XslTeamPositionExample xslTeamPositionExample = new XslTeamPositionExample();
            XslTeamPositionExample.Criteria criteria = xslTeamPositionExample.createCriteria();
            criteria.andTeamidEqualTo(teamId).andPositionstateNotEqualTo(DataStates.DELETE.getCode());

            List<XslTeamPosition> teamPositions = xslTeamPositionMapper.selectByExample(xslTeamPositionExample);
            return ResultUtils.isOk(teamPositions);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public XslResult addPositionForTeam(XslTeamPosition xslTeamPosition) throws RuntimeException {
        return null;
    }

    @Override
    public XslResult deletePosition(String positionId) throws RuntimeException {
        return null;
    }

    @Override
    public XslResult changPosition(XslTeamPosition xslTeamPosition) throws RuntimeException {
        return null;
    }

    @Override
    public XslResult getPositionByPositionId(String positionId) throws RuntimeException {
        return null;
    }
}
