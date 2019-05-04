package com.xsl.pojo;

import java.util.Date;

public class XslMatchReward {
    private Integer id;

    private String matchid;

    private String rewardid;

    private Date rewardaddtime;

    private Integer matchrewardstate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMatchid() {
        return matchid;
    }

    public void setMatchid(String matchid) {
        this.matchid = matchid == null ? null : matchid.trim();
    }

    public String getRewardid() {
        return rewardid;
    }

    public void setRewardid(String rewardid) {
        this.rewardid = rewardid == null ? null : rewardid.trim();
    }

    public Date getRewardaddtime() {
        return rewardaddtime;
    }

    public void setRewardaddtime(Date rewardaddtime) {
        this.rewardaddtime = rewardaddtime;
    }

    public Integer getMatchrewardstate() {
        return matchrewardstate;
    }

    public void setMatchrewardstate(Integer matchrewardstate) {
        this.matchrewardstate = matchrewardstate;
    }
}