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
    XslResult removePositionTag(String positionId ,String tagId)throws RuntimeException;
    /** 查询职位的所有使用中标签 */
    XslResult getAllTagByPositionId(String positionId)throws RuntimeException;
    /** 查询所有持有某标签的职位 */
    XslResult getAllPositionByTagId(String tagId)throws RuntimeException;
}
