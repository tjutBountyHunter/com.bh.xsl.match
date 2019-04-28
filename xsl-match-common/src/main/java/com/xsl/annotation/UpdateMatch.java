package com.xsl.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 说明：更新比赛的注解
 *
 * @Auther: 11432_000
 * @Date: 2019/4/28 09:52
 * @Description:
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE})
public @interface UpdateMatch {
}
