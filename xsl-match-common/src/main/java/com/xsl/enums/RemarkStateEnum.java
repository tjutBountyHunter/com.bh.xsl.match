package com.xsl.enums;

/**
 * @ClassName RemarkStateEnum
 * @Description TODO
 * @Author 11432
 * @DATE 2019/6/3 16:26
 */
public enum  RemarkStateEnum {
    NORMAL(1,"正常"),DELETE(0,"已删除");

    private Integer code;
    private String msg;

    RemarkStateEnum(Integer code, String msg) {
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
