package com.xsl.Utils;

import java.util.UUID;

/**
 * 说明：ID 相关工具类
 *
 * @Auther: 11432_000
 * @Date: 2019/4/24 15:37
 * @Description:
 */
public class IdUtils {

    /** 获取一个自定义前缀的UUID */
    public static String getUuid(String prefix){
        return prefix + UUID.randomUUID().toString();
    }
}
