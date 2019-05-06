package xsl.match.service.impl;

import com.xsl.Utils.JedisUtils;
import com.xsl.Utils.JsonUtils;
import com.xsl.enums.DataStates;
import com.xsl.pojo.*;
import com.xsl.pojo.Example.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import xsl.match.mapper.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 说明：服务器启动时执行
 *
 * @Auther: 11432_000
 * @Date: 2019/4/28 14:36
 * @Description:
 */
public class InitService {

    private static final Logger LOGGER = LoggerFactory.getLogger(InitService.class);

    @Autowired
    XslMatchMapper xslMatchMapper;
    @Autowired
    XslSchoolMapper xslSchoolMapper;
    @Autowired
    BufferService bufferService;
    @Autowired
    XslTaskTagMapper xslTaskTagMapper;
    @Autowired
    XslHunterTagMapper xslHunterTagMapper;

    @Value("MATCH_INFO")
    private String MATCH_INFO;
    @Value("${USER_SCHOOL_LIST}")
    private String USER_SCHOOL_LIST;
    @Value("${USER_SCHOOL_INFO}")
    private String USER_SCHOOL_INFO;
    @Value("${USER_SCHOOL_REGION}")
    private String USER_SCHOOL_REGION;
    @Value("${MATCH_LIST}")
    private String MATCH_LIST;
    @Value("${HUNTER_TAG_BUFFER}")
    private String HUNTER_TAG_BUFFER;
    @Value("${POSITION_TAG_BUFFER}")
    private String POSITION_TAG_BUFFER;

    public void init(){
        addMatchToInfo();
        addSchoolToBuffer();
        addPositionTag();
        addHunterTag();
    }

    /** 添加比赛信息到缓存 */
    public void addMatchToInfo(){
        List<XslMatch> list = null;
        try {
            XslMatchExample xslMatchExample = new XslMatchExample();
            XslMatchExample.Criteria criteria = xslMatchExample.createCriteria();
            criteria.andMatchstateNotEqualTo(DataStates.DELETE.getCode());
            list = xslMatchMapper.selectByExample(xslMatchExample);
            //添加单个比赛
            for (XslMatch xslMatch : list){
                JedisUtils.set(MATCH_INFO + ":" + xslMatch.getMatchid(), JsonUtils.objectToJson(xslMatch));
            }
            bufferService.addMatchRankClassification(list);
            bufferService.addMatchTypeClassification(list);
            bufferService.addMatchStateClassification(list);
            //添加比赛列表缓存
            String json = JsonUtils.objectToJson(list);
            JedisUtils.set(MATCH_LIST,json);

            LOGGER.info("添加比赛缓存---成功");
        } catch (Exception e) {
            LOGGER.error("添加比赛缓存---失败");
            throw new RuntimeException(e.getMessage());
        }
    }
    /** 添加学校信息到缓存(按地区分类) */
    public boolean addSchoolToBuffer(){
        try {
            HashMap<String,ArrayList<XslSchool>> schoolClassification = new HashMap();
            ArrayList<String> regionList = new ArrayList<>();
            XslSchoolExample xslSchoolExample = new XslSchoolExample();

            List<XslSchool> xslSchools = xslSchoolMapper.selectByExample(xslSchoolExample);
            for (XslSchool xslSchool : xslSchools){
                if(schoolClassification.containsKey(xslSchool.getProvince())){
                    schoolClassification.get(xslSchool.getProvince()).add(xslSchool);
                }else {
                    ArrayList<XslSchool> list = new ArrayList<>();
                    list.add(xslSchool);
                    schoolClassification.put(xslSchool.getProvince(),list);
                    regionList.add(xslSchool.getProvince());
                }
            }
            for (Map.Entry<String,ArrayList<XslSchool>> entry : schoolClassification.entrySet()){
                ArrayList<XslSchool> value = entry.getValue();
                String json = JsonUtils.objectToJson(value);
                JedisUtils.set(USER_SCHOOL_LIST + ":" + entry.getKey(),json);
            }
            String regionListJson = JsonUtils.objectToJson(regionList);
            JedisUtils.set(USER_SCHOOL_REGION,regionListJson);
            LOGGER.info("添加学校缓存---成功");
            return true;
        } catch (Exception e) {
            LOGGER.error("添加学校缓存---失败");
            throw new RuntimeException(e.getMessage());
        }
    }
    /** 添加职位标签缓存 */
    public void addPositionTag(){
        try {
            XslTaskTagExample xslTaskTagExample = new XslTaskTagExample();
            xslTaskTagExample.createCriteria().andStateEqualTo(true);
            List<XslTaskTag> xslTaskTags = xslTaskTagMapper.selectByExample(xslTaskTagExample);
            HashMap<String,ArrayList<XslTaskTag>> map =  new HashMap<>();
            for (XslTaskTag xslTaskTag : xslTaskTags){
                if (map.containsKey(xslTaskTag.getTaskid())){
                    map.get(xslTaskTag.getTaskid()).add(xslTaskTag);
                }else {
                    ArrayList<XslTaskTag> list = new ArrayList<>();
                    list.add(xslTaskTag);
                    map.put(xslTaskTag.getTaskid(),list);
                }
            }
            for (Map.Entry<String,ArrayList<XslTaskTag>> entry : map.entrySet()){
                String json = JsonUtils.objectToJson(entry.getValue());
                JedisUtils.set(POSITION_TAG_BUFFER + ":" + entry.getKey(),json);
            }
            LOGGER.info("添加职位标签缓存 成功");
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    /** 添加用户标签缓存 */
    public void addHunterTag(){
        try {
            XslHunterTagExample xslHunterTagExample = new XslHunterTagExample();
            xslHunterTagExample.createCriteria().andStateEqualTo(true);
            List<XslHunterTag> xslHunterTags = xslHunterTagMapper.selectByExample(xslHunterTagExample);
            HashMap<String,ArrayList<XslHunterTag>> map =  new HashMap<>();
            for (XslHunterTag xslHunterTag : xslHunterTags){
                if (map.containsKey(xslHunterTag.getHunterid())){
                    map.get(xslHunterTag.getHunterid()).add(xslHunterTag);
                }else {
                    ArrayList<XslHunterTag> list = new ArrayList<>();
                    list.add(xslHunterTag);
                    map.put(xslHunterTag.getHunterid(),list);
                }
            }
            for (Map.Entry<String,ArrayList<XslHunterTag>> entry : map.entrySet()){
                String json = JsonUtils.objectToJson(entry.getValue());
                JedisUtils.set(HUNTER_TAG_BUFFER + ":" + entry.getKey(),json);
            }
            LOGGER.info("添加用户标签缓存 成功");
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
