package com.xsl.enums;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2019/5/1 18:07
 * @Description:
 */
public enum HonorStates {
    NORMAL(1,"正常"),DELETE(0,"已删除"),UNAUDITED(2,"未审核"),AUDIT_FAILED(3,"审核未通过");

    private Integer code;
    private String msg;

    HonorStates(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }
}
