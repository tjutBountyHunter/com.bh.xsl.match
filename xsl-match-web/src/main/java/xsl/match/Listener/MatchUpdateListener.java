package xsl.match.Listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * 说明：比赛更新监听
 *
 * @Auther: 11432_000
 * @Date: 2019/5/6 17:43
 * @Description:
 */
public class MatchUpdateListener implements MessageListener {
    @Override
    public void onMessage(Message message) {
        TextMessage textMessage = null;
        try {
            if (message instanceof TextMessage){
                textMessage = (TextMessage) message;
                String json = textMessage.getText();
                System.out.println("接收到了：" + json);
            }
        } catch (JMSException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
