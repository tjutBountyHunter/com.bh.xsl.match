package xsl.match.controller;

import com.xsl.pojo.XslOriented;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @RequestMapping("/selectAll")
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
    public List<XslOriented> getAllOriented(){
        return xslOrientedService.getAllXslOrienteds();
    }
}
