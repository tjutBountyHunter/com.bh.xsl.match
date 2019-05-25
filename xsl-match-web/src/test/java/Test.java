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
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import xsl.match.mapper.XslTagMapper;
import xsl.match.service.impl.XslMatchServiceImpl;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.*;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2019/4/21 20:14
 * @Description:
 */
//@RunWith(SpringJUnit4ClassRunner.class)//固定写法
//@ContextConfiguration({"classpath:spring/applicationContext-dao.xml"})
public class Test {

//    public static void main(String[] args) {
//        String uuid = UUID.randomUUID().toString();
//        System.out.println(uuid);
//    }
private static final Logger LOGGER = LoggerFactory.getLogger(Test.class);

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

    private static JedisPoolConfig jedisPoolConfig;

    static {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();

    }
    @org.junit.Test
    public void test02(){
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

        XslUserRegister userReqVo = new XslUserRegister();
        userReqVo.setCode("8766");
        userReqVo.setPassword("123456");
        userReqVo.setPhone("15222355001");
        System.out.println(JsonUtils.objectToJson(userReqVo));
    }
//    public static class Animals{
//
//    }
//    public static class Cat extends Animals{
//
//    }
//    public static class BlackCat extends Cat{
//
//    }
}

