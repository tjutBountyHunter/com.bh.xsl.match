package com.xsl.pojo;

import java.util.Date;

public class XslMatchTeam {
    private Integer id;

    private String teamId;

    private String matchId;

    private String teamName;

    private String teamSynopsis;

    private String teamCreatorId;

    private Date teamCreateTime;

    private Integer teamState;

    private String teamSlogan;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamSynopsis() {
        return teamSynopsis;
    }

    public void setTeamSynopsis(String teamSynopsis) {
        this.teamSynopsis = teamSynopsis;
    }

    public String getTeamCreatorId() {
        return teamCreatorId;
    }

    public void setTeamCreatorId(String teamCreatorId) {
        this.teamCreatorId = teamCreatorId;
    }

    public Date getTeamCreateTime() {
        return teamCreateTime;
    }

    public void setTeamCreateTime(Date teamCreateTime) {
        this.teamCreateTime = teamCreateTime;
    }

    public Integer getTeamState() {
        return teamState;
    }

    public void setTeamState(Integer teamState) {
        this.teamState = teamState;
    }

    public String getTeamSlogan() {
        return teamSlogan;
    }

    public void setTeamSlogan(String teamSlogan) {
        this.teamSlogan = teamSlogan;
    }
}