package xsl.match.advice;

import com.xsl.Utils.JedisUtils;
import com.xsl.Utils.JsonUtils;
import com.xsl.pojo.Example.XslHunterTagExample;
import com.xsl.pojo.XslHunterTag;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import xsl.match.mapper.XslHunterTagMapper;

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

    @AfterReturning("@annotation(com.xsl.annotation.UpdateHunterTag)")
    public void updateBuffer(JoinPoint joinPoint){
        try {
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
