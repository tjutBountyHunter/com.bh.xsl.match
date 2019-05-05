package xsl.match.service;

import com.xsl.pojo.XslMatchType;
import com.xsl.result.EasyUIDataGridResult;
import com.xsl.result.XslResult;

import java.util.List;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2019/4/26 21:04
 * @Description:
 */
public interface XslMatchTypeService {

    /** 获取所有比赛类型 分页*/
    XslResult getAllType(Integer page, Integer rows) throws RuntimeException;
    /** 根据id 获取类型信息 */
    XslResult getType(String xslMatchType)throws RuntimeException;
    /** 更新比赛类型 */
    XslResult updateMatchType(XslMatchType xslMatchType)throws RuntimeException;
    /** 添加一条比赛类型 */
    XslResult addMatchType(XslMatchType xslMatchType)throws RuntimeException;
    /** 逻辑删除一条或多条比赛类型 */
    XslResult deleteMatchTypes(List<String> matchTypeIds)throws RuntimeException;
}
