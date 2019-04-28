package xsl.match.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xsl.Utils.IdUtils;
import com.xsl.Utils.ResultUtils;
import com.xsl.enums.DataStates;
import com.xsl.pojo.XslMatchRank;
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
    XslMatchTypeMapper xslMatchTypeMapper;
    @Override
    public XslResult getAllType(Integer page, Integer rows) throws RuntimeException {
        /**
         *
         * 功能描述: 获取所有比赛类型
         *
         * @param: [page, rows]
         * @return: com.xsl.result.XslResult
         * @auther: 11432_000
         * @date: 2019/4/26 21:12
         */
        try {
            List<XslMatchType> xslMatchTypes = xslMatchTypeMapper.selectAllMatchType();
            if (page == null || rows == null){
                return ResultUtils.isOk(xslMatchTypes);
            }
            EasyUIDataGridResult result = new EasyUIDataGridResult();
            result.setRows(xslMatchTypes);
            //设置分页信息
            PageHelper.startPage(page,rows);
            //获取分页结果
            PageInfo<XslMatchType> xslMatchTypePageInfo = new PageInfo<XslMatchType>(xslMatchTypes);
            result.setTotal(xslMatchTypePageInfo.getTotal());
            return ResultUtils.isOk(result);
        }catch (Exception e){
            throw new RuntimeException("获取比赛类型异常:" + e.getMessage());
        }
    }
    @Override
    public XslResult getType(String xslMatchTypeId) throws RuntimeException {
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
            XslMatchType xslMatchType = xslMatchTypeMapper.selectMatchTypeByMatchTypeId(xslMatchTypeId);
            if (xslMatchType == null){
                return ResultUtils.isError();
            }
            return ResultUtils.isOk(xslMatchType);
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
            int i = xslMatchTypeMapper.updateByMatchTypeId(xslMatchType);
            if (i <= 0){
                LOGGER.error("updateMatchType 更新比赛类型信息失败");
                return ResultUtils.isError();
            }
            return ResultUtils.isOk();
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
        xslMatchType.setMatchTypeId(uuid);
        xslMatchType.setMatchTypeState(DataStates.NORMAL.getCode());
        try{
            int insert = xslMatchTypeMapper.insert(xslMatchType);
            if (insert <= 0){
                LOGGER.error("addMatchType 添加比赛类型 失败");
                return ResultUtils.isError("添加比赛类型失败");
            }
            return ResultUtils.isOk();
        }catch (Exception e){
            throw new RuntimeException("添加比赛类型异常:" + e.getMessage());
        }
    }
    @Override
    public XslResult deleteMatchTypes(String matchTypeIds) throws RuntimeException {
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
            return ResultUtils.isParameterError("deleteMatchRanks() 参数为null");
        }
        //拆分多个id
        String[] split = matchTypeIds.split(",");
        try {
            XslMatchType xslMatchType = new XslMatchType();
            for (String str : split){
                xslMatchType.setMatchTypeId(str);
                xslMatchType.setMatchTypeState(DataStates.DELETE.getCode());
                int i = xslMatchTypeMapper.updateTypeStateByMatchTypeId(xslMatchType);
                if (i <= 0){
                    LOGGER.error("deleteMatchRanks() 删除数据" + str + "失败");
                    return ResultUtils.isError("deleteMatchRanks() 删除数据" + str + "失败");
                }
            }
            return ResultUtils.isOk();
        }catch (Exception e){
            throw new RuntimeException("比赛类型删除异常：" + e.getMessage());
        }
    }
}
