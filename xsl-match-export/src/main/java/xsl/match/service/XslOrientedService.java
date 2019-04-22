package xsl.match.service;

import com.xsl.pojo.XslOriented;

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
    List<XslOriented> getAllXslOrienteds();
}
