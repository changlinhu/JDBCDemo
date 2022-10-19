package com.changlin.jdbc;


import com.changlin.pojo.Account;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户登陆
 */

public class JDBCDemo_UserLogin {

    public static void main(String[] args) throws Exception {
        // 1. 注册驱动 load the driver class
        // jar包中services/java.sql.Driver中已经传入
        //Class.forName("com.mysql.cj.jdbc.Driver");

        // 2. 获取连接
        String url = "jdbc:mysql://localhost:3306/db1";
        String username = "root";
        String password = "0520";
        Connection conn = DriverManager.getConnection(url, username, password);

        // 接收用户登陆的用户名和密码
        String name = "sddsgjvsvs";
        String pwd = "' or '1' = '1";

        String sql = "SELECT * FROM tb_user WHERE username = '"+name+"' and password = '"+pwd+"'";
        System.out.println(sql);

        // 获取stmt对象
        Statement stmt = conn.createStatement();
        
        // 执行sql
        ResultSet rs = stmt.executeQuery(sql);

        // 判断登陆是否成功
        if (rs.next()) {
            System.out.println("登陆成功!");
        } else {
            System.out.println("登陆失败!");
        }

        // 7. 释放资源
        rs.close();
        stmt.close();
        conn.close();
    }
}
