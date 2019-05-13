package xsl.match.service;

import com.xsl.pojo.XslMatch;
import com.xsl.pojo.XslMatchHonor;
import com.xsl.result.XslResult;

import java.util.List;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2019/5/9 16:36
 * @Description:
 */
public interface XslHonorService {
    /** 添加荣誉 */
    XslResult addHonor(XslMatchHonor xslMatchHonor)throws RuntimeException;
    /** 删除荣誉 */
    XslResult deleteHonor(String honorId)throws RuntimeException;
    /** 用户更改荣誉 */
    XslResult updateHonorByUser(XslMatchHonor xslMatchHonor)throws RuntimeException;
    /** 管理员更改荣誉 */
    XslResult updateHonorByManager(XslMatchHonor xslMatchHonor)throws RuntimeException;
    /** 获取指定状态和用户的荣誉列表 */
    List<XslMatchHonor> getHonorByHunterId(String hunter,Integer... state)throws RuntimeException;
    /** 获取指定状态的荣誉列表 */
    List<XslMatchHonor> getHonorByState(Integer... state)throws RuntimeException;
}
