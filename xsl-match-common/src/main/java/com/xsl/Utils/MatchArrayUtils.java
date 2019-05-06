package com.xsl.Utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 说明：容器工具
 *
 * @Auther: 11432_000
 * @Date: 2019/5/5 19:46
 * @Description:
 */
public class MatchArrayUtils {

    /** 获取两个数组的交集 需要重写equals()方法*/
    public static <T> List<T> getIntersection(List<T> list1, List<T> list2){
        List<T> result = new ArrayList<T>();
        for (T t1 : list1){
            for (T t2 : list2){
                if (t1.equals(t2)){
                    result.add(t1);
                    break;
                }
            }
        }
        return result;
    }

}
