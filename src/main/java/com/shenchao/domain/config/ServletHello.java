package com.shenchao.domain.config;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;

/**
 * Created by shenchao on 2017/1/30.
 */
@javax.servlet.annotation.WebServlet(name = "ServletHello",urlPatterns = "/hello")
public class ServletHello extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        try {
            Context initCtx = new InitialContext();
            Context envCtx = (Context) initCtx.lookup("java:comp/env");
            DataSource ds = (DataSource)
                    envCtx.lookup("jdbc/mysql");
            Connection conn = ds.getConnection();
            System.out.println(conn);
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
