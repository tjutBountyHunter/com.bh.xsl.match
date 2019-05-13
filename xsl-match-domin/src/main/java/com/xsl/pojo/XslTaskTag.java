package com.xsl.pojo;

import java.io.Serializable;
import java.util.Date;

public class XslTaskTag implements Serializable {
    private Integer id;

    private String taskid;

    private String tagid;

    private Date createdate;

    private Boolean state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTaskid() {
        return taskid;
    }

    public void setTaskid(String taskid) {
        this.taskid = taskid == null ? null : taskid.trim();
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
        if (!(obj instanceof XslTaskTag)){
            return false;
        }
        XslTaskTag xslTaskTag = (XslTaskTag) obj;
        if (this.getTagid().equals(xslTaskTag.getTagid()) && this.getTaskid().equals(xslTaskTag.getTaskid())){
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.getTagid().hashCode();
    }

}