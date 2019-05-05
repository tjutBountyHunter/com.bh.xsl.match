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
}
