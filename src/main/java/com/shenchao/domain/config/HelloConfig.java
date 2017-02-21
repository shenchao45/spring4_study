package com.shenchao.domain.config;

import org.springframework.beans.factory.InjectionPoint;
import org.springframework.context.annotation.Bean;

/**
 * Created by shenchao on 2017/1/30.
 */
public class HelloConfig {
    @Bean(name = "hello3")
    public Hello getHello1(){
        return new Hello("hello1");
    }
    @Bean(name = "hello4")
    public Hello getHello2(InjectionPoint injectionPoint){
        return new Hello("hello2..."+injectionPoint.getMember());
    }
}
