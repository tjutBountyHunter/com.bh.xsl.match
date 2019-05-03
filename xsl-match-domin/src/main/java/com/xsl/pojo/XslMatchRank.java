package com.xsl.pojo;

public class XslMatchRank {
    private Integer id;

    private String matchrankid;

    private String rankname;

    private String rankinfo;

    private Integer rankstate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMatchrankid() {
        return matchrankid;
    }

    public void setMatchrankid(String matchrankid) {
        this.matchrankid = matchrankid == null ? null : matchrankid.trim();
    }

    public String getRankname() {
        return rankname;
    }

    public void setRankname(String rankname) {
        this.rankname = rankname == null ? null : rankname.trim();
    }

    public String getRankinfo() {
        return rankinfo;
    }

    public void setRankinfo(String rankinfo) {
        this.rankinfo = rankinfo == null ? null : rankinfo.trim();
    }

    public Integer getRankstate() {
        return rankstate;
    }

    public void setRankstate(Integer rankstate) {
        this.rankstate = rankstate;
    }
}