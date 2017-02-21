package com.shenchao.domain.config;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;

/**
 * Created by shenchao on 2017/2/1.
 */
public class MyAdvisor implements Advisor {
    @Override
    public Advice getAdvice() {
        return null;
    }

    @Override
    public boolean isPerInstance() {
        return false;
    }
}
