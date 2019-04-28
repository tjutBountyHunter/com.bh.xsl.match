package xsl.match.mapper;


import com.xsl.pojo.XslUser;

import java.util.List;

public interface XslUserMapper {
    /** 根据用户名查询用户 */
    XslUser selectAllUserByEmail(String email);
    /** 根据手机号查询用户 */
    XslUser selectUserByPhone(String phone);
}