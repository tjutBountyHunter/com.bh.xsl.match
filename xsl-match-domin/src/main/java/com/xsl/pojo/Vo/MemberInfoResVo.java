package com.xsl.pojo.Vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 说明：职位信息 + 用户信息 + 成员信息
 *
 * @Auther: 11432_000
 * @Date: 2019/5/4 10:00
 * @Description:
 */
public class MemberInfoResVo implements Serializable {

    private String hunterid;

    private String name;

    private String sex;

    private String phone;

    private String email;

    private Byte state;

    private Date updatedate;



    private String memberid;

    private String positionid;

    private Integer memberstate;

    private Date memberjointime;


    private String teamid;

    private String positionname;

    private String positioninfo;

    private String positionrequirements;

    private Integer positionstate;


    public String getHunterid() {
        return hunterid;
    }

    public void setHunterid(String hunterid) {
        this.hunterid = hunterid;
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

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public Date getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }

    public String getMemberid() {
        return memberid;
    }

    public void setMemberid(String memberid) {
        this.memberid = memberid;
    }

    public String getPositionid() {
        return positionid;
    }

    public void setPositionid(String positionid) {
        this.positionid = positionid;
    }

    public Integer getMemberstate() {
        return memberstate;
    }

    public void setMemberstate(Integer memberstate) {
        this.memberstate = memberstate;
    }

    public Date getMemberjointime() {
        return memberjointime;
    }

    public void setMemberjointime(Date memberjointime) {
        this.memberjointime = memberjointime;
    }

    public String getTeamid() {
        return teamid;
    }

    public void setTeamid(String teamid) {
        this.teamid = teamid;
    }

    public String getPositionname() {
        return positionname;
    }

    public void setPositionname(String positionname) {
        this.positionname = positionname;
    }

    public String getPositioninfo() {
        return positioninfo;
    }

    public void setPositioninfo(String positioninfo) {
        this.positioninfo = positioninfo;
    }

    public String getPositionrequirements() {
        return positionrequirements;
    }

    public void setPositionrequirements(String positionrequirements) {
        this.positionrequirements = positionrequirements;
    }

    public Integer getPositionstate() {
        return positionstate;
    }

    public void setPositionstate(Integer positionstate) {
        this.positionstate = positionstate;
    }
}
