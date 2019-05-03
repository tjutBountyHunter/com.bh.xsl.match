package com.xsl.enums;


/**
 * 说明：返回状态码
 *
 * @Auther: 11432_000
 * @Date: 2019/4/21 20:22
 * @Description:
 */
public enum ResultCode {
    SUCCESS(200,"成功"),EXCEPTION(500,"服务器异常"),TIMEOUT(502,"超时"),PARAMETER_ERROR(403,"参数错误");

    private Integer code;
    private String msg;

    ResultCode(Integer code, String msg) {
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
