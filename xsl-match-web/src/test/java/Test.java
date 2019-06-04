import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.xsl.Utils.GsonSingle;
import com.xsl.Utils.JedisUtils;
import com.xsl.Utils.JsonUtils;
import com.xsl.Utils.MatchArrayUtils;
import com.xsl.enums.PositionApplicationStatesEnum;
import com.xsl.pojo.*;
import com.xsl.pojo.Example.XslTagExample;
import com.xsl.pojo.Vo.*;
import com.xsl.result.XslResult;
import com.xsl.search.export.vo.MatchSearchVo;
import com.xsl.search.export.vo.MatchTeamSearchVo;
import com.xsl.search.export.vo.MatchUserSearchVo;
import com.xsl.user.vo.JPushReqVo;
import org.apache.activemq.ActiveMQQueueSession;
import org.apache.activemq.ActiveMQSession;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import xsl.match.mapper.XslTagMapper;
import xsl.match.service.*;
import xsl.match.service.impl.XslMatchServiceImpl;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.Session;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2019/4/21 20:14
 * @Description:
 */
//@RunWith(SpringJUnit4ClassRunner.class)//固定写法
//@ContextConfiguration({"classpath:spring/*.xml"})
public class Test {

//    @Autowired
//    XslMatchService xslMatchService;
//    @Autowired
//    XslMatchTeamService xslMatchTeamService;
//    @Autowired
//    XslUserService xslUserService;
//    @Autowired
//    GxzdESService gxzdESService;
//    @Value("${REDIS_USER_SESSION_KEY}")
//    private String REDIS_USER_SESSION_KEY;
//    @Autowired
//    private MyPush myPush;
////    @org.junit.Test
    public void test04(){
//        List<XslMatch> matchList = xslMatchService.getMatchList();
//        matchList.forEach(match ->{
//            MatchSearchVo matchResVo = new MatchSearchVo();
//            BeanUtils.copyProperties(match,matchResVo);
//            gxzdESService.addMatch(matchResVo);
//        });
//        List<XslMatchTeam> teamList = xslMatchTeamService.getTeamList();
//        teamList.forEach(team ->{
//            MatchTeamSearchVo matchResVo = new MatchTeamSearchVo();
//            BeanUtils.copyProperties(team,matchResVo);
//            XslMatch xslMatch = xslMatchService.selectMatchByMatchId(team.getMatchid());
//            matchResVo.setMatchname(xslMatch.getMatchname());
//            gxzdESService.addTeam(matchResVo);
//        });
//        List<XslUser> allUser = xslUserService.getAllUser();
//        allUser.forEach(user ->{
//            MatchUserSearchVo matchResVo = new MatchUserSearchVo();
//            UserDetailedResVo userDetailedInfo = xslUserService.getUserDetailedInfo(user.getUserid());
//            BeanUtils.copyProperties(userDetailedInfo,matchResVo);
//            gxzdESService.addUser(matchResVo);
//        });
//        List<MatchSearchVo> matchs = gxzdESService.searchMatch("测试", null, 10);
////        System.out.println();
//        List<MatchUserSearchVo> matchUserSearchVos = gxzdESService.searchUser("188", null, 10);
//        System.out.println();
    }
    @org.junit.Test
    public void test003(){
//        JedisUtils.set(REDIS_USER_SESSION_KEY + ":" + "18222905538","13065ffa4e5470861ee");
//        JPushReqVo jPushReqVo = new JPushReqVo();
//        jPushReqVo.setPhone("18222905538");
//        jPushReqVo.setMsgTitle("测试标题");
//        jPushReqVo.setMsgContent("测试主体");
//        jPushReqVo.setNotificationTitle("测试内容标题");
//        jPushReqVo.setExtrasparam("测试扩展");
//        XslResult xslResult = myPush.sendPushByPhone(jPushReqVo);
//        System.out.println();

        /** 正则 */
//        Pattern compile = Pattern.compile("^1[3|4|5|7|8][0-9]{9}$");
//        Matcher matcher = compile.matcher("1522235009");
//        System.out.println(matcher.matches());
//        System.out.println("15222355009".matches("^1[3|4|5|7|8][0-9]{9}$"));
    }
    //    @org.junit.Test
//    public void test(){
//        String str = "xsl_collecth\n" +
//                "xsl_collectt\n" +
//                "xsl_college\n" +
//                "xsl_datetime\n" +
//                "xsl_file\n" +
//                "xsl_group_rule\n" +
//                "xsl_historyh\n" +
//                "xsl_hunter\n" +
//                "xsl_hunter_level\n" +
//                "xsl_hunter_level_experience\n" +
//                "xsl_hunter_level_privilege\n" +
//                "xsl_hunter_level_rule\n" +
//                "xsl_hunter_tag\n" +
//                "xsl_hunter_task\n" +
//                "xsl_input_bill\n" +
//                "xsl_log\n" +
//                "xsl_major\n" +
//                "xsl_manager\n" +
//                "xsl_manager_role\n" +
//                "xsl_master\n" +
//                "xsl_master_level\n" +
//                "xsl_master_level_experience\n" +
//                "xsl_master_level_privilege\n" +
//                "xsl_master_level_rule\n" +
//                "xsl_master_tag\n" +
//                "xsl_match\n" +
//                "xsl_match_rank\n" +
//                "xsl_match_reward\n" +
//                "xsl_network\n" +
//                "xsl_order\n" +
//                "xsl_oriented\n" +
//                "xsl_output_bill\n" +
//                "xsl_privilege_rule\n" +
//                "xsl_reward\n" +
//                "xsl_reward_rank\n" +
//                "xsl_role\n" +
//                "xsl_role_rule\n" +
//                "xsl_rule\n" +
//                "xsl_school\n" +
//                "xsl_schoolInfo\n" +
//                "xsl_score\n" +
//                "xsl_tag\n" +
//                "xsl_task\n" +
//                "xsl_task_category\n" +
//                "xsl_task_tag\n" +
//                "xsl_throwinglog\n" +
//                "xsl_token\n" +
//                "xsl_user\n" +
//                "xsl_user_file\n";
//        String[] split = str.split("\n");
//        for (int i = 0; i < split.length; i++) {
//            System.out.println("<table schema=\"\" tableName=\""+ split[i] +"\"></table>");
//        }
//    }

//    @Autowired
//    XslTagMapper xslTagMapper;
//    @Value("${MATCH_TAG_PREFIX}")
//    String MATCH_TAG_PREFIX;

//    private static JedisPoolConfig jedisPoolConfig;
//
//    static {
//        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
//    }
//    @org.junit.Test
//    public void test02(){
//        XslTagExample xslTagExample = new XslTagExample();
//        xslTagExample.createCriteria().andTagidLike(MATCH_TAG_PREFIX + "%").andStateEqualTo(true);
//        List<XslTag> xslTags = xslTagMapper.selectByExample(xslTagExample);
//        System.out.println();
//        XslMatchUserReqVo xslMatchUserReqVo = new XslMatchUserReqVo();
//        xslMatchUserReqVo.setHunterid("MTH:3884e72d-96f1-4424-a758-bdca23ec0f31");
//        List<String> strings = new ArrayList<>();
//        strings.add("MTT:1233");
//        xslMatchUserReqVo.setTags(strings);
//        String s = JsonUtils.objectToJson(xslMatchUserReqVo);
//        System.out.println(s);
//        ArrayList<Cat> cats1 = new ArrayList<>();
//        ArrayList<Animals> animals = new ArrayList<>();
//        ArrayList<BlackCat> blackCats = new ArrayList<>();
//        ArrayList<? extends Cat> cats = new ArrayList<>();
//
//        cats = cats1;
//        cats = animals;
//        cats = blackCats;

//        XslMatchTeam xslMatchTeam = new XslMatchTeam();
//        xslMatchTeam.setTeamid("503");
//        xslMatchTeam.setTeamname("503");
//        xslMatchTeam.setMatchid("M49a30f57-67ce-4361-a4d8-628c6f631ee4");
//        xslMatchTeam.setTeamsynopsis("大家都很懒，所以什么也没有ヽ(ー_ー)ノ");
//        xslMatchTeam.setTeamcreatorid("MTH:59152adf-6815-4d2f-b147-c8aaeb642c77");
//        xslMatchTeam.setTeamstate(1);
//        String s = JsonUtils.objectToJson(xslMatchTeam);
//        System.out.println(s);
    //        PositionUpdateReqVo positionUpdateReqVo = new PositionUpdateReqVo();
//        positionUpdateReqVo.setPositionid("777");
//        positionUpdateReqVo.setPositionname("777");
//        positionUpdateReqVo.setPositioninfo("77777");
//        positionUpdateReqVo.setTeamid("Taadc747a-275a-43b9-9350-e337f9e89c5d");
//        System.out.println(JsonUtils.objectToJson(positionUpdateReqVo));
//    }
}

