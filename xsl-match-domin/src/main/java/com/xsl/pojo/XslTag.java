package com.xsl.pojo;

import java.io.Serializable;
import java.util.Date;

public class XslTag implements Serializable {
    private Integer id;

    private String tagid;

    private String name;

    private Short usenum;

    private Date createdate;

    private Boolean state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTagid() {
        return tagid;
    }

    public void setTagid(String tagid) {
        this.tagid = tagid == null ? null : tagid.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Short getUsenum() {
        return usenum;
    }

    public void setUsenum(Short usenum) {
        this.usenum = usenum;
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
        if (!(obj instanceof XslTag)){
            return false;
        }
        XslTag xslTag = (XslTag) obj;
        if (this.getTagid().equals(xslTag.getTagid())){
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.getTagid().hashCode();
    }
}