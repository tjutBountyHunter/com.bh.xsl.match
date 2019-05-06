package xsl.match.service;

import com.xsl.result.XslResult;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2019/5/6 16:42
 * @Description:
 */
public interface MatchUserRecommend {

    /** 获取推荐名单 */
    XslResult recommended(String positionId)throws RuntimeException;
}
