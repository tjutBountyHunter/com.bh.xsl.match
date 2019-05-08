package xsl.match.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import xsl.match.mapper.XslHunterTagMapper;

/**
 * 说明：猎人标签切面
 *
 * @Auther: 11432_000
 * @Date: 2019/5/6 20:51
 * @Description:
 */
@Aspect
@Component
public class updateHunterTagBuffer {

    @Value("${HUNTER_TAG_BUFFER}")
    private String HUNTER_TAG_BUFFER;
    @Autowired
    private XslHunterTagMapper xslHunterTagMapper;

    @AfterReturning("@annotation(com.xsl.annotation.UpdateHunterTag)")
    public void updateBuffer(JoinPoint joinPoint){

    }
}
