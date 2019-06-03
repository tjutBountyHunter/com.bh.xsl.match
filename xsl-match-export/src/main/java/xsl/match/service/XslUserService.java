package xsl.match.service;

import com.xsl.pojo.Vo.*;
import com.xsl.pojo.XslMatchUser;
import com.xsl.pojo.XslSchool;
import com.xsl.pojo.XslSchoolinfo;
import com.xsl.pojo.XslUser;
import com.xsl.result.XslResult;

import java.util.List;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2019/4/27 15:05
 * @Description:
 */
public interface XslUserService {
    /** 根据邮箱获取用户信息 */
    XslUser getUserByEmail(String email)throws RuntimeException;
    /** 根据手机号获取用户信息 */
    XslUser getUserByPhone(String phone)throws RuntimeException;
    /** 根据 userId 获取用户信息 */
    XslUser getUserByUserId(String userId)throws RuntimeException;
    /** 根据 hunterId 获取用户信息 */
    XslUser getUserByHunterId(String hunterId)throws RuntimeException;
    /** 获取学校 */
    List<XslSchool> getSchoolList(String region)throws RuntimeException;
    /** 获取所有地区 */
    List<String> getRegionList()throws RuntimeException;
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
    XslResult updateUserInfo(String hunterId,UserSupplementVo userinfo)throws RuntimeException;

    /**  获取用户详细信息 */
    UserDetailedResVo getUserDetailedInfo(String userId)throws RuntimeException;

    /** 获取学校信息 */
    public XslSchoolinfo getSchoolInfo(String schoolid) throws RuntimeException;

    /** 获取用户列表 */
    List<XslUser> getAllUser()throws RuntimeException;

}
