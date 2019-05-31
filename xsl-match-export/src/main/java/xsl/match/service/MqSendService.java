package xsl.match.service;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2019/5/26 17:23
 * @Description:
 */
public interface MqSendService {
	/** 发送match相关mq */
	void testMq(String msg);
}
