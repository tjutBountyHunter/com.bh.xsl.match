package xsl.match.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2019/4/20 18:14
 * @Description:
 */
@Controller
public class TestController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/item-add")
    public String index2(){
        return "item-add";
    }
}
