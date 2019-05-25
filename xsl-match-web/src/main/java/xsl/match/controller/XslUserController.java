package xsl.match.controller;

import com.xsl.Utils.ResultUtils;
import com.xsl.annotation.CharSet;
import com.xsl.pojo.Vo.*;
import com.xsl.pojo.XslSchool;
import com.xsl.pojo.XslUser;
import com.xsl.result.XslResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xsl.match.service.PhoneAuthentication;
import xsl.match.service.XslUserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

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
    private XslUserService xslUserService;
    @Autowired
    private PhoneAuthentication phoneAuthentication;

    @RequestMapping("/select/email")
    @ResponseBody
    /** 根据邮箱查询用户*/
    public XslResult getUserByEmail(@Param("email")String email){
        XslUser userByEmail = xslUserService.getUserByEmail(email);
        return ResultUtils.ok(userByEmail);
    }

    @RequestMapping("/select/phone")
    @ResponseBody
    /** 根据手机号查询用户 */
    public XslResult getUserByPhone(@Param("phone")String phone){
        XslUser userByPhone = xslUserService.getUserByPhone(phone);
        return ResultUtils.ok(userByPhone);
    }

    @RequestMapping("/login")
    @ResponseBody
    /** 登录 */
    public XslResult login(@RequestBody UserReqVo userReqVo){
        XslResult userByPhone = xslUserService.userLogin(userReqVo);
        return userByPhone;
    }


    @RequestMapping("/quick/register")
    @ResponseBody
    /** 快速注册 */
    public XslResult quickRegister(@RequestBody XslUserRegister xslUserRegister){
        XslResult userByPhone = xslUserService.quickCreateUser(xslUserRegister);
        return userByPhone;
    }

    @RequestMapping("/school/list")
    @ResponseBody
    /** 根据地区获取学校列表  */
    public XslResult getSchoolList(String region){
        List<XslSchool> schoolList = xslUserService.getSchoolList(region.toString());
        return ResultUtils.ok(schoolList);
    }


    @RequestMapping("/school/region")
    @ResponseBody
    /** 获取地区 */
    public XslResult getSchoolRegion(){
        List<String> regionList = xslUserService.getRegionList();
        return ResultUtils.ok(regionList);
    }

    @RequestMapping("/edit/user/info")
    @ResponseBody
    /** 更改用户信息 */
    public XslResult editUserInfo(@RequestBody MatchUserEditReqVo xMatchUserEditReqVo){
        UserSupplementVo userSupplementVo =  new UserSupplementVo();
        BeanUtils.copyProperties(xMatchUserEditReqVo,userSupplementVo);
        XslResult xslResult = xslUserService.updateUserInfo(userSupplementVo.getUserid(),userSupplementVo);
        return xslResult;
    }

    @RequestMapping("/authentication")
    @ResponseBody
    /** 认证用户信息 */
    public XslResult authenticationUserInfo(@RequestBody UserSupplementVo userSupplementVo){
        XslResult xslResult = xslUserService.updateUserInfo(userSupplementVo.getUserid(),userSupplementVo);
        return xslResult;
    }

    @RequestMapping("/detailedInfo")
    @ResponseBody
    /** 获取用户详情（其他人查看的） */
    public XslResult getDetailedInfo(String userid){
        UserDetailedResVo userDetailedInfo = xslUserService.getUserDetailedInfo(userid);
        return ResultUtils.ok(userDetailedInfo);
    }

    @RequestMapping("/get/verificationCode")
    @ResponseBody
    /** 获取验证码 */
    public XslResult sendVerificationCode(@Param("phone") String phone){
        XslResult xslResult = phoneAuthentication.sendVerificationCode(phone);
        return xslResult;
    }


}
