package xsl.match.service.impl;

import com.xsl.Utils.ResultUtils;
import com.xsl.pojo.*;
import com.xsl.pojo.Example.XslMatchUserExample;
import com.xsl.pojo.Example.XslTaskTagExample;
import com.xsl.result.XslResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xsl.match.mapper.XslHunterTagMapper;
import xsl.match.mapper.XslMatchUserMapper;
import xsl.match.mapper.XslTaskTagMapper;
import xsl.match.service.HunterRecommend;
import xsl.match.service.XslMatchService;
import xsl.match.service.XslMatchTeamService;
import xsl.match.service.XslPositionService;

import java.util.*;

@Service
public class HunterRecommendImpl implements HunterRecommend {

    @Autowired
    XslTaskTagMapper xslTaskTagMapper;

    @Autowired
    XslHunterTagMapper xslHunterTagMapper;

    @Autowired
    XslMatchUserMapper xslMatchUserMapper;

    @Autowired
    XslPositionService xslPositionService;

    @Autowired
    XslMatchTeamService xslMatchTeamService;

    @Autowired
    XslMatchService xslMatchService;

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
        for (int i = 0; i < recommendNum; i++) {
            if (i % 5 != 0 && x < list.size()){
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
        List<XslTaskTag> tagsByTaskId = xslTaskTagMapper.getTagsByTaskId(taskId);
        for (XslTaskTag xslTaskTag : tagsByTaskId) {
            taskTags.add(xslTaskTag.getTagid());
        }
    }

    //    通过任务的标签id，获取所有相关的猎人集和任务集
    private void getAllHuntersByTag(){
        for (String taskTag : taskTags) {
            List<XslHunterTag> huntersByTag = xslHunterTagMapper.getHuntersByTagId(taskTag);
            for (XslHunterTag xslHunterTag : huntersByTag) {
                hunters.add(xslHunterTag.getHunterid());
            }

            List<XslTaskTag> tasksByTag = xslTaskTagMapper.getTasksByTagId(taskTag);
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
        List<XslHunterTag> tagsByHunterId = xslHunterTagMapper.getTagsByHunterId(hunterId);
        List<XslTaskTag> tagsByTaskId = xslTaskTagMapper.getTagsByTaskId(taskId);
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

            List<XslHunterTag> tagsByHunter1 = xslHunterTagMapper.getTagsByHunterId(hunter1);
            for (XslHunterTag xslHunterTag : tagsByHunter1) {
                hun1Set.add(xslHunterTag.getTagid());
            }
            List<XslHunterTag> tagsByHunter2 = xslHunterTagMapper.getTagsByHunterId(hunter2);
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
        XslMatch match = getMatch();

        //筛选有参赛意向的且偏好为同一类型的人
        for (int i = 0; topMap.size() >0 ; i++) {
            String hunterId = topMap.pollLastEntry().getValue();
            xslMatchUserExample.clear();
            criteria.andHunteridEqualTo(hunterId);
            List<XslMatchUser> xslMatchUsers = xslMatchUserMapper.selectByExample(xslMatchUserExample);
            if (xslMatchUsers.size() == 0){
                continue;
            }
            XslMatchUser xslMatchUser = xslMatchUsers.get(0);
            if (xslMatchUser.getMatchtypeid().equals(match.getMatchtypeid()) && xslMatchUser.getIsrecommend()){
                identical.add(hunterId);
            }else if (xslMatchUser.getIsrecommend()){
                different.add(hunterId);
            }
        }
        HashMap<Integer,List<String>> map = new HashMap<>();
        map.put(1,identical);
        map.put(2,different);
        return map;
    }

    /** 获取比赛信息 */
    public XslMatch getMatch(){
        XslResult positionByPositionId = xslPositionService.getPositionByPositionId(this.taskId);
        if (!ResultUtils.isSuccess(positionByPositionId)){
            return new XslMatch();
        }
        XslTeamPosition data = (XslTeamPosition) positionByPositionId.getData();
        XslResult xslResult = xslMatchTeamService.selectTeamByTeamId(data.getTeamid());
        if (!ResultUtils.isSuccess(xslResult)){
            return new XslMatch();
        }
        XslMatchTeam data1 = (XslMatchTeam) xslResult.getData();
        XslResult matchInfoByMatchId = xslMatchService.selectMatchInfoByMatchId(data1.getMatchid());
        if (!ResultUtils.isSuccess(matchInfoByMatchId)){
            return new XslMatch();
        }
        return (XslMatch) matchInfoByMatchId.getData();
    }

    /** ----------------------------------------------------------- 推荐算法2 -------------------------------------------------------- */
    @Override
    public List<String> recommend2(String taskId, Integer recommendNum) {
        //获取所有 职位 标签
        XslTaskTagExample xslTaskTagExample = new XslTaskTagExample();
        xslTaskTagExample.createCriteria().andTaskidEqualTo(taskId);
        List<XslTaskTag> xslTaskTags = xslTaskTagMapper.selectByExample(xslTaskTagExample);

        return null;
    }
}
