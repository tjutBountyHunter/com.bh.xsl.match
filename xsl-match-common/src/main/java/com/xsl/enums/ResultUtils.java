package com.xsl.enums;

import com.xsl.enums.DataStates;
import com.xsl.enums.ResultCode;
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
    public static XslResult isOk(Object data,String msg){
        return new XslResult(ResultCode.SUCCESS.getCode(), msg,data);
    }
    public static XslResult isOk(Object data){
        return isOk(data, ResultCode.SUCCESS.getMsg());
    }
    public static XslResult isOk(){
        return isOk(null);
    }

    /** 发生异常 */
    public static XslResult isError(String msg){
        return new XslResult(ResultCode.EXCEPTION.getCode(),msg);
    }
    public static XslResult isError(){
        return isError(ResultCode.EXCEPTION.getMsg());
    }


    /** 发生参数异常 */
    public static XslResult isParameterError(String msg){
        return new XslResult(ResultCode.PARAMETER_ERROR.getCode(),msg);
    }
    public static XslResult isParameterError(){
        return isParameterError(ResultCode.PARAMETER_ERROR.getMsg());
    }

    /** 判断是否成功 */
    public static boolean isSuccess(XslResult xslResult){
        return xslResult.getCode().equals(ResultCode.SUCCESS.getCode());
    }
    public static boolean isSuccess(Integer xslResult){
        return xslResult.equals(ResultCode.SUCCESS.getCode());
    }
}
