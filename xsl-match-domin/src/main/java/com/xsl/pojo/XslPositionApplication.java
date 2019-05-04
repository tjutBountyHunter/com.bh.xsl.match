package com.xsl.pojo;

import java.util.Date;

public class XslPositionApplication {
    private Integer id;

    private String userid;

    private String teamid;

    private String positionid;

    private Integer applicationstate;

    private Date applicationtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getTeamid() {
        return teamid;
    }

    public void setTeamid(String teamid) {
        this.teamid = teamid == null ? null : teamid.trim();
    }

    public String getPositionid() {
        return positionid;
    }

    public void setPositionid(String positionid) {
        this.positionid = positionid == null ? null : positionid.trim();
    }

    public Integer getApplicationstate() {
        return applicationstate;
    }

    public void setApplicationstate(Integer applicationstate) {
        this.applicationstate = applicationstate;
    }

    public Date getApplicationtime() {
        return applicationtime;
    }

    public void setApplicationtime(Date applicationtime) {
        this.applicationtime = applicationtime;
    }
}