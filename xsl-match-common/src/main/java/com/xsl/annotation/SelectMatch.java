package com.xsl.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 说明：对比赛进行查询时的注解
 *
 * @Auther: 11432_000
 * @Date: 2019/4/28 13:38
 * @Description:
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface SelectMatch {
}
