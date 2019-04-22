package xsl.match.service;

import com.xsl.pojo.XslMatch;
import com.xsl.result.EasyUIDataGridResult;
import com.xsl.result.XslResult;

import java.util.HashMap;
import java.util.List;

/**
 * 说明：比赛信息相关操作
 *
 * @Auther: 11432_000
 * @Date: 2019/4/21 14:19
 * @Description:
 */
public interface XslMatchService {
    /** 获取所有的参赛形式 */
    List<HashMap<String,String>> getAllForm();

    /** 添加一个比赛 */
    XslResult addAMatch(XslMatch xslMatch);

    /** 获取比赛列表 */
    EasyUIDataGridResult getMatchList(Integer page,Integer rows);

    /** 根据 MatchId 修改一条比赛数据 */
    XslResult updateAMatchInfo(XslMatch xslMatch);

    /** 获取所有的比赛状态 */
    List<HashMap<String,String>> getAllState();
}
