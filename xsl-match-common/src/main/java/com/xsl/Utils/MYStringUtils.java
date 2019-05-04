package com.xsl.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2019/5/3 19:14
 * @Description:
 */
public class MYStringUtils {

    /** 将 target 字符串按 Separator 分隔为 List */
    public static List<String> getStringList(String target,String separator){
        if (target == null){ return new ArrayList<String>(); }
        ArrayList<String> strings = new ArrayList<String>();
        if (separator == null || "".equals(separator)){
            strings.add(target);
            return strings;
        }
        String[] split = target.split(separator);
        return Arrays.asList(split);
    }
}
