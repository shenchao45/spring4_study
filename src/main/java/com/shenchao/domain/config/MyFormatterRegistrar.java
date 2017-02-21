package com.shenchao.domain.config;

import org.springframework.format.FormatterRegistrar;
import org.springframework.format.FormatterRegistry;

/**
 * Created by shenchao on 2017/1/31.
 */
public class MyFormatterRegistrar implements FormatterRegistrar {
    @Override
    public void registerFormatters(FormatterRegistry registry) {
        registry.addConverter(new MyFormatting());
    }
}
