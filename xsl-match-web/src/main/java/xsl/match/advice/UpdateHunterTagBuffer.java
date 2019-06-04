package xsl.match.advice;

import com.xsl.Utils.JedisUtils;
import com.xsl.Utils.JsonUtils;
import com.xsl.Utils.ResultUtils;
import com.xsl.pojo.Example.XslHunterTagExample;
import com.xsl.pojo.XslHunterTag;
import com.xsl.result.XslResult;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;
import xsl.match.mapper.XslHunterTagMapper;
import xsl.match.service.XslTagService;

import java.util.List;

/**
 * 说明：猎人标签切面
 *
 * @Auther: 11432_000
 * @Date: 2019/5/6 20:51
 * @Description:
 */
@Aspect
@Component
public class UpdateHunterTagBuffer {

    @Value("${HUNTER_TAG_BUFFER}")
    private String HUNTER_TAG_BUFFER;
    @Autowired
    private XslHunterTagMapper xslHunterTagMapper;

    @AfterReturning(pointcut = "@annotation(com.xsl.annotation.UpdateHunterTag)",returning = "xslResult" )
    public void updateBuffer(JoinPoint joinPoint, XslResult xslResult){
        try {
            if (!ResultUtils.isSuccess(xslResult)){
                return;
            }
            Object[] args = joinPoint.getArgs();
            String hunterId = args[0].toString();
            XslHunterTagExample xslTaskTagExample = new XslHunterTagExample();
            xslTaskTagExample.createCriteria().andHunteridEqualTo(hunterId).andStateEqualTo(true);
            List<XslHunterTag> xslTaskTags = xslHunterTagMapper.selectByExample(xslTaskTagExample);
            String json = JsonUtils.objectToJson(xslTaskTags);
            JedisUtils.set(HUNTER_TAG_BUFFER + ":" + hunterId,json);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
