package xsl.match.service.impl;

import com.xsl.Utils.ResultUtils;
import com.xsl.enums.MatchState;
import com.xsl.pojo.XslMatch;
import com.xsl.result.XslResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import xsl.match.service.XslMatchService;

import java.util.Date;
import java.util.List;

/**
 * 说明：定时任务
 *
 * @Auther: 11432_000
 * @Date: 2019/5/8 17:43
 * @Description:
 */
public class MatchQuartzTask {
    private static final Logger LOGGER = LoggerFactory.getLogger(MatchQuartzTask.class);

    @Autowired
    XslMatchService xslMatchService;
    @Autowired
    ThreadPoolTaskExecutor threadPoolTaskExecutor;


    public void execut(){
        LOGGER.info("定时任务开始");
        threadPoolTaskExecutor.execute(()->{updateMatchState();});
    }

    public void updateMatchState(){
        List<XslMatch> matchList = xslMatchService.getMatchList();
        Date now = new Date(System.currentTimeMillis());
        XslMatch newMatch = new XslMatch();
        //更新所有比赛状态
        for (XslMatch xslMatch : matchList){
            MatchState state = getState(xslMatch, now);
            if (state != null){
                newMatch.setMatchid(xslMatch.getMatchid());
                newMatch.setMatchstate(state.getKey());
                XslResult xslResult = xslMatchService.updateMatch(newMatch);
                if (!ResultUtils.isSuccess(xslResult)){
                    LOGGER.error("更新比赛" + xslMatch.getMatchid() + "失败！");
                }
            }
        }
    }

    /** 获取当前比赛应有的状态 */
    public MatchState getState(XslMatch xslMatch,Date now){
        if (xslMatch.getMatchstate().equals(MatchState.DELETE.getKey()) || xslMatch.getMatchstate().equals(MatchState.MATCH_END.getKey())){
            return null;
        }
        if (xslMatch.getMatchsignupstarttime().after(now)){
            return MatchState.BEFORE_SIGN_UP;
        }
        if (xslMatch.getMatchsignupendtime().after(now)){
            return MatchState.SIGN_UP;
        }
        if (xslMatch.getMatchstarttime().after(now)){
            return MatchState.SIGN_UP_END;
        }
        if (xslMatch.getMatchendtime().after(now)){
            return MatchState.MATCH_START;
        }
        return MatchState.MATCH_END;
    }
}
