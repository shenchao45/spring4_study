package com.shenchao.domain.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by shenchao on 2017/2/1.
 */
@Component
@Aspect
public class AOPTest {
    @Pointcut("execution(* com.shenchao..AOPTarget.*(..))")
    public void myPoint(){}
    @Before("myPoint()")
    public void before(){
        System.out.println("这是aop的before方法。。。");
    }
    @After("myPoint()")
    public void After(){
        System.out.println("After。。。");
    }
    @AfterReturning("myPoint()")
    public void AfterReturning(){
        System.out.println("AfterReturning。。。");
    }
    @AfterThrowing("myPoint()")
    public void AfterThrowing(){
        System.out.println("AfterThrowing。。。");
    }
    @Around("myPoint()")
    public Object Around(ProceedingJoinPoint point) throws Throwable {
        System.out.println("before ....Around。。。");
        Object proceed = point.proceed();
        System.out.println("after......Around......");
        return proceed;
    }

}
