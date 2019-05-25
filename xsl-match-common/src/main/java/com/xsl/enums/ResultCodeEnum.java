package com.xsl.enums;


/**
 * 说明：返回状态码
 *
 * @Auther: 11432_000
 * @Date: 2019/4/21 20:22
 * @Description:
 */
public enum ResultCodeEnum {
    SUCCESS(200,"成功"),EXCEPTION(500,"服务器异常"),TIMEOUT(502,"超时"),PARAMETER_ERROR(403,"参数错误"),NON_EDITABLE(401,"权限不足"),
    RESOURCE_DUPLICATION(70,"重复添加（仅用于服务器）"),NOT_HAVE(404,"资源不存在");

    private Integer code;
    private String msg;

    ResultCodeEnum(Integer code, String msg) {
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
