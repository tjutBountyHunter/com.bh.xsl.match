package xsl.match.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xsl.Utils.IdUtils;
import com.xsl.Utils.ResultUtils;
import com.xsl.enums.DataStatesEnum;
import com.xsl.enums.MemberStatesEnum;
import com.xsl.enums.TeamStatesEnum;
import com.xsl.pojo.Example.XslMatchTeamExample;
import com.xsl.pojo.XslMatchTeam;
import com.xsl.pojo.XslTeamMember;
import com.xsl.pojo.XslTeamPosition;
import com.xsl.result.EasyUIDataGridResult;
import com.xsl.result.XslResult;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import xsl.match.mapper.XslMatchTeamMapper;
import xsl.match.service.XslMatchTeamService;
import xsl.match.service.XslMemberService;
import xsl.match.service.XslPositionService;

import java.lang.reflect.Array;
import java.util.Arrays;
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
    private XslMatchTeamMapper xslMatchTeamMapper;
    @Autowired
    private XslMemberService xslMemberService;
    @Autowired
    private XslPositionService xslPositionService;
    @Value("${TEAM_DEFAULT_SYNOPSIS}")
    private String TEAM_DEFAULT_SYNOPSIS;

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
        XslMatchTeam currentTeamByCreater = getCurrentTeamByCreater(xslMatchTeam.getTeamcreatorid());
        if (StringUtils.isNotBlank(currentTeamByCreater.getTeamid())){
            return ResultUtils.repeat(currentTeamByCreater);
        }
        //生成ID
        String uuid = UUID.randomUUID().toString();
        String teamId = "T:" + uuid;
        xslMatchTeam.setTeamid(teamId);
        xslMatchTeam.setTeamstate(TeamStatesEnum.CREATE_SUCCESS.getCode());
        if (StringUtils.isBlank(xslMatchTeam.getTeamsynopsis())){
            xslMatchTeam.setTeamsynopsis(TEAM_DEFAULT_SYNOPSIS);
        }
        try{
            int insert = xslMatchTeamMapper.insertSelective(xslMatchTeam);
            if (insert <= 0){
                LOGGER.error("addATeam() 添加数据失败");
                return ResultUtils.error("添加失败");
            }
            //添加队长职位
            String positionId = addCaptain(teamId);
            if (StringUtils.isNotBlank(positionId)){
                addMember(positionId,teamId,xslMatchTeam.getTeamcreatorid());
            }
            return ResultUtils.ok(teamId);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    /** 添加队长职位 返回职位ID */
    public String addCaptain(String teamId){
        XslTeamPosition xslTeamPosition = new XslTeamPosition();
        xslTeamPosition.setPositionname("队长");
        xslTeamPosition.setTeamid(teamId);
        XslResult xslResult = xslPositionService.addPosition(xslTeamPosition);
        if (ResultUtils.isSuccess(xslResult)){
            return (String) xslResult.getData();
        }
        return null;
    }
    /** 添加到成员 */
    public void addMember(String positionId,String teamId,String hunterId){
        XslResult xslResult = xslMemberService.addMember(positionId, hunterId, teamId);
    }
    @Override
    public List<XslMatchTeam> getTeamList() throws RuntimeException {
        /**
         *
         * 功能描述: 获取队伍列表(不分页)
         *
         * @param: [page, rows]
         * @return: com.xsl.result.XslResult
         * @auther: 11432_000
         * @date: 2019/4/27 17:42
         */
        try {
            XslMatchTeamExample xslMatchTeamExample = new XslMatchTeamExample();
            XslMatchTeamExample.Criteria criteria = xslMatchTeamExample.createCriteria();
            criteria.andTeamstateNotEqualTo(DataStatesEnum.DELETE.getCode());

            List<XslMatchTeam> xslMatchTeams = xslMatchTeamMapper.selectByExample(xslMatchTeamExample);
            return xslMatchTeams;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    @Override
    public EasyUIDataGridResult getTeamPage(Integer page, Integer rows) throws RuntimeException {
        /**
         *
         * 功能描述: 获取队伍列表(分页)
         *
         * @param: [page, rows]
         * @return: com.xsl.result.XslResult
         * @auther: 11432_000
         * @date: 2019/4/27 17:41
         */
        PageHelper.startPage(page,rows);
        try {
            XslMatchTeamExample xslMatchTeamExample = new XslMatchTeamExample();
            xslMatchTeamExample.createCriteria().andTeamstateNotEqualTo(DataStatesEnum.DELETE.getCode());
            List<XslMatchTeam> xslMatchTeams = xslMatchTeamMapper.selectByExample(xslMatchTeamExample);
            EasyUIDataGridResult result =  new EasyUIDataGridResult();
            result.setRows(xslMatchTeams);
            PageInfo<XslMatchTeam> xslMatchTeamPageInfo = new PageInfo<>(xslMatchTeams);
            result.setTotal(xslMatchTeamPageInfo.getTotal());
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    @Override
    public XslResult updateATeamInfo(XslMatchTeam xslMatchTeam) throws RuntimeException {
        /**
         *
         * 功能描述: 根据 MatchId 修改一条队伍数据
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
                return ResultUtils.parameterError();
            }
            return ResultUtils.ok();
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
            return ResultUtils.parameterError();
        }
        try {
            for (String teamId : teamIds){
                XslResult result = updateTeamState(teamId, TeamStatesEnum.DELETE.getCode());
                if (!ResultUtils.isSuccess(result)){
                    LOGGER.error("deleteTeamInfoByIds删除数据失败 " + teamId );
                }
            }
            return ResultUtils.ok();
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    @Override
    public XslResult updateTeamState(String teamId, Integer state) throws RuntimeException {
        /**
         *
         * 功能描述: 变更队伍状态
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
                return ResultUtils.error();
            }
            return ResultUtils.ok();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    @Override
    public List<XslMatchTeam> selectAllTeamByMatch(String matchId) throws RuntimeException {
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
            return xslMatchTeams;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public XslMatchTeam getCurrentTeamByTeamId(String teamId) throws RuntimeException {
        /**
         *
         * 功能描述: 根据队伍Id 获取队伍信息
         *
         * @param: [teamId]
         * @return: com.xsl.result.XslResult
         * @auther: 11432_000
         * @date: 2019/5/4 9:12
         */
        return getTeam(null,teamId,TeamStatesEnum.CREATE_SUCCESS.getCode(),TeamStatesEnum.RECRUIT.getCode(),TeamStatesEnum.NOT_RECRUIT.getCode(),
                TeamStatesEnum.FINISH.getCode());
    }

    @Override
    public XslMatchTeam getCurrentTeamByCreater(String hunterId) throws RuntimeException {
        return getTeam(hunterId,null,TeamStatesEnum.CREATE_SUCCESS.getCode(),TeamStatesEnum.RECRUIT.getCode(),TeamStatesEnum.NOT_RECRUIT.getCode(),
                TeamStatesEnum.FINISH.getCode());
    }

    public XslMatchTeam getTeam(String hunterId,String teamId,Integer... state) throws RuntimeException {
        try {
            XslMatchTeamExample xslMatchTeamExample = new XslMatchTeamExample();
            XslMatchTeamExample.Criteria criteria = xslMatchTeamExample.createCriteria();
            if (StringUtils.isNotBlank(hunterId)){
                criteria.andTeamcreatoridEqualTo(hunterId);
            }
            if (StringUtils.isNotBlank(teamId)){
                criteria.andTeamidEqualTo(teamId);
            }
            if (state != null && state.length > 0){
                criteria.andTeamstateIn(Arrays.asList(state));
            }
            List<XslMatchTeam> xslMatchTeams = xslMatchTeamMapper.selectByExample(xslMatchTeamExample);
            if (xslMatchTeams.size() == 0){
                return new XslMatchTeam();
            }
            return xslMatchTeams.get(0);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
