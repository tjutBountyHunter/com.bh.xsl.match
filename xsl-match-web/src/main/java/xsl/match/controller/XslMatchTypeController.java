package xsl.match.controller;

import com.xsl.Utils.MYStringUtils;
import com.xsl.pojo.XslMatchType;
import com.xsl.result.EasyUIDataGridResult;
import com.xsl.result.XslResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xsl.match.service.XslMatchTypeService;

import java.util.List;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2019/4/27 09:52
 * @Description:
 */
@Controller
@RequestMapping("/match/type")
public class XslMatchTypeController {

    @Autowired
    XslMatchTypeService xslMatchTypeService;

    @RequestMapping("/selectAll/page")
    @ResponseBody
    /** 分页的获取所有比赛类型 */
    public EasyUIDataGridResult getPageOfMatchType(Integer page,Integer rows){
        XslResult allType = xslMatchTypeService.getAllType(page, rows);
        return (EasyUIDataGridResult)allType.getData();
    }

    @RequestMapping("/selectAll/list")
    @ResponseBody
    /** 不分页的获取所有比赛类型 */
    public List<XslMatchType> getListOfMatchType(){
        XslResult allType = xslMatchTypeService.getAllType();
        return (List<XslMatchType>)allType.getData();
    }

    @RequestMapping("/selectAll/list/app")
    @ResponseBody
    /** 不分页的获取所有比赛类型 */
    public XslResult getListOfMatchTypeAPP(){
        XslResult allType = xslMatchTypeService.getAllType();
        return allType;
    }

    @RequestMapping("/select")
    @ResponseBody
    /** 根据Id获取比赛类型 */
    public XslMatchType getTypeById(@Param("matchTypeId") String matchTypeId){
        XslResult type = xslMatchTypeService.getType(matchTypeId);
        return (XslMatchType)type.getData();
    }

    @RequestMapping("/add")
    @ResponseBody
    /** 添加一条比赛类型 */
    public XslResult addMatchType(@RequestBody XslMatchType xslMatchType){
        XslResult result = xslMatchTypeService.addMatchType(xslMatchType);
        return result;
    }

    @RequestMapping("/edit")
    @ResponseBody
    /** 修改一条比赛类型 */
    public XslResult editMatchType(@RequestBody XslMatchType xslMatchType){
        XslResult result = xslMatchTypeService.updateMatchType(xslMatchType);
        return result;
    }

    @RequestMapping("/delete")
    @ResponseBody
    /** 逻辑删除一条比赛类型 */
    public XslResult addMatchType(@Param("matchTypeIds") String matchTypeIds){
        List<String> stringList = MYStringUtils.getStringList(matchTypeIds, ",");
        XslResult result = xslMatchTypeService.deleteMatchTypes(stringList);
        return result;
    }

}
