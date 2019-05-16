package xsl.match.controller;

import com.xsl.Utils.ResultUtils;
import com.xsl.pojo.Vo.HunterTagResVo;
import com.xsl.pojo.Vo.XslMatchUserReqVo;
import com.xsl.pojo.Vo.XslMatchUserResVo;
import com.xsl.pojo.XslMatchUser;
import com.xsl.pojo.XslTag;
import com.xsl.result.XslResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xsl.match.service.XslMatchUserService;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2019/5/11 13:50
 * @Description:
 */
@Controller
@RequestMapping("user/added")
public class XslMatchUserController {

    @Autowired
    private XslMatchUserService xslMatchUserService;

    @RequestMapping("/get/info")
    @ResponseBody
    /** 获取用户补充信息 */
    public XslResult getMatchUserInfo(@Param("hunterId") String hunterId){
        List<HunterTagResVo> allTagsInfoByHunterId = xslMatchUserService.getAllTagsInfoByHunterId(hunterId);
        XslMatchUser xslMatchUser = xslMatchUserService.selectMatchUserInfoByHunterId(hunterId);
        XslMatchUserResVo xslResult = new XslMatchUserResVo();
        BeanUtils.copyProperties(xslMatchUser,xslResult);
        xslResult.setTags(allTagsInfoByHunterId);
        return ResultUtils.ok(xslResult);
    }


    @RequestMapping("/edit/info")
    @ResponseBody
    /** 更改用户补充信息 */
    public XslResult editMatchUserInfo(@RequestBody XslMatchUserReqVo xslMatchUserReqVo){
        XslMatchUser xslMatchUser = new XslMatchUser();
        BeanUtils.copyProperties(xslMatchUserReqVo,xslMatchUser);
        XslResult xslResult = xslMatchUserService.updateMatchUserInfo(xslMatchUser.getHunterid(),xslMatchUser);
        if (!ResultUtils.isSuccess(xslResult)){
            return xslResult;
        }
        List<XslTag> xslTags = xslMatchUserReqVo.getTags();
        ArrayList<String> tags = new ArrayList<>();
        for (XslTag xslTag : xslTags){
            tags.add(xslTag.getTagid());
        }
        XslResult xslResult1 = xslMatchUserService.updateHunterTag(xslMatchUserReqVo.getHunterid(), tags);
        if (!ResultUtils.isSuccess(xslResult1)){
            return xslResult1;
        }
        return ResultUtils.ok();
    }

}
