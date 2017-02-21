package com.shenchao.domain.config;

/**
 * Created by shenchao on 2017/1/30.
 */
public class Hello {
    public String name;

    public Hello(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Hello{" +
                "name='" + name + '\'' +
                '}';
    }
}
