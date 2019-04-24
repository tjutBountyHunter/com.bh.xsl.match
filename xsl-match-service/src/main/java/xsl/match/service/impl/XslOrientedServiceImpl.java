package xsl.match.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xsl.Utils.IdUtils;
import com.xsl.Utils.ResultUtils;
import com.xsl.pojo.XslOriented;
import com.xsl.result.EasyUIDataGridResult;
import com.xsl.result.XslResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xsl.match.mapper.XslOrientedMapper;
import xsl.match.service.XslOrientedService;

import java.util.List;

/**
 * 说明：面向人群相关操作
 *
 * @Auther: 11432_000
 * @Date: 2019/4/21 13:16
 * @Description:
 */
@Service
public class XslOrientedServiceImpl implements XslOrientedService {

    private static final Logger LOGGER = LoggerFactory.getLogger(XslOrientedServiceImpl.class);

    @Autowired
    XslOrientedMapper xslOrientedMapper;

    /**
     *
     * 功能描述:获取所有面向人群
     *
     * @param: []
     * @return: java.util.List<com.xsl.pojo.XslOriented>
     * @auther: 11432_000
     * @date: 2019/4/21 14:25
     */
    public EasyUIDataGridResult getAllOrienteds(Integer page ,Integer rows)throws RuntimeException {
        try{
            List<XslOriented> xslOrienteds = xslOrientedMapper.selectAll();
            EasyUIDataGridResult result = new EasyUIDataGridResult();
            result.setRows(xslOrienteds);
            if (page == null || rows == null){
                return result;
            }
            //配置分页信息
            PageHelper.startPage(page,rows);
            //获取分页结果
            PageInfo<XslOriented> xslOrientedPageInfo = new PageInfo<XslOriented>(xslOrienteds);
            result.setTotal(xslOrientedPageInfo.getTotal());
            return result;
        }catch (Exception e){
            throw new RuntimeException("获取面向人群列表异常:"  + e.getMessage());
        }
    }

    public XslResult updateOriented(XslOriented xslOriented) throws RuntimeException {
        /**
         *
         * 功能描述: 更新一条人群
         *
         * @param: [xslOriented]
         * @return: com.xsl.result.XslResult
         * @auther: 11432_000
         * @date: 2019/4/24 17:45
         */
        try {
            int i = xslOrientedMapper.updateByOrientedId(xslOriented);
            if (i <= 0){
                LOGGER.error("updateOriented 修改数据 id" + xslOriented.getOrientedId() + "失败");
                return ResultUtils.isError();
            }
            return ResultUtils.isOk();
        }catch (Exception e){
            throw new RuntimeException("更新人群信息异常" + e.getMessage());
        }
    }

    public XslResult addOriented(XslOriented xslOriented) throws RuntimeException {
        /**
         *
         * 功能描述: 添加一种人群
         *
         * @param: [xslOriented]
         * @return: com.xsl.result.XslResult
         * @auther: 11432_000
         * @date: 2019/4/24 17:55
         */
        String uuid = IdUtils.getUuid("MO");
        xslOriented.setOrientedId(uuid);
        try{
            int insert = xslOrientedMapper.insert(xslOriented);
            if (insert <= 0){
                LOGGER.error("addOriented 添加人群失败");
                return ResultUtils.isParameterError();
            }
            return ResultUtils.isOk();
        }catch (Exception e){
            throw new RuntimeException("添加人群异常：" + e.getMessage());
        }
    }

    public XslResult deleteOrienteds(String matchOrientedIds) throws RuntimeException {
        if (matchOrientedIds == null){
            LOGGER.info("删除人群 matchOrientedIds 为null");
            return ResultUtils.isParameterError();
        }
        //拆分多个id
        String[] split = matchOrientedIds.split(",");
        if (split.length == 0){
            return ResultUtils.isParameterError();
        }
        try{
            for (String matchOrientedId : split){
                int i = xslOrientedMapper.deleteByOrientedId(matchOrientedId);
                if (i <= 0){
                    LOGGER.error("updateMatchState 删除 matchOrientedId =" +  matchOrientedId + " 失败");
                    return ResultUtils.isError();
                }
            }
            return ResultUtils.isOk();
        }catch (Exception e){
            throw new RuntimeException("删除人群异常:" + e.getMessage());
        }
    }
}
