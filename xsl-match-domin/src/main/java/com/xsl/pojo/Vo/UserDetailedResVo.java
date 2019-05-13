package com.xsl.pojo.Vo;

import com.xsl.pojo.XslMatch;
import com.xsl.pojo.XslMatchHonor;

import java.util.Date;
import java.util.List;

/**
 * 说明：用户详细信息
 *
 * @Auther: 11432_000
 * @Date: 2019/5/9 15:50
 * @Description:
 */
public class UserDetailedResVo {
    private String userid;

    private String hunterid;

    private String schoolinfo;

    private String name;

    private String sex;

    private String phone;

    private String email;

    private String signature;

    private String matchtypeid;

    private Boolean isrecommend;

    private Date lasttime;

    private String selfassessment;

    private List<XslMatchHonor> honors;

    private List<HunterTagResVo> tags;


    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getHunterid() {
        return hunterid;
    }

    public void setHunterid(String hunterid) {
        this.hunterid = hunterid;
    }

    public String getSchoolinfo() {
        return schoolinfo;
    }

    public void setSchoolinfo(String schoolinfo) {
        this.schoolinfo = schoolinfo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getMatchtypeid() {
        return matchtypeid;
    }

    public void setMatchtypeid(String matchtypeid) {
        this.matchtypeid = matchtypeid;
    }

    public Boolean getIsrecommend() {
        return isrecommend;
    }

    public void setIsrecommend(Boolean isrecommend) {
        this.isrecommend = isrecommend;
    }

    public Date getLasttime() {
        return lasttime;
    }

    public void setLasttime(Date lasttime) {
        this.lasttime = lasttime;
    }

    public String getSelfassessment() {
        return selfassessment;
    }

    public void setSelfassessment(String selfassessment) {
        this.selfassessment = selfassessment;
    }

    public List<XslMatchHonor> getHonors() {
        return honors;
    }

    public void setHonors(List<XslMatchHonor> honors) {
        this.honors = honors;
    }

    public List<HunterTagResVo> getTags() {
        return tags;
    }

    public void setTags(List<HunterTagResVo> tags) {
        this.tags = tags;
    }
}
