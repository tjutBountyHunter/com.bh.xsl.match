package xsl.match.service.impl;

import com.xsl.Utils.ResultUtils;
import com.xsl.enums.MqTargetEnum;
import com.xsl.result.XslResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import xsl.match.service.SendMq;

import javax.annotation.Resource;
import javax.jms.Destination;

/**
 * @ClassName SendMqImpl
 * @Description TODO
 * @Author 11432
 * @DATE 2019/5/31 13:58
 */
@Service
public class SendMqImpl implements SendMq {

    /*private static final Logger LOGGER = LoggerFactory.getLogger(SendMqImpl.class);

    @Autowired
    private JmsTemplate jmsTemplate;
    @Resource
    private Destination updateESMatch;
    @Resource
    private Destination removeESMatch;
    @Resource
    private Destination updateESMatchUser;
    @Resource
    private Destination removeESMatchUser;
    @Resource
    private Destination updateESMatchTeam;
    @Resource
    private Destination removeESMatchTeam;


    @Override
    public XslResult sendByMq(MqTargetEnum targetEnum, String message) throws RuntimeException {
        LOGGER.debug("sendByMq param is targetEnum:[{}],message:[{}]",targetEnum,message);
        Destination target = getDestination(targetEnum);
        jmsTemplate.send(target ,session -> session.createTextMessage(message));
        return ResultUtils.ok();
    }

    private Destination getDestination(MqTargetEnum targetEnum){
        switch (targetEnum.getCode()){
            case 0:
                return updateESMatch;
            case 1:
                return removeESMatch;
            case 2:
                return updateESMatchTeam;
            case 3:
                return removeESMatchTeam;
            case 4:
                return updateESMatchUser;
            case 5:
                return removeESMatchUser;
        }
        throw new RuntimeException("不存在该消息目标");
    }*/
}
