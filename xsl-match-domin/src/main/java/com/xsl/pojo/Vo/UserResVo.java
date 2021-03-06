package com.xsl.pojo.Vo;

import java.io.Serializable;

public class UserResVo implements Serializable{
	private String userid;

	private String hunterid;

	private String masterid;

	private String name;

	private transient String password;

	private String sex;

	private String phone;

	private String email;

	private String school;

	private String schoolinfo;

	private Short hunterlevel;

	private Short masterlevel;

	private String college;

	private String major;

	private String txUrl;

	private String signature;

	private String teamId;

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

	public String getMasterid() {
		return masterid;
	}

	public void setMasterid(String masterid) {
		this.masterid = masterid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public Short getHunterlevel() {
		return hunterlevel;
	}

	public void setHunterlevel(Short hunterlevel) {
		this.hunterlevel = hunterlevel;
	}

	public Short getMasterlevel() {
		return masterlevel;
	}

	public void setMasterlevel(Short masterlevel) {
		this.masterlevel = masterlevel;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getTxUrl() {
		return txUrl;
	}

	public void setTxUrl(String txUrl) {
		this.txUrl = txUrl;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getSchoolinfo() {
		return schoolinfo;
	}

	public void setSchoolinfo(String schoolinfo) {
		this.schoolinfo = schoolinfo;
	}

	public String getTeamId() {
		return teamId;
	}

	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}
}
