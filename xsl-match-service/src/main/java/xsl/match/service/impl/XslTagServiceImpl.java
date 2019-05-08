package xsl.match.service.impl;

import com.xsl.Utils.IdUtils;
import com.xsl.Utils.ResultUtils;
import com.xsl.pojo.Example.XslTagExample;
import com.xsl.pojo.XslTag;
import com.xsl.result.XslResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import xsl.match.mapper.XslTagMapper;
import xsl.match.service.XslTagService;
;
import java.util.List;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2019/5/8 20:16
 * @Description:
 */
@Service
public class XslTagServiceImpl implements XslTagService {

    @Autowired
    XslTagMapper xslTagMapper;
    @Value("${MATCH_TAG_PREFIX}")
    private String MATCH_TAG_PREFIX;

    @Override
    public XslResult addTag(String tagName) throws RuntimeException {
        if (checkTagByName(tagName)){
            return ResultUtils.isParameterError();
        }
        XslTag xslTag = new XslTag();
        xslTag.setTagid(IdUtils.getUuid(MATCH_TAG_PREFIX));
        xslTag.setName(tagName);
        xslTag.setState(true);
        xslTag.setUsenum((short)1);
        int i = xslTagMapper.insertSelective(xslTag);
        if (i <= 0){
            throw new RuntimeException("添加标签失败");
        }
        return ResultUtils.isOk();
    }

    @Override
    public XslResult removeTag(String tagId) throws RuntimeException {
        /**
         *
         * 功能描述: 移除标签
         *
         * @param: [tagId]
         * @return: com.xsl.result.XslResult
         * @auther: 11432_000
         * @date: 2019/5/8 20:38
         */
        try {
            XslTagExample xslTagExample = new XslTagExample();
            xslTagExample.createCriteria().andTagidEqualTo(tagId);
            XslTag xslTag = new XslTag();
            xslTag.setState(false);
            int i = xslTagMapper.updateByExampleSelective(xslTag, xslTagExample);
            if(i <= 0){
                throw new RuntimeException("删除失败");
            }
            return ResultUtils.isOk();
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<XslTag> getTags(List<String> tagIds) throws RuntimeException {
        /**
         *
         * 功能描述: 根据 Id 批量获取标签
         *
         * @param: [tagIds]
         * @return: java.util.List<com.xsl.pojo.XslTag>
         * @auther: 11432_000
         * @date: 2019/5/8 20:43
         */
        XslTagExample xslTagExample = new XslTagExample();
        xslTagExample.createCriteria().andTagidIn(tagIds);
        List<XslTag> xslTags = xslTagMapper.selectByExample(xslTagExample);
        return xslTags;
    }

    @Override
    public List<XslTag> getTags() throws RuntimeException {
        /**
         *
         * 功能描述: 获取所有Tag
         *
         * @param: []
         * @return: java.util.List<com.xsl.pojo.XslTag>
         * @auther: 11432_000
         * @date: 2019/5/8 20:43
         */
        try {
            XslTagExample xslTagExample = new XslTagExample();
            List<XslTag> xslTags = xslTagMapper.selectByExample(xslTagExample);
            return xslTags;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    /** 检查标签是否已存在 */
    public boolean checkTagByName(String tagName) throws RuntimeException {
        try {
            XslTagExample xslTagExample = new XslTagExample();
            xslTagExample.createCriteria().andNameEqualTo(tagName).andStateEqualTo(true);
            List<XslTag> xslTags = xslTagMapper.selectByExample(xslTagExample);
            if (xslTags.size() == 0){
                return false;
            }
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }


}
