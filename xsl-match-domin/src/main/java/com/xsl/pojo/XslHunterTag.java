package com.xsl.pojo;

import java.io.Serializable;
import java.util.Date;

public class XslHunterTag implements Serializable {
    private Integer id;

    private String hunterid;

    private String tagid;

    private Date createdate;

    private Boolean state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHunterid() {
        return hunterid;
    }

    public void setHunterid(String hunterid) {
        this.hunterid = hunterid == null ? null : hunterid.trim();
    }

    public String getTagid() {
        return tagid;
    }

    public void setTagid(String tagid) {
        this.tagid = tagid == null ? null : tagid.trim();
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null){
            return false;
        }
        if (obj == this){
            return true;
        }
        if (!(obj instanceof XslHunterTag)){
            return false;
        }
        XslHunterTag xslTaskTag = (XslHunterTag) obj;
        if (this.getTagid().equals(xslTaskTag.getTagid()) && this.getHunterid().equals(xslTaskTag.getHunterid())){
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.getTagid().hashCode();
    }
}