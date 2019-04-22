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

}
