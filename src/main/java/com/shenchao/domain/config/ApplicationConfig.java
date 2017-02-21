package com.shenchao.domain.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.io.IOException;
import java.sql.SQLException;
import java.util.GregorianCalendar;

/**
 * Created by shenchao on 2017/1/28.
 */
//@Configuration
//@ComponentScan(basePackages = "com.shenchao.domain.config")
//@EnableAspectJAutoProxy
//@EnableTransactionManagement
public class ApplicationConfig {
    public static void main1(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        AOPTarget bean = context.getBean(AOPTarget.class);
        bean.testThrows();
    }

    public static void main2(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression("'Hello world'.concat('!')");
        System.out.println(expression.getValue());
        expression = parser.parseExpression("'hello'.bytes");
        byte[] bytes = (byte[]) expression.getValue();
        System.out.println(bytes.length);
        expression = parser.parseExpression("'hello'.bytes.length");
        System.out.println(expression.getValue());
        expression = parser.parseExpression("new String('hello world').toUpperCase()");
        System.out.println(expression.getValue());

        GregorianCalendar c = new GregorianCalendar();
        c.set(1856, 7, 9);

        Inventor tesla = new Inventor("沈超", c.getTime(), "Serbian");
        expression = parser.parseExpression("name");
        StandardEvaluationContext context = new StandardEvaluationContext(tesla);
        String name = (String) expression.getValue(context);
        System.out.println(name);

        expression = parser.parseExpression("name=='沈超'");
        Boolean value = expression.getValue(tesla, Boolean.class);
        System.out.println(value);
    }

    public static void main(String[] args) throws SQLException, IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        Person bean = (Person) context.getBean("myPerson");
        System.out.println(bean.getClass().getName());
        bean.sayHi();

        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
    }

}
