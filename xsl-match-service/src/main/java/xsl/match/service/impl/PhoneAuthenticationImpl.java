package xsl.match.service.impl;

import com.xsl.result.XslResult;
import com.xsl.user.VerifyCodeResource;
import com.xsl.user.vo.ResBaseVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import xsl.match.service.PhoneAuthentication;

import javax.annotation.Resource;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2019/5/18 15:27
 * @Description:
 */
@Service
public class PhoneAuthenticationImpl implements PhoneAuthentication {

	private static final Logger LOGGER = LoggerFactory.getLogger(PhoneAuthenticationImpl.class);

	@Resource
	private VerifyCodeResource verifyCodeResource;

	@Override
	/** 发送验证码 */
	public XslResult sendVerificationCode(String phone) throws RuntimeException {
		ResBaseVo resBaseVo = verifyCodeResource.sendMessageCode(phone);
		XslResult copy = copy(resBaseVo);
		return copy;
	}

	@Override
	/** 校验验证码 */
	public XslResult checkVerificationCode(String phone, String code) throws RuntimeException {
		ResBaseVo resBaseVo = verifyCodeResource.checkCode(phone, code);
		XslResult copy = copy(resBaseVo);
		return copy;
	}

	private XslResult copy(ResBaseVo resBaseVo){
		XslResult result = new XslResult();
		result.setCode(resBaseVo.getStatus());
		result.setData(resBaseVo.getExParam());
		result.setMsg(resBaseVo.getMsg());
		return result;
	}
}
