package com.xsl.enums;

/**
 * 说明：职位状态
 *
 * @Auther: 11432_000
 * @Date: 2019/5/2 11:44
 * @Description:
 */
public enum PositionStates {
    NORMAL(1,"正常"),DELETE(0,"已删除"),RECRUITMENT(3,"招募中"),RECRUITMENT_STOP(4,"招募停止"),NON_EDITABLE(5,"队伍已停用");

    private Integer code;
    private String msg;

    PositionStates(Integer code, String msg) {
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
