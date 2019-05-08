package com.xsl.pojo.Vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 说明：职位标签Vo
 *
 * @Auther: 11432_000
 * @Date: 2019/5/8 14:01
 * @Description:
 */
public class PositionTagResVo implements Serializable {

    private String taskid;

    private String tagid;

    private Date createdate;

    private Boolean state;

    private String name;

    private Short usenum;

    public String getTaskid() {
        return taskid;
    }

    public void setTaskid(String taskid) {
        this.taskid = taskid;
    }

    public String getTagid() {
        return tagid;
    }

    public void setTagid(String tagid) {
        this.tagid = tagid;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Short getUsenum() {
        return usenum;
    }

    public void setUsenum(Short usenum) {
        this.usenum = usenum;
    }
}
