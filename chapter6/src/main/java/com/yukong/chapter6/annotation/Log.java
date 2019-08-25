package com.yukong.chapter6.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author qinjunjie
 * @projectName testDemo
 * @title: Log
 * @description: TODO
 * @date 2019/7/1019:32
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.METHOD,ElementType.TYPE})
public @interface Log {
    //详情
    String value() default "";
    //备注
    String mark() default "";
}
