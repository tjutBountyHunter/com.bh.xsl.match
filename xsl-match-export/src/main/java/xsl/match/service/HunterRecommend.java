package xsl.match.service;

import java.util.ArrayList;
import java.util.List;

public interface HunterRecommend {

    /**
     * 猎人推荐
     *
     * @param taskId
     * @return 猎人id数组
     */
    List<String> recommend(String taskId, Integer recommendNum);

    /** 第二方案，根据标签和类型匹配*/
    List<String> recommend2(String taskId, Integer recommendNum);

    /** 第三方案 根据类型匹配*/
    List<String> recommend3(String positionId)throws RuntimeException;

    /** 最终方案 根据完成数匹配 */
    List<String> finaPlan(String positionId)throws RuntimeException;
}
