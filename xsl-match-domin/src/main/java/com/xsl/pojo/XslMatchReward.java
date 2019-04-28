package com.xsl.pojo;

import java.util.Date;

public class XslMatchReward {
    private Integer id;

    private String matchId;

    private String rewardId;

    private Date rewardAddTime;

    private Integer matchRewardState;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }

    public String getRewardId() {
        return rewardId;
    }

    public void setRewardId(String rewardId) {
        this.rewardId = rewardId;
    }

    public Date getRewardAddTime() {
        return rewardAddTime;
    }

    public void setRewardAddTime(Date rewardAddTime) {
        this.rewardAddTime = rewardAddTime;
    }

    public Integer getMatchRewardState() {
        return matchRewardState;
    }

    public void setMatchRewardState(Integer matchRewardState) {
        this.matchRewardState = matchRewardState;
    }
}