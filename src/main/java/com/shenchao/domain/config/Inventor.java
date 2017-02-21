package com.shenchao.domain.config;

import java.util.Date;

/**
 * Created by shenchao on 2017/1/31.
 */
public class Inventor {
    private String name;
    private Date time;
    private String serbian;

    public Inventor(String name, Date time, String serbian) {
        this.name = name;
        this.time = time;
        this.serbian = serbian;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getSerbian() {
        return serbian;
    }

    public void setSerbian(String serbian) {
        this.serbian = serbian;
    }
}
