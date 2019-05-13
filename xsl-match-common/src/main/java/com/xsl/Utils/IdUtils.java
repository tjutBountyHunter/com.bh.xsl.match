package com.xsl.Utils;

import java.util.Random;
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
    public static String getUuid(){
        return getUuid("");
    }

    /**
     * 图片名生成
     */
    public static String genImageName() {
        //取当前时间的长整形值包含毫秒
        long millis = System.currentTimeMillis();
        //long millis = System.nanoTime();
        //加上三位随机数
        Random random = new Random();
        int end3 = random.nextInt(999);
        //如果不足三位前面补0
        String str = "MATCH-IMG-"+ millis + String.format("%03d", end3);
        return str;
    }
}
