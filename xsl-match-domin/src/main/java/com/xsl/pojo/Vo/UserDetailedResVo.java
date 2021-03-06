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

    /** 补充信息 */
    private String matchtypeid;

    private Boolean isrecommend;

    private Date lasttime;

    private String selfassessment;

    /** 头像信息 */
    private String txUrl;

    /** 学校信息 */
    private String sno;

    private String major;

    private String college;

    private String school;

    private String startdate;

    private Byte degree;

    private Byte schoolhours;

    /** 标签信息 */
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

//    public List<XslMatchHonor> getHonors() {
//        return honors;
//    }
//
//    public void setHonors(List<XslMatchHonor> honors) {
//        this.honors = honors;
//    }

    public List<HunterTagResVo> getTags() {
        return tags;
    }

    public void setTags(List<HunterTagResVo> tags) {
        this.tags = tags;
    }

    public String getTxUrl() {
        return txUrl;
    }

    public void setTxUrl(String txUrl) {
        this.txUrl = txUrl;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public Byte getDegree() {
        return degree;
    }

    public void setDegree(Byte degree) {
        this.degree = degree;
    }

    public Byte getSchoolhours() {
        return schoolhours;
    }

    public void setSchoolhours(Byte schoolhours) {
        this.schoolhours = schoolhours;
    }
}
