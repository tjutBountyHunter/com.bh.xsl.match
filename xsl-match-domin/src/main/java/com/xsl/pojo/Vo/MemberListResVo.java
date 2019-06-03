package com.xsl.pojo.Vo;

import java.util.Date;
import java.util.List;

/**
 * @ClassName MemberListResVo
 * @Description TODO
 * @Author 11432
 * @DATE 2019/6/1 16:59
 */
public class MemberListResVo {

    private String userid;

    private String hunterid;

    private String name;

    private String positionid;

    /** 头像信息 */
    private String txUrl;

    private String positionname;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getHunterid() {
        return hunterid;
    }

    public void setHunterid(String hunterid) {
        this.hunterid = hunterid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTxUrl() {
        return txUrl;
    }

    public void setTxUrl(String txUrl) {
        this.txUrl = txUrl;
    }

    public String getPositionname() {
        return positionname;
    }

    public void setPositionname(String positionname) {
        this.positionname = positionname;
    }

    public String getPositionid() {
        return positionid;
    }

    public void setPositionid(String positionid) {
        this.positionid = positionid;
    }
}
