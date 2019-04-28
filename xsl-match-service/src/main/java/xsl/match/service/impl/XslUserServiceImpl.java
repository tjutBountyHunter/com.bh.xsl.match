package xsl.match.service.impl;

import com.xsl.Utils.ResultUtils;
import com.xsl.enums.ResultCode;
import com.xsl.pojo.XslUser;
import com.xsl.result.XslResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xsl.match.mapper.XslUserMapper;
import xsl.match.service.XslUserService;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2019/4/27 15:12
 * @Description:
 */
@Service
public class XslUserServiceImpl implements XslUserService {

    @Autowired
    XslUserMapper xslUserMapper;
    @Override
    public XslResult getUserByEmail(String email) throws RuntimeException {
        /**
         *
         * 功能描述: 根据邮箱获取用户信息
         *
         * @param: [email]
         * @return: com.xsl.result.XslResult
         * @auther: 11432_000
         * @date: 2019/4/27 15:16
         */
        try {
            XslUser xslUser = xslUserMapper.selectAllUserByEmail(email);
            if (xslUser == null){
                return ResultUtils.isParameterError();
            }
            return ResultUtils.isOk(xslUser);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    @Override
    public XslResult getUserByPhone(String phone) throws RuntimeException {
        /**
         *
         * 功能描述: 根据手机号获取用户信息
         *
         * @param: [phone]
         * @return: com.xsl.result.XslResult
         * @auther: 11432_000
         * @date: 2019/4/27 15:17
         */
        try {
            XslUser xslUser = xslUserMapper.selectUserByPhone(phone);
            if (xslUser == null){
                return ResultUtils.isParameterError();
            }
            return ResultUtils.isOk(xslUser);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
