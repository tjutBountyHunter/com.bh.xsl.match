package com.xsl.pojo.Vo;

import com.xsl.pojo.XslTeamMember;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 说明：职位详情
 *
 * @Auther: 11432_000
 * @Date: 2019/5/10 13:36
 * @Description:
 */
public class PositionDetailsResVo implements Serializable {

    private String positionid;

    private String teamid;

    private String positionname;

    private String positioninfo;

    private String positionrequirements;

    private Date positioncreatetime;

    private List<PositionTagResVo> tags;

    public String getPositionid() {
        return positionid;
    }

    public void setPositionid(String positionid) {
        this.positionid = positionid;
    }

    public String getTeamid() {
        return teamid;
    }

    public void setTeamid(String teamid) {
        this.teamid = teamid;
    }

    public String getPositionname() {
        return positionname;
    }

    public void setPositionname(String positionname) {
        this.positionname = positionname;
    }

    public String getPositioninfo() {
        return positioninfo;
    }

    public void setPositioninfo(String positioninfo) {
        this.positioninfo = positioninfo;
    }

    public String getPositionrequirements() {
        return positionrequirements;
    }

    public void setPositionrequirements(String positionrequirements) {
        this.positionrequirements = positionrequirements;
    }

    public Date getPositioncreatetime() {
        return positioncreatetime;
    }

    public void setPositioncreatetime(Date positioncreatetime) {
        this.positioncreatetime = positioncreatetime;
    }

    public List<PositionTagResVo> getTags() {
        return tags;
    }

    public void setTags(List<PositionTagResVo> tags) {
        this.tags = tags;
    }

}
