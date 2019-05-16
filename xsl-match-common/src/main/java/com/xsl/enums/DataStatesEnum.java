package com.xsl.enums;

/**
 * 说明：比赛奖励状态
 *
 * @Auther: 11432_000
 * @Date: 2019/4/26 11:53
 * @Description:
 */
public enum DataStatesEnum {
    NORMAL(1,"正常"),DELETE(0,"已删除");

    private Integer code;
    private String msg;

    DataStatesEnum(Integer code, String msg) {
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
