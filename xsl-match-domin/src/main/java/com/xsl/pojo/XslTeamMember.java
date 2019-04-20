package com.xsl.pojo;

import java.util.Date;

public class XslTeamMember {
    private Integer id;

    private String memberId;

    private String teamId;

    private String positionId;

    private Integer memberState;

    private Date memberJoinTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getPositionId() {
        return positionId;
    }

    public void setPositionId(String positionId) {
        this.positionId = positionId;
    }

    public Integer getMemberState() {
        return memberState;
    }

    public void setMemberState(Integer memberState) {
        this.memberState = memberState;
    }

    public Date getMemberJoinTime() {
        return memberJoinTime;
    }

    public void setMemberJoinTime(Date memberJoinTime) {
        this.memberJoinTime = memberJoinTime;
    }
}