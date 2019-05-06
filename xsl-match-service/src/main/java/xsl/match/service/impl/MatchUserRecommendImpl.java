package xsl.match.service.impl;

import com.xsl.Utils.JedisUtils;
import com.xsl.Utils.JsonUtils;
import com.xsl.Utils.ResultUtils;
import com.xsl.result.XslResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import xsl.match.service.HunterRecommend;
import xsl.match.service.MatchUserRecommend;

import javax.annotation.Resource;
import java.util.List;


/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2019/5/6 16:37
 * @Description:
 */
@Service
public class MatchUserRecommendImpl implements MatchUserRecommend {

    private static final Logger LOGGER = LoggerFactory.getLogger(MatchUserRecommendImpl.class);

    @Autowired
    private ThreadPoolTaskExecutor threadPool;
    @Autowired
    private HunterRecommend hunterRecommend;
    @Value("${HUNTER_RECOMMEND_NUM}")
    private Integer HUNTER_RECOMMEND_NUM;
    @Value("${HUNTER_RECOMMEND_BUFFER}")
    private String HUNTER_RECOMMEND_BUFFER;

    @Override
    public XslResult recommended(String positionId)throws RuntimeException{
        /**
         *
         * 功能描述: 异步获取推荐名单
         *
         * @param: [positionId]
         * @return: com.xsl.result.XslResult
         * @auther: 11432_000
         * @date: 2019/5/6 19:48
         */
        try {
            threadPool.execute(()->{getRecommendedList(positionId,HUNTER_RECOMMEND_NUM);});
            return ResultUtils.isOk();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    /** 获取推荐列表并存入缓存 */
    private void getRecommendedList(String positionId,Integer num){
        try {
            List<String> recommend = hunterRecommend.recommend(positionId, num);
            if (recommend.size() < num){
                List<String> list = hunterRecommend.recommend2(positionId, num);
                for (int i = recommend.size(); i < num; i++) {
                    recommend.add(i ,list.get(i - recommend.size()));
                }
            }
            String json = JsonUtils.objectToJson(recommend);
            JedisUtils.set(HUNTER_RECOMMEND_BUFFER + ":" + positionId,json);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
