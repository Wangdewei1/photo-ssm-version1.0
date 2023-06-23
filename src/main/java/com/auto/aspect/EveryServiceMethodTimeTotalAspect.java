package com.auto.aspect;

import com.auto.pojo.Log;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 统计service所有方法的总时长
 */
@Component
@Aspect
public class EveryServiceMethodTimeTotalAspect {
    //日志
    private static Log log;
    Logger logger = LoggerFactory.getLogger(EveryServiceMethodTimeTotalAspect.class);

    @Pointcut("execution(* com.auto.service.impl.*.*(..))")
    public void allServiceMethod() {

    }

/*    //要增强的方法
    @Around("allServiceMethod()")
    public Object totalTime(ProceedingJoinPoint pjp) {

        //开始执行方法的时间
        Long startTime = System.currentTimeMillis();

        Object result = null;
        Long endTime = null;
        Long totalTime = null;
        try {
            result = pjp.proceed();
            return result;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        } finally {
            //方法执行结束时间
            endTime = System.currentTimeMillis();
            totalTime = endTime - startTime;
            //日志对象
            String methodName = pjp.getSignature().getName();
            String allClassName = pjp.getTarget().getClass().getName();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String currentTime = simpleDateFormat.format(new Date());
            log = new Log(
                    null,
                    methodName + allClassName + totalTime,
                    currentTime
            );
            logger.debug("总时长：" + pjp.getSignature().getName() + totalTime + "毫秒");
        }
    }*/

    //要增强的方法
    @Before("allServiceMethod()")
    public void totalTimeAfter(JoinPoint joinPoint){
        Long startTime = System.currentTimeMillis();
        String methodName = joinPoint.getSignature().getName();
        String allClassName = joinPoint.getTarget().getClass().getName();
        Long endTime = System.currentTimeMillis();
        Long totalTime = endTime - startTime;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = simpleDateFormat.format(new Date());
        log = new Log(
                null,
                methodName + allClassName + totalTime,
                currentTime
        );
        logger.debug(totalTime + "" + methodName);
    }

    /**
     * 获取日志
     */
    public static Log getLogInfo() {
        return log;
    }
}
