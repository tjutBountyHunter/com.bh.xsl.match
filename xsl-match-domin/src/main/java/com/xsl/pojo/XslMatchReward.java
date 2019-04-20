package com.xsl.pojo;

import java.util.Date;

public class XslMatchReward {
    private Integer id;

    private String matchId;

    private String rewardId;

    private Date rewardCreateTime;

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

    public Date getRewardCreateTime() {
        return rewardCreateTime;
    }

    public void setRewardCreateTime(Date rewardCreateTime) {
        this.rewardCreateTime = rewardCreateTime;
    }
}