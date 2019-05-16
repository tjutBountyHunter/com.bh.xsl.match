package xsl.match.service.impl;

import com.xsl.Utils.JedisUtils;
import com.xsl.Utils.JsonUtils;
import com.xsl.Utils.ResultUtils;
import com.xsl.annotation.UpdatePosition;
import com.xsl.annotation.UpdatePositionTag;
import com.xsl.pojo.Example.XslTaskTagExample;
import com.xsl.pojo.Vo.PositionTagResVo;
import com.xsl.pojo.XslTag;
import com.xsl.pojo.XslTaskTag;
import com.xsl.result.XslResult;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import xsl.match.mapper.XslTaskTagMapper;
import xsl.match.service.XslPositionTagService;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarEntry;

/**
 * 说明：注意taskId 等同于 positionId
 *
 * @Auther: 11432_000
 * @Date: 2019/5/6 20:01
 * @Description:
 */
@Service
public class XslPositionTagServiceImpl implements XslPositionTagService {

    private static final Logger LOGGER = LoggerFactory.getLogger(XslPositionTagServiceImpl.class);

    @Autowired
    private XslTaskTagMapper xslTaskTagMapper;
    @Value("${POSITION_TAG_BUFFER}")
    private String POSITION_TAG_BUFFER;
    @Value("${TAG_BUFFER}")
    private String TAG_BUFFER;
    @Value("${POSITION_TAG_MAX_NUM}")
    private Integer POSITION_TAG_MAX_NUM;

    @Override
    public XslResult addPositionTag(String positionId, String tagId) throws RuntimeException {
        /**
         *
         * 功能描述: 为职位添加一个标签
         *
         * @param: [positionId, tagId]
         * @return: com.xsl.result.XslResult
         * @auther: 11432_000
         * @date: 2019/5/6 20:12
         */
        try {
//            List<XslTaskTag> allTagByPositionId = getAllTagByPositionId(positionId);
//            if (allTagByPositionId.size() >= POSITION_TAG_MAX_NUM){
//                return ResultUtils.parameterError("已达可添加标签上限");
//            }
            XslTaskTag xslTaskTag = new XslTaskTag();
            xslTaskTag.setTaskid(positionId);
            xslTaskTag.setTagid(tagId);
            xslTaskTag.setState(true);
            int i = xslTaskTagMapper.insertSelective(xslTaskTag);
            if (i <= 0){
                return ResultUtils.error("添加职位标签失败");
            }
            return ResultUtils.ok();
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public XslResult removePositionTag(String positionId, String tagId) throws RuntimeException {
        /**
         *
         * 功能描述: 为职位删除一个标签
         *
         * @param: [positionId, tagId]
         * @return: com.xsl.result.XslResult
         * @auther: 11432_000
         * @date: 2019/5/6 20:15
         */
        try {
            XslTaskTagExample xslTaskTagExample = new XslTaskTagExample();
            xslTaskTagExample.createCriteria().andTaskidEqualTo(positionId).andTagidEqualTo(tagId);
            XslTaskTag xslTaskTag = new XslTaskTag();
            xslTaskTag.setState(false);
            int i = xslTaskTagMapper.updateByExampleSelective(xslTaskTag, xslTaskTagExample);
            if (i <= 0){
                return ResultUtils.error("删除职位标签失败");
            }
            return ResultUtils.ok();
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public XslResult addPositionTags(String positionId, List<String> tagIds) throws RuntimeException {
        for (int j = 0; j < POSITION_TAG_MAX_NUM && j < tagIds.size(); j++) {
            addPositionTag(positionId, tagIds.get(j));
        }
        return ResultUtils.ok();
    }

    @Override
    public List<XslTaskTag> getAllTagByPositionId(String positionId) throws RuntimeException {
        /**
         *
         * 功能描述: 查询职位的所有使用中标签
         *
         * @param: [positionId]
         * @return: com.xsl.result.XslResult
         * @auther: 11432_000
         * @date: 2019/5/7 13:43
         */
        try {
            String json = JedisUtils.get(POSITION_TAG_BUFFER + ":" + positionId);
            if (StringUtils.isBlank(json)){
                return new ArrayList<XslTaskTag>();
            }
            List<XslTaskTag> xslTaskTags = JsonUtils.jsonToList(json, XslTaskTag.class);
            return (xslTaskTags);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<PositionTagResVo> getAllTagInfoByPositionId(String positionId) throws RuntimeException {
        /**
         *
         * 功能描述: 查询职位的所有使用中标签 + 标签名
         *
         * @param: [positionId]
         * @return: java.util.List<com.xsl.pojo.Vo.PositionTagResVo>
         * @auther: 11432_000
         * @date: 2019/5/9 14:32
         */
        try {
            List<XslTaskTag> allTagByPositionId = getAllTagByPositionId(positionId);
            ArrayList<PositionTagResVo> positionTagResVos = new ArrayList<>();
            PositionTagResVo tagResVo;
            for (XslTaskTag xslTaskTag : allTagByPositionId){
                tagResVo = new PositionTagResVo();
                BeanUtils.copyProperties(xslTaskTag,tagResVo);
                String json = JedisUtils.get(TAG_BUFFER + ":" + xslTaskTag.getTagid());
                if (StringUtils.isBlank(json)){continue;}
                XslTag xslTag = JsonUtils.jsonToPojo(json, XslTag.class);
                BeanUtils.copyProperties(xslTag,tagResVo);
                positionTagResVos.add(tagResVo);
            }
            return positionTagResVos;
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<XslTaskTag> getAllPositionByTagId(String tagId) throws RuntimeException {
        /**
         *
         * 功能描述: 查询所有持有某标签的职位
         *
         * @param: [tagId]
         * @return: com.xsl.result.XslResult
         * @auther: 11432_000
         * @date: 2019/5/7 13:43
         */
        try {
            XslTaskTagExample xslTaskTagExample = new XslTaskTagExample();
            xslTaskTagExample.createCriteria().andTagidEqualTo(tagId).andStateEqualTo(true);
            List<XslTaskTag> xslTaskTags = xslTaskTagMapper.selectByExample(xslTaskTagExample);
            return (xslTaskTags);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    @UpdatePosition
    @UpdatePositionTag
    public XslResult updateTags(String positionId, List<String> tagIds) throws RuntimeException {
        try {
            tagIds = tagIds.subList(0, tagIds.size() < POSITION_TAG_MAX_NUM ? tagIds.size() : POSITION_TAG_MAX_NUM);
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
                int size = xslTaskTags.size();
                for (int x = 0; x < size;x ++){
                    int i = list.indexOf(xslTaskTags.get(x));
                    if (i != -1){
                        list.remove(i);
                        xslTaskTags.remove(xslTaskTags.get(x));
                    }
                }
                //删除不在使用的标签
                for (XslTaskTag xslTaskTag : xslTaskTags){
                    XslResult xslResult = removePositionTag(positionId, xslTaskTag.getTagid());
                }
            }
            //添加增标签
            for (XslTaskTag xslTaskTag : list){
                XslResult xslResult = addPositionTag(positionId, xslTaskTag.getTagid());
            }
            return ResultUtils.ok();
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
