package xsl.match.advice;

import com.xsl.Utils.JedisUtils;
import com.xsl.Utils.JsonUtils;
import com.xsl.pojo.Example.XslTagExample;
import com.xsl.pojo.XslTag;
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
import xsl.match.mapper.XslTagMapper;

import java.util.List;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2019/5/9 21:24
 * @Description:
 */
@Aspect
@Component
public class UpdateTagBuffer {

    private static final Logger LOGGER = LoggerFactory.getLogger(UpdateTagBuffer.class);

    @Autowired
    ThreadPoolTaskExecutor threadPoolTaskExecutor;
    @Autowired
    XslTagMapper xslTagMapper;
    @Value("${TAG_BUFFER}")
    private String TAG_BUFFER;
    @Value("${TAG_BUFFER_LIST}")
    private String TAG_BUFFER_LIST;
    @Value("${MATCH_TAG_PREFIX}")
    private String MATCH_TAG_PREFIX;



    @AfterReturning(pointcut = "@annotation(com.xsl.annotation.AddTag)" ,returning = "xslResult")
    public void addTag(JoinPoint joinPoint, XslResult xslResult){
        /**
         *
         * 功能描述: 添加或修改的切面
         *
         * @param: [xslResult]
         * @return: void
         * @auther: 11432_000
         * @date: 2019/4/28 14:01
         */
        String arg = (String) joinPoint.getArgs()[0];
        XslTagExample xslTagExample = new XslTagExample();
        xslTagExample.createCriteria().andNameEqualTo(arg).andStateEqualTo(true);
        List<XslTag> xslTags = xslTagMapper.selectByExample(xslTagExample);
        if (xslTags.size() == 0){
            throw new RuntimeException("标签不存在");
        }
        //添加单个
        XslTag xslTag = xslTags.get(0);
        String json = JsonUtils.objectToJson(xslTag);
        JedisUtils.set(TAG_BUFFER + ":" + xslTag.getTagid(),json);
        //更新列表
        String s = JedisUtils.get(TAG_BUFFER_LIST);
        List<XslTag> xslTags1 = JsonUtils.jsonToList(s, XslTag.class);
        xslTags1.add(xslTag);
        String s1 = JsonUtils.objectToJson(xslTags1);
        JedisUtils.set(TAG_BUFFER_LIST,s1);

    }

    @AfterReturning(pointcut = "@annotation(com.xsl.annotation.DeleteTag)" ,returning = "xslResult")
    public void deleteTag(JoinPoint joinPoint,XslResult xslResult){
        /**
         *
         * 功能描述: 删除的切面
         *
         * @param: [xslResult]
         * @return: void
         * @auther: 11432_000
         * @date: 2019/4/28 14:02
         */
        String tagId = (String) joinPoint.getArgs()[0];
        JedisUtils.delete(TAG_BUFFER + ":" + tagId);

        //更新列表
        XslTagExample xslTagExample = new XslTagExample();
        xslTagExample.createCriteria().andTagidLike(MATCH_TAG_PREFIX + "%").andStateEqualTo(true);
        List<XslTag> xslTags = xslTagMapper.selectByExample(xslTagExample);

        String json = JsonUtils.objectToJson(xslTags);
        JedisUtils.set(TAG_BUFFER_LIST,json);
    }
}
