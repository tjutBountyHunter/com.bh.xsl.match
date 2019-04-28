package xsl.match.service;

import com.xsl.result.XslResult;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2019/4/27 15:05
 * @Description:
 */
public interface XslUserService {
    /** 根据邮箱获取用户信息 */
    XslResult getUserByEmail(String email)throws RuntimeException;
    /** 根据手机号获取用户信息 */
    XslResult getUserByPhone(String phone)throws RuntimeException;
}
