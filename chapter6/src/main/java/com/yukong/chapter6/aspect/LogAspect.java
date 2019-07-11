package com.yukong.chapter6.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author qinjunjie
 * @projectName testDemo
 * @title: LogAspect
 * @description: TODO
 * @date 2019/7/1019:38
 */
@Aspect
@Component
public class LogAspect {

    @Pointcut("@annotation(com.yukong.chapter6.annotation.Log)")
    public void annotationPointCut() {

    }

    @Before("annotationPointCut()")
    public void before(JoinPoint joinPoint){

    }

}
