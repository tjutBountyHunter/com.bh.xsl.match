package xsl.match.service.impl;

import com.xsl.Utils.IdUtils;
import com.xsl.Utils.JedisUtils;
import com.xsl.Utils.JsonUtils;
import com.xsl.Utils.ResultUtils;
import com.xsl.annotation.UpdatePosition;
import com.xsl.enums.DataStatesEnum;
import com.xsl.enums.PositionStatesEnum;
import com.xsl.enums.PositionApplicationStatesEnum;
import com.xsl.pojo.Example.XslTeamPositionExample;
import com.xsl.pojo.Vo.PositionDetailsResVo;
import com.xsl.pojo.Vo.PositionTagResVo;
import com.xsl.pojo.XslMatchTeam;
import com.xsl.pojo.XslTaskTag;
import com.xsl.pojo.XslTeamMember;
import com.xsl.pojo.XslTeamPosition;
import com.xsl.result.XslResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import xsl.match.mapper.XslTeamPositionMapper;
import xsl.match.service.*;

import java.util.List;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2019/5/4 09:17
 * @Description:
 */
@Service
public class XslPositionServiceImpl implements XslPositionService {

    @Autowired
    private XslTeamPositionMapper xslTeamPositionMapper;
    @Autowired
    private XslPositionTagService xslPositionTagService;
    @Autowired
    private XslPositionApplicationService xslPositionApplicationService;

    @Value("${POSITION_DETAILED_INFO}")
    private String POSITION_DETAILED_INFO;
    @Value("${POSITION_TAG_MAX_NUM}")
    private Integer POSITION_TAG_MAX_NUM;
    @Value("${POSITION_TAG_BUFFER}")
    private String POSITION_TAG_BUFFER;
    @Value("${POSITION_INFO_LIFETIME}")
    private Integer POSITION_INFO_LIFETIME;
    @Value("${TEAM_POSITION_NUM}")
    private String TEAM_POSITION_NUM;
    @Value("${MAX_POSITION}")
    private Integer MAX_POSITION;

    @Override
    public List<XslTeamPosition>  getAllPositionByTeamId(String teamId) throws RuntimeException {
        /**
         *
         * 功能描述: 获取指定队伍的全部职位
         *
         * @param: [teamId]
         * @return: com.xsl.result.XslResult
         * @auther: 11432_000
         * @date: 2019/5/4 9:35
         */
        try {
            XslTeamPositionExample xslTeamPositionExample = new XslTeamPositionExample();
            XslTeamPositionExample.Criteria criteria = xslTeamPositionExample.createCriteria();
            criteria.andTeamidEqualTo(teamId).andPositionstateNotEqualTo(DataStatesEnum.DELETE.getCode());

            List<XslTeamPosition> teamPositions = xslTeamPositionMapper.selectByExample(xslTeamPositionExample);
            return (teamPositions);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public XslResult addPosition(XslTeamPosition xslTeamPosition) throws RuntimeException {
        /**
         *
         * 功能描述: 添加职位
         *
         * @param: [positionDetailsReqVo]
         * @return: com.xsl.result.XslResult
         * @auther: 11432_000
         * @date: 2019/5/10 17:12
         */
        try {
            String num = JedisUtils.get(TEAM_POSITION_NUM + ":" + xslTeamPosition.getTeamid());
            Integer positionNum = 0;
            if(StringUtils.isNotBlank(num)){
                positionNum = Integer.valueOf(num);
            }
            if (positionNum >= MAX_POSITION){
                return ResultUtils.parameterError("职位到达上限");
            }
            String uuid = IdUtils.getUuid();
            xslTeamPosition.setPositionid(uuid);
            xslTeamPosition.setPositionstate(PositionStatesEnum.RECRUITMENT.getCode());
            //添加职位
            int i = xslTeamPositionMapper.insertSelective(xslTeamPosition);
            if (i <= 0){
                return ResultUtils.error("添加职位失败");
            }
            positionNum ++;
            JedisUtils.set(TEAM_POSITION_NUM +":"+xslTeamPosition.getTeamid(),positionNum.toString());
            return ResultUtils.ok(uuid);
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
    }


    @Override
    @UpdatePosition
    public XslResult deletePosition(String positionId) throws RuntimeException {
        /**
         *
         * 功能描述: 删除职位
         *
         * @param: [positionId]
         * @return: com.xsl.result.XslResult
         * @auther: 11432_000
         * @date: 2019/5/10 17:30
         */
        try {
            //删除职位信息
            XslTeamPositionExample xslTeamPositionExample =  new XslTeamPositionExample();
            xslTeamPositionExample.createCriteria().andPositionidEqualTo(positionId);
            XslTeamPosition xslTeamPosition = new XslTeamPosition();
            xslTeamPosition.setPositionstate(PositionStatesEnum.DELETE.getCode());
            int i = xslTeamPositionMapper.updateByExample(xslTeamPosition, xslTeamPositionExample);
            if (i <= 0){
                return ResultUtils.error("删除职位失败");
            }
            String json = JedisUtils.get(POSITION_TAG_BUFFER + ":" + positionId);
            List<XslTaskTag> xslTaskTags = null;
            if (StringUtils.isNotBlank(json)){
                xslTaskTags = JsonUtils.jsonToList(json, XslTaskTag.class);
                //删除不在使用的标签
                for (XslTaskTag xslTaskTag : xslTaskTags){
                    xslPositionTagService.removePositionTag(positionId,xslTaskTag.getTagid());
                }
            }
            //将所有该职位的申请置为不可用
            xslPositionApplicationService.changeApplyState(positionId,null, PositionApplicationStatesEnum.INVALID.getCode());
            //更新缓存
            String num = JedisUtils.get(TEAM_POSITION_NUM + ":" + xslTeamPosition.getTeamid());
            Integer positionNum = Integer.valueOf(num);
            positionNum --;
            JedisUtils.set(TEAM_POSITION_NUM +":"+xslTeamPosition.getTeamid(),positionNum.toString());
            return ResultUtils.ok();
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    @UpdatePosition
    public XslResult updatePosition(String positionId,XslTeamPosition xslTeamPosition) throws RuntimeException {
        /**
         *
         * 功能描述: 更改职位
         *
         * @param: [PositionUpdateReqVo]
         * @return: com.xsl.result.XslResult
         * @auther: 11432_000
         * @date: 2019/5/10 17:09
         */
        try {
            XslTeamPositionExample xslTeamPositionExample = new XslTeamPositionExample();
            xslTeamPositionExample.createCriteria().andPositionidEqualTo(xslTeamPosition.getPositionid());
            //更改职位
            int i = xslTeamPositionMapper.updateByExampleSelective(xslTeamPosition,xslTeamPositionExample);
            if (i <= 0){
                return ResultUtils.error("修改职位失败");
            }
            return ResultUtils.ok();
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
    }


    @Override
    public XslTeamPosition  getPositionByPositionId(String positionId) throws RuntimeException {
        /**
         *
         * 功能描述: 根据职位ID 获取指定职位
         *
         * @param: [positionId]
         * @return: com.xsl.result.XslResult
         * @auther: 11432_000
         * @date: 2019/5/5 18:26
         */
        try {
            XslTeamPositionExample xslTeamPositionExample = new XslTeamPositionExample();
            xslTeamPositionExample.createCriteria().andPositionidEqualTo(positionId);
            List<XslTeamPosition> teamPositions = xslTeamPositionMapper.selectByExample(xslTeamPositionExample);
            if (teamPositions.size() == 0){
                return new XslTeamPosition();
            }
            return (teamPositions.get(0));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public PositionDetailsResVo getPositionDetails(String positionId) throws RuntimeException {
        /**
         *
         * 功能描述: 获取职位详情
         *
         * @param: [positionId]
         * @return: com.xsl.pojo.Vo.PositionDetailsResVo
         * @auther: 11432_000
         * @date: 2019/5/10 14:47
         */
        //优先取缓存
        String json = JedisUtils.get(POSITION_DETAILED_INFO + ":" + positionId);
        if (StringUtils.isNotBlank(json)){
            PositionDetailsResVo positionDetailsResVo = JsonUtils.jsonToPojo(json, PositionDetailsResVo.class);
            JedisUtils.expire(POSITION_DETAILED_INFO + ":" + positionId,POSITION_INFO_LIFETIME);
            return positionDetailsResVo;
        }
        XslTeamPosition positionByPositionId = getPositionByPositionId(positionId);
        PositionDetailsResVo positionDetailsResVo = new PositionDetailsResVo();
        //添加职位信息
        BeanUtils.copyProperties(positionByPositionId,positionDetailsResVo);
        //添加职位标签
        List<PositionTagResVo> allTagInfoByPositionId = xslPositionTagService.getAllTagInfoByPositionId(positionId);
        positionDetailsResVo.setTags(allTagInfoByPositionId);
        //添加缓存
        String toJson = JsonUtils.objectToJson(positionDetailsResVo);
        JedisUtils.set(POSITION_DETAILED_INFO + ":" + positionId,toJson);
        JedisUtils.expire(POSITION_DETAILED_INFO + ":" + positionId,POSITION_INFO_LIFETIME);
        return positionDetailsResVo;
    }
}
