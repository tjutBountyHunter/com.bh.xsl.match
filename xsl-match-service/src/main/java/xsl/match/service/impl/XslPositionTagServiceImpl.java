package xsl.match.service.impl;

import com.xsl.Utils.JedisUtils;
import com.xsl.Utils.JsonUtils;
import com.xsl.Utils.ResultUtils;
import com.xsl.annotation.UpdatePositionTag;
import com.xsl.pojo.Example.XslTaskTagExample;
import com.xsl.pojo.XslTaskTag;
import com.xsl.result.XslResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import xsl.match.mapper.XslTaskTagMapper;
import xsl.match.service.XslPositionTagService;

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
    XslTaskTagMapper xslTaskTagMapper;
    @Value("${POSITION_TAG_BUFFER}")
    private String POSITION_TAG_BUFFER;

    @Override
    @UpdatePositionTag
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
            XslTaskTag xslTaskTag = new XslTaskTag();
            xslTaskTag.setTaskid(positionId);
            xslTaskTag.setTagid(tagId);
            xslTaskTag.setState(true);
            int i = xslTaskTagMapper.insertSelective(xslTaskTag);
            if (i <= 0){
                throw new RuntimeException("添加职位标签失败");
            }
            return ResultUtils.isOk();
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    @UpdatePositionTag
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
                throw new RuntimeException("删除职位标签失败");
            }
            return ResultUtils.isOk();
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
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
//            XslTaskTagExample xslTaskTagExample = new XslTaskTagExample();
//            xslTaskTagExample.createCriteria().andTaskidEqualTo(positionId).andStateEqualTo(true);
//            List<XslTaskTag> xslTaskTags = xslTaskTagMapper.selectByExample(xslTaskTagExample);
            String json = JedisUtils.get(POSITION_TAG_BUFFER + ":" + positionId);
            List<XslTaskTag> xslTaskTags = JsonUtils.jsonToList(json, XslTaskTag.class);
            return (xslTaskTags);
        } catch (Exception e) {
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
}
