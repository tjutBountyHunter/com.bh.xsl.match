package com.xsl.pojo;

import java.io.Serializable;
import java.util.Date;

public class XslMatchTeam implements Serializable {
    private Integer id;

    private String teamid;

    private String matchid;

    private String teamname;

    private String teamsynopsis;

    private String teamcreatorid;

    private Date teamcreatetime;

    private Integer teamstate;

    private String teamslogan;

    private String teamlogourl;

    private Boolean isedit;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTeamid() {
        return teamid;
    }

    public void setTeamid(String teamid) {
        this.teamid = teamid == null ? null : teamid.trim();
    }

    public String getMatchid() {
        return matchid;
    }

    public void setMatchid(String matchid) {
        this.matchid = matchid == null ? null : matchid.trim();
    }

    public String getTeamname() {
        return teamname;
    }

    public void setTeamname(String teamname) {
        this.teamname = teamname == null ? null : teamname.trim();
    }

    public String getTeamsynopsis() {
        return teamsynopsis;
    }

    public void setTeamsynopsis(String teamsynopsis) {
        this.teamsynopsis = teamsynopsis == null ? null : teamsynopsis.trim();
    }

    public String getTeamcreatorid() {
        return teamcreatorid;
    }

    public void setTeamcreatorid(String teamcreatorid) {
        this.teamcreatorid = teamcreatorid == null ? null : teamcreatorid.trim();
    }

    public Date getTeamcreatetime() {
        return teamcreatetime;
    }

    public void setTeamcreatetime(Date teamcreatetime) {
        this.teamcreatetime = teamcreatetime;
    }

    public Integer getTeamstate() {
        return teamstate;
    }

    public void setTeamstate(Integer teamstate) {
        this.teamstate = teamstate;
    }

    public String getTeamslogan() {
        return teamslogan;
    }

    public void setTeamslogan(String teamslogan) {
        this.teamslogan = teamslogan == null ? null : teamslogan.trim();
    }

    public String getTeamlogourl() {
        return teamlogourl;
    }

    public void setTeamlogourl(String teamlogourl) {
        this.teamlogourl = teamlogourl == null ? null : teamlogourl.trim();
    }

    public Boolean getIsedit() {
        return isedit;
    }

    public void setIsedit(Boolean isedit) {
        this.isedit = isedit;
    }
}