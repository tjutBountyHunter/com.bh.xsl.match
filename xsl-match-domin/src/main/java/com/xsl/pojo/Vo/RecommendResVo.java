package com.xsl.pojo.Vo;

import java.io.Serializable;
import java.util.List;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2019/5/16 17:03
 * @Description:
 */
public class RecommendResVo implements Serializable {


	private String userid;

	private String hunterid;

	private String name;

	/** 头像信息 */
	private String txUrl;

	/** 标签信息 */
	private List<HunterTagResVo> tags;

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
}
