package xsl.match.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2019/5/4 20:53
 * @Description:
 */
@Aspect
@Component
public class CharSet {

    @Before("@annotation(com.xsl.annotation.CharSet)")
    public void charset(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        StringBuilder arg = (StringBuilder) args[0];
        try {
            String s = new String(arg.toString().getBytes("ISO-8859-1"), "UTF-8");
            arg.delete(0,arg.length());
            arg.append(s);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
