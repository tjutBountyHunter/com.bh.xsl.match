package xsl.match.service;

import com.xsl.pojo.Vo.PositionTagResVo;
import com.xsl.pojo.XslTaskTag;
import com.xsl.result.XslResult;

import java.util.List;

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
    /** 为职位添加多个标签 */
    XslResult addPositionTags(String positionId ,List<String> tagIds)throws RuntimeException;
    /** 查询职位的所有使用中标签 */
    List<XslTaskTag> getAllTagByPositionId(String positionId)throws RuntimeException;
    /** 查询职位的所有使用中标签 + 标签名 */
    List<PositionTagResVo> getAllTagInfoByPositionId(String positionId)throws RuntimeException;
    /** 查询所有持有某标签的职位 */
    List<XslTaskTag> getAllPositionByTagId(String tagId)throws RuntimeException;
    /** 更新用户标签 */
    XslResult updateTags(String positionId ,List<String> tagIds)throws RuntimeException;
}
