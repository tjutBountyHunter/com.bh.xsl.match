package com.xsl.enums;

/**
 * 说明：成员状态
 *
 * @Auther: 11432_000
 * @Date: 2019/5/2 11:44
 * @Description:
 */
public enum MemberStatesEnum {
    NORMAL(1,"正常"),DELETE(0,"已删除"),FINISH(2,"比赛完成");

    private Integer code;
    private String msg;

    MemberStatesEnum(Integer code, String msg) {
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
