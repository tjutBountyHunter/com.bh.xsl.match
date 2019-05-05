package xsl.match.service.impl;

import com.xsl.Utils.IdUtils;
import com.xsl.Utils.ResultUtils;
import com.xsl.enums.DataStates;
import com.xsl.pojo.Example.XslMatchUserExample;
import com.xsl.pojo.XslMatchUser;
import com.xsl.result.XslResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import xsl.match.mapper.XslMatchUserMapper;
import xsl.match.service.XslMatchUserService;

import java.util.List;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2019/5/5 11:51
 * @Description:
 */
@Service
public class XslMatchUserServiceImpl implements XslMatchUserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(XslMatchUserServiceImpl.class);

    @Autowired
    XslMatchUserMapper xslMatchUserMapper;
    @Value("${MATCH_HUNTER_PREFIX}")
    private String MATCH_HUNTER_PREFIX;

    @Override
    public XslResult updateMatchUserInfo(XslMatchUser xslMatchUser) throws RuntimeException {
        try {
            XslMatchUser updateUser = new XslMatchUser();
            if (!StringUtils.isEmpty(xslMatchUser.getMatchtypeid())){
                updateUser.setMatchtypeid(xslMatchUser.getMatchtypeid());
            }
            if (xslMatchUser.getIsrecommend() != null){
                updateUser.setIsrecommend(xslMatchUser.getIsrecommend());
            }
            if (!StringUtils.isEmpty(xslMatchUser.getSelfassessment())){
                updateUser.setSelfassessment(xslMatchUser.getSelfassessment());
            }
            boolean b = updateMatchUser(updateUser);
            if(!b){
                return ResultUtils.isError();
            }
            return ResultUtils.isOk();
        } catch (RuntimeException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public XslResult addMatchUserInfo(XslMatchUser xslMatchUser) throws RuntimeException {
        /**
         *
         * 功能描述: 添加用户补充信息
         *
         * @param: [xslMatchUser]
         * @return: com.xsl.result.XslResult
         * @auther: 11432_000
         * @date: 2019/5/5 13:09
         */
        try {
            String uuid = IdUtils.getUuid(MATCH_HUNTER_PREFIX);
            xslMatchUser.setHunterid(uuid);
            xslMatchUser.setState(DataStates.NORMAL.getCode());
            xslMatchUser.setLevel((short)1);
            xslMatchUser.setCredit((short)100);
            int i = xslMatchUserMapper.insertSelective(xslMatchUser);
            if (i <= 0){
                return ResultUtils.isError();
            }
            return ResultUtils.isOk();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public XslResult selectMatchUserInfoByUserId(String userId) throws RuntimeException {
        /**
         *
         * 功能描述: 根据userId查询用户补充信息
         *
         * @param: [userId]
         * @return: com.xsl.result.XslResult
         * @auther: 11432_000
         * @date: 2019/5/5 13:20
         */
        try {
            XslMatchUserExample xslMatchUserExample = new XslMatchUserExample();
            xslMatchUserExample.createCriteria().andUseridEqualTo(userId);

            List<XslMatchUser> xslMatchUsers = xslMatchUserMapper.selectByExample(xslMatchUserExample);
            return ResultUtils.isOk(xslMatchUsers.get(0));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public XslResult selectMatchUserInfoByHunterId(String hunterId) throws RuntimeException {
        try {
            XslMatchUserExample xslMatchUserExample = new XslMatchUserExample();
            xslMatchUserExample.createCriteria().andHunteridEqualTo(hunterId);

            List<XslMatchUser> xslMatchUsers = xslMatchUserMapper.selectByExample(xslMatchUserExample);
            return ResultUtils.isOk(xslMatchUsers.get(0));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public boolean updateMatchUser(XslMatchUser xslMatchUser)throws RuntimeException{
        /**
         *
         * 功能描述: 更新用户补充信息
         *
         * @param: [xslMatchUser]
         * @return: boolean
         * @auther: 11432_000
         * @date: 2019/5/5 11:44
         */
        try {
            XslMatchUserExample xslMatchUserExample = new XslMatchUserExample();
            int i = xslMatchUserMapper.updateByExampleSelective(xslMatchUser, xslMatchUserExample);
            if (i <= 0){
                return false;
            }
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
