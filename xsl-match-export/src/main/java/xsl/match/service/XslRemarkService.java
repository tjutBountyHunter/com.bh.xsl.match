package xsl.match.service;

import com.xsl.pojo.XslMatchRemark;
import com.xsl.pojo.XslReward;
import com.xsl.result.XslResult;

import java.util.List;

/**
 * @ClassName XslRemarkService
 * @Description TODO
 * @Author 11432
 * @DATE 2019/6/2 18:54
 */
public interface XslRemarkService {

    /** 添加评论 */
    XslResult addRemark(XslMatchRemark xslMatchRemark)throws RuntimeException;
    /** 删除评论 */
    XslResult removeRemark(String commentatorId,String targetId,String teamId)throws RuntimeException;
    /** 获取指定评论 */
    List<XslMatchRemark> selectRemarkByCommentatorIdAndTargetId(String commentatorId,String targetId,String teamId)throws RuntimeException;
    /** 获取某个人的评论 */
    List<XslMatchRemark> selectRemarkByTargetId(String targetId)throws RuntimeException;
    /** 获取某个人发表的评论 */
    List<XslMatchRemark> selectRemarkByCommentatorId(String commentatorId)throws RuntimeException;
}
