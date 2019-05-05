import com.xsl.Utils.JedisUtils;
import com.xsl.Utils.JsonUtils;
import com.xsl.pojo.XslMatch;
import com.xsl.result.XslResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import xsl.match.service.impl.XslMatchServiceImpl;

import java.util.List;
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
//        String str = " {\"code\":200,\"msg\":\"成功\",\"data\":[{\"id\":13,\"matchid\":\"Md9850f5e-48b2-476c-a2d0-300cd63536e8\",\"matchname\":\"666\",\"matchrankid\":\"MR9a716137-9441-4547-bcb8-c95761e5e1af\",\"matchwebsite\":\"\",\"matchorientedid\":\"MOa236bf3c-d0b3-4c67-b7f4-c1fac76bbe45\",\"matchstarttime\":1554422400000,\"matchendtime\":1554422400000,\"matchstate\":7,\"matchsignupendtime\":1554422400000,\"matchaddress\":\"是是是\",\"matchsignupmaxnum\":null,\"matchform\":1,\"matchteamnum\":null,\"matchsignupstarttime\":1554336000000,\"matchcreatetime\":1556024477000,\"matchposterurl\":\"\",\"matchtypeid\":\"1\",\"matchinfo\":null},{\"id\":14,\"matchid\":\"M3026756a-c790-432f-b058-240990f5e353\",\"matchname\":\"测试1\",\"matchrankid\":\"MR0fedc424-298f-46ca-898e-922d01b6cb3d\",\"matchwebsite\":\"\",\"matchorientedid\":\"MOa236bf3c-d0b3-4c67-b7f4-c1fac76bbe45\",\"matchstarttime\":1556496000000,\"matchendtime\":1556582400000,\"matchstate\":7,\"matchsignupendtime\":1556323200000,\"matchaddress\":\"不知道\",\"matchsignupmaxnum\":null,\"matchform\":2,\"matchteamnum\":4,\"matchsignupstarttime\":1556236800000,\"matchcreatetime\":1556267119000,\"matchposterurl\":\"\",\"matchtypeid\":\"1\",\"matchinfo\":null}]}\n";
//        XslResult xslResult = JsonUtils.jsonToPojo(str, XslResult.class);
//        List<XslMatch> data = (List<XslMatch>) xslResult.getData();
//        XslMatch xslMatch = data.get(0);
//        System.out.println();
//    }

}
