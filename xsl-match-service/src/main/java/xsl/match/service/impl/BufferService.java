package xsl.match.service.impl;

import com.xsl.Utils.JedisUtils;
import com.xsl.Utils.JsonUtils;
import com.xsl.pojo.XslMatch;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2019/5/5 15:20
 * @Description:
 */
@Component
public class BufferService {

    @Value("${MATCH_LIST_BY_TYPE}")
    private String MATCH_LIST_BY_TYPE;
    @Value("${MATCH_LIST_BY_RANK}")
    private String MATCH_LIST_BY_RANK;
    @Value("${MATCH_LIST_BY_STATE}")
    private String MATCH_LIST_BY_STATE;
    /** 添加比赛类型分类 */
    public void addMatchTypeClassification(List<XslMatch> list){
        try {
            HashMap<String, ArrayList<XslMatch>> byType = new HashMap<>();
            for (XslMatch xslMatch : list){
                if (byType.containsKey(xslMatch.getMatchtypeid())){
                    byType.get(xslMatch.getMatchtypeid()).add(xslMatch);
                }else {
                    ArrayList<XslMatch> xslMatches = new ArrayList<>();
                    xslMatches.add(xslMatch);
                    byType.put(xslMatch.getMatchtypeid(),xslMatches);
                }
            }
            for (Map.Entry<String,ArrayList<XslMatch>> entry : byType.entrySet()){
                String json = JsonUtils.objectToJson(entry.getValue());
                JedisUtils.set(MATCH_LIST_BY_TYPE + ":" + entry.getKey(),json);
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    /** 添加比赛等级分类 */
    public void addMatchRankClassification(List<XslMatch> list){
        try {
            HashMap<String, ArrayList<XslMatch>> byRank = new HashMap<>();
            for (XslMatch xslMatch : list){
                if (byRank.containsKey(xslMatch.getMatchrankid())){
                    byRank.get(xslMatch.getMatchrankid()).add(xslMatch);
                }else {
                    ArrayList<XslMatch> xslMatches = new ArrayList<>();
                    xslMatches.add(xslMatch);
                    byRank.put(xslMatch.getMatchrankid(),xslMatches);
                }
            }
            for (Map.Entry<String,ArrayList<XslMatch>> entry : byRank.entrySet()){
                String json = JsonUtils.objectToJson(entry.getValue());
                JedisUtils.set(MATCH_LIST_BY_RANK + ":" + entry.getKey(),json);
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    /** 添加比赛状态分类 */
    public void addMatchStateClassification(List<XslMatch> list){
        try {
            HashMap<Integer, ArrayList<XslMatch>> byState = new HashMap<>();
            for (XslMatch xslMatch : list){
                if (byState.containsKey(xslMatch.getMatchstate())){
                    byState.get(xslMatch.getMatchstate()).add(xslMatch);
                }else {
                    ArrayList<XslMatch> xslMatches = new ArrayList<>();
                    xslMatches.add(xslMatch);
                    byState.put(xslMatch.getMatchstate(),xslMatches);
                }
            }
            for (Map.Entry<Integer,ArrayList<XslMatch>> entry : byState.entrySet()){
                String json = JsonUtils.objectToJson(entry.getValue());
                JedisUtils.set(MATCH_LIST_BY_STATE + ":" + entry.getKey(),json);
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    /** 更新比赛类型分类 */
    public void updateMatchTypeClassification(List<XslMatch> list,String typeId){
        try {
            ArrayList<XslMatch> xslMatches = new ArrayList<>();
            for (XslMatch xslMatch : list){
                if (typeId.equals(xslMatch.getMatchtypeid())){
                    xslMatches.add(xslMatch);
                }
            }
            String json = JsonUtils.objectToJson(xslMatches);
            JedisUtils.set(MATCH_LIST_BY_TYPE + ":" + typeId,json);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    /** 更新比赛等级分类 */
    public void updateMatchRankClassification(List<XslMatch> list,String rankId){
        try {
            ArrayList<XslMatch> xslMatches = new ArrayList<>();
            for (XslMatch xslMatch : list){
                if (rankId.equals(xslMatch.getMatchrankid())){
                    xslMatches.add(xslMatch);
                }
            }
            String json = JsonUtils.objectToJson(xslMatches);
            JedisUtils.set(MATCH_LIST_BY_TYPE + ":" + rankId,json);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    /** 更新比赛状态分类 */
    public void updateMatchStateClassification(List<XslMatch> list,Integer state){
        try {
            ArrayList<XslMatch> xslMatches = new ArrayList<>();
            for (XslMatch xslMatch : list){
                if (state.equals(xslMatch.getMatchstate())){
                    xslMatches.add(xslMatch);
                }
            }
            String json = JsonUtils.objectToJson(xslMatches);
            JedisUtils.set(MATCH_LIST_BY_TYPE + ":" + state,json);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
