package com.xsl.pojo;

import java.util.Date;

public class XslMatchType {
    private Integer id;

    private String matchTypeId;

    private String matchTypeName;

    private Integer matchTypeState;

    private String matchTypeInfo;

    private Date matchTypeCreateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMatchTypeId() {
        return matchTypeId;
    }

    public void setMatchTypeId(String matchTypeId) {
        this.matchTypeId = matchTypeId;
    }

    public String getMatchTypeName() {
        return matchTypeName;
    }

    public void setMatchTypeName(String matchTypeName) {
        this.matchTypeName = matchTypeName;
    }

    public Integer getMatchTypeState() {
        return matchTypeState;
    }

    public void setMatchTypeState(Integer matchTypeState) {
        this.matchTypeState = matchTypeState;
    }

    public String getMatchTypeInfo() {
        return matchTypeInfo;
    }

    public void setMatchTypeInfo(String matchTypeInfo) {
        this.matchTypeInfo = matchTypeInfo;
    }

    public Date getMatchTypeCreateTime() {
        return matchTypeCreateTime;
    }

    public void setMatchTypeCreateTime(Date matchTypeCreateTime) {
        this.matchTypeCreateTime = matchTypeCreateTime;
    }
}