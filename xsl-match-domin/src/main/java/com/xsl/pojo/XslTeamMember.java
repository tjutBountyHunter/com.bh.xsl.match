package com.xsl.pojo;

import java.util.Date;

public class XslTeamMember {
    private Integer id;

    private String memberid;

    private String hunterid;

    private String positionid;

    private Integer memberstate;

    private Date memberjointime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMemberid() {
        return memberid;
    }

    public void setMemberid(String memberid) {
        this.memberid = memberid == null ? null : memberid.trim();
    }

    public String getHunterid() {
        return hunterid;
    }

    public void setHunterid(String hunterid) {
        this.hunterid = hunterid == null ? null : hunterid.trim();
    }

    public String getPositionid() {
        return positionid;
    }

    public void setPositionid(String positionid) {
        this.positionid = positionid == null ? null : positionid.trim();
    }

    public Integer getMemberstate() {
        return memberstate;
    }

    public void setMemberstate(Integer memberstate) {
        this.memberstate = memberstate;
    }

    public Date getMemberjointime() {
        return memberjointime;
    }

    public void setMemberjointime(Date memberjointime) {
        this.memberjointime = memberjointime;
    }
}