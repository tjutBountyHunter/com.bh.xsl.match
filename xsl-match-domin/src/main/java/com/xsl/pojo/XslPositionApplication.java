package com.xsl.pojo;

import java.io.Serializable;
import java.util.Date;

public class XslPositionApplication implements Serializable {
    private Integer id;

    private String hunterid;

    private String positionid;

    private String teamid;

    private Integer applicationstate;

    private Date applicationtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHunterid() {
        return hunterid;
    }

    public void setHunterid(String hunterid) {
        this.hunterid = hunterid == null ? null : hunterid.trim();
    }

    public String getPositionid() {
        return positionid;
    }

    public void setPositionid(String positionid) {
        this.positionid = positionid == null ? null : positionid.trim();
    }

    public String getTeamid() {
        return teamid;
    }

    public void setTeamid(String teamid) {
        this.teamid = teamid == null ? null : teamid.trim();
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