package com.xsl.pojo.Vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 说明：添加/修改职位
 *
 * @Auther: 11432_000
 * @Date: 2019/5/10 13:36
 * @Description:
 */
public class PositionUpdateReqVo implements Serializable {

    private String teamid;

    private String positionid;

    private String positionname;

    private String positioninfo;

    private String positionrequirements;

    private List<String> tagIds;

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

    public List<String> getTagIds() {
        return tagIds;
    }

    public void setTagIds(List<String> tagIds) {
        this.tagIds = tagIds;
    }

    public String getPositionid() {
        return positionid;
    }

    public void setPositionid(String positionid) {
        this.positionid = positionid;
    }
}
