package com.xsl.result;

import java.io.Serializable;

/**
 * 说明：通用返回值
 *
 * @Auther: 11432_000
 * @Date: 2019/4/21 20:20
 * @Description:
 */
public class XslResult implements Serializable {

    private Integer code;

    private String msg;

    private Object data;

    public XslResult(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public XslResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public XslResult() {
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
