package com.xdclass.web.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Greated by Terry on 2019/4/19
 * Time: 2:15
 */
//@Aspect//面向切面
//@Component
public class TimeAspect {
    @Around("execution(* com.xdclass.web.controller.UserController.*(..))")
    public Object handleControllerMethod(ProceedingJoinPoint pjp) throws Throwable {

        System.out.println("time aspect start");

        Object[] args = pjp.getArgs();
        for (Object arg : args) {
            System.out.println("arg is "+arg);
        }

        long start = new Date().getTime();

        Object object = pjp.proceed();

        System.out.println("time aspect 耗时:"+ (new Date().getTime() - start));

        System.out.println("time aspect end");

        return object;
    }
}
