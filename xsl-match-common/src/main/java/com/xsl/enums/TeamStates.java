package com.xsl.enums;

/**
 * 说明：队伍状态
 *
 * @Auther: 11432_000
 * @Date: 2019/4/27 17:16
 * @Description:
 */
public enum TeamStates {
    DELETE(0,"已删除"),CREATE_SUCCESS(1,"创建成功"),RECRUIT(2,"招募新成员"),NOT_RECRUIT(3,"停止招募");

    private Integer code;
    private String msg;

    TeamStates(Integer code, String msg) {
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
