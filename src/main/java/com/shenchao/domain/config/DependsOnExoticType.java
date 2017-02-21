package com.shenchao.domain.config;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by shenchao on 2017/1/31.
 */
public class DependsOnExoticType {

    private ExoticType type;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ExoticType getType() {
        return type;
    }

    public void setType(ExoticType type) {
        this.type = type;
    }
}
