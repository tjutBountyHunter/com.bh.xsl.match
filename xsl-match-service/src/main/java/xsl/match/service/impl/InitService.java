package xsl.match.service.impl;

import com.xsl.Utils.JedisUtils;
import com.xsl.Utils.JsonUtils;
import com.xsl.enums.DataStates;
import com.xsl.pojo.XslMatch;
import com.xsl.pojo.XslMatchExample;
import com.xsl.pojo.XslMatchRankExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import xsl.match.mapper.XslMatchMapper;

import java.util.List;

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
    @Value("MATCH_BUFFER_PREFIX")
    private String MATCH_BUFFER_PREFIX;

    public void init(){
        List<XslMatch> list = null;
        try {
            XslMatchExample xslMatchExample = new XslMatchExample();
            XslMatchExample.Criteria criteria = xslMatchExample.createCriteria();
            criteria.andMatchstateNotEqualTo(DataStates.DELETE.getCode());
            list = xslMatchMapper.selectByExample(xslMatchExample);
            for (XslMatch xslMatch : list){
                JedisUtils.set(MATCH_BUFFER_PREFIX + ":" + xslMatch.getMatchid(), JsonUtils.objectToJson(xslMatch));
            }
            LOGGER.info("添加比赛缓存---成功");
        } catch (Exception e) {
            LOGGER.error("添加比赛缓存---失败");
            throw new RuntimeException(e.getMessage());
        }
    }
}
