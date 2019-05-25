package com.xsl.Utils;

import com.xsl.enums.ResultCodeEnum;
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
    public static XslResult ok(Object data){
        return new XslResult(ResultCodeEnum.SUCCESS.getCode(), ResultCodeEnum.SUCCESS.getMsg(),data);
    }
    public static XslResult ok(){
        return ok(null);
    }

    /** 发生异常 */
    public static XslResult error(String msg){
        return new XslResult(ResultCodeEnum.EXCEPTION.getCode(),msg);
    }
    public static XslResult error(){
        return error(ResultCodeEnum.EXCEPTION.getMsg());
    }


    /** 发生参数异常 */
    public static XslResult parameterError(String msg){
        return new XslResult(ResultCodeEnum.PARAMETER_ERROR.getCode(),msg);
    }
    public static XslResult parameterError(){
        return parameterError(ResultCodeEnum.PARAMETER_ERROR.getMsg());
    }
    /** 资源重复 */
    public static XslResult repeat(Object data){
        return new XslResult(ResultCodeEnum.RESOURCE_DUPLICATION.getCode(),ResultCodeEnum.RESOURCE_DUPLICATION.getMsg(),data);
    }
    public static XslResult repeat(){
        return repeat(null);
    }

    /** 校验请求是否成功 */
    public static Boolean isSuccess(XslResult xslResult){
        return ResultCodeEnum.SUCCESS.getCode().equals(xslResult.getCode());
    }
    public static Boolean isSuccess(Integer xslResult){
        return ResultCodeEnum.SUCCESS.getCode().equals(xslResult);
    }

    /** 资源不存在 */
    public static XslResult notHave(Object data){
        return new XslResult(ResultCodeEnum.NOT_HAVE.getCode(),ResultCodeEnum.NOT_HAVE.getMsg(),data);
    }
    public static XslResult notHave(){
        return notHave(null);
    }
}
