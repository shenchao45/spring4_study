package com.shenchao;

import com.mchange.v1.io.OutputStreamUtils;
import com.shenchao.domain.config.BeanA;
import com.shenchao.domain.config.MyServlet;
import com.shenchao.domain.config.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.annotation.Repeat;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.annotation.Timed;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.AfterTransaction;
import org.springframework.test.context.transaction.BeforeTransaction;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.jdbc.JdbcTestUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.ServletWebRequest;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by shenchao on 2017/2/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@TestPropertySource(properties = {"sc.hello:沈超"})
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@Transactional
@Rollback
//@ContextHierarchy({
//        @ContextConfiguration(name = "parent", locations = "classpath:parent.xml"),
//        @ContextConfiguration(name = "child", locations = "classpath:child.xml")
//})
public class SpringJunit4Test {
    @Autowired
    private BeanA beanA;
    @BeforeTransaction
    public void beforeTransaction() {
        System.out.println("transaction before.....");
    }
    @AfterTransaction
    public void afterTransaction() {
        System.out.println("transaction after.....");
    }
    @Autowired
    private ApplicationContext context;
    @Value("${jdbc.user}")
    private String user;
    @Autowired
    MockServletContext servletContext; // cached

    @Autowired
    MockHttpSession session;

    @Autowired
    MockHttpServletRequest request;

    @Autowired
    MockHttpServletResponse response;

    @Autowired
    ServletWebRequest webRequest;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private MyServlet myServlet;
    @Test
    public void testContext() throws IOException {
        Environment environment = context.getEnvironment();
        System.out.println(user);
        String property = environment.getProperty("sc.hello");
        System.out.println(property);
    }

    @Test
    @Repeat(10)
    @Timed(millis = 1000)
    @Sql(scripts = {"classpath:init.sql","classpath:init_data.sql"},config = @SqlConfig(commentPrefix = "--", separator = ";"))
    public void testDb(){
        jdbcTemplate.query("select * from my_user where name='沈超'", new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                int anInt = rs.getInt(1);
                String string = rs.getString(2);
                System.out.println(anInt+"::::"+string);
            }
        });
    }

    @Test
    public void testWeb(){
        int user = JdbcTestUtils.countRowsInTable(jdbcTemplate, "user");
        System.out.println(user);
    }
    @Test
    public void testEmbeddedDatabase(){
        List<User> query = jdbcTemplate.query("select name from my_user", new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();
                user.setUsername(rs.getString(1));
                return user;
            }
        });
        System.out.println(query);
    }
}
