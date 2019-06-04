package xsl.match.controller;

import com.xsl.Utils.ResultUtils;
import com.xsl.pojo.XslMatchRemark;
import com.xsl.pojo.XslUser;
import com.xsl.result.XslResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xsl.match.service.XslRemarkService;

import java.util.List;

/**
 * @ClassName XslRemarkController
 * @Description TODO
 * @Author 11432
 * @DATE 2019/6/4 10:02
 */
@Controller
@RequestMapping("remark")
public class XslRemarkController {

    @Autowired
    private XslRemarkService xslRemarkService;

    @RequestMapping("/add")
    @ResponseBody
    /** 添加评论 */
    public XslResult addRemark(@RequestBody XslMatchRemark xslMatchRemark){
        XslResult xslResult = xslRemarkService.addRemark(xslMatchRemark);
        return xslResult;
    }
    @RequestMapping("/select/byUser")
    @ResponseBody
    /** 获取指定用户的所有评论 */
    public XslResult getRemarksByUser(@Param("hunterId")String hunterId){
        List<XslMatchRemark> xslMatchRemarks = xslRemarkService.selectRemarkByTargetId(hunterId);
        return ResultUtils.ok(xslMatchRemarks);
    }

    @RequestMapping("/select/byPublisher")
    @ResponseBody
    /** 获取指定用户发表的所有评论 */
    public XslResult getRemarksByPublisher(@Param("commentatorId")String commentatorId){
        List<XslMatchRemark> xslMatchRemarks = xslRemarkService.selectRemarkByCommentatorId(commentatorId);
        return ResultUtils.ok(xslMatchRemarks);
    }

    @RequestMapping("/select")
    @ResponseBody
    /** 获取指定评论 */
    public XslResult getRemark(@RequestBody XslMatchRemark xslMatchRemark){
        List<XslMatchRemark> xslMatchRemarks = xslRemarkService.selectRemarkByCommentatorIdAndTargetId(xslMatchRemark.getCommentatorid(),
                xslMatchRemark.getTargetid(), xslMatchRemark.getTeamid());
        return ResultUtils.ok(xslMatchRemarks.get(0));
    }
    @RequestMapping("/delete")
    @ResponseBody
    /** 删除指定评论 */
    public XslResult removeRemark(@RequestBody XslMatchRemark xslMatchRemark){
        XslResult xslResult = xslRemarkService.removeRemark(xslMatchRemark.getCommentatorid(),
                xslMatchRemark.getTargetid(), xslMatchRemark.getTeamid());
        return xslResult;
    }

}
