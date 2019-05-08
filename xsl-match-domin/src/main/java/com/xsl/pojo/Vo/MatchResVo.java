package com.xsl.pojo.Vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 说明：比赛详情 比赛信息 + 等级信息 + 奖励信息
 *
 * @Auther: 11432_000
 * @Date: 2019/5/5 14:00
 * @Description:
 */
public class MatchResVo implements Serializable {

    private String matchid;

    private String matchname;

    private String matchrankid;

    private String matchwebsite;

    private String matchorientedid;

    private Date matchstarttime;

    private Date matchendtime;

    private Integer matchstate;

    private Date matchsignupendtime;

    private String matchaddress;

    private Integer matchsignupmaxnum;

    private Integer matchform;

    private Integer matchteamnum;

    private Date matchsignupstarttime;

    private Date matchcreatetime;

    private String matchposterurl;

    private String matchtypeid;

    private String matchinfo;

    /** 等级信息 */
    private String rankname;

    private String rankinfo;

    /** 人群信息 */
    private String orientedname;

    private String orientedinfo;

    /** 类型信息 */
    private String matchtypename;

    private String matchtypeinfo;

    public String getMatchid() {
        return matchid;
    }

    public void setMatchid(String matchid) {
        this.matchid = matchid;
    }

    public String getMatchname() {
        return matchname;
    }

    public void setMatchname(String matchname) {
        this.matchname = matchname;
    }

    public String getMatchrankid() {
        return matchrankid;
    }

    public void setMatchrankid(String matchrankid) {
        this.matchrankid = matchrankid;
    }

    public String getMatchwebsite() {
        return matchwebsite;
    }

    public void setMatchwebsite(String matchwebsite) {
        this.matchwebsite = matchwebsite;
    }

    public String getMatchorientedid() {
        return matchorientedid;
    }

    public void setMatchorientedid(String matchorientedid) {
        this.matchorientedid = matchorientedid;
    }

    public Date getMatchstarttime() {
        return matchstarttime;
    }

    public void setMatchstarttime(Date matchstarttime) {
        this.matchstarttime = matchstarttime;
    }

    public Date getMatchendtime() {
        return matchendtime;
    }

    public void setMatchendtime(Date matchendtime) {
        this.matchendtime = matchendtime;
    }

    public Integer getMatchstate() {
        return matchstate;
    }

    public void setMatchstate(Integer matchstate) {
        this.matchstate = matchstate;
    }

    public Date getMatchsignupendtime() {
        return matchsignupendtime;
    }

    public void setMatchsignupendtime(Date matchsignupendtime) {
        this.matchsignupendtime = matchsignupendtime;
    }

    public String getMatchaddress() {
        return matchaddress;
    }

    public void setMatchaddress(String matchaddress) {
        this.matchaddress = matchaddress;
    }

    public Integer getMatchsignupmaxnum() {
        return matchsignupmaxnum;
    }

    public void setMatchsignupmaxnum(Integer matchsignupmaxnum) {
        this.matchsignupmaxnum = matchsignupmaxnum;
    }

    public Integer getMatchform() {
        return matchform;
    }

    public void setMatchform(Integer matchform) {
        this.matchform = matchform;
    }

    public Integer getMatchteamnum() {
        return matchteamnum;
    }

    public void setMatchteamnum(Integer matchteamnum) {
        this.matchteamnum = matchteamnum;
    }

    public Date getMatchsignupstarttime() {
        return matchsignupstarttime;
    }

    public void setMatchsignupstarttime(Date matchsignupstarttime) {
        this.matchsignupstarttime = matchsignupstarttime;
    }

    public Date getMatchcreatetime() {
        return matchcreatetime;
    }

    public void setMatchcreatetime(Date matchcreatetime) {
        this.matchcreatetime = matchcreatetime;
    }

    public String getMatchposterurl() {
        return matchposterurl;
    }

    public void setMatchposterurl(String matchposterurl) {
        this.matchposterurl = matchposterurl;
    }

    public String getMatchtypeid() {
        return matchtypeid;
    }

    public void setMatchtypeid(String matchtypeid) {
        this.matchtypeid = matchtypeid;
    }

    public String getMatchinfo() {
        return matchinfo;
    }

    public void setMatchinfo(String matchinfo) {
        this.matchinfo = matchinfo;
    }

    public String getRankname() {
        return rankname;
    }

    public void setRankname(String rankname) {
        this.rankname = rankname;
    }

    public String getRankinfo() {
        return rankinfo;
    }

    public void setRankinfo(String rankinfo) {
        this.rankinfo = rankinfo;
    }

    public String getOrientedname() {
        return orientedname;
    }

    public void setOrientedname(String orientedname) {
        this.orientedname = orientedname;
    }

    public String getOrientedinfo() {
        return orientedinfo;
    }

    public void setOrientedinfo(String orientedinfo) {
        this.orientedinfo = orientedinfo;
    }

    public String getMatchtypename() {
        return matchtypename;
    }

    public void setMatchtypename(String matchtypename) {
        this.matchtypename = matchtypename;
    }

    public String getMatchtypeinfo() {
        return matchtypeinfo;
    }

    public void setMatchtypeinfo(String matchtypeinfo) {
        this.matchtypeinfo = matchtypeinfo;
    }
}
