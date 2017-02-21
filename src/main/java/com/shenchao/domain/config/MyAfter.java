package com.shenchao.domain.config;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by shenchao on 2017/2/1.
 */
public class MyAfter implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println(method.getName()+"....before");
    }
}
