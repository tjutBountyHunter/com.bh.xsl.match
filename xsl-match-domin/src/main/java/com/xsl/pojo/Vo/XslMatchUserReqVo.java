package com.xsl.pojo.Vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 说明：用户补充信息
 *
 * @Auther: 11432_000
 * @Date: 2019/5/11 13:55
 * @Description:
 */
public class XslMatchUserReqVo implements Serializable {

    private String hunterid;

    private String userid;

    private String matchtypeid;

    private Boolean isrecommend;

    private Integer state;

    private Date lasttime;

    private String selfassessment;

    private List<String> tags;

    public String getHunterid() {
        return hunterid;
    }

    public void setHunterid(String hunterid) {
        this.hunterid = hunterid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getMatchtypeid() {
        return matchtypeid;
    }

    public void setMatchtypeid(String matchtypeid) {
        this.matchtypeid = matchtypeid;
    }

    public Boolean getIsrecommend() {
        return isrecommend;
    }

    public void setIsrecommend(Boolean isrecommend) {
        this.isrecommend = isrecommend;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getLasttime() {
        return lasttime;
    }

    public void setLasttime(Date lasttime) {
        this.lasttime = lasttime;
    }

    public String getSelfassessment() {
        return selfassessment;
    }

    public void setSelfassessment(String selfassessment) {
        this.selfassessment = selfassessment;
    }


    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
