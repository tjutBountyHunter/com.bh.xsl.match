package xsl.match.advice;

import com.xsl.Utils.JedisUtils;
import com.xsl.Utils.JsonUtils;
import com.xsl.pojo.Example.XslTaskTagExample;
import com.xsl.pojo.XslTaskTag;
import com.xsl.result.XslResult;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;
import xsl.match.mapper.XslTaskTagMapper;
import xsl.match.service.XslTagService;

import java.util.List;

/**
 * 说明：职位标签切面
 *
 * @Auther: 11432_000
 * @Date: 2019/5/6 20:51
 * @Description:
 */
@Aspect
@Component
public class UpdatePositionTagBuffer {

    private static final Logger LOGGER = LoggerFactory.getLogger(UpdatePositionTagBuffer.class);

    @Autowired
    private XslTaskTagMapper xslTaskTagMapper;
    @Value("${POSITION_TAG_BUFFER}")
    private String POSITION_TAG_BUFFER;

    @AfterReturning("@annotation(com.xsl.annotation.UpdatePositionTag)")
    public void updateBuffer(JoinPoint joinPoint){
        try {
            Object[] args = joinPoint.getArgs();
            String positionId = args[0].toString();
            XslTaskTagExample xslTaskTagExample = new XslTaskTagExample();
            xslTaskTagExample.createCriteria().andTaskidEqualTo(positionId).andStateEqualTo(true);
            //获取所有该用户的标签
            List<XslTaskTag> xslTaskTags = xslTaskTagMapper.selectByExample(xslTaskTagExample);
            String json = JsonUtils.objectToJson(xslTaskTags);
            JedisUtils.set(POSITION_TAG_BUFFER + ":" + positionId,json);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
