package xsl.match.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2019/5/6 20:51
 * @Description:
 */
@Aspect
@Component
public class updateHunterTagBuffer {

    @AfterReturning("@annotation(com.xsl.annotation.UpdateHunterTag)")
    public void updateBuffer(JoinPoint joinPoint){

    }
}
