package xsl.match.service.impl;

import com.xsl.Utils.IdUtils;
import com.xsl.Utils.JedisUtils;
import com.xsl.Utils.JsonUtils;
import com.xsl.Utils.ResultUtils;
import com.xsl.enums.DataStates;
import com.xsl.enums.PositionStates;
import com.xsl.enums.PositonApplicationStates;
import com.xsl.pojo.Example.XslTeamPositionExample;
import com.xsl.pojo.Vo.PositionUpdateReqVo;
import com.xsl.pojo.Vo.PositionDetailsResVo;
import com.xsl.pojo.Vo.PositionTagResVo;
import com.xsl.pojo.XslMatchTeam;
import com.xsl.pojo.XslTaskTag;
import com.xsl.pojo.XslTeamPosition;
import com.xsl.result.XslResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import xsl.match.mapper.XslTeamPositionMapper;
import xsl.match.service.XslMatchTeamService;
import xsl.match.service.XslPositionApplicationService;
import xsl.match.service.XslPositionService;
import xsl.match.service.XslPositionTagService;

import java.util.ArrayList;
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
    private XslMatchTeamService xslMatchTeamService;
    @Autowired
    private XslPositionApplicationService xslPositionApplicationService;

    @Value("${POSITION_DETAILED_INFO}")
    private String POSITION_DETAILED_INFO;
    @Value("${POSITION_TAG_MAX_NUM}")
    private Integer POSITION_TAG_MAX_NUM;
    @Value("${POSITION_TAG_BUFFER}")
    private String POSITION_TAG_BUFFER;

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
            criteria.andTeamidEqualTo(teamId).andPositionstateNotEqualTo(DataStates.DELETE.getCode());

            List<XslTeamPosition> teamPositions = xslTeamPositionMapper.selectByExample(xslTeamPositionExample);
            return (teamPositions);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public XslResult addPositionForTeam(PositionUpdateReqVo positionDetailsReqVo) throws RuntimeException {
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
            XslTeamPosition xslTeamPosition = new XslTeamPosition();
            String uuid = IdUtils.getUuid();
            BeanUtils.copyProperties(positionDetailsReqVo,xslTeamPosition);
            xslTeamPosition.setPositionid(uuid);
            xslTeamPosition.setPositionstate(PositionStates.RECRUITMENT.getCode());
            //添加职位
            int i = xslTeamPositionMapper.insertSelective(xslTeamPosition);
            if (i <= 0){
                return ResultUtils.isError("添加职位失败");
            }
            //添加职位标签
            List<String> tagIds = positionDetailsReqVo.getTagIds();
            for (int j = 0; j < POSITION_TAG_MAX_NUM && j < tagIds.size(); j++) {
                xslPositionTagService.addPositionTag(uuid, tagIds.get(i));
            }
            return ResultUtils.isOk();
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
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
            xslTeamPosition.setPositionstate(PositionStates.DELETE.getCode());
            int i = xslTeamPositionMapper.updateByExample(xslTeamPosition, xslTeamPositionExample);
            if (i <= 0){
                return ResultUtils.isError("删除职位失败");
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
            xslPositionApplicationService.changeApplyState(positionId,null, PositonApplicationStates.INVALID.getCode());
            return ResultUtils.isOk();
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public XslResult changPosition(PositionUpdateReqVo positionUpdateReqVo) throws RuntimeException {
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
            XslTeamPosition xslTeamPosition = new XslTeamPosition();
            BeanUtils.copyProperties(positionUpdateReqVo,xslTeamPosition);
            XslTeamPositionExample xslTeamPositionExample = new XslTeamPositionExample();
            xslTeamPositionExample.createCriteria().andPositionidEqualTo(positionUpdateReqVo.getPositionid());
            //更改职位
            int i = xslTeamPositionMapper.updateByExampleSelective(xslTeamPosition,xslTeamPositionExample);
            if (i <= 0){
                return ResultUtils.isError("修改职位失败");
            }
            //更改职位标签
            List<String> tagIds = positionUpdateReqVo.getTagIds();
            List<String> list = tagIds.subList(0, tagIds.size() < POSITION_TAG_MAX_NUM ? tagIds.size() : POSITION_TAG_MAX_NUM);
            updatePositionTag(list,xslTeamPosition.getPositionid());
            return ResultUtils.isOk();
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    /** 更新职位标签 */
    public void updatePositionTag(List<String> tagIds,String positionId)throws RuntimeException {
        ArrayList<XslTaskTag> list = new ArrayList<>();
        for (String tagId : tagIds){
            XslTaskTag xslTaskTag = new XslTaskTag();
            xslTaskTag.setTagid(tagId);
            xslTaskTag.setTaskid(positionId);
            list.add(xslTaskTag);
        }
        String json = JedisUtils.get(POSITION_TAG_BUFFER + ":" + positionId);
        //过滤已存在标签
        List<XslTaskTag> xslTaskTags = null;
        if (StringUtils.isNotBlank(json)){
            xslTaskTags = JsonUtils.jsonToList(json, XslTaskTag.class);
            for (XslTaskTag xslTaskTag : xslTaskTags){
                int i = list.indexOf(xslTaskTag);
                if (i != -1){
                    list.remove(i);
                    xslTaskTags.remove(xslTaskTag);
                }
            }
            //删除不在使用的标签
            for (XslTaskTag xslTaskTag : xslTaskTags){
                xslPositionTagService.removePositionTag(positionId,xslTaskTag.getTagid());
            }
        }
        //添加增标签
        for (XslTaskTag xslTaskTag : list){
            xslPositionTagService.addPositionTag(positionId,xslTaskTag.getTagid());
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
                throw new RuntimeException("职位不存在");
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
            return positionDetailsResVo;
        }

        XslTeamPosition positionByPositionId = getPositionByPositionId(positionId);
        PositionDetailsResVo positionDetailsResVo = new PositionDetailsResVo();
        //添加职位信息
        BeanUtils.copyProperties(positionByPositionId,positionDetailsResVo);
        //添加职位标签
        List<PositionTagResVo> allTagInfoByPositionId = xslPositionTagService.getAllTagInfoByPositionId(positionId);
        positionDetailsResVo.setTags(allTagInfoByPositionId);
        //添加队伍信息
        XslMatchTeam xslMatchTeam = xslMatchTeamService.selectTeamByTeamId(positionByPositionId.getTeamid());
        positionDetailsResVo.setTeamname(xslMatchTeam.getTeamname());
        //添加缓存
        String toJson = JsonUtils.objectToJson(positionDetailsResVo);
        JedisUtils.set(POSITION_DETAILED_INFO + ":" + positionId,toJson);

        return positionDetailsResVo;
    }
}
