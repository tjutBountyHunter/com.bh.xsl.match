package com.xsl.pojo;

public class XslOriented {
    private Integer id;

    private String orientedid;

    private String orientedname;

    private String orientedinfo;

    private Integer orientedstate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrientedid() {
        return orientedid;
    }

    public void setOrientedid(String orientedid) {
        this.orientedid = orientedid == null ? null : orientedid.trim();
    }

    public String getOrientedname() {
        return orientedname;
    }

    public void setOrientedname(String orientedname) {
        this.orientedname = orientedname == null ? null : orientedname.trim();
    }

    public String getOrientedinfo() {
        return orientedinfo;
    }

    public void setOrientedinfo(String orientedinfo) {
        this.orientedinfo = orientedinfo == null ? null : orientedinfo.trim();
    }

    public Integer getOrientedstate() {
        return orientedstate;
    }

    public void setOrientedstate(Integer orientedstate) {
        this.orientedstate = orientedstate;
    }
}