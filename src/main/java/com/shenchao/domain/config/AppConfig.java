package com.shenchao.domain.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * Created by shenchao on 2017/1/30.
 */
@Configuration
public class AppConfig {
    @Value("${jdbc.password}")
    private String password;
    @Value("${jdbc.user}")
    private String user;
    @Value("${jdbc.jdbcUrl}")
    private String url;
    @Value("${jdbc.driverClass}")
    private String classDriverName;

//    @Bean
    public DataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(password);
        dataSource.setJdbcUrl(url);
        dataSource.setDriverClass(classDriverName);
        return dataSource;
    }

//    @Bean
//    public CustomEditorConfigurer customEditorConfigurer(){
//        Map<Class<?>, Class<? extends PropertyEditor>> customEditors = new HashMap<>();
//        CustomEditorConfigurer customEditorConfigurer = new CustomEditorConfigurer();
//        customEditors.put(ExoticType.class, ExoticTypeEditor1.class);
//        customEditorConfigurer.setCustomEditors(customEditors);
//        return customEditorConfigurer;
//    }


    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig bean = context.getBean(AppConfig.class);
        System.out.println(bean);
    }


    @Bean
    public ClientService clientService2() {
        ClientServiceImpl clientService = new ClientServiceImpl();
        clientService.setClientDao(clientDao());
        return clientService;
    }

    @Bean
    @Scope("prototype")
    public ClientDao clientDao() {
        return new ClientDaoImpl();
    }
}