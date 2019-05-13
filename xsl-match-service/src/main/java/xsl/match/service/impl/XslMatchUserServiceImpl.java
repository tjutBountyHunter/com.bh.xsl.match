package xsl.match.service.impl;

import com.xsl.Utils.IdUtils;
import com.xsl.Utils.JedisUtils;
import com.xsl.Utils.JsonUtils;
import com.xsl.Utils.ResultUtils;
import com.xsl.annotation.UpdateHunterTag;
import com.xsl.enums.DataStates;
import com.xsl.pojo.*;
import com.xsl.pojo.Example.XslHunterTagExample;
import com.xsl.pojo.Example.XslMatchUserExample;
import com.xsl.pojo.Vo.HunterTagResVo;
import com.xsl.result.XslResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import xsl.match.mapper.XslHunterTagMapper;
import xsl.match.mapper.XslMatchUserMapper;
import xsl.match.service.XslMatchUserService;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarEntry;

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
    private XslMatchUserMapper xslMatchUserMapper;
    @Autowired
    private XslHunterTagMapper xslHunterTagMapper;
    @Value("${MATCH_HUNTER_PREFIX}")
    private String MATCH_HUNTER_PREFIX;
    @Value("${HUNTER_TAG_BUFFER}")
    private String HUNTER_TAG_BUFFER;
    @Value("${TAG_BUFFER}")
    private String TAG_BUFFER;

    @Override
    public XslResult updateMatchUserInfo(XslMatchUser xslMatchUser) throws RuntimeException {
        try {
            XslMatchUser updateUser = new XslMatchUser();
            updateUser.setHunterid(xslMatchUser.getHunterid());
            updateUser.setUserid(xslMatchUser.getUserid());
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
    public XslMatchUser selectMatchUserInfoByUserId(String userId) throws RuntimeException {
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
            if (xslMatchUsers == null || xslMatchUsers.size() == 0){
                throw new RuntimeException("用户不存在");
            }
            return xslMatchUsers.get(0);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public XslMatchUser selectMatchUserInfoByHunterId(String hunterId) throws RuntimeException {
        try {
            XslMatchUserExample xslMatchUserExample = new XslMatchUserExample();
            xslMatchUserExample.createCriteria().andHunteridEqualTo(hunterId);

            List<XslMatchUser> xslMatchUsers = xslMatchUserMapper.selectByExample(xslMatchUserExample);
            return xslMatchUsers.get(0);
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
            XslMatchUserExample.Criteria criteria = xslMatchUserExample.createCriteria();
            if (org.apache.commons.lang3.StringUtils.isNotBlank(xslMatchUser.getHunterid())){
                criteria.andHunteridEqualTo(xslMatchUser.getHunterid());
            }else {
                criteria.andUseridEqualTo(xslMatchUser.getUserid());
            }
            int i = xslMatchUserMapper.updateByExampleSelective(xslMatchUser, xslMatchUserExample);
            if (i <= 0){
                return false;
            }
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    @UpdateHunterTag
    public XslResult addHunterTag(String hunterId, String tagId) throws RuntimeException {
        /**
         *
         * 功能描述: 添加一个用户标签
         *
         * @param: [hunterId, tagId]
         * @return: com.xsl.result.XslResult
         * @auther: 11432_000
         * @date: 2019/5/7 14:22
         */
        try {
            XslHunterTag xslHunterTag =  new XslHunterTag();
            xslHunterTag.setHunterid(hunterId);
            xslHunterTag.setTagid(tagId);
            xslHunterTag.setState(true);
            int i = xslHunterTagMapper.insertSelective(xslHunterTag);
            if(i <= 0){
                return ResultUtils.isError("添加用户标签失败");
            }
            return ResultUtils.isOk();
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    @UpdateHunterTag
    public XslResult removeHunterTag(String hunterId, String tagId) throws RuntimeException {
        /**
         *
         * 功能描述: 删除一个用户标签
         *
         * @param: [hunterId, tagId]
         * @return: com.xsl.result.XslResult
         * @auther: 11432_000
         * @date: 2019/5/7 14:22
         */
        try {
            XslHunterTagExample xslHunterTagExample = new XslHunterTagExample();
            xslHunterTagExample.createCriteria().andHunteridEqualTo(hunterId).andTagidEqualTo(tagId);
            XslHunterTag xslHunterTag = new XslHunterTag();
            xslHunterTag.setState(false);
            int i = xslHunterTagMapper.updateByExampleSelective(xslHunterTag, xslHunterTagExample);
            if (i <= 0){
                return ResultUtils.isError("删除用户标签失败");
            }
            return ResultUtils.isOk();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<XslHunterTag> getAllTagsByHunterId(String hunterId) throws RuntimeException {
        /**
         *
         * 功能描述: 根据hunterId 获取用户标签
         *
         * @param: [hunterId]
         * @return: com.xsl.result.XslResult
         * @auther: 11432_000
         * @date: 2019/5/7 15:08
         */
        try {
            String json = JedisUtils.get(HUNTER_TAG_BUFFER + ":" + hunterId);
            List<XslHunterTag> xslHunterTags = JsonUtils.jsonToList(json, XslHunterTag.class);
            return (xslHunterTags);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<HunterTagResVo> getAllTagsInfoByHunterId(String hunterId) throws RuntimeException {
        /**
         *
         * 功能描述: 根据hunterId 获取用户标签 + 标签名
         *
         * @param: [hunterId]
         * @return: java.util.List<com.xsl.pojo.Vo.HunterTagResVo>
         * @auther: 11432_000
         * @date: 2019/5/9 14:50
         */
        try {
            List<XslHunterTag> allTagsByHunterId = getAllTagsByHunterId(hunterId);
            ArrayList<HunterTagResVo> hunterTagResVos = new ArrayList<>();
            HunterTagResVo hunterTagResVo;
            for (XslHunterTag xslHunterTag : allTagsByHunterId){
                hunterTagResVo = new HunterTagResVo();
                BeanUtils.copyProperties(xslHunterTag,hunterTagResVo);
                String json = JedisUtils.get(TAG_BUFFER + ":" + xslHunterTag.getTagid());
                XslTag xslTag = JsonUtils.jsonToPojo(json, XslTag.class);
                BeanUtils.copyProperties(xslTag,hunterTagResVo);
                hunterTagResVos.add(hunterTagResVo);
            }
            return hunterTagResVos;
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<XslHunterTag> getAllHuntersByTagId(String tagId) throws RuntimeException {
        /**
         *
         * 功能描述: 根据 tagId 获取所有用户
         *
         * @param: [tagId]
         * @return: com.xsl.result.XslResult
         * @auther: 11432_000
         * @date: 2019/5/7 15:21
         */
        try {
            List<XslHunterTag> huntersByTagId = xslHunterTagMapper.getHuntersByTagId(tagId);
            return (huntersByTagId);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    @UpdateHunterTag
    /** 更改用户标签 */
    public XslResult updateHunterTag(String hunterId,List<String> tagIds) throws RuntimeException {
        try {
            ArrayList<XslHunterTag> list = new ArrayList<>();
            for (String tagId : tagIds){
                XslHunterTag xslHunterTag = new XslHunterTag();
                xslHunterTag.setTagid(tagId);
                xslHunterTag.setHunterid(hunterId);
                list.add(xslHunterTag);
            }
            String json = JedisUtils.get(HUNTER_TAG_BUFFER + ":" + hunterId);
            //过滤已存在标签
            List<XslHunterTag> xslHunterTags = null;
            if (org.apache.commons.lang3.StringUtils.isNotBlank(json)){
                xslHunterTags = JsonUtils.jsonToList(json, XslHunterTag.class);
                for (XslHunterTag xslHunterTag : xslHunterTags){
                    int i = list.indexOf(xslHunterTag);
                    if (i != -1){
                        list.remove(i);
                        xslHunterTags.remove(xslHunterTag);
                    }
                }
                //删除不在使用的标签
                for (XslHunterTag xslHunterTag : xslHunterTags){
                    removeHunterTag(xslHunterTag.getHunterid(),xslHunterTag.getTagid());
                }
            }
            //添加增标签
            for (XslHunterTag xslHunterTag : list){
                addHunterTag(xslHunterTag.getHunterid(),xslHunterTag.getTagid());
            }
            return ResultUtils.isOk();
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
