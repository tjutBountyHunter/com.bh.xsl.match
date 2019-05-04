package com.xsl.pojo;

public class XslRewardRank {
    private Integer id;

    private String rewardrankid;

    private String rewardrankname;

    private String rewardrankinfo;

    private Integer rewardrankstate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRewardrankid() {
        return rewardrankid;
    }

    public void setRewardrankid(String rewardrankid) {
        this.rewardrankid = rewardrankid == null ? null : rewardrankid.trim();
    }

    public String getRewardrankname() {
        return rewardrankname;
    }

    public void setRewardrankname(String rewardrankname) {
        this.rewardrankname = rewardrankname == null ? null : rewardrankname.trim();
    }

    public String getRewardrankinfo() {
        return rewardrankinfo;
    }

    public void setRewardrankinfo(String rewardrankinfo) {
        this.rewardrankinfo = rewardrankinfo == null ? null : rewardrankinfo.trim();
    }

    public Integer getRewardrankstate() {
        return rewardrankstate;
    }

    public void setRewardrankstate(Integer rewardrankstate) {
        this.rewardrankstate = rewardrankstate;
    }
}