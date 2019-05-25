package com.xsl.enums;

/**
 * 说明：邀请状态
 *
 * @Auther: 11432_000
 * @Date: 2019/5/17 16:06
 * @Description:
 */
public enum XslInvitationEnum {

	DELETE(0,"撤销邀请"),UNDER_PPLICATION(1,"邀请中"),FAIL(2,"邀请被拒绝"),SUCCESS(3,"邀请成功"),INVALID(4,"邀请无效");

	private Integer code;
	private String msg;

	XslInvitationEnum(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public Integer getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}
}
