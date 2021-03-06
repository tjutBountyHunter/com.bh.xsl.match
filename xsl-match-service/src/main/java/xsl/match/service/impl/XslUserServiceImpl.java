package xsl.match.service.impl;

import com.xsl.Utils.*;
import com.xsl.annotation.CharSet;
import com.xsl.annotation.UpdateUser;
import com.xsl.enums.HonorStatesEnum;
import com.xsl.enums.UserStateEnum;
import com.xsl.pojo.*;
import com.xsl.pojo.Example.*;
import com.xsl.pojo.Vo.*;
import com.xsl.result.XslResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.util.PatternMatchUtils;
import org.springframework.util.StringUtils;
import xsl.match.mapper.*;
import xsl.match.service.*;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2019/4/27 15:12
 * @Description:
 */
@Service
public class XslUserServiceImpl implements XslUserService {

    @Autowired
    private XslUserMapper xslUserMapper;
    @Autowired
    private XslUserFileMapper xslUserFileMapper;
    @Autowired
    private XslFileMapper xslFileMapper;
    @Autowired
    private XslSchoolinfoMapper xslSchoolinfoMapper;
    @Autowired
    private XslMatchUserService xslMatchUserService;
    @Autowired
    private XslMemberService xslMemberService;
    @Autowired
    private PhoneAuthentication phoneAuthentication;

    private static final Logger LOGGER = LoggerFactory.getLogger(XslUserServiceImpl.class);
    @Value("${USER_DEFAULT_SIGNATURE}")
    private String USER_DEFAULT_SIGNATURE;
    @Value("${REDIS_USER_SESSION_KEY}")
    private String REDIS_USER_SESSION_KEY;
    @Value("${MATCH_HUNTER_PREFIX}")
    private String MATCH_HUNTER_PREFIX;
    @Value("${MATCH_TAG_PREFIX}")
    private String MATCH_TAG_PREFIX;
    @Value("${USER_SCHOOL_LIST}")
    private String USER_SCHOOL_LIST;
    @Value("${USER_SCHOOL_INFO}")
    private String USER_SCHOOL_INFO;
    @Value("${USER_SCHOOL_REGION}")
    private String USER_SCHOOL_REGION;
    @Value("${USER_DETAILED_INFO}")
    private String USER_DETAILED_INFO;
    @Value("${USER_INFO_LIFETIME}")
    private Integer USER_INFO_LIFETIME;

    @Override
    public XslUser getUserByEmail(String email) throws RuntimeException {
        /**
         *
         * 功能描述: 根据邮箱获取用户信息
         *
         * @param: [email]
         * @return: com.xsl.result.XslResult
         * @auther: 11432_000
         * @date: 2019/4/27 15:16
         */
        try {
            XslUserExample xslUserExample =  new XslUserExample();
            XslUserExample.Criteria criteria = xslUserExample.createCriteria();
            criteria.andEmailEqualTo(email);
            List<XslUser> xslUsers = xslUserMapper.selectByExample(xslUserExample);
            if (xslUsers == null || xslUsers.size() == 0){
                throw new RuntimeException("用户不存在");
            }
            return (xslUsers.get(0));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    @Override
    public XslUser getUserByPhone(String phone) throws RuntimeException {
        /**
         *
         * 功能描述: 根据手机号获取用户信息
         *
         * @param: [phone]
         * @return: com.xsl.result.XslResult
         * @auther: 11432_000
         * @date: 2019/4/27 15:17
         */
        try {
            XslUserExample xslUserExample =  new XslUserExample();
            XslUserExample.Criteria criteria = xslUserExample.createCriteria();
            criteria.andPhoneEqualTo(phone);
            List<XslUser> xslUsers = xslUserMapper.selectByExample(xslUserExample);
            if (xslUsers == null || xslUsers.size() == 0){
                throw new RuntimeException("用户不存在");
            }
            return (xslUsers.get(0));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }


    @Override
    public XslUser getUserByUserId(String userId) throws RuntimeException {
        /**
         *
         * 功能描述: 根据 userId 获取用户信息
         *
         * @param: [userId]
         * @return: com.xsl.result.XslResult
         * @auther: 11432_000
         * @date: 2019/5/4 14:54
         */
        try {
            XslUserExample xslUserExample =  new XslUserExample();
            XslUserExample.Criteria criteria = xslUserExample.createCriteria();
            criteria.andUseridEqualTo(userId);
            List<XslUser> xslUsers = xslUserMapper.selectByExample(xslUserExample);
            if (xslUsers == null || xslUsers.size() == 0){
                throw new RuntimeException("用户不存在");
            }
            return (xslUsers.get(0));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public XslUser getUserByHunterId(String hunterId) throws RuntimeException {
        /**
         *
         * 功能描述: 根据 hunterId 获取用户信息
         *
         * @param: [hunterId]
         * @return: com.xsl.result.XslResult
         * @auther: 11432_000
         * @date: 2019/5/4 14:57
         */
        try {
            XslUserExample xslUserExample =  new XslUserExample();
            XslUserExample.Criteria criteria = xslUserExample.createCriteria();
            criteria.andHunteridEqualTo(hunterId);
            List<XslUser> xslUsers = xslUserMapper.selectByExample(xslUserExample);
            if (xslUsers == null || xslUsers.size() == 0){
                throw new RuntimeException("用户不存在");
            }
            return (xslUsers.get(0));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    @CharSet
    public List<XslSchool> getSchoolList(String region) throws RuntimeException {
        /**
         *
         * 功能描述: 获取某地区的学校
         *
         * @param: [region]
         * @return: com.xsl.result.XslResult
         * @auther: 11432_000
         * @date: 2019/5/4 20:05
         */
        try {
            String json;
            if (StringUtils.isEmpty(region)){
                json = JedisUtils.get(USER_SCHOOL_LIST);
            }else {
                json = JedisUtils.get(USER_SCHOOL_LIST + ":" + region);
            }
            List<XslSchool> xslSchoolList = JsonUtils.jsonToList(json,XslSchool.class);
            return (xslSchoolList);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<String> getRegionList() throws RuntimeException {
        /**
         *
         * 功能描述: 获取所有地区
         *
         * @param: []
         * @return: com.xsl.result.XslResult
         * @auther: 11432_000
         * @date: 2019/5/4 21:36
         */
        try {
            String json = JedisUtils.get(USER_SCHOOL_REGION);
            List<String> list = JsonUtils.jsonToList(json, String.class);
            return (list);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }



    /**
     * 快速注册
     *
     * @return
     */
    @Override
    public XslResult quickCreateUser(XslUserRegister xslUserRegister) {
        XslUserExample example = new XslUserExample();
        XslUserExample.Criteria criteria = example.createCriteria();
        criteria.andPhoneEqualTo(xslUserRegister.getPhone());
        List<XslUser> list = xslUserMapper.selectByExample(example);
        //验证码校验
        if (ResultUtils.isSuccess(phoneAuthentication.checkVerificationCode(xslUserRegister.getPhone(),xslUserRegister.getCode()))){
            return ResultUtils.parameterError("验证码不正确！");
        }
        if(list != null && list.size() > 0){
            return ResultUtils.parameterError("该手机号已经注册过");
        }
        XslUser xslUser = new XslUser();
        xslUser.setUserid(IdUtils.getUuid("MT:"));
        //初始化猎人信息
        XslMatchUser xslMatchUser = initXslHunter(xslUser);
        //初始化用户信息
        initUserInfo(xslUserRegister, xslUser, xslMatchUser);

        UserResVo userResVo = new UserResVo();
        BeanUtils.copyProperties(xslUser, userResVo);
        userResVo.setUserid(xslUser.getUserid());
        userResVo.setHunterid(xslMatchUser.getHunterid());
        userResVo.setHunterlevel(xslMatchUser.getLevel());
        userResVo.setTxUrl("http://47.93.200.190/images/default.png");
        //将设备码存入缓存
        setPushId(xslUserRegister.getPhone(),xslUserRegister.getToken());
        return ResultUtils.ok(userResVo);
    }

    /** 初始化 比赛用户 信息  */
    private XslMatchUser initXslHunter(XslUser xslUser) {
        XslMatchUser xslHunter = new XslMatchUser();
        xslHunter.setUserid(xslUser.getUserid());
        try {
            XslResult xslResult = xslMatchUserService.addMatchUserInfo(xslHunter);
            if (!ResultUtils.isSuccess(xslResult)){
                throw new RuntimeException("添加补充信息异常");
            }
        }catch (Exception e){
            throw new RuntimeException("服务器异常" + e.getMessage());
        }
        return xslHunter;
    }

    /** 初始化用户信息 */
    private void initUserInfo(XslUserRegister xslUserRegister, XslUser xslUser, XslMatchUser xslHunter) {
        String hunterid = xslHunter.getHunterid();
        hunterid = hunterid.replaceFirst(MATCH_HUNTER_PREFIX,"");
        xslUser.setHunterid(hunterid);
        xslUser.setPhone(xslUserRegister.getPhone());
        xslUser.setState(UserStateEnum.NORMAL.getCode());
        xslUser.setPassword(Md5Utils.digestMds(xslUserRegister.getPassword()));
        xslUser.setSex("男");
        xslUser.setName("xsl_"+xslUserRegister.getPhone());
        xslUser.setSignature(USER_DEFAULT_SIGNATURE);
        try {
            int result = xslUserMapper.insertSelective(xslUser);

            if (result < 1){
                throw new RuntimeException("用户信息插入失败");
            }

        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("服务器异常");
        }
    }



    /**
     * 登录
     *
     * @param userReqVo
     * @return
     */
    @Override
    public XslResult userLogin(UserReqVo userReqVo) {
        String phone = userReqVo.getPhone();
        String password = userReqVo.getPassword();
        String token = userReqVo.getToken();

        if(StringUtils.isEmpty(phone)){
            return ResultUtils.parameterError("手机号码为空");
        }

        if(StringUtils.isEmpty(password)){
            return ResultUtils.parameterError("密码为空");
        }

        //1.查询
        XslUserExample example = new XslUserExample();
        XslUserExample.Criteria criteria = example.createCriteria();
        criteria.andPhoneEqualTo(phone);
        List<XslUser> list = xslUserMapper.selectByExample(example);

        //2.判断用户是否存在
        if(list == null || list.size() < 1){
            return ResultUtils.parameterError("用户名或密码错误");
        }
        XslUser user = list.get(0);
        user.setHunterid(MATCH_HUNTER_PREFIX + user.getHunterid());

        UserResVo resVo = new UserResVo();
        BeanUtils.copyProperties(user, resVo);
        resVo.setUserid(user.getUserid());

        //3.校验密码
        if (!Md5Utils.digestMds(password).equals(user.getPassword())) {
            LOGGER.info("password error");
            return ResultUtils.parameterError("用户名或密码错误");
        }

        String userId = user.getUserid();

        //4.判断用户异常状态
        Byte state = user.getState();

        if(state == -1){
            LOGGER.info("login check status is {}", user.getState());
            return ResultUtils.parameterError("用户被冻结");
        }

        if(state == -3){
            LOGGER.info("login check status is {}", user.getState());
            return ResultUtils.parameterError("用户不存在");
        }

        //5.查询图片信息
        String imgUrl = getTx(userId);

        resVo.setTxUrl(imgUrl);
        if (StringUtils.isEmpty(resVo.getSignature())){
            resVo.setSignature(USER_DEFAULT_SIGNATURE);
        }

        //6.查询猎人信息
        XslMatchUserExample xslMatchUserExample = new XslMatchUserExample();
        XslMatchUserExample.Criteria criteria1 = xslMatchUserExample.createCriteria();
        criteria1.andUseridEqualTo(userId);
        XslMatchUser xslMatchUser = xslMatchUserService.selectMatchUserInfoByUserId(userId);
        resVo.setHunterid(xslMatchUser.getHunterid());
        resVo.setHunterlevel(xslMatchUser.getLevel());

        //7.获取学校信息
        if(!StringUtils.isEmpty(user.getSchoolinfo())){
            XslSchoolinfoExample xslSchoolinfoExample = new XslSchoolinfoExample();
            XslSchoolinfoExample.Criteria criteria4 = xslSchoolinfoExample.createCriteria();
            criteria4.andSchoolidEqualTo(user.getSchoolinfo());
            List<XslSchoolinfo> xslSchoolinfos = xslSchoolinfoMapper.selectByExample(xslSchoolinfoExample);
            BeanUtils.copyProperties(xslSchoolinfos.get(0), resVo);
        }
        //检查是否有队伍信息
        XslTeamMember memberByHunterId = xslMemberService.getMemberByHunterId(xslMatchUser.getHunterid());
        if (org.apache.commons.lang3.StringUtils.isNotBlank(memberByHunterId.getTeamid())){
            resVo.setTeamId(memberByHunterId.getTeamid());
        }
        setPushId(phone,token);
        //将用户信息加入缓存
//        jedisClient.set(REDIS_USER_SESSION_KEY + ":" + user.getPhone(), token);
//        Gson gson = GsonSingle.getGson();
//        String userInfo = gson.toJson(user);
//        JedisClientUtil.setEx(USER_INFO + ":" + user.getUserid(), userInfo, 300);
//        logger.info("login return message is {}", JsonUtils.objectToJson(resVo));
        return ResultUtils.ok(JsonUtils.objectToJson(resVo));
    }

    /** 根据userID 获取头像 */
    public String getTx(String userId){
        String imgUrl = "http://47.93.200.190/images/default.png";
        XslUserFileExample xslUserFileExample = new XslUserFileExample();
        XslUserFileExample.Criteria criteria2 = xslUserFileExample.createCriteria();
        criteria2.andUseridEqualTo(userId);
        criteria2.andTypeEqualTo("TX");
        List<XslUserFile> xslUserFiles = xslUserFileMapper.selectByExample(xslUserFileExample);
        if(xslUserFiles != null && xslUserFiles.size() > 0){
            XslFileExample xslFileExample = new XslFileExample();
            XslFileExample.Criteria criteria1 = xslFileExample.createCriteria();
            criteria1.andFileidEqualTo(xslUserFiles.get(0).getFileid());
            List<XslFile> xslFileList = xslFileMapper.selectByExample(xslFileExample);
            if (xslFileList != null && xslFileList.size() > 0) {
                imgUrl = xslFileList.get(0).getUrl();
            }
        }
        return imgUrl;
    }

    @Override
    @UpdateUser
    public XslResult updateUserInfo(String hunterId,UserSupplementVo userInfo) throws RuntimeException {
        /**
         *
         * 功能描述: 更新用户信息 + 学校信息
         *
         * @param: [xslUser]
         * @return: com.xsl.result.XslResult
         * @auther: 11432_000
         * @date: 2019/5/4 10:12
         */
        if (userInfo == null){
            return ResultUtils.parameterError("参数为空");
        }
        try {
            XslUserExample xslUserExample = new XslUserExample();
            XslUserExample.Criteria criteria = xslUserExample.createCriteria();
            criteria.andUseridEqualTo(userInfo.getUserid());
            //校验用户是否存在
            List<XslUser> xslUsers = xslUserMapper.selectByExample(xslUserExample);
            if (xslUsers == null || xslUsers.size() <= 0){
                LOGGER.error("用户不存在");
                return ResultUtils.parameterError("用户不存在");
            }
            XslUser xslUser = xslUsers.get(0);
            //清除不可更改属性
            XslUser updateUserInfo = new XslUser();
            BeanUtils.copyProperties(userInfo,updateUserInfo);
            XslUser updateUser = getUpdateUser(updateUserInfo);
            //检查是否已存在学校信息
            XslSchoolinfo schoolInfo = getSchoolInfo(xslUser.getSchoolinfo());
            if (StringUtils.isEmpty(schoolInfo.getSchoolid())){
                BeanUtils.copyProperties(userInfo,schoolInfo);
                XslResult xslResult = addSchoolInfo(schoolInfo);
                if (ResultUtils.isSuccess(xslResult)){
                    updateUser.setSchoolinfo(xslResult.getData().toString());
                }
            }


            int i = xslUserMapper.updateByExampleSelective(updateUser, xslUserExample);
            if (i <= 0) {
                return ResultUtils.error("");
            }
            return ResultUtils.ok();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    /** 获取用户详情 */
    public UserDetailedResVo getUserDetailedInfo(String id) throws RuntimeException {
        //优先取缓存
        if (id.startsWith(MATCH_HUNTER_PREFIX)){
            String json = JedisUtils.get(USER_SCHOOL_INFO + ":" + id);
            if (org.apache.commons.lang3.StringUtils.isNotBlank(json)){
                UserDetailedResVo userDetailedResVo = JsonUtils.jsonToPojo(json, UserDetailedResVo.class);
                JedisUtils.expire(USER_DETAILED_INFO + ":" + userDetailedResVo.getHunterid(),USER_INFO_LIFETIME);
                return userDetailedResVo;
            }
        }
        XslUserExample xslUserExample = new XslUserExample();
        XslUserExample.Criteria criteria = xslUserExample.createCriteria();
        //检查是什么Id
        if (!id.startsWith(MATCH_HUNTER_PREFIX)){
            criteria.andUseridEqualTo(id);
        }else {
            id = id.replaceFirst(MATCH_HUNTER_PREFIX,"");
            criteria.andHunteridEqualTo(id);
        }
        List<XslUser> xslUsers = xslUserMapper.selectByExample(xslUserExample);
        if (xslUsers.size() == 0){
            throw new RuntimeException("用户信息不存在");
        }
        //添加基本信息
        XslUser xslUser = xslUsers.get(0);
        String hunterId = MATCH_HUNTER_PREFIX + xslUser.getHunterid();
        UserDetailedResVo userDetailedResVo = new UserDetailedResVo();
        BeanUtils.copyProperties(xslUser,userDetailedResVo);
        //添加头像
        String tx = getTx(xslUser.getUserid());
        userDetailedResVo.setTxUrl(tx);
        //添加补充信息
        XslMatchUser xslMatchUser = xslMatchUserService.selectMatchUserInfoByHunterId(hunterId);
        BeanUtils.copyProperties(xslMatchUser,userDetailedResVo);
        // 添加标签
        List<HunterTagResVo> allTagsInfoByHunterId = xslMatchUserService.getAllTagsInfoByHunterId(xslMatchUser.getHunterid());
        userDetailedResVo.setTags(allTagsInfoByHunterId);
        //添加学校信息
        XslSchoolinfo schoolInfo = getSchoolInfo(xslUser.getSchoolinfo());
        BeanUtils.copyProperties(schoolInfo,userDetailedResVo);
        //添加缓存
        String toJson = JsonUtils.objectToJson(userDetailedResVo);
        JedisUtils.set(USER_DETAILED_INFO + ":" + userDetailedResVo.getHunterid(),toJson);
        JedisUtils.expire(USER_DETAILED_INFO + ":" + userDetailedResVo.getHunterid(),USER_INFO_LIFETIME);
        return userDetailedResVo;
    }

    /** 获取学校信息 */
    @Override
    public XslSchoolinfo getSchoolInfo(String schoolid) throws RuntimeException{
        if (org.apache.commons.lang3.StringUtils.isBlank(schoolid)){
            return new XslSchoolinfo();
        }
        String schoolInfo = JedisUtils.get(USER_SCHOOL_INFO + ":" + schoolid);

        if(!StringUtils.isEmpty(schoolInfo)){
            return JsonUtils.jsonToPojo(schoolInfo,XslSchoolinfo.class);
        }

        XslSchoolinfoExample xslSchoolinfoExample = new XslSchoolinfoExample();
        xslSchoolinfoExample.createCriteria().andSchoolidEqualTo(schoolid);
        List<XslSchoolinfo> xslUsers = xslSchoolinfoMapper.selectByExample(xslSchoolinfoExample);

        if(xslUsers != null && xslUsers.size() > 0){
            String info =  JsonUtils.objectToJson(xslUsers.get(0));
            JedisUtils.setEx(USER_SCHOOL_INFO + ":" + schoolid, info , 60 * 30);
            return xslUsers.get(0);
        }
        return new XslSchoolinfo();
    }

    /** 添加学校信息 */
    public XslResult addSchoolInfo(XslSchoolinfo xslSchoolinfo){
        try {
            String uuid = IdUtils.getUuid("MSI:");
            xslSchoolinfo.setSchoolid(uuid);
            int i = xslSchoolinfoMapper.insertSelective(xslSchoolinfo);
            if (i <= 0) {
                return ResultUtils.parameterError("参数错误");
            }
            return ResultUtils.ok(uuid);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    /** 设置user可更新属性  */
    public XslUser getUpdateUser(XslUser xslUser){
        XslUser newUser = new XslUser();
        if (!StringUtils.isEmpty(xslUser.getName())){
            newUser.setName(xslUser.getName());
        }
        if (!StringUtils.isEmpty(xslUser.getPassword())){
            newUser.setPassword(xslUser.getPassword());
        }
        if (!StringUtils.isEmpty(xslUser.getSignature())){
            newUser.setSignature(xslUser.getSignature());
        }
        if (!StringUtils.isEmpty(xslUser.getEmail())){
            newUser.setEmail(xslUser.getEmail());
        }
        if(!StringUtils.isEmpty(xslUser.getSex())){
            newUser.setSex(xslUser.getSex());
        }
        return newUser;
    }

    @Override
    public List<XslUser> getAllUser() throws RuntimeException {
        try {
            XslUserExample xslUserExample = new XslUserExample();
            xslUserExample.createCriteria().andStateEqualTo((byte)1);
            List<XslUser> xslUsers = xslUserMapper.selectByExample(xslUserExample);
            return xslUsers;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private void setPushId(String phone,String pushId){
        if (!StringUtils.isEmpty(pushId)){
            JedisUtils.set(REDIS_USER_SESSION_KEY + ":" + phone,pushId);
        }
    }
}
