package xsl.match.service;

import com.xsl.pojo.Vo.UserReqVo;
import com.xsl.pojo.Vo.UserSupplementVo;
import com.xsl.pojo.Vo.XslUserRegister;
import com.xsl.pojo.XslMatchUser;
import com.xsl.pojo.XslUser;
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
    /** 根据 userId 获取用户信息 */
    XslResult getUserByUserId(String userId)throws RuntimeException;
    /** 根据 hunterId 获取用户信息 */
    XslResult getUserByHunterId(String hunterId)throws RuntimeException;
    /** 获取学校信息 */
    XslResult getSchoolLsit(String region)throws RuntimeException;
    /** 获取所有地区 */
    XslResult getRegionList()throws RuntimeException;
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

    /** 更新用户信息 */
    XslResult updateUserInfo(UserSupplementVo userinfo)throws RuntimeException;

}
