package xsl.match.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;
import xsl.match.service.MqSendService;

import javax.annotation.Resource;
import javax.jms.Destination;

/**
 * 说明：Mq发送类
 *
 * @Auther: 11432_000
 * @Date: 2019/5/26 17:21
 * @Description:
 */
@Service
public class MqSendServiceImpl implements MqSendService {

	@Autowired
    private JmsTemplate jmsTemplate;
	@Resource
	private Destination updateESMatch;

	@Override
	public void testMq(String msg) {
		try {
//			jmsTemplate.send(updateESMatch,session -> {return session.createTextMessage(msg);});
			jmsTemplate.send(updateESMatch,session -> session.createTextMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}





}
