package com.xsl.Utils;

import com.xsl.enums.StatusCode;
import com.xsl.result.XslResult;

/**
 * 说明：常用返回值
 *
 * @Auther: 11432_000
 * @Date: 2019/4/21 20:21
 * @Description:
 */
public class ResultUtils {

    /** 执行成功 */
    public static XslResult isOk(Object data){
        return new XslResult(StatusCode.SUCCESS.getCode(),StatusCode.SUCCESS.getMsg(),data);
    }
    public static XslResult isOk(){
        return isOk(null);
    }

    /** 发生异常 */
    public static XslResult isError(String msg){
        return new XslResult(StatusCode.EXCEPTION.getCode(),msg);
    }
    public static XslResult isError(){
        return isError(StatusCode.EXCEPTION.getMsg());
    }


    /** 发生参数异常 */
    public static XslResult isParameterError(String msg){
        return new XslResult(StatusCode.PARAMETER_ERROR.getCode(),msg);
    }
    public static XslResult isParameterError(){
        return isParameterError(StatusCode.PARAMETER_ERROR.getMsg());
    }
}
