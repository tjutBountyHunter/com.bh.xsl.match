package xsl.match.controller;

import com.xsl.annotation.CharSet;
import com.xsl.pojo.Vo.UserReqVo;
import com.xsl.pojo.Vo.UserSupplementVo;
import com.xsl.pojo.Vo.XslUserRegister;
import com.xsl.pojo.XslUser;
import com.xsl.result.XslResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xsl.match.service.XslUserService;

import java.io.UnsupportedEncodingException;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2019/4/27 15:17
 * @Description:
 */
@Controller
@RequestMapping("user")
public class XslUserController {

    @Autowired
    XslUserService xslUserService;

    @RequestMapping("/select/email")
    @ResponseBody
    public XslResult getUserByEmail(@Param("email")String email){
        XslResult userByEmail = xslUserService.getUserByEmail(email);
        return userByEmail;
    }

    @RequestMapping("/select/phone")
    @ResponseBody
    public XslResult getUserByPhone(@Param("phone")String phone){
        XslResult userByPhone = xslUserService.getUserByPhone(phone);
        return userByPhone;
    }

    @RequestMapping("/login")
    @ResponseBody
    public XslResult login(UserReqVo userReqVo){
        XslResult userByPhone = xslUserService.userLogin(userReqVo);
        return userByPhone;
    }


    @RequestMapping("/quick/register")
    @ResponseBody
    public XslResult quickRegister(XslUserRegister xslUserRegister){
        XslResult userByPhone = xslUserService.quickCreateUser(xslUserRegister);
        return userByPhone;
    }

    @RequestMapping(value = "/school/list")
    @ResponseBody
    @CharSet
    public XslResult getSchoolList(StringBuilder region){
        XslResult schoolLsit = xslUserService.getSchoolLsit(region.toString());
        return schoolLsit;
    }


    @RequestMapping("/school/region")
    @ResponseBody
    public XslResult getSchoolRegion(){
        XslResult regionList = xslUserService.getRegionList();
        return regionList;
    }

    @RequestMapping("/edit/user/info")
    @ResponseBody
    /** 更新用户信息 */
    public XslResult editUserInfo(UserSupplementVo userSupplementVo){
        XslResult xslResult = xslUserService.updateUserInfo(userSupplementVo);
        return xslResult;
    }

}
