package com.xsl.pojo;

import java.util.Date;

public class XslReward {
    private Integer id;

    private String rewardid;

    private String rewardrankid;

    private String rewardcontent;

    private Integer contentquota;

    private Date rewardcreatetime;

    private Integer rewardstate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRewardid() {
        return rewardid;
    }

    public void setRewardid(String rewardid) {
        this.rewardid = rewardid == null ? null : rewardid.trim();
    }

    public String getRewardrankid() {
        return rewardrankid;
    }

    public void setRewardrankid(String rewardrankid) {
        this.rewardrankid = rewardrankid == null ? null : rewardrankid.trim();
    }

    public String getRewardcontent() {
        return rewardcontent;
    }

    public void setRewardcontent(String rewardcontent) {
        this.rewardcontent = rewardcontent == null ? null : rewardcontent.trim();
    }

    public Integer getContentquota() {
        return contentquota;
    }

    public void setContentquota(Integer contentquota) {
        this.contentquota = contentquota;
    }

    public Date getRewardcreatetime() {
        return rewardcreatetime;
    }

    public void setRewardcreatetime(Date rewardcreatetime) {
        this.rewardcreatetime = rewardcreatetime;
    }

    public Integer getRewardstate() {
        return rewardstate;
    }

    public void setRewardstate(Integer rewardstate) {
        this.rewardstate = rewardstate;
    }
}