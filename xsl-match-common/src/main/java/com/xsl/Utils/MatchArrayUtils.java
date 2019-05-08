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

    /** 获取两个数组的交集 需要重写hashCode()和equals()方法*/
    public static <T> List<T> getIntersection(List<T> list1, List<T> list2){
        List<T> result = new ArrayList<T>();
        Set<T> set = new HashSet<T>();
        //去重
        for (T t1 : list1){
            set.add(t1);
        }
        //提取交集
        for (T t2 : list2){
            if (set.contains(t2)){
                result.add(t2);
                set.remove(t2);
            }
        }
        return result;
    }

    /** 分页 */
    public static <T> List<T> pageHelper(List<T> list, Integer page,Integer rows){
        int start = (page - 1) * rows;
        int end = start + rows;
        ArrayList<T> ts = new ArrayList<T>();
        for (int i = start; i < end && i < list.size(); i++) {
            ts.add(list.get(i));
        }
        return ts;
    }

}
