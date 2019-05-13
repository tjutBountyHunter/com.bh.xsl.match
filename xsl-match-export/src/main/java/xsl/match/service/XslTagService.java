package xsl.match.service;

import com.xsl.pojo.XslTag;
import com.xsl.result.XslResult;

import java.util.List;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2019/5/8 13:47
 * @Description:
 */
public interface XslTagService {
    /** 添加标签 */
    XslResult addTag(String tagName)throws RuntimeException;
    /** 移除标签 */
    XslResult removeTag(String tagId)throws RuntimeException;
    /** 根据 Id 批量获取标签 */
    List<XslTag> getTags(List<String> tagIds)throws RuntimeException;
    /** 根据 Id 批量获取标签 */
    List<XslTag> getTags(String... tagIds)throws RuntimeException;
    /** 获取所有Tag */
    List<XslTag> getTags()throws RuntimeException;
}
