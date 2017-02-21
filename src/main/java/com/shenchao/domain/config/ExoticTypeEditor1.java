package com.shenchao.domain.config;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by shenchao on 2017/1/31.
 */
public class ExoticTypeEditor1 extends PropertyEditorSupport {
    public void setAsText(String text) {
//        setValue(new ExoticType(text.toUpperCase()));
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            setValue(new ExoticType(dateFormat.parse(text)));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
