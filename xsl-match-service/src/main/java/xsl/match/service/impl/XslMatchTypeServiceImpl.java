package xsl.match.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xsl.Utils.IdUtils;
import com.xsl.Utils.ResultUtils;
import com.xsl.enums.DataStatesEnum;
import com.xsl.pojo.Example.XslMatchTypeExample;
import com.xsl.pojo.XslMatchType;
import com.xsl.result.EasyUIDataGridResult;
import com.xsl.result.XslResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xsl.match.mapper.XslMatchTypeMapper;
import xsl.match.service.XslMatchTypeService;

import java.util.List;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2019/4/26 21:08
 * @Description:
 */
@Service
public class XslMatchTypeServiceImpl implements XslMatchTypeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(XslMatchTypeServiceImpl.class);

    @Autowired
    private XslMatchTypeMapper xslMatchTypeMapper;
    @Override
    public EasyUIDataGridResult getAllType(Integer page, Integer rows) throws RuntimeException {
        /**
         *
         * 功能描述: 获取所有比赛类型 分页
         *
         * @param: [page, rows]
         * @return: com.xsl.result.XslResult
         * @auther: 11432_000
         * @date: 2019/4/26 21:12
         */
        //设置分页信息
        PageHelper.startPage(page,rows);
        try {
            XslMatchTypeExample xslMatchTypeExample = new XslMatchTypeExample();
            XslMatchTypeExample.Criteria criteria = xslMatchTypeExample.createCriteria();
            criteria.andMatchtypestateNotEqualTo(DataStatesEnum.DELETE.getCode());
            List<XslMatchType> xslMatchTypes = xslMatchTypeMapper.selectByExample(xslMatchTypeExample);

            EasyUIDataGridResult result = new EasyUIDataGridResult();
            result.setRows(xslMatchTypes);
            //获取分页结果
            PageInfo<XslMatchType> xslMatchTypePageInfo = new PageInfo<XslMatchType>(xslMatchTypes);
            result.setTotal(xslMatchTypePageInfo.getTotal());
            return result;
        }catch (Exception e){
            throw new RuntimeException("获取比赛类型异常:" + e.getMessage());
        }
    }

    @Override
    public List<XslMatchType> getAllType() throws RuntimeException {
        /**
         *
         * 功能描述: 获取所有比赛类型 不分页
         *
         * @param: []
         * @return: com.xsl.result.XslResult
         * @auther: 11432_000
         * @date: 2019/5/5 13:48
         */
        try {
            XslMatchTypeExample xslMatchTypeExample = new XslMatchTypeExample();
            XslMatchTypeExample.Criteria criteria = xslMatchTypeExample.createCriteria();
            criteria.andMatchtypestateNotEqualTo(DataStatesEnum.DELETE.getCode());
            List<XslMatchType> xslMatchTypes = xslMatchTypeMapper.selectByExample(xslMatchTypeExample);
            return xslMatchTypes;
        }catch (Exception e){
            throw new RuntimeException("获取比赛类型异常:" + e.getMessage());
        }
    }

    @Override
    public XslMatchType getType(String xslMatchTypeId) throws RuntimeException {
        /**
         *
         * 功能描述:  根据id 获取类型信息
         *
         * @param: [xslMatchTypeId]
         * @return: com.xsl.result.XslResult
         * @auther: 11432_000
         * @date: 2019/4/27 9:43
         */
        try{
            XslMatchTypeExample xslMatchTypeExample = new XslMatchTypeExample();
            XslMatchTypeExample.Criteria criteria = xslMatchTypeExample.createCriteria();
            criteria.andMatchtypeidEqualTo(xslMatchTypeId);
            List<XslMatchType> xslMatchTypes = xslMatchTypeMapper.selectByExample(xslMatchTypeExample);
            if (xslMatchTypes == null || xslMatchTypes.size() == 0){
                throw new RuntimeException("比赛类型不存在");
            }
            return xslMatchTypes.get(0);
        }catch (Exception e){
            throw new RuntimeException("获取比赛类型异常:"+ e.getMessage());
        }
    }
    @Override
    public XslResult updateMatchType(XslMatchType xslMatchType) throws RuntimeException {
        /**
         *
         * 功能描述: 更新比赛类型
         *
         * @param: [xslMatchType]
         * @return: com.xsl.result.XslResult
         * @auther: 11432_000
         * @date: 2019/4/27 9:45
         */
        try{
            XslMatchTypeExample xslMatchTypeExample = new XslMatchTypeExample();
            XslMatchTypeExample.Criteria criteria = xslMatchTypeExample.createCriteria();
            criteria.andMatchtypeidEqualTo(xslMatchType.getMatchtypeid());
            int i = xslMatchTypeMapper.updateByExampleSelective(xslMatchType,xslMatchTypeExample);
            if (i <= 0){
                LOGGER.error("updateMatchType 更新比赛类型信息失败");
                return ResultUtils.error();
            }
            return ResultUtils.ok();
        }catch (Exception e){
            throw new RuntimeException("修改比赛类型信息异常:"+ e.getMessage());
        }
    }
    @Override
    public XslResult addMatchType(XslMatchType xslMatchType) throws RuntimeException {
        /**
         *
         * 功能描述: 添加一条比赛类型
         *
         * @param: [xslMatchType]
         * @return: com.xsl.result.XslResult
         * @auther: 11432_000
         * @date: 2019/4/27 9:48
         */
        String uuid = IdUtils.getUuid("MT");
        xslMatchType.setMatchtypeid(uuid);
        xslMatchType.setMatchtypestate(DataStatesEnum.NORMAL.getCode());
        try{
            int insert = xslMatchTypeMapper.insertSelective(xslMatchType);
            if (insert <= 0){
                LOGGER.error("addMatchType 添加比赛类型 失败");
                return ResultUtils.error("添加比赛类型失败");
            }
            return ResultUtils.ok();
        }catch (Exception e){
            throw new RuntimeException("添加比赛类型异常:" + e.getMessage());
        }
    }
    @Override
    public XslResult deleteMatchTypes(List<String> matchTypeIds) throws RuntimeException {
        /**
         *
         * 功能描述: 逻辑删除一条或多条比赛类型
         *
         * @param: [matchTypeIds]
         * @return: com.xsl.result.XslResult
         * @auther: 11432_000
         * @date: 2019/4/27 9:51
         */
        if (matchTypeIds == null){
            return ResultUtils.parameterError("deleteMatchRanks() 参数为null");
        }
        try {
            XslMatchType xslMatchType = new XslMatchType();
            XslMatchTypeExample xslMatchTypeExample = new XslMatchTypeExample();
            XslMatchTypeExample.Criteria criteria = xslMatchTypeExample.createCriteria();
            criteria.andMatchtypeidIn(matchTypeIds);

            xslMatchType.setMatchtypestate(DataStatesEnum.DELETE.getCode());
            int i = xslMatchTypeMapper.updateByExampleSelective(xslMatchType,xslMatchTypeExample);
            if (i <= 0){
                LOGGER.error("deleteMatchRanks() 删除数据失败");
                return ResultUtils.error("deleteMatchRanks() 删除数据失败");
            }
            return ResultUtils.ok();
        }catch (Exception e){
            throw new RuntimeException("比赛类型删除异常：" + e.getMessage());
        }
    }

}
