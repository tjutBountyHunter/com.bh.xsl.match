package com.xsl.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 说明：职位更改
 *
 * @Auther: 11432_000
 * @Date: 2019/5/15 16:26
 * @Description:
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE})
public @interface UpdatePosition {
}
