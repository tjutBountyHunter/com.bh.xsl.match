package xsl.match.controller;

import com.xsl.pojo.XslOriented;
import com.xsl.result.EasyUIDataGridResult;
import com.xsl.result.XslResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xsl.match.service.XslOrientedService;

import java.util.List;

/**
 * 说明：人群表相关操作
 *
 * @Auther: 11432_000
 * @Date: 2019/4/21 13:21
 * @Description:
 */
@Controller
@RequestMapping("match/oriented")
public class XslOrientedController {

    @Autowired
    XslOrientedService xslOrientedService;

    @RequestMapping("/selectAll/list")
    @ResponseBody
    /**
     *
     * 功能描述: 获取所有面向人群
     *
     * @param: []
     * @return: java.util.List<com.xsl.pojo.XslOriented>
     * @auther: 11432_000
     * @date: 2019/4/21 14:29
     */
    public List<XslOriented> getAllOrientedList(){
        return xslOrientedService.getAllOrienteds(null,null).getRows();
    }

    @RequestMapping("/selectAll/page")
    @ResponseBody
    /**
     *
     * 功能描述: 获取所有面向人群
     *
     * @param: []
     * @return: java.util.List<com.xsl.pojo.XslOriented>
     * @auther: 11432_000
     * @date: 2019/4/21 14:29
     */
    public EasyUIDataGridResult getAllOrientedPage(Integer page,Integer rows){
        return xslOrientedService.getAllOrienteds(page,rows);
    }

    @RequestMapping("/add")
    @ResponseBody
    /**
     *
     * 功能描述: 添加面向人群
     *
     * @param: []
     * @return: java.util.List<com.xsl.pojo.XslOriented>
     * @auther: 11432_000
     * @date: 2019/4/21 14:29
     */
    public XslResult addOriented(@RequestBody XslOriented xslOriented){
        return xslOrientedService.addOriented(xslOriented);
    }

    @RequestMapping("/edit")
    @ResponseBody
    /**
     *
     * 功能描述: 获取所有面向人群
     *
     * @param: []
     * @return: java.util.List<com.xsl.pojo.XslOriented>
     * @auther: 11432_000
     * @date: 2019/4/21 14:29
     */
    public XslResult editOriented(@RequestBody XslOriented xslOriented){
        return xslOrientedService.updateOriented(xslOriented);
    }


    @RequestMapping("/delete")
    @ResponseBody
    /**
     *
     * 功能描述: 删除一或多个面向人群
     *
     * @param: []
     * @return: java.util.List<com.xsl.pojo.XslOriented>
     * @auther: 11432_000
     * @date: 2019/4/21 14:29
     */
    public XslResult editOriented(String OrientedIds){
        return xslOrientedService.deleteOrienteds(OrientedIds);
    }

}
