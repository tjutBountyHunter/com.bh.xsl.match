package com.xsl.Utils;

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
    public static XslResult isOk(Object data){
        return new XslResult(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMsg(),data);
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

    /** 校验请求是否成功 */
    public static Boolean isSuccess(XslResult xslResult){
        return ResultCode.SUCCESS.getCode().equals(xslResult.getCode());
    }
    public static Boolean isSuccess(Integer xslResult){
        return ResultCode.SUCCESS.getCode().equals(xslResult);
    }
}
