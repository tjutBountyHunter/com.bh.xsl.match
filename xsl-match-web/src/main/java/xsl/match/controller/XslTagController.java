package xsl.match.controller;

import com.xsl.Utils.MYStringUtils;
import com.xsl.Utils.MatchArrayUtils;
import com.xsl.Utils.ResultUtils;
import com.xsl.pojo.Vo.UserDetailedResVo;
import com.xsl.pojo.XslTag;
import com.xsl.result.EasyUIDataGridResult;
import com.xsl.result.XslResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xsl.match.service.XslTagService;

import java.util.List;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2019/5/9 20:40
 * @Description:
 */
@Controller
@RequestMapping("tag")
public class XslTagController {

    @Autowired
    private XslTagService xslTagService;

    @RequestMapping("/user/add")
    @ResponseBody
    /** 添加标签 */
    public XslResult addTag(@Param("tagName") String tagName){
        XslResult xslResult = xslTagService.addTag(tagName);
        return xslResult;
    }

    @RequestMapping("/get/tagList")
    @ResponseBody
    /** 获取所有标签 */
    public XslResult getTags(){
        List<XslTag> tags = xslTagService.getTags();
        return ResultUtils.ok(tags);
    }

    @RequestMapping("/get/tag")
    @ResponseBody
    /** 获取指定标签 */
    public XslResult getTag(String tagId){
        List<XslTag> tags = xslTagService.getTags(tagId);
        return ResultUtils.ok(tags.get(0));
    }


    @RequestMapping("/remove")
    @ResponseBody
    /** 删除指定标签 */
    public XslResult removeTag(String tagId){
        XslResult xslResult = xslTagService.removeTag(tagId);
        return xslResult;
    }

    @RequestMapping("/get/tags/page")
    @ResponseBody
    /** 分页获取标签 */
    public EasyUIDataGridResult getTagsPage(@Param("page") Integer page,@Param("rows") Integer rows){
        EasyUIDataGridResult pageTags = xslTagService.getPageTags(page, rows);
        return pageTags;
    }

    @RequestMapping("/edit/tag")
    @ResponseBody
    /** 修改标签 */
    public XslResult editTag(@RequestBody XslTag xslTag){
        XslResult xslResult = xslTagService.updateTags(xslTag);
        return xslResult;
    }

    @RequestMapping("/remove/tags")
    @ResponseBody
    /** 删除指定标签 */
    public XslResult removeTags(@Param("tagIds") String tagIds){
        List<String> stringList = MYStringUtils.getStringList(tagIds, ",");
        XslResult xslResult = xslTagService.removeTags(stringList);
        return xslResult;
    }
}
