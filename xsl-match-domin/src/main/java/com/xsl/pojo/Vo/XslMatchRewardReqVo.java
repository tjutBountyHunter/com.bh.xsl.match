package com.xsl.pojo.Vo;

import java.util.Date;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2019/4/26 10:11
 * @Description:
 */
public class XslMatchRewardReqVo {

    private String rewardid;

    private String rewardrankid;

    private String rewardcontent;

    private Integer contentquota;

    private Date rewardcreatetime;

    private String matchid;

    private Date rewardaddtime;

    private Integer rewardstate;

    private Integer matchrewardstate;

    public String getRewardid() {
        return rewardid;
    }

    public void setRewardid(String rewardid) {
        this.rewardid = rewardid;
    }

    public String getRewardrankid() {
        return rewardrankid;
    }

    public void setRewardrankid(String rewardrankid) {
        this.rewardrankid = rewardrankid;
    }

    public String getRewardcontent() {
        return rewardcontent;
    }

    public void setRewardcontent(String rewardcontent) {
        this.rewardcontent = rewardcontent;
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

    public String getMatchid() {
        return matchid;
    }

    public void setMatchid(String matchid) {
        this.matchid = matchid;
    }

    public Date getRewardaddtime() {
        return rewardaddtime;
    }

    public void setRewardaddtime(Date rewardaddtime) {
        this.rewardaddtime = rewardaddtime;
    }

    public Integer getRewardstate() {
        return rewardstate;
    }

    public void setRewardstate(Integer rewardstate) {
        this.rewardstate = rewardstate;
    }

    public Integer getMatchrewardstate() {
        return matchrewardstate;
    }

    public void setMatchrewardstate(Integer matchrewardstate) {
        this.matchrewardstate = matchrewardstate;
    }
}
