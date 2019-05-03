package xsl.match.advice;

import com.xsl.Utils.JedisUtils;
import com.xsl.Utils.JsonUtils;
import com.xsl.enums.ResultCode;
import com.xsl.pojo.XslMatch;
import com.xsl.pojo.XslMatchExample;
import com.xsl.result.XslResult;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import xsl.match.mapper.XslMatchMapper;

import java.util.List;

/**
 * 说明：更新比赛数据的切面
 *
 * @Auther: 11432_000
 * @Date: 2019/4/28 09:49
 * @Description:
 */
@Aspect
@Component
public class updateMatchBuffer {

    private static final Logger LOGGER = LoggerFactory.getLogger(updateMatchBuffer.class);

    private boolean isUpdate = true;

    @Autowired
    XslMatchMapper xslMatchMapper;
    @Value("MATCH_BUFFER_PREFIX")
    private String MATCH_BUFFER_PREFIX;

    @AfterReturning(pointcut = "@annotation(com.xsl.annotation.UpdateMatch)" ,returning = "xslResult")
    public void updateBuffer(JoinPoint joinPoint,XslResult xslResult){
        /**
         *
         * 功能描述: 添加或修改的切面
         *
         * @param: [xslResult]
         * @return: void
         * @auther: 11432_000
         * @date: 2019/4/28 14:01
         */
        if (!xslResult.getCode().equals(ResultCode.SUCCESS.getCode())){
            return;
        }
        if (xslResult.getData() != null){
            String matchIds = xslResult.getData().toString();
            String[] split = matchIds.split(",");
            XslMatchExample xslMatchExample = new XslMatchExample();
            XslMatchExample.Criteria criteria = xslMatchExample.createCriteria();
            for (String matchId : split){
                try {
                    xslMatchExample.clear();
                    criteria.andMatchidEqualTo(matchId);
                    XslMatch xslMatch = xslMatchMapper.selectByExample(xslMatchExample).get(0);
                    JedisUtils.set(MATCH_BUFFER_PREFIX +  ":" + xslMatch.getMatchid(), JsonUtils.objectToJson(xslMatch));
                    LOGGER.info("更新比赛缓存---成功");
                } catch (Exception e) {
                    LOGGER.error("更新比赛缓存---失败");
                    throw new RuntimeException(e.getMessage());
                }
            }
        }
    }

    @AfterReturning(pointcut = "@annotation(com.xsl.annotation.DeleteMatch)" ,returning = "xslResult")
    public void deleteMatch(JoinPoint joinPoint,XslResult xslResult){
        /**
         *
         * 功能描述: 删除的切面
         *
         * @param: [xslResult]
         * @return: void
         * @auther: 11432_000
         * @date: 2019/4/28 14:02
         */
        if (!xslResult.getCode().equals(ResultCode.SUCCESS.getCode())){
            return;
        }
        if (xslResult.getData() != null){
            String matchIds = xslResult.getData().toString();
            String[] split = matchIds.split(",");
            for (String matchId : split){
                try {
                    JedisUtils.delete(MATCH_BUFFER_PREFIX +  ":" + matchId);
                    LOGGER.info("删除比赛缓存--"+ joinPoint.getArgs()[0].toString() +"成功");
                } catch (Exception e) {
                    LOGGER.error("删除比赛缓存---失败");
                    throw new RuntimeException(e.getMessage());
                }
            }
        }
    }


}
