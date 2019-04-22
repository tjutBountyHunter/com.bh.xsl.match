package xsl.match.service.impl;

import com.xsl.pojo.XslOriented;
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
    public List<XslOriented> getAllXslOrienteds() {
        return xslOrientedMapper.selectAll();
    }
}
