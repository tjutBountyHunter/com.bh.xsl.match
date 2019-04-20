package com.xsl.pojo;

import java.util.Date;

public class XslTeamPosition {
    private Integer id;

    private String positionId;

    private String positionName;

    private String positionInfo;

    private String positionRequirements;

    private Integer positionState;

    private Date positionCreateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPositionId() {
        return positionId;
    }

    public void setPositionId(String positionId) {
        this.positionId = positionId;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getPositionInfo() {
        return positionInfo;
    }

    public void setPositionInfo(String positionInfo) {
        this.positionInfo = positionInfo;
    }

    public String getPositionRequirements() {
        return positionRequirements;
    }

    public void setPositionRequirements(String positionRequirements) {
        this.positionRequirements = positionRequirements;
    }

    public Integer getPositionState() {
        return positionState;
    }

    public void setPositionState(Integer positionState) {
        this.positionState = positionState;
    }

    public Date getPositionCreateTime() {
        return positionCreateTime;
    }

    public void setPositionCreateTime(Date positionCreateTime) {
        this.positionCreateTime = positionCreateTime;
    }
}