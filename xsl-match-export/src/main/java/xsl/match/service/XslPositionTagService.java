package xsl.match.service;

import com.xsl.result.XslResult;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2019/5/6 19:51
 * @Description:
 */
public interface XslPositionTagService {
    /** 为职位添加一个标签 */
    XslResult addPositionTag(String positionId ,String tagId)throws RuntimeException;
    /** 为职位删除一个标签 */
    XslResult deletePositionTag(String positionId ,String tagId)throws RuntimeException;
}
