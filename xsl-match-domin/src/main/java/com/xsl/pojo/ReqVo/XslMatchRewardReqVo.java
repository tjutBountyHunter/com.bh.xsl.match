package com.xsl.pojo.ReqVo;

import java.util.Date;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2019/4/26 10:11
 * @Description:
 */
public class XslMatchRewardReqVo {

    private String rewardId;

    private String rewardRankId;

    private String rewardContent;

    private Integer contentQuota;

    private Date rewardCreateTime;

    private String matchId;

    private Date rewardAddTime;

    private Integer rewardState;

    private Integer matchRewardState;

    public Integer getMatchRewardState() {
        return matchRewardState;
    }

    public void setMatchRewardState(Integer matchRewardState) {
        this.matchRewardState = matchRewardState;
    }

    public String getRewardId() {
        return rewardId;
    }

    public void setRewardId(String rewardId) {
        this.rewardId = rewardId;
    }

    public String getRewardRankId() {
        return rewardRankId;
    }

    public void setRewardRankId(String rewardRankId) {
        this.rewardRankId = rewardRankId;
    }

    public String getRewardContent() {
        return rewardContent;
    }

    public void setRewardContent(String rewardContent) {
        this.rewardContent = rewardContent;
    }

    public Integer getContentQuota() {
        return contentQuota;
    }

    public void setContentQuota(Integer contentQuota) {
        this.contentQuota = contentQuota;
    }

    public Date getRewardCreateTime() {
        return rewardCreateTime;
    }

    public void setRewardCreateTime(Date rewardCreateTime) {
        this.rewardCreateTime = rewardCreateTime;
    }

    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }

    public Date getRewardAddTime() {
        return rewardAddTime;
    }

    public void setRewardAddTime(Date rewardAddTime) {
        this.rewardAddTime = rewardAddTime;
    }

    public Integer getRewardState() {
        return rewardState;
    }

    public void setRewardState(Integer rewardState) {
        this.rewardState = rewardState;
    }
}
