package xsl.match.service.impl;

import com.xsl.Utils.JedisUtils;
import com.xsl.Utils.JsonUtils;
import com.xsl.Utils.ResultUtils;
import com.xsl.pojo.Vo.RecommendResVo;
import com.xsl.pojo.Vo.UserDetailedResVo;
import com.xsl.result.XslResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import xsl.match.service.HunterRecommend;
import xsl.match.service.MatchUserRecommend;
import xsl.match.service.XslUserService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


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
    /** 最小推荐人数 */
    private static final Integer MIN_RECOMMEND_NUM = 5;

    @Autowired
    private ThreadPoolTaskExecutor threadPool;
    @Autowired
    private HunterRecommend hunterRecommend;
    @Autowired
    private XslUserService xslUserService;
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
            return ResultUtils.ok();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    /** 获取推荐列表并存入缓存 */
    private void getRecommendedList(String positionId,Integer num){
        try {
            int size = 0;
            Set<String> recommends = new HashSet<>();
            //第一方案
            List<String> recommend = hunterRecommend.recommend(positionId, num);
            recommends.addAll(recommend);
            size = recommends.size();
            if (size < num){
                //第二方案
                List<String> list = hunterRecommend.recommend2(positionId, num);
                recommends.addAll(list);
                size = recommends.size();
                if (size < num){
                    //第三方案
                    List<String> lastCandidates = hunterRecommend.recommend3(positionId);
                    recommends.addAll(lastCandidates);
                    size = recommends.size();
                }
            }
            /** 最终方案 */
            if (size < MIN_RECOMMEND_NUM){
                List<String> finaPlan = hunterRecommend.finaPlan(positionId);
               recommends.addAll(finaPlan);
            }
            ArrayList<RecommendResVo> recommendResVos = new ArrayList<>();
            for (String hunterId : recommends){
                //添加用户信息
                UserDetailedResVo userDetailedInfo = xslUserService.getUserDetailedInfo(hunterId);
                RecommendResVo xslApplyResVo = new RecommendResVo();
                BeanUtils.copyProperties(userDetailedInfo,xslApplyResVo);
                recommendResVos.add(xslApplyResVo);
            }

            String json = JsonUtils.objectToJson(recommendResVos);
            JedisUtils.set(HUNTER_RECOMMEND_BUFFER + ":" + positionId,json);
            //设置推荐列表保存三天
            JedisUtils.expire(HUNTER_RECOMMEND_BUFFER + ":" + positionId,60*60*24*3);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
