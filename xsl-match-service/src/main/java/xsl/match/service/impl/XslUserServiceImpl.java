package xsl.match.service.impl;

import com.xsl.Utils.IdUtils;
import com.xsl.Utils.JsonUtils;
import com.xsl.Utils.Md5Utils;
import com.xsl.Utils.ResultUtils;
import com.xsl.enums.UserStateEnum;
import com.xsl.pojo.*;
import com.xsl.pojo.Example.*;
import com.xsl.pojo.Vo.UserReqVo;
import com.xsl.pojo.Vo.UserResVo;
import com.xsl.pojo.Vo.XslUserRegister;
import com.xsl.result.XslResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import xsl.match.mapper.*;
import xsl.match.service.XslUserService;

import java.util.List;

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
    XslUserMapper xslUserMapper;
    @Autowired
    XslMatchUserMapper xslMatchUserMapper;
    @Autowired
    XslUserFileMapper xslUserFileMapper;
    @Autowired
    XslFileMapper xslFileMapper;
    @Autowired
    XslSchoolinfoMapper xslSchoolinfoMapper;

    private static final Logger LOGGER = LoggerFactory.getLogger(XslUserServiceImpl.class);


    @Value("${MATCH_HUNTER_PREFIX}")
    private String MATCH_HUNTER_PREFIX;
    @Value("${MATCH_TAG_PREFIX}")
    private String MATCH_TAG_PREFIX;


    @Override
    public XslResult getUserByEmail(String email) throws RuntimeException {
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
                return ResultUtils.isParameterError();
            }
            return ResultUtils.isOk(xslUsers.get(0));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    @Override
    public XslResult getUserByPhone(String phone) throws RuntimeException {
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
                return ResultUtils.isParameterError();
            }
            return ResultUtils.isOk(xslUsers.get(0));
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
        if(list != null && list.size() > 0){
            return ResultUtils.isParameterError("该手机号已经注册过");
        }

        XslUser xslUser = new XslUser();
        xslUser.setUserid(IdUtils.getUuid(""));
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

        return ResultUtils.isOk(userResVo);

    }

    /** 初始化 比赛用户 信息  */
    private XslMatchUser initXslHunter(XslUser xslUser) {
        XslMatchUser xslHunter = new XslMatchUser();
        xslHunter.setUserid(xslUser.getUserid());
        xslHunter.setHunterid(IdUtils.getUuid(MATCH_HUNTER_PREFIX));
        xslHunter.setLevel((short) 1);
        try {
            int result = xslMatchUserMapper.insertSelective(xslHunter);
            if (result < 1){
                throw new RuntimeException("猎人信息插入失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("服务器异常");
        }
        return xslHunter;
    }

    /** 初始化用户信息 */
    private void initUserInfo(XslUserRegister xslUserRegister, XslUser xslUser, XslMatchUser xslHunter) {
        String hunterid = xslHunter.getHunterid();
        hunterid = hunterid.replaceFirst(MATCH_HUNTER_PREFIX,"");
        xslUser.setHunterid(hunterid);
        xslUser.setPhone(xslUserRegister.getPhone());
        xslUser.setState(UserStateEnum.NA.getCode());
        xslUser.setPassword(Md5Utils.digestMds(xslUserRegister.getPassword()));
        xslUser.setSex("男");
        xslUser.setName("xsl_"+xslUserRegister.getPhone());

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
            return ResultUtils.isParameterError("手机号码为空");
        }

        if(StringUtils.isEmpty(password)){
            return ResultUtils.isParameterError("密码为空");
        }

        //1.查询
        XslUserExample example = new XslUserExample();
        XslUserExample.Criteria criteria = example.createCriteria();
        criteria.andPhoneEqualTo(phone);
        List<XslUser> list = xslUserMapper.selectByExample(example);

        //2.判断用户是否存在
        if(list == null || list.size() < 1){
            return ResultUtils.isParameterError("用户名或密码错误");
        }
        XslUser user = list.get(0);
        user.setHunterid(MATCH_HUNTER_PREFIX + user.getHunterid());

        UserResVo resVo = new UserResVo();
        BeanUtils.copyProperties(user, resVo);
        resVo.setUserid(user.getUserid());

        //3.校验密码
        if (Md5Utils.digestMds(password).equals(user.getPassword())) {
            LOGGER.info("password error");
            return ResultUtils.isParameterError("用户名或密码错误");
        }

        String userId = user.getUserid();

        //4.判断用户异常状态
        Byte state = user.getState();

        if(state == -1){
            LOGGER.info("login check status is {}", user.getState());
            return ResultUtils.isParameterError("用户被冻结");
        }

        if(state == -3){
            LOGGER.info("login check status is {}", user.getState());
            return ResultUtils.isParameterError("用户不存在");
        }

        //5.查询图片信息
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

        resVo.setTxUrl(imgUrl);

        //6.查询雇主信息和猎人信息
        XslMatchUserExample xslMatchUserExample = new XslMatchUserExample();
        XslMatchUserExample.Criteria criteria1 = xslMatchUserExample.createCriteria();
        criteria1.andUseridEqualTo(userId);


        List<XslMatchUser> xslHunters = xslMatchUserMapper.selectByExample(xslMatchUserExample);
        resVo.setHunterid(MATCH_HUNTER_PREFIX + xslHunters.get(0).getHunterid());
        resVo.setHunterlevel(xslHunters.get(0).getLevel());

        //7.获取学校信息
        if(!StringUtils.isEmpty(user.getSchoolinfo())){
            XslSchoolinfoExample xslSchoolinfoExample = new XslSchoolinfoExample();
            XslSchoolinfoExample.Criteria criteria4 = xslSchoolinfoExample.createCriteria();
            criteria4.andSchoolidEqualTo(user.getSchoolinfo());
            List<XslSchoolinfo> xslSchoolinfos = xslSchoolinfoMapper.selectByExample(xslSchoolinfoExample);
            BeanUtils.copyProperties(xslSchoolinfos.get(0), resVo);
        }

        //将用户信息加入缓存
//        jedisClient.set(REDIS_USER_SESSION_KEY + ":" + user.getPhone(), token);
//
//        Gson gson = GsonSingle.getGson();
//        String userInfo = gson.toJson(user);
//        JedisClientUtil.setEx(USER_INFO + ":" + user.getUserid(), userInfo, 300);
//
//        logger.info("login return message is {}", JsonUtils.objectToJson(resVo));

        return ResultUtils.isOk(JsonUtils.objectToJson(resVo));
    }

}
