package com.xsl.pojo.Vo;

import java.util.List;

/**
 * 说明：用户展示列表
 *
 * @Auther: 11432_000
 * @Date: 2019/5/15 15:14
 * @Description:
 */
public class XslApplyResVo {

	private String userid;

	private String hunterid;

	private String name;

	/** 头像信息 */
	private String txUrl;

	/** 标签信息 */
	private List<HunterTagResVo> tags;
	/** 职位信息 */
	private String positionid;

	private String teamid;

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

	public List<HunterTagResVo> getTags() {
		return tags;
	}

	public void setTags(List<HunterTagResVo> tags) {
		this.tags = tags;
	}

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
}
