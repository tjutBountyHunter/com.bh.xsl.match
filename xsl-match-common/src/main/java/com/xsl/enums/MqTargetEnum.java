package com.xsl.enums;

/**
 * @ClassName MqTargetEnum
 * @Description TODO
 * @Author 11432
 * @DATE 2019/5/31 14:26
 */
public enum MqTargetEnum {
    MATCH_ES_UPDATE(0,"比赛更新"),MATCH_ES_DELETE(1,"比赛移除"),TEAM_ES_UPDATE(2,"队伍更新"),
    TEAM_ES_DELETE(3,"队伍移除"),USER_ES_UPDATE(4,"用户更新"),USER_ES_DELETE(5,"用户移除");

    private Integer code;
    private String msg;

    MqTargetEnum(Integer code,String msg){
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
