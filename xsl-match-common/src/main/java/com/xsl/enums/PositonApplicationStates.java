package com.xsl.enums;

/**
 * 说明：申请状态
 *
 * @Auther: 11432_000
 * @Date: 2019/5/10 18:01
 * @Description:
 */
public enum PositonApplicationStates {
    DELETE(0,"申请撤销"),UNDER_PPLICATION(1,"申请中"),FAIL(2,"申请失败"),SUCCESS(3,"申请成功"),INVALID(4,"申请无效");

    private Integer code;
    private String msg;

    PositonApplicationStates(Integer code, String msg) {
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
