package com.xsl.pojo;

import java.io.Serializable;
import java.util.Date;

public class XslMatch implements Serializable {
    private Integer id;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMatchid() {
        return matchid;
    }

    public void setMatchid(String matchid) {
        this.matchid = matchid == null ? null : matchid.trim();
    }

    public String getMatchname() {
        return matchname;
    }

    public void setMatchname(String matchname) {
        this.matchname = matchname == null ? null : matchname.trim();
    }

    public String getMatchrankid() {
        return matchrankid;
    }

    public void setMatchrankid(String matchrankid) {
        this.matchrankid = matchrankid == null ? null : matchrankid.trim();
    }

    public String getMatchwebsite() {
        return matchwebsite;
    }

    public void setMatchwebsite(String matchwebsite) {
        this.matchwebsite = matchwebsite == null ? null : matchwebsite.trim();
    }

    public String getMatchorientedid() {
        return matchorientedid;
    }

    public void setMatchorientedid(String matchorientedid) {
        this.matchorientedid = matchorientedid == null ? null : matchorientedid.trim();
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
        this.matchaddress = matchaddress == null ? null : matchaddress.trim();
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
        this.matchposterurl = matchposterurl == null ? null : matchposterurl.trim();
    }

    public String getMatchtypeid() {
        return matchtypeid;
    }

    public void setMatchtypeid(String matchtypeid) {
        this.matchtypeid = matchtypeid == null ? null : matchtypeid.trim();
    }

    public String getMatchinfo() {
        return matchinfo;
    }

    public void setMatchinfo(String matchinfo) {
        this.matchinfo = matchinfo == null ? null : matchinfo.trim();
    }
}