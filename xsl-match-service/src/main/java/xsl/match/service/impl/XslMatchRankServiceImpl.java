package xsl.match.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xsl.Utils.IdUtils;
import com.xsl.Utils.ResultUtils;
import com.xsl.enums.DataStatesEnum;
import com.xsl.pojo.XslMatchRank;
import com.xsl.pojo.Example.XslMatchRankExample;
import com.xsl.result.EasyUIDataGridResult;
import com.xsl.result.XslResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xsl.match.mapper.XslMatchRankMapper;
import xsl.match.service.XslMatchRankService;

import java.util.Arrays;
import java.util.List;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2019/4/20 20:51
 * @Description:
 */
@Service
public class XslMatchRankServiceImpl implements XslMatchRankService {

    private static final Logger LOGGER = LoggerFactory.getLogger(XslMatchRankServiceImpl.class);

    @Autowired
    private XslMatchRankMapper xslMatchRankMapper;

    @Override
    public EasyUIDataGridResult getAllRank(Integer page,Integer rows) throws RuntimeException{
        /**
         *
         * 功能描述: 获取所有比赛等级 分页
         *
         * @param: [page, rows]
         * @return: com.xsl.result.XslResult
         * @auther: 11432_000
         * @date: 2019/5/4 15:59
         */
        //设置分页信息
        PageHelper.startPage(page,rows);
        try {
            XslMatchRankExample xslMatchRankExample = new XslMatchRankExample();
            XslMatchRankExample.Criteria criteria = xslMatchRankExample.createCriteria();
            criteria.andRankstateEqualTo(DataStatesEnum.NORMAL.getCode());
            List<XslMatchRank> xslMatchRanks = xslMatchRankMapper.selectByExample(xslMatchRankExample);
            EasyUIDataGridResult result = new EasyUIDataGridResult();
            result.setRows(xslMatchRanks);
            //获取分页结果
            PageInfo<XslMatchRank> xslMatchRankPageInfo = new PageInfo<XslMatchRank>(xslMatchRanks);
            result.setTotal(xslMatchRankPageInfo.getTotal());
            return result;
        }catch (Exception e){
            throw new RuntimeException("获取比赛信息异常:" + e.getMessage());
        }
    }

    @Override
    public List<XslMatchRank> getAllRank() throws RuntimeException{
        /**
         *
         * 功能描述: 获取所有比赛等级 不分页
         *
         * @param: []
         * @return: java.util.List<com.xsl.pojo.XslMatchRank>
         * @auther: 11432_000
         * @date: 2019/4/21 14:24
         */
        try {
            XslMatchRankExample xslMatchRankExample = new XslMatchRankExample();
            xslMatchRankExample.createCriteria().andRankstateEqualTo(DataStatesEnum.NORMAL.getCode());
            List<XslMatchRank> xslMatchRanks = xslMatchRankMapper.selectByExample(xslMatchRankExample);
            return xslMatchRanks;
        }catch (Exception e){
            throw new RuntimeException("获取比赛信息异常:" + e.getMessage());
        }
    }

    /**
     *
     * 功能描述: 根据id获取比赛等级
     *
     * @param: [rankId]
     * @return: java.util.List<com.xsl.pojo.XslMatchRank>
     * @auther: 11432_000
     * @date: 2019/4/22 14:53
     */
    @Override
    public XslMatchRank getRank(String rankId)throws RuntimeException {
        try{
            XslMatchRankExample xslMatchRankExample = new XslMatchRankExample();
            XslMatchRankExample.Criteria criteria = xslMatchRankExample.createCriteria();
            criteria.andMatchrankidEqualTo(rankId);
            List<XslMatchRank> xslMatchRanks = xslMatchRankMapper.selectByExample(xslMatchRankExample);
            if (xslMatchRanks == null || xslMatchRanks.size() == 0){
                throw new RuntimeException("等级不存在");
            }
            return xslMatchRanks.get(0);
        }catch (Exception e){
            throw new RuntimeException("获取比赛信息异常:"+ e.getMessage());
        }
    }

    /**
     *
     * 功能描述:修改比赛等级信息
     *
     * @param: [xslMatchRank]
     * @return: com.xsl.result.XslResult
     * @auther: 11432_000
     * @date: 2019/4/23 21:16
     */
    @Override
    public XslResult updateMatchRankInfo(XslMatchRank xslMatchRank)throws RuntimeException {
        try{
            XslMatchRankExample xslMatchRankExample = new XslMatchRankExample();
            XslMatchRankExample.Criteria criteria = xslMatchRankExample.createCriteria();
            criteria.andMatchrankidEqualTo(xslMatchRank.getMatchrankid());

            int i = xslMatchRankMapper.updateByExampleSelective(xslMatchRank,xslMatchRankExample);
            if (i <= 0){
                LOGGER.error("更新比赛等级信息失败");
                return ResultUtils.error();
            }
            return ResultUtils.ok();
        }catch (Exception e){
            throw new RuntimeException("修改比赛等级信息异常:"+ e.getMessage());
        }
    }
    @Override
    public XslResult addMatchRank(XslMatchRank xslMatchRank) throws RuntimeException {
        /**
         *
         * 功能描述: 添加一条比赛记录
         *
         * @param: [xslMatchRank]
         * @return: com.xsl.result.XslResult
         * @auther: 11432_000
         * @date: 2019/4/24 15:43
         */
        String matchRankId = IdUtils.getUuid("MR");
        xslMatchRank.setMatchrankid(matchRankId);
        xslMatchRank.setRankstate(DataStatesEnum.NORMAL.getCode());
        try{
            int insert = xslMatchRankMapper.insert(xslMatchRank);
            if (insert <= 0){
                LOGGER.error("addMatchRank 添加比赛 失败");
                return ResultUtils.error("添加比赛等级失败");
            }
            return ResultUtils.ok();
        }catch (Exception e){
            throw new RuntimeException("添加比赛等级异常:" + e.getMessage());
        }
    }

    /**
     *
     * 功能描述: 逻辑删除一条或多条比赛等级记录
     *
     * @param: [matchRankIds]
     * @return: com.xsl.result.XslResult
     * @auther: 11432_000
     * @date: 2019/4/24 16:20
     */
    @Override
    public XslResult deleteMatchRanks(String matchRankIds) throws RuntimeException {
        if (matchRankIds == null){
            return ResultUtils.parameterError("deleteMatchRanks() 参数为null");
        }
        //拆分多个id
        String[] split = matchRankIds.split(",");
        try {
            XslMatchRank xslMatchRank = new XslMatchRank();
            XslMatchRankExample xslMatchRankExample = new XslMatchRankExample();
            XslMatchRankExample.Criteria criteria = xslMatchRankExample.createCriteria();
            criteria.andMatchrankidIn(Arrays.asList(split));
            xslMatchRank.setRankstate(DataStatesEnum.DELETE.getCode());
            int i = xslMatchRankMapper.updateByExampleSelective(xslMatchRank,xslMatchRankExample);
            if (i <= 0){
                return ResultUtils.parameterError("deleteMatchRanks() 删除数据失败");
            }
            return ResultUtils.ok();
        }catch (Exception e){
            throw new RuntimeException("比赛等级删除异常：" + e.getMessage());
        }
    }
}
