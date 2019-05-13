package com.xsl.pojo;

import java.util.Date;

public class XslMatchHonor {
    private Integer id;

    private String honorid;

    private String hunterid;

    private String teamid;

    private String honorname;

    private String honorinfo;

    private String honorvoucher;

    private Date honortime;

    private String matchrankid;

    private Integer honorstate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHonorid() {
        return honorid;
    }

    public void setHonorid(String honorid) {
        this.honorid = honorid == null ? null : honorid.trim();
    }

    public String getHunterid() {
        return hunterid;
    }

    public void setHunterid(String hunterid) {
        this.hunterid = hunterid == null ? null : hunterid.trim();
    }

    public String getTeamid() {
        return teamid;
    }

    public void setTeamid(String teamid) {
        this.teamid = teamid == null ? null : teamid.trim();
    }

    public String getHonorname() {
        return honorname;
    }

    public void setHonorname(String honorname) {
        this.honorname = honorname == null ? null : honorname.trim();
    }

    public String getHonorinfo() {
        return honorinfo;
    }

    public void setHonorinfo(String honorinfo) {
        this.honorinfo = honorinfo == null ? null : honorinfo.trim();
    }

    public String getHonorvoucher() {
        return honorvoucher;
    }

    public void setHonorvoucher(String honorvoucher) {
        this.honorvoucher = honorvoucher == null ? null : honorvoucher.trim();
    }

    public Date getHonortime() {
        return honortime;
    }

    public void setHonortime(Date honortime) {
        this.honortime = honortime;
    }

    public String getMatchrankid() {
        return matchrankid;
    }

    public void setMatchrankid(String matchrankid) {
        this.matchrankid = matchrankid == null ? null : matchrankid.trim();
    }

    public Integer getHonorstate() {
        return honorstate;
    }

    public void setHonorstate(Integer honorstate) {
        this.honorstate = honorstate;
    }
}