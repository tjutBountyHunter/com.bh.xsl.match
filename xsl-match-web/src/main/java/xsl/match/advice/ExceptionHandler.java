package xsl.match.advice;

import com.xsl.Utils.ResultUtils;
import com.xsl.result.XslResult;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2019/5/18 12:50
 * @Description:
 */
@Aspect
@Component
public class ExceptionHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandler.class);


	@Around("execution(com.xsl.result.XslResult xsl.match.controller.*.*(..))")
	@ResponseBody
	public XslResult exceptionHandler(ProceedingJoinPoint proceedingJoinPoint){
		try {
			Object proceed = proceedingJoinPoint.proceed(proceedingJoinPoint.getArgs());
			return (XslResult) proceed;
		} catch (Throwable throwable) {
			LOGGER.info("进入全局异常处理");
			throwable.printStackTrace();
			return ResultUtils.error("参数错误！");
		}
	}

}
