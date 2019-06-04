package xsl.match.advice;

import com.xsl.Utils.JedisUtils;
import com.xsl.Utils.JsonUtils;
import com.xsl.enums.DataStatesEnum;
import com.xsl.enums.ResultCodeEnum;
import com.xsl.pojo.XslMatch;
import com.xsl.pojo.Example.XslMatchExample;
import com.xsl.result.XslResult;
import com.xsl.search.export.vo.MatchSearchVo;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;
import xsl.match.mapper.XslMatchMapper;
import xsl.match.service.GxzdESService;
import xsl.match.service.XslMatchService;
import xsl.match.service.impl.BufferService;

import java.util.*;

/**
 * 说明：更新比赛数据的切面
 *
 * @Auther: 11432_000
 * @Date: 2019/4/28 09:49
 * @Description:
 */
@Aspect
@Component
public class UpdateMatchBuffer {

    private static final Logger LOGGER = LoggerFactory.getLogger(UpdateMatchBuffer.class);

    @Autowired
    private XslMatchMapper xslMatchMapper;
    @Autowired
    private XslMatchService xslMatchService;
    @Autowired
    private BufferService bufferService;
    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;
    @Autowired
    private GxzdESService gxzdESService;

    @Value("${MATCH_INFO}")
    private String MATCH_BUFFER_PREFIX;
    @Value("${MATCH_LIST}")
    private String MATCH_LIST;
    @Value("${MATCH_DETAILS}")
    private String MATCH_DETAILS;

    @AfterReturning(pointcut = "@annotation(com.xsl.annotation.UpdateMatch) && execution(* xsl.match.service.impl.XslMatchServiceImpl.*(..))" ,returning = "xslResult")
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
        String matchId = (String) xslResult.getData();
        threadPoolTaskExecutor.execute(()->{
            update(xslResult,matchId);
        });
    }

    private void update(XslResult xslResult,String arg){
        if (!xslResult.getCode().equals(ResultCodeEnum.SUCCESS.getCode())){
            return;
        }
        if (xslResult.getData() != null){
            XslMatchExample xslMatchExample = new XslMatchExample();
            XslMatchExample.Criteria criteria = xslMatchExample.createCriteria();
            try {
                //更新比赛列表
                criteria.andMatchidEqualTo(arg);
                XslMatch xslMatch = xslMatchMapper.selectByExample(xslMatchExample).get(0);
                JedisUtils.set(MATCH_BUFFER_PREFIX +  ":" + xslMatch.getMatchid(), JsonUtils.objectToJson(xslMatch));
                updateMatch(xslMatch.getMatchtypeid(),xslMatch.getMatchrankid(),xslMatch.getMatchstate());
                //更新比赛详情
                xslMatchService.getMatchDetails(arg);
                //更新搜索库
                MatchSearchVo matchSearchVo = new MatchSearchVo();
                BeanUtils.copyProperties(xslMatch,matchSearchVo);
                boolean success = gxzdESService.addMatch(matchSearchVo);
                LOGGER.info("更新比赛缓存---成功");
            } catch (Exception e) {
                LOGGER.error("更新比赛缓存---失败");
                throw new RuntimeException(e.getMessage());
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
        List<String> matchIds = (List<String>)joinPoint.getArgs()[0];
        threadPoolTaskExecutor.execute(()->{
            delete(matchIds,xslResult);
        });
    }

    public void delete(List<String> matchIds,XslResult xslResult){
        if (!xslResult.getCode().equals(ResultCodeEnum.SUCCESS.getCode())){
            return;
        }
        //统计需要更新的分类
        Set<String> rank = new HashSet<>();
        Set<String> type = new HashSet<>();
        Set<Integer> state = new HashSet<>();
        try {
            for (String matchId : matchIds){
                String json = JedisUtils.get(MATCH_BUFFER_PREFIX + ":" + matchId);
                XslMatch xslMatch = JsonUtils.jsonToPojo(json, XslMatch.class);
                JedisUtils.delete(MATCH_BUFFER_PREFIX +  ":" + matchId);
                rank.add(xslMatch.getMatchrankid());
                type.add(xslMatch.getMatchtypeid());
                state.add(xslMatch.getMatchstate());
                //删除比赛详情
                JedisUtils.delete(MATCH_DETAILS + ":" + matchId);
                LOGGER.info("删除比赛缓存--"+ matchId +"成功");
                //删除搜索库
                boolean success = gxzdESService.removeMatch(matchId);
            }
            XslMatchExample xslMatchExample = new XslMatchExample();
            xslMatchExample.createCriteria().andMatchstateNotEqualTo(DataStatesEnum.DELETE.getCode());
            List<XslMatch> xslMatches = xslMatchMapper.selectByExample(xslMatchExample);
            for (String rankId : rank){
                bufferService.updateMatchRankClassification(xslMatches,rankId);
            }
            for (String typeId : type){
                bufferService.updateMatchTypeClassification(xslMatches,typeId);
            }
            for (Integer i : state){
                bufferService.updateMatchStateClassification(xslMatches,i);
            }
            String json = JsonUtils.objectToJson(xslMatches);
            JedisUtils.set(MATCH_LIST,json);
        } catch (Exception e) {
            LOGGER.error("删除比赛缓存---失败");
            throw new RuntimeException(e.getMessage());
        }
    }

    /** 更新分类和所有比赛 */
    public void updateMatch(String typeId,String rankId,Integer state){
        XslMatchExample xslMatchExample = new XslMatchExample();
        XslMatchExample.Criteria criteria = xslMatchExample.createCriteria();
        criteria.andMatchstateNotEqualTo(DataStatesEnum.DELETE.getCode());
        List<XslMatch> xslMatches = xslMatchMapper.selectByExample(xslMatchExample);
        bufferService.updateMatchRankClassification(xslMatches,rankId);
        bufferService.updateMatchStateClassification(xslMatches,state);
        bufferService.updateMatchTypeClassification(xslMatches,typeId);
        String json = JsonUtils.objectToJson(xslMatches);
        JedisUtils.set(MATCH_LIST,json);
    }

}
