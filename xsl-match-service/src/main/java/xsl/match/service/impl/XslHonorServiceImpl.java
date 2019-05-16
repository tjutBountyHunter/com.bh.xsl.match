package xsl.match.service.impl;

import com.xsl.Utils.IdUtils;
import com.xsl.Utils.ResultUtils;
import com.xsl.enums.HonorStatesEnum;
import com.xsl.pojo.Example.XslMatchHonorExample;
import com.xsl.pojo.XslMatchHonor;
import com.xsl.result.XslResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xsl.match.mapper.XslMatchHonorMapper;
import xsl.match.service.XslHonorService;

import java.util.Arrays;
import java.util.List;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2019/5/9 17:09
 * @Description:
 */
@Service
public class XslHonorServiceImpl implements XslHonorService{

    @Autowired
    private XslMatchHonorMapper xslMatchHonorMapper;

    @Override
    public XslResult addHonor(XslMatchHonor xslMatchHonor) throws RuntimeException {
        /**
         *
         * 功能描述: 添加荣誉
         *
         * @param: [xslMatchHonor]
         * @return: com.xsl.result.XslResult
         * @auther: 11432_000
         * @date: 2019/5/9 17:22
         */
        try {
            xslMatchHonor.setHonorid(IdUtils.getUuid(""));
            xslMatchHonor.setHonorstate(HonorStatesEnum.UNAUDITED.getCode());
            int i = xslMatchHonorMapper.insertSelective(xslMatchHonor);
            if (i <= 0){
                return ResultUtils.error("添加荣誉失败");
            }
            return ResultUtils.ok();
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public XslResult deleteHonor(String honorId) throws RuntimeException {
        /**
         *
         * 功能描述: 删除荣誉
         *
         * @param: [honorId]
         * @return: com.xsl.result.XslResult
         * @auther: 11432_000
         * @date: 2019/5/9 17:33
         */
        try {
            XslMatchHonorExample xslMatchHonorExample = new XslMatchHonorExample();
            xslMatchHonorExample.createCriteria().andHonoridEqualTo(honorId);
            XslMatchHonor xslMatchHonor =  new XslMatchHonor();
            xslMatchHonor.setHonorstate(HonorStatesEnum.DELETE.getCode());
            int i = xslMatchHonorMapper.updateByExampleSelective(xslMatchHonor, xslMatchHonorExample);
            if (i <= 0){
                return ResultUtils.error("删除荣誉失败");
            }
            return ResultUtils.ok();
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public XslResult updateHonorByUser(XslMatchHonor xslMatchHonor) throws RuntimeException {
        /**
         *
         * 功能描述: 用户更新荣誉
         *
         * @param: [xslMatchHonor]
         * @return: com.xsl.result.XslResult
         * @auther: 11432_000
         * @date: 2019/5/9 17:39
         */
        try {
            XslMatchHonorExample xslMatchHonorExample = new XslMatchHonorExample();
            xslMatchHonorExample.createCriteria().andHonoridEqualTo(xslMatchHonor.getHonorid());
            xslMatchHonor.setHonorid(null);
            xslMatchHonor.setHunterid(null);
            xslMatchHonor.setHonorstate(HonorStatesEnum.UNAUDITED.getCode());
            int i = xslMatchHonorMapper.updateByExampleSelective(xslMatchHonor, xslMatchHonorExample);
            if (i <= 0){
                return ResultUtils.error("更新荣誉失败");
            }
            return ResultUtils.ok();
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public XslResult updateHonorByManager(XslMatchHonor xslMatchHonor) throws RuntimeException {
        /**
         *
         * 功能描述: 管理员更改荣誉
         *
         * @param: [xslMatchHonor]
         * @return: com.xsl.result.XslResult
         * @auther: 11432_000
         * @date: 2019/5/9 17:43
         */
        try {
            XslMatchHonorExample xslMatchHonorExample = new XslMatchHonorExample();
            xslMatchHonorExample.createCriteria().andHonoridEqualTo(xslMatchHonor.getHonorid());
            XslMatchHonor updateHonor =  new XslMatchHonor();
            updateHonor.setHonorstate(xslMatchHonor.getHonorstate());
            int i = xslMatchHonorMapper.updateByExampleSelective(updateHonor, xslMatchHonorExample);
            if (i <= 0){
                return ResultUtils.error("更新荣誉失败");
            }
            return ResultUtils.ok();
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<XslMatchHonor> getHonorByHunterId(String hunter,Integer... state) throws RuntimeException {
        /**
         *
         * 功能描述: 获取指定状态和用户的荣誉列表 state为null查询所有
         *
         * @param: [hunter, state]
         * @return: java.util.List<com.xsl.pojo.XslMatchHonor>
         * @auther: 11432_000
         * @date: 2019/5/9 17:52
         */
        try {
            XslMatchHonorExample xslMatchHonorExample = new XslMatchHonorExample();
            XslMatchHonorExample.Criteria criteria = xslMatchHonorExample.createCriteria();
            if (state != null){
                criteria.andHonorstateIn(Arrays.asList(state));
            }
            criteria.andHunteridEqualTo(hunter);
            List<XslMatchHonor> xslMatchHonors = xslMatchHonorMapper.selectByExample(xslMatchHonorExample);
            return xslMatchHonors;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<XslMatchHonor> getHonorByState(Integer... state) throws RuntimeException {
        /**
         *
         * 功能描述: 获取指定状态的荣誉列表
         *
         * @param: [state]
         * @return: java.util.List<com.xsl.pojo.XslMatchHonor>
         * @auther: 11432_000
         * @date: 2019/5/9 18:09
         */
        try {
            XslMatchHonorExample xslMatchHonorExample = new XslMatchHonorExample();
            XslMatchHonorExample.Criteria criteria = xslMatchHonorExample.createCriteria();
            if (state != null){
                criteria.andHonorstateIn(Arrays.asList(state));
            }
            criteria.andHonorstateNotEqualTo(HonorStatesEnum.DELETE.getCode());
            List<XslMatchHonor> xslMatchHonors = xslMatchHonorMapper.selectByExample(xslMatchHonorExample);
            return xslMatchHonors;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
