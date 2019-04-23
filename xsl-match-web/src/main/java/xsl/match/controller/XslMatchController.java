package xsl.match.controller;

import com.xsl.Utils.ResultUtils;
import com.xsl.enums.MatchState;
import com.xsl.pojo.XslMatch;
import com.xsl.result.EasyUIDataGridResult;
import com.xsl.result.XslResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xsl.match.service.XslMatchService;

import java.util.HashMap;
import java.util.List;

/**
 * 说明：比赛信息相关操作
 *
 * @Auther: 11432_000
 * @Date: 2019/4/21 14:18
 * @Description:
 */
@Controller
@RequestMapping("match/info")
public class XslMatchController {

    @Autowired
    XslMatchService xslMatchService;

    @RequestMapping("/select/form")
    @ResponseBody
    /**
     *
     * 功能描述: 获取所有参赛形式
     *
     * @param: []
     * @return: java.util.List<java.util.HashMap<java.lang.String,java.lang.String>>
     * @auther: 11432_000
     * @date: 2019/4/21 14:36
     */
    public List<HashMap<String,String>> getAllForm(){
        List<HashMap<String, String>> allForm = xslMatchService.getAllForm();
        return allForm;
    }

    @RequestMapping("/select/state")
    @ResponseBody
    /**
     *
     * 功能描述: 获取所有比赛状态
     *
     * @param: []
     * @return: java.util.List<java.util.HashMap<java.lang.String,java.lang.String>>
     * @auther: 11432_000
     * @date: 2019/4/21 14:36
     */
    public List<HashMap<String,String>> getAllState(){
        List<HashMap<String, String>> allForm = xslMatchService.getAllState();
        return allForm;
    }

    @RequestMapping("/add")
    @ResponseBody/**
     *
     * 功能描述: 添加一条比赛信息
     *
     * @param: [xslMatch]
     * @return: com.xsl.result.XslResult
     * @auther: 11432_000
     * @date: 2019/4/22 11:56
     */
    public XslResult addAMatchInfo(@RequestBody XslMatch xslMatch){
        XslResult xslResult = xslMatchService.addAMatch(xslMatch);
        return xslResult;
    }

    @RequestMapping("/list")
    @ResponseBody
    /**
     *
     * 功能描述: 获取比赛列表
     *
     * @param: [page, rows]
     * @return: com.xsl.result.EasyUIDataGridResult
     * @auther: 11432_000
     * @date: 2019/4/22 19:28
     */
    public EasyUIDataGridResult getMatchList(Integer page,Integer rows){
        EasyUIDataGridResult matchList = xslMatchService.getMatchList(page, rows);
        return matchList;
    }


    @RequestMapping("/edit")
    @ResponseBody
    /**
     *
     * 功能描述: 修改一条比赛信息
     *
     * @param: [xslMatch]
     * @return: com.xsl.result.XslResult
     * @auther: 11432_000
     * @date: 2019/4/22 19:29
     */
    public XslResult editMatchInfo(@RequestBody XslMatch xslMatch){
        XslResult xslResult = xslMatchService.updateAMatchInfo(xslMatch);
        return xslResult;
    }


    @RequestMapping("/delete")
    @ResponseBody
    /**
     *
     * 功能描述: 根据MatchId删除记录
     *
     * @param: [matchIds]
     * @return: com.xsl.result.XslResult
     * @auther: 11432_000
     * @date: 2019/4/23 15:48
     */
    public XslResult deleteSomeMatch(@Param("matchIds") String matchIds){
        return xslMatchService.deleteMatchInfoByIds(matchIds);
    }

    @RequestMapping("/update/disableMatch")
    @ResponseBody
    /**
     *
     * 功能描述: 批量禁用比赛
     *
     * @param: [matchIds]
     * @return: com.xsl.result.XslResult
     * @auther: 11432_000
     * @date: 2019/4/23 16:44
     */
    public XslResult disableMatch(@Param("matchIds") String matchIds){
        return xslMatchService.updateMatchState(matchIds, MatchState.DELETE.getKey());
    }

}
