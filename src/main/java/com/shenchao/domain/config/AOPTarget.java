package com.shenchao.domain.config;

import org.springframework.stereotype.Component;

/**
 * Created by shenchao on 2017/2/1.
 */
@Component
public class AOPTarget {
    public void testNormal(){
        System.out.println("这个是一个normal的方法");
    }

    public void testThrows(){
        System.out.println("出错了");
        throw new RuntimeException("出错了");
    }
}
