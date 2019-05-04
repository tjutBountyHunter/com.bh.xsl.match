package xsl.match.service;

import com.xsl.pojo.Vo.UserReqVo;
import com.xsl.pojo.Vo.XslUserRegister;
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

    /**
     * 快速注册
     * @param xslUserRegister
     * @return
     * @throws Exception
     */
    XslResult quickCreateUser(XslUserRegister xslUserRegister);

    /**
     * 登录
     *
     * @param userReqVo
     * @return
     */
    XslResult userLogin(UserReqVo userReqVo);

}
