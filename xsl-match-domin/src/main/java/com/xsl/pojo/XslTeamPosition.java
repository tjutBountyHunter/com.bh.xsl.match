package com.xsl.pojo;

import java.util.Date;

public class XslTeamPosition {
    private Integer id;

    private String positionid;

    private String teamid;

    private String positionname;

    private String positioninfo;

    private String positionrequirements;

    private Integer positionstate;

    private Date positioncreatetime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getPositionname() {
        return positionname;
    }

    public void setPositionname(String positionname) {
        this.positionname = positionname == null ? null : positionname.trim();
    }

    public String getPositioninfo() {
        return positioninfo;
    }

    public void setPositioninfo(String positioninfo) {
        this.positioninfo = positioninfo == null ? null : positioninfo.trim();
    }

    public String getPositionrequirements() {
        return positionrequirements;
    }

    public void setPositionrequirements(String positionrequirements) {
        this.positionrequirements = positionrequirements == null ? null : positionrequirements.trim();
    }

    public Integer getPositionstate() {
        return positionstate;
    }

    public void setPositionstate(Integer positionstate) {
        this.positionstate = positionstate;
    }

    public Date getPositioncreatetime() {
        return positioncreatetime;
    }

    public void setPositioncreatetime(Date positioncreatetime) {
        this.positioncreatetime = positioncreatetime;
    }
}