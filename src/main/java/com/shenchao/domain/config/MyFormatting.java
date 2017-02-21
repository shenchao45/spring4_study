package com.shenchao.domain.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * Created by shenchao on 2017/1/31.
 */
public class MyFormatting implements Converter<String,ExoticType>,Formatter<ExoticType> {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public ExoticType convert(String source) {
        try {
            return new ExoticType(dateFormat.parse(source));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ExoticType parse(String text, Locale locale) throws ParseException {
        return new ExoticType(dateFormat.parse(text));
    }

    @Override
    public String print(ExoticType object, Locale locale) {
        return dateFormat.format(object.getName());
    }
}
