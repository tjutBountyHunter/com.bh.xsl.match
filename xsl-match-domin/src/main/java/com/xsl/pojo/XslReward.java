package com.xsl.pojo;

public class XslReward {
    private Integer id;

    private String rewardId;

    private String rewardRankId;

    private String rewardContent;

    private Integer contentQuota;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
}