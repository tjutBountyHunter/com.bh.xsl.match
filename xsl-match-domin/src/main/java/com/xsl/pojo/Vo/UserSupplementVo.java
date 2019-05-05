package com.xsl.pojo.Vo;

import java.io.Serializable;
/**
 *
 * 功能描述: 用户信息补充
 *
 * @param:
 * @return:
 * @auther: 11432_000
 * @date: 2019/5/4 10:34
 */
public class UserSupplementVo implements Serializable {
    private String userid;

    private String name;

    private String sex;

    private String email;

    private String signature;

    private String password;

    private String sno;

    private String major;

    private String college;

    private String school;

    private String startdate;

    private Byte degree;

    private Byte schoolhours;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
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

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
