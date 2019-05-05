package xsl.match.service;

import com.xsl.pojo.XslOriented;
import com.xsl.result.EasyUIDataGridResult;
import com.xsl.result.XslResult;

import java.util.List;

/**
 * 说明：面向人群的相关操作
 *
 * @Auther: 11432_000
 * @Date: 2019/4/21 13:15
 * @Description:
 */
public interface XslOrientedService {
    /** 获取所有面向人群 */
    EasyUIDataGridResult getAllOrienteds(Integer page , Integer rows) throws RuntimeException;
    /** 更新人群信息 */
    XslResult updateOriented(XslOriented xslOriented)throws RuntimeException;
    /** 添加一条人群 */
    XslResult addOriented(XslOriented xslOriented)throws RuntimeException;
    /** 逻辑删除一条或多条人群 */
    XslResult deleteOrienteds(List<String> xslOrientedIds)throws RuntimeException;
}
