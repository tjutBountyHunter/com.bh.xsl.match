package xsl.match.service;

import com.xsl.result.XslResult;

/**
 * 说明：短信认证
 *
 * @Auther: 11432_000
 * @Date: 2019/5/18 15:25
 * @Description:
 */
public interface PhoneAuthentication {
	/** 发送验证码 */
	XslResult sendVerificationCode(String phone)throws RuntimeException;

	/** 校验验证码 */
	XslResult checkVerificationCode(String phone,String code)throws RuntimeException;
}
