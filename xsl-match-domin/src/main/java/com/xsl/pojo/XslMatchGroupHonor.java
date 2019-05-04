package com.xsl.pojo;

import java.util.Date;

public class XslMatchGroupHonor {
    private Integer id;

    private String grouphonorid;

    private String teamid;

    private String grouphonorname;

    private String grouphonorinfo;

    private String grouphonorvoucher;

    private Integer grouphonorstate;

    private Date grouphonortime;

    private String matchrankid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGrouphonorid() {
        return grouphonorid;
    }

    public void setGrouphonorid(String grouphonorid) {
        this.grouphonorid = grouphonorid == null ? null : grouphonorid.trim();
    }

    public String getTeamid() {
        return teamid;
    }

    public void setTeamid(String teamid) {
        this.teamid = teamid == null ? null : teamid.trim();
    }

    public String getGrouphonorname() {
        return grouphonorname;
    }

    public void setGrouphonorname(String grouphonorname) {
        this.grouphonorname = grouphonorname == null ? null : grouphonorname.trim();
    }

    public String getGrouphonorinfo() {
        return grouphonorinfo;
    }

    public void setGrouphonorinfo(String grouphonorinfo) {
        this.grouphonorinfo = grouphonorinfo == null ? null : grouphonorinfo.trim();
    }

    public String getGrouphonorvoucher() {
        return grouphonorvoucher;
    }

    public void setGrouphonorvoucher(String grouphonorvoucher) {
        this.grouphonorvoucher = grouphonorvoucher == null ? null : grouphonorvoucher.trim();
    }

    public Integer getGrouphonorstate() {
        return grouphonorstate;
    }

    public void setGrouphonorstate(Integer grouphonorstate) {
        this.grouphonorstate = grouphonorstate;
    }

    public Date getGrouphonortime() {
        return grouphonortime;
    }

    public void setGrouphonortime(Date grouphonortime) {
        this.grouphonortime = grouphonortime;
    }

    public String getMatchrankid() {
        return matchrankid;
    }

    public void setMatchrankid(String matchrankid) {
        this.matchrankid = matchrankid == null ? null : matchrankid.trim();
    }
}