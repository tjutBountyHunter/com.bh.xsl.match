package xsl.match.service.impl;

import com.xsl.Utils.ResultUtils;
import com.xsl.pojo.*;
import com.xsl.pojo.Example.XslHunterTagExample;
import com.xsl.pojo.Example.XslMatchUserExample;
import com.xsl.result.XslResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xsl.match.mapper.XslHunterTagMapper;
import xsl.match.mapper.XslMatchUserMapper;
import xsl.match.service.*;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
/**
 *
 * 功能描述: 推荐算法（职位标签最多4个，用户标签最多12个）
 *
 * @param:
 * @return:
 * @auther: 11432_000
 * @date: 2019/5/8 13:44
 */
@Service
public class HunterRecommendImpl implements HunterRecommend {

    private static final Logger LOGGER = LoggerFactory.getLogger(HunterRecommendImpl.class);

    @Autowired
    private XslPositionTagService xslPositionTagService;

    @Autowired
    private XslHunterTagMapper xslHunterTagMapper;

    @Autowired
    private XslMatchUserMapper xslMatchUserMapper;

    @Autowired
    private XslPositionService xslPositionService;

    @Autowired
    private XslMatchTeamService xslMatchTeamService;

    @Autowired
    private XslMatchUserService xslMatchUserService;

    @Autowired
    private XslMatchService xslMatchService;

    private String taskId;

    //    带有的标签集
    private List<String> taskTags;
    //    相关的猎人
    private HashSet<String> hunters;
    //    相关的任务
    private HashSet<String> tasks;

    //    特征属性map
    private HashMap<String,Double> attributeMap;
    private double attributeCount;
    //    频率map
    private HashMap<String,Double> frequencyMap;
    private double frequencyCount;
    //    相似度map
    private HashMap<String,Double> similarityMap;
    private double similarityCount;

    //    topN猎人
    private TreeMap<Double,String> topMap;


    //    调用
    @Override
    public  List<String> recommend(String taskId, Integer recommendNum){
        this.taskId = taskId;

        taskTags = new LinkedList<>();  //78 tag 17 18 19 20

        hunters = new HashSet<>();
        tasks = new HashSet<>();
        attributeMap = new HashMap<>();
        frequencyMap = new HashMap<>();
        similarityMap = new HashMap<>();
        topMap = new TreeMap<>();

        getAllTaskTag();
        getAllHuntersByTag();
        countFrequency();
        countSimilarity();
        countAttribute();
        getTopN();
        Map<Integer, List<String>> screen = screen();

        ArrayList<String> strings = new ArrayList<>();
        List<String> list = screen.get(1);
        List<String> list1 = screen.get(2);
        int x,y;
        x = 0; y= 0;
        //将类型相同和不相同的按4:1进行推荐
        for (int i = 1; i <= recommendNum; i++) {
            if (i % 4 != 0 && x < list.size()){
                strings.add(list.get(x));
                x ++;
            }else if (y < list1.size()){
                strings.add(list1.get(y));
                y ++;
            }
        }
        return strings;
    }

    //    获取任务带有的所有标签
    private void getAllTaskTag(){
        List<XslTaskTag> tagsByTaskId = xslPositionTagService.getAllTagByPositionId(taskId);
        for (XslTaskTag xslTaskTag : tagsByTaskId) {
            taskTags.add(xslTaskTag.getTagid());
        }
    }

    //    通过任务的标签id，获取所有相关的猎人集和任务集
    private void getAllHuntersByTag(){
        for (String taskTag : taskTags) {
            List<XslHunterTag> huntersByTag = xslMatchUserService.getAllHuntersByTagId(taskTag);
            for (XslHunterTag xslHunterTag : huntersByTag) {
                hunters.add(xslHunterTag.getHunterid());
            }
            List<XslTaskTag> tasksByTag = xslPositionTagService.getAllPositionByTagId(taskTag);
            for (XslTaskTag xslTaskTag : tasksByTag) {
                tasks.add(xslTaskTag.getTaskid());
            }
        }
    }

    //    遍历猎人集，获取每个猎人在任务集中出现的频率，总频率
    private void countFrequency(){
        for (String hunterId : hunters) {
            double fre = 0.0;
            for (String taskId : tasks) {
                if (compareFrequency(hunterId,taskId)){
                    fre += 1.0;
                }

            }
            frequencyMap.put(hunterId,fre);
            frequencyCount += fre;
        }
    }

    //    比较猎人和任务标签
    private boolean compareFrequency(String hunterId,String taskId){
        List<XslHunterTag> tagsByHunterId = xslMatchUserService.getAllTagsByHunterId(hunterId);
        List<XslTaskTag> tagsByTaskId = xslPositionTagService.getAllTagByPositionId(taskId);
        for (XslTaskTag taskTag : tagsByTaskId) {
            String taskTagId = taskTag.getTagid();
            for (XslHunterTag hunterTag : tagsByHunterId) {
                String hunterTagId = hunterTag.getTagid();
                if (taskTagId.equals(hunterTagId)){
                    return true;
                }
            }
        }
        return false;
    }

    //    遍历猎人集，计算每个猎人在猎人集中的相似度，总相似度
    private void countSimilarity(){
        for (String hunterId : hunters) {
            double sim = computeSimilarity(hunterId,hunters);
            similarityMap.put(hunterId,sim);
            similarityCount += sim;
        }
    }

    //    计算猎人与其他猎人的相似度
    private double computeSimilarity(String hunter1, HashSet<String> hunters) {
        double sim = 0.0;
        for (String hunter2 : hunters) {
            if (hunter1.equals(hunter2)){
                continue;
            }

            HashSet<String> all = new HashSet<>();

            HashSet<String> hun1Set = new HashSet<>();
            HashSet<String> hun2Set = new HashSet<>();

            List<XslHunterTag> tagsByHunter1 = xslMatchUserService.getAllTagsByHunterId(hunter1);
            for (XslHunterTag xslHunterTag : tagsByHunter1) {
                hun1Set.add(xslHunterTag.getTagid());
            }
            List<XslHunterTag> tagsByHunter2 = xslMatchUserService.getAllTagsByHunterId(hunter2);
            for (XslHunterTag xslHunterTag : tagsByHunter2) {
                hun2Set.add(xslHunterTag.getTagid());
            }

            all.addAll(hun1Set);
            all.addAll(hun2Set);

            double hun1Avg = (double)hun1Set.size()/all.size();
            double hun2Avg = (double)hun2Set.size()/all.size();

            double deno = 0;
            double mole1 = 0;
            double mole2 = 0;

            for (String tagId : all) {
                double hun1 = hun1Set.contains(tagId)?1:0;
                double hun2 = hun2Set.contains(tagId)?1:0;

                deno += (hun1-hun1Avg)*(hun2-hun2Avg);
                mole1 += (hun1-hun1Avg)*(hun1-hun1Avg);
                mole2 += (hun2-hun2Avg)*(hun2-hun2Avg);
            }

            sim += deno/Math.sqrt(mole1*mole2);
        }
        return sim;
    }

    //        遍历猎人集，计算特征属性
    private void countAttribute(){
        int maxLevel = xslMatchUserMapper.selectMaxLevel();
        int maxTaskDoneNum = xslMatchUserMapper.selectMaxTaskAccNum();
        for (String hunterId : hunters) {
            XslMatchUser xslHunter = xslMatchUserMapper.selectHunterByHunterId(hunterId);
            double attr = (double)xslHunter.getLevel()/maxLevel + (double)xslHunter.getTaskaccnum()/maxTaskDoneNum + (double)xslHunter.getCredit()/100;
            attributeMap.put(hunterId,attr);
            attributeCount += attr;
        }
    }

    //    选出topN的猎人
    private void getTopN(){
        for (String hunterId : hunters) {
            double res = 0.4*frequencyMap.get(hunterId)/frequencyCount;
            res += 0.6*similarityMap.get(hunterId)/similarityCount;
            res += attributeMap.get(hunterId)/attributeCount;
            topMap.put(res,hunterId);
        }
    }

    /** 区分有偏和无偏好 并筛除无被推荐意向的人 */
    public Map<Integer,List<String>> screen(){

        XslMatchUserExample xslMatchUserExample = new XslMatchUserExample();
        XslMatchUserExample.Criteria criteria = xslMatchUserExample.createCriteria();
        List<String> identical = new ArrayList<>(topMap.size());
        List<String> different = new ArrayList<>(topMap.size());
        XslMatch match = getMatch(this.taskId);

        //筛选有参赛意向的且偏好为同一类型的人
        for (int i = 0; topMap.size() >0 ; i++) {
            String hunterId = topMap.pollLastEntry().getValue();
            XslMatchUser xslMatchUser = xslMatchUserService.selectMatchUserInfoByHunterId(hunterId);
            if (!xslMatchUser.getIsrecommend()){
                continue;
            }
            if (xslMatchUser.getMatchtypeid().equals(match.getMatchtypeid())){
                identical.add(hunterId);
            }else {
                different.add(hunterId);
            }
        }
        HashMap<Integer,List<String>> map = new HashMap<>();
        map.put(1,identical);
        map.put(2,different);
        return map;
    }

    /** 获取比赛信息 */
    public XslMatch getMatch(String taskId){
        XslTeamPosition data = xslPositionService.getPositionByPositionId(taskId);
        XslMatchTeam xslMatchTeam = xslMatchTeamService.selectTeamByTeamId(data.getTeamid());
        XslMatch xslMatch = xslMatchService.selectMatchByMatchId(xslMatchTeam.getMatchid());
        return xslMatch;
    }

    /** ----------------------------------------------------------- 推荐算法2 -------------------------------------------------------- */
    @Override
    public List<String> recommend2(String taskId, Integer recommendNum) {
        ArrayList<String> taglist = new ArrayList<>();
        //获取所有 职位の标签
        List<XslTaskTag> xslTaskTags = xslPositionTagService.getAllTagByPositionId(taskId);
        for (int i = 0; i < 4 && i < xslTaskTags.size(); i++) {
            taglist.add(xslTaskTags.get(i).getTagid());
        }
        Map<Integer, List<String>> intersection = getIntersection(taglist);
        ArrayList<String> users = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            users.addAll(intersection.get(i));
        }
        ArrayList<String> recommend = new ArrayList<>();
        List<String> users2 = intersection.get(5);
        int x,y;
        x = 0;y = 0;
        //将类型相同和不相同的按4:1进行推荐
        for (int i = 1; i <= recommendNum ; i++) {
            if (i % 5 != 0 && x < users.size()){
                recommend.add(users.get(x++));
            }else if (y < users2.size()){
                recommend.add(users2.get(y));
            }
        }
        return recommend;
    }

    /** 获取分别持有1,2,3,4个相同标签且有被推荐意向的用户列表 */
    public Map<Integer,List<String>> getIntersection(List<String> tagIds){
        //获取包含标签之一的所有用户
        XslHunterTagExample xslHunterTagExample = new XslHunterTagExample();
        xslHunterTagExample.createCriteria().andTagidIn(tagIds).andStateNotEqualTo(false);
        List<XslHunterTag> xslHunterTags = xslHunterTagMapper.selectByExample(xslHunterTagExample);
        //统计每个用户符合的标签的数量
        Map<String,Integer> statistics = new ConcurrentHashMap<>(xslHunterTags.size());
        for (XslHunterTag xslHunterTag : xslHunterTags){
            if (statistics.containsKey(xslHunterTag.getHunterid())){
                Integer integer = statistics.get(xslHunterTag.getHunterid());
                statistics.put(xslHunterTag.getHunterid(),integer + 1);
            }else {
                statistics.put(xslHunterTag.getHunterid(),1);
            }
        }
        //分别获取符合1,2,3,4个标签得用户的列表
        Map<Integer,List<String>> top = new HashMap<>(5);
        //初始化
        for (int i = 1; i <= 5; i++) {
            top.put(i,new ArrayList<String>());
        }
        //获取比赛类型
        XslMatch match = getMatch(taskId);
        for (Map.Entry<String,Integer> entry : statistics.entrySet()){
            //检查是否有被推荐意向
            XslMatchUser xslMatchUser = xslMatchUserService.selectMatchUserInfoByHunterId(entry.getKey());
            if (!xslMatchUser.getIsrecommend()){
                continue;
            }
            //将偏好类型不同的人放在 5 中（至少符合两个标签）
            if (entry.getValue() < 5){
                if (entry.getValue() >= 2 && !xslMatchUser.getMatchtypeid().equals(match.getMatchtypeid())){
                    top.get(5).add(entry.getKey());
                }else {
                    top.get(entry.getValue()).add(entry.getKey());
                }
            }
        }
        return top;
    }

}
