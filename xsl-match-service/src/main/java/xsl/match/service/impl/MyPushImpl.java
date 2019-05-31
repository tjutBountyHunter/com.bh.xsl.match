package xsl.match.service.impl;

import com.xsl.result.XslResult;
import com.xsl.user.JpushResource;
import com.xsl.user.vo.ResBaseVo;
import xsl.match.service.MyPush;
import com.xsl.user.vo.JPushReqVo;

import javax.annotation.Resource;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2019/5/17 16:26
 * @Description:
 */
public class MyPushImpl implements MyPush {

	@Resource
	private JpushResource jpushResource;

	@Override
	public XslResult sendPushByPhone(JPushReqVo jPushReqVo) throws RuntimeException {
		ResBaseVo resBaseVo = jpushResource.sendByPhone(jPushReqVo);
		XslResult result = new XslResult();
		result.setCode(resBaseVo.getStatus());
		result.setData(resBaseVo.getExParam());
		result.setMsg(resBaseVo.getMsg());
		return result;
	}
}
