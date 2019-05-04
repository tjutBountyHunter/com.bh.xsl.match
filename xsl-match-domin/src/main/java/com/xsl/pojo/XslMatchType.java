package com.xsl.pojo;

import java.util.Date;

public class XslMatchType {
    private Integer id;

    private String matchtypeid;

    private String matchtypename;

    private Integer matchtypestate;

    private String matchtypeinfo;

    private Date matchtypecreatetime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMatchtypeid() {
        return matchtypeid;
    }

    public void setMatchtypeid(String matchtypeid) {
        this.matchtypeid = matchtypeid == null ? null : matchtypeid.trim();
    }

    public String getMatchtypename() {
        return matchtypename;
    }

    public void setMatchtypename(String matchtypename) {
        this.matchtypename = matchtypename == null ? null : matchtypename.trim();
    }

    public Integer getMatchtypestate() {
        return matchtypestate;
    }

    public void setMatchtypestate(Integer matchtypestate) {
        this.matchtypestate = matchtypestate;
    }

    public String getMatchtypeinfo() {
        return matchtypeinfo;
    }

    public void setMatchtypeinfo(String matchtypeinfo) {
        this.matchtypeinfo = matchtypeinfo == null ? null : matchtypeinfo.trim();
    }

    public Date getMatchtypecreatetime() {
        return matchtypecreatetime;
    }

    public void setMatchtypecreatetime(Date matchtypecreatetime) {
        this.matchtypecreatetime = matchtypecreatetime;
    }
}