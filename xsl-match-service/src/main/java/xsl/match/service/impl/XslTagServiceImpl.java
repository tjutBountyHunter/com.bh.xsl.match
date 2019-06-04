package xsl.match.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xsl.Utils.IdUtils;
import com.xsl.Utils.JedisUtils;
import com.xsl.Utils.JsonUtils;
import com.xsl.Utils.ResultUtils;
import com.xsl.annotation.AddTag;
import com.xsl.annotation.DeleteTag;
import com.xsl.pojo.Example.XslTagExample;
import com.xsl.pojo.XslTag;
import com.xsl.result.EasyUIDataGridResult;
import com.xsl.result.XslResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import xsl.match.mapper.XslTagMapper;
import xsl.match.service.XslTagService;
;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.jar.JarEntry;

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
    private XslTagMapper xslTagMapper;
    @Value("${MATCH_TAG_PREFIX}")
    private String MATCH_TAG_PREFIX;
    @Value("${TAG_BUFFER}")
    private String TAG_BUFFER;
    @Value("${TAG_BUFFER_LIST}")
    private String TAG_BUFFER_LIST;

    @Override
    @AddTag
    public XslResult addTag(String tagName) throws RuntimeException {
        XslTag xslTag = checkTagByName(tagName);
        if (StringUtils.isNotBlank(xslTag.getTagid())){
            return ResultUtils.ok(xslTag);
        }
        String uuid = IdUtils.getUuid(MATCH_TAG_PREFIX);
        xslTag.setTagid(uuid);
        xslTag.setName(tagName);
        xslTag.setState(true);
        xslTag.setUsenum((short)1);
        int i = xslTagMapper.insertSelective(xslTag);
        if (i <= 0){
            return ResultUtils.error("添加标签失败");
        }
        return ResultUtils.ok(xslTag);
    }

    @Override
    @DeleteTag
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
                return ResultUtils.error("删除失败");
            }
            return ResultUtils.ok();
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
        try {
            ArrayList<XslTag> xslTags = new ArrayList<>();
            for (String tagId : tagIds){
                String json = JedisUtils.get(TAG_BUFFER + ":" + tagId);
                XslTag xslTag = JsonUtils.jsonToPojo(json, XslTag.class);
                xslTags.add(xslTag);
            }
            return xslTags;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<XslTag> getTags(String... tagIds) throws RuntimeException {
        return getTags(Arrays.asList(tagIds));
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
            String json = JedisUtils.get(TAG_BUFFER_LIST);
            if (StringUtils.isNotBlank(json)){
                return JsonUtils.jsonToList(json,XslTag.class);
            }
            return new ArrayList<>();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    /** 检查标签是否已存在 */
    public XslTag checkTagByName(String tagName) throws RuntimeException {
        try {
            XslTagExample xslTagExample = new XslTagExample();
            xslTagExample.createCriteria().andNameEqualTo(tagName).andStateEqualTo(true);
            List<XslTag> xslTags = xslTagMapper.selectByExample(xslTagExample);
            if (xslTags.size() == 0){
                return new XslTag();
            }
            return xslTags.get(0);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    /** 获取所有标签 分页*/
    public EasyUIDataGridResult getPageTags(Integer page, Integer rows) throws RuntimeException {
        try {
            PageHelper.startPage(page,rows);
            XslTagExample xslTagExample = new XslTagExample();
            List<XslTag> xslTags = xslTagMapper.selectByExample(xslTagExample);
            PageInfo pageInfo = new PageInfo(xslTags);
            EasyUIDataGridResult result = new EasyUIDataGridResult();
            result.setRows(xslTags);
            result.setTotal(pageInfo.getTotal());
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    /** 获取指定的标签 */
    private List<XslTag> getTags(String tagId,Boolean... state){
        XslTagExample xslTagExample = new XslTagExample();
        XslTagExample.Criteria criteria = xslTagExample.createCriteria();
        if (StringUtils.isNotBlank(tagId)){
            criteria.andTagidEqualTo(tagId);
        }
        if (state != null && state.length > 0){
            criteria.andStateIn(Arrays.asList(state));
        }
        List<XslTag> xslTags = xslTagMapper.selectByExample(xslTagExample);
        return xslTags;
    }

    @Override
    /** 修改标签 */
    public XslResult updateTags(XslTag xslTag) throws RuntimeException {
        try {
            XslTagExample xslTagExample = new XslTagExample();
            xslTagExample.createCriteria().andTagidEqualTo(xslTag.getTagid()).andStateEqualTo(xslTag.getState());
            int i = xslTagMapper.updateByExampleSelective(xslTag, xslTagExample);
            if (i < 0){
                return ResultUtils.parameterError();
            }
            return ResultUtils.ok();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    @DeleteTag
    public XslResult removeTags(List<String> tagIds) throws RuntimeException {
        try {
            XslTagExample xslTagExample = new XslTagExample();
            xslTagExample.createCriteria().andTagidIn(tagIds);
            XslTag xslTag = new XslTag();
            xslTag.setState(false);
            int i = xslTagMapper.updateByExampleSelective(xslTag, xslTagExample);
            if(i <= 0){
                return ResultUtils.error("删除失败");
            }
            return ResultUtils.ok();
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    /** 更新标签使用次数  传入tagIds */
    public XslResult updateTagUseNum(Object arg) throws RuntimeException {
        XslResult xslResult = ResultUtils.ok();
        if (arg != null && arg instanceof List){
            xslResult= updateTagUseNum((List<String>) arg);
        }
        return xslResult;
    }

    private XslResult updateTagUseNum(List<String> tagIds){
        try {
            XslTagExample xslTagExample = new XslTagExample();
            XslTagExample.Criteria criteria = xslTagExample.createCriteria();
            criteria.andTagidIn(tagIds).andStateEqualTo(true);
            List<XslTag> xslTags = xslTagMapper.selectByExample(xslTagExample);
            xslTags.forEach(xslTag -> {
                xslTagExample.clear();
                xslTag.setUsenum((short)(xslTag.getUsenum() + 1));
                criteria.andTagidEqualTo(xslTag.getTagid()).andStateEqualTo(true);
                xslTagMapper.updateByExampleSelective(xslTag,xslTagExample);
            });
            return ResultUtils.ok();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }
}
