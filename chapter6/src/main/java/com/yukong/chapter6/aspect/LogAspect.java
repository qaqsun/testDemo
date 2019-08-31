package com.yukong.chapter6.aspect;

import com.alibaba.fastjson.JSON;
import com.yukong.chapter6.annotation.Log;
import com.yukong.chapter6.entity.SysLogEntity;
import com.yukong.chapter6.service.SysLogService;
import com.yukong.chapter6.utils.IPUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author qinjunjie
 * @projectName testDemo
 * @title: LogAspect
 * @description: TODO
 * @date 2019/7/1019:38
 */
@Aspect
@Component
@Slf4j
public class LogAspect {

    @Autowired
    private SysLogService sysLogService;

    @Pointcut("@annotation(com.yukong.chapter6.annotation.Log)")
    public void annotationPointCut() {

    }

    @Around("annotationPointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable
    {
        long startTime = System.currentTimeMillis();

        // 执行方法
        Object result = joinPoint.proceed();
        // 执行时间
        long time = System.currentTimeMillis() - startTime;
        // 保存日志
        saveLog(joinPoint,time);
        return result;
    }

    private void saveLog(ProceedingJoinPoint point,long time){
        SysLogEntity logEntity = new SysLogEntity();
        MethodSignature signature = (MethodSignature)point.getSignature();
        // 获取方法
        Method method = signature.getMethod();
        Log logInfo = method.getAnnotation(Log.class);
        if (logInfo != null) {
            // 注解上的描述
            logEntity.setOperation(logInfo.value());
            log.info("备注值===="+logInfo.mark());
        }
        // 获取方法名
        String className = point.getTarget().getClass().getName();
        String methodName = signature.getName();
        logEntity.setMethodName(className+"."+methodName+"()");
        // 方法接收的参数
        Object[] args = point.getArgs();
        String params = JSON.toJSONString(args);
        logEntity.setParams(params);
        logEntity.setTime(time);

        //获取request
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        logEntity.setIp(IPUtils.getIpAddr(request));
        logEntity.setCreateTime(new Date());
        // 保存记录
        sysLogService.save(logEntity);
    }

}
