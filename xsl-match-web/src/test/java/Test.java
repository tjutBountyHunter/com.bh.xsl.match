import com.xsl.Utils.JedisUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import xsl.match.service.impl.XslMatchServiceImpl;

import java.util.UUID;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2019/4/21 20:14
 * @Description:
 */
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


//    @org.junit.Test
//    public void test02(){
//        ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext-redis.xml");
//        JedisUtils.set("SSS" + ":" + "1" ,"99");
//        JedisUtils.set("SSS" + ":" + "2" ,"97");
//    }

}
