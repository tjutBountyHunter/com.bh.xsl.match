package xsl.match.service;

import com.xsl.result.XslResult;
import com.xsl.user.vo.JPushReqVo;

/**
 * 说明：推送
 *
 * @Auther: 11432_000
 * @Date: 2019/5/17 16:16
 * @Description:
 */
public interface MyPush {

	/** 发送推送 */
	public XslResult sendPushByPhone(JPushReqVo jPushReqVo)throws RuntimeException;

	/** 向所有人发送推送 */
	public XslResult sendAll(JPushReqVo jPushReqVo)throws RuntimeException;
}
