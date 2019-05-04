package xsl.match.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xsl.Utils.ResultUtils;
import com.xsl.enums.DataStates;
import com.xsl.enums.ResultCode;
import com.xsl.enums.TeamStates;
import com.xsl.pojo.Example.XslMatchTeamExample;
import com.xsl.pojo.XslMatchTeam;
import com.xsl.result.EasyUIDataGridResult;
import com.xsl.result.XslResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xsl.match.mapper.XslMatchTeamMapper;
import xsl.match.service.XslMatchTeamService;

import java.util.List;
import java.util.UUID;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2019/4/27 17:14
 * @Description:
 */
@Service
public class XslMatchTeamServiceImpl implements XslMatchTeamService {

    private static final Logger LOGGER = LoggerFactory.getLogger(XslMatchTeamServiceImpl.class);

    @Autowired
    XslMatchTeamMapper xslMatchTeamMapper;

    @Override
    public XslResult addATeam(XslMatchTeam xslMatchTeam) throws RuntimeException {
        /**
         *
         * 功能描述: 添加一个队伍
         *
         * @param: [xslMatchTeam]
         * @return: com.xsl.result.XslResult
         * @auther: 11432_000
         * @date: 2019/4/27 17:41
         */
        //生成比赛ID
        String uuid = UUID.randomUUID().toString();
        String teamId = "T" + uuid;
        xslMatchTeam.setTeamid(teamId);
        xslMatchTeam.setTeamstate(TeamStates.CREATE_SUCCESS.getCode());
        try{
            int insert = xslMatchTeamMapper.insertSelective(xslMatchTeam);
            if (insert <= 0){
                LOGGER.error("addATeam() 添加数据失败");
                return ResultUtils.isError("插入失败");
            }
            return ResultUtils.isOk();
        }catch (Exception e){
            throw new RuntimeException("添加比赛信息异常:"+ e.getMessage());
        }
    }

    @Override
    public XslResult getTeamList() throws RuntimeException {
        /**
         *
         * 功能描述: 获取比赛列表(不分页)
         *
         * @param: [page, rows]
         * @return: com.xsl.result.XslResult
         * @auther: 11432_000
         * @date: 2019/4/27 17:42
         */
        try {
            XslMatchTeamExample xslMatchTeamExample = new XslMatchTeamExample();
            XslMatchTeamExample.Criteria criteria = xslMatchTeamExample.createCriteria();
            criteria.andTeamstateNotEqualTo(DataStates.DELETE.getCode());

            List<XslMatchTeam> xslMatchTeams = xslMatchTeamMapper.selectByExample(xslMatchTeamExample);
            return ResultUtils.isOk(xslMatchTeams);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    @Override
    public XslResult getTeamPage(Integer page, Integer rows) throws RuntimeException {
        /**
         *
         * 功能描述: 获取比赛列表(分页)
         *
         * @param: [page, rows]
         * @return: com.xsl.result.XslResult
         * @auther: 11432_000
         * @date: 2019/4/27 17:41
         */
        try {
            XslResult xslResult = getTeamList();
            if (ResultUtils.isSuccess(xslResult)){
                List<XslMatchTeam> xslMatchTeams =(List<XslMatchTeam>) xslResult.getData();
                EasyUIDataGridResult result =  new EasyUIDataGridResult();
                result.setRows(xslMatchTeams);
                PageHelper.startPage(page,rows);
                PageInfo<XslMatchTeam> xslMatchTeamPageInfo = new PageInfo<XslMatchTeam>(xslMatchTeams);
                result.setTotal(xslMatchTeamPageInfo.getTotal());
                return ResultUtils.isOk(result);
            }
            return xslResult;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    @Override
    public XslResult updateATeamInfo(XslMatchTeam xslMatchTeam) throws RuntimeException {
        /**
         *
         * 功能描述: 根据 MatchId 修改一条比赛数据
         *
         * @param: [xslMatchTeam]
         * @return: com.xsl.result.XslResult
         * @auther: 11432_000
         * @date: 2019/4/27 17:45
         */
        try{
            XslMatchTeamExample xslMatchTeamExample = new XslMatchTeamExample();
            XslMatchTeamExample.Criteria criteria = xslMatchTeamExample.createCriteria();
            criteria.andTeamidEqualTo(xslMatchTeam.getTeamid());
            //如果比赛已锁定，者不容许更改比赛
            if (!xslMatchTeam.getIsedit()){
                xslMatchTeam.setMatchid(null);
            }
            int i = xslMatchTeamMapper.updateByExampleSelective(xslMatchTeam,xslMatchTeamExample);
            if (i <= 0){
                LOGGER.error("updateATeamInfo 更新数据失败");
                return ResultUtils.isParameterError();
            }
            return ResultUtils.isOk();
        }catch (Exception e){
            throw new RuntimeException("更新比赛信息异常:"  + e.getMessage());
        }
    }
    @Override
    public XslResult deleteTeamInfoByIds(List<String> teamIds) throws RuntimeException {
        /**
         *
         * 功能描述: 根据 Id 逻辑删除一个或多个队伍
         *
         * @param: [teamIds]
         * @return: com.xsl.result.XslResult
         * @auther: 11432_000
         * @date: 2019/4/27 18:03
         */
        if (teamIds == null){
            LOGGER.info("更新队伍状态 teamIds 为null");
            return ResultUtils.isParameterError();
        }
        try {
            for (String teamId : teamIds){
                XslResult result = updateTeamState(teamId, TeamStates.DELETE.getCode());
                if (!ResultUtils.isSuccess(result)){
                    LOGGER.error("deleteTeamInfoByIds删除数据失败 " + teamId );
                }
            }
            return ResultUtils.isOk();
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    @Override
    public XslResult updateTeamState(String teamId, Integer state) throws RuntimeException {
        /**
         *
         * 功能描述: 变更比赛状态
         *
         * @param: [teamId, state]
         * @return: com.xsl.result.XslResult
         * @auther: 11432_000
         * @date: 2019/4/27 17:50
         */
        XslMatchTeam xslMatchTeam = new XslMatchTeam();
        XslMatchTeamExample xslMatchTeamExample = new XslMatchTeamExample();
        XslMatchTeamExample.Criteria criteria = xslMatchTeamExample.createCriteria();
        criteria.andTeamidEqualTo(teamId);

        xslMatchTeam.setTeamstate(state);
        try {
            int i = xslMatchTeamMapper.updateByExampleSelective(xslMatchTeam,xslMatchTeamExample);
            if (i <= 0){
                LOGGER.error("updateTeamState 失败");
                return ResultUtils.isError();
            }
            return ResultUtils.isOk();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    @Override
    public XslResult selectAllTeamByMatch(String matchId) throws RuntimeException {
        /**
         *
         * 功能描述: 获取某一比赛的所有队伍
         *
         * @param: [matchId]
         * @return: com.xsl.result.XslResult
         * @auther: 11432_000
         * @date: 2019/4/27 18:06
         */
        try {
            XslMatchTeamExample xslMatchTeamExample = new XslMatchTeamExample();
            XslMatchTeamExample.Criteria criteria = xslMatchTeamExample.createCriteria();
            criteria.andMatchidEqualTo(matchId);
            List<XslMatchTeam> xslMatchTeams = xslMatchTeamMapper.selectByExample(xslMatchTeamExample);
            return ResultUtils.isOk(xslMatchTeams);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
