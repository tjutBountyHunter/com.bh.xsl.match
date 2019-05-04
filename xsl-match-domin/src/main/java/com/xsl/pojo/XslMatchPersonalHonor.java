package com.xsl.pojo;

import java.util.Date;

public class XslMatchPersonalHonor {
    private Integer id;

    private String personalhonorid;

    private String hunterid;

    private String personalhonorname;

    private String personalhonorinfo;

    private String personalhonorvoucher;

    private Date personalhonortime;

    private String matchrankid;

    private Integer personalhonorstate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPersonalhonorid() {
        return personalhonorid;
    }

    public void setPersonalhonorid(String personalhonorid) {
        this.personalhonorid = personalhonorid == null ? null : personalhonorid.trim();
    }

    public String getHunterid() {
        return hunterid;
    }

    public void setHunterid(String hunterid) {
        this.hunterid = hunterid == null ? null : hunterid.trim();
    }

    public String getPersonalhonorname() {
        return personalhonorname;
    }

    public void setPersonalhonorname(String personalhonorname) {
        this.personalhonorname = personalhonorname == null ? null : personalhonorname.trim();
    }

    public String getPersonalhonorinfo() {
        return personalhonorinfo;
    }

    public void setPersonalhonorinfo(String personalhonorinfo) {
        this.personalhonorinfo = personalhonorinfo == null ? null : personalhonorinfo.trim();
    }

    public String getPersonalhonorvoucher() {
        return personalhonorvoucher;
    }

    public void setPersonalhonorvoucher(String personalhonorvoucher) {
        this.personalhonorvoucher = personalhonorvoucher == null ? null : personalhonorvoucher.trim();
    }

    public Date getPersonalhonortime() {
        return personalhonortime;
    }

    public void setPersonalhonortime(Date personalhonortime) {
        this.personalhonortime = personalhonortime;
    }

    public String getMatchrankid() {
        return matchrankid;
    }

    public void setMatchrankid(String matchrankid) {
        this.matchrankid = matchrankid == null ? null : matchrankid.trim();
    }

    public Integer getPersonalhonorstate() {
        return personalhonorstate;
    }

    public void setPersonalhonorstate(Integer personalhonorstate) {
        this.personalhonorstate = personalhonorstate;
    }
}