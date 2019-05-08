package xsl.match.service;

import com.xsl.pojo.XslMatchUser;
import com.xsl.result.XslResult;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2019/5/5 11:50
 * @Description:
 */
public interface XslMatchUserService {

    /** 更新用户补充信息 */
    XslResult updateMatchUserInfo(XslMatchUser xslMatchUser)throws RuntimeException;
    /** 添加用户补充信息 */
    XslResult addMatchUserInfo(XslMatchUser xslMatchUser)throws RuntimeException;
    /** 根据userId查询用户补充信息 */
    XslResult selectMatchUserInfoByUserId(String userId)throws RuntimeException;
    /** 根据hunterId查询用户补充信息 */
    XslResult selectMatchUserInfoByHunterId(String hunterId)throws RuntimeException;
    /** 添加一个用户标签 */
    XslResult addHunterTag(String hunterId, String tagId)throws RuntimeException;
    /** 删除一个用户标签 */
    XslResult removeHunterTag(String hunterId, String tagId)throws RuntimeException;
    /** 根据hunterId 获取用户标签 */
    XslResult getAllTagsByHunterId(String hunterId)throws RuntimeException;
    /** 根据 tagId 获取所有用户 */
    XslResult getAllHuntersByTagId(String tagId)throws RuntimeException;
}
