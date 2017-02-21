package com.shenchao.domain.config;

import com.shenchao.domain.config.child.BeanB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by shenchao on 2017/1/30.
 */
@Component
public class BeanA {
    @Autowired
    private BeanB b;

    public BeanB getB() {
        return b;
    }

    public void setB(BeanB b) {
        this.b = b;
    }
}
