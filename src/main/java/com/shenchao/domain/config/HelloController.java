package com.shenchao.domain.config;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


/**
 * Created by shenchao on 2017/1/30.
 */
//@RestController
public class HelloController {
    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("/helloDataSource")
    public List sayHello() throws SQLException {
        Connection connection = dataSource.getConnection();
        QueryRunner queryRunner = new QueryRunner();
        List<User> query = queryRunner.query(connection, "select * from  user", new BeanListHandler<User>(User.class));
        System.out.println(query.size());
        return query;
    }
    @RequestMapping("/helloDataSource1")
    public List sayHello1() throws SQLException {
        List<User> query = jdbcTemplate.query("select * from user_table", new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();
                user.setId(rs.getString(1));
                return user;
            }
        });
        return query;
    }


}
