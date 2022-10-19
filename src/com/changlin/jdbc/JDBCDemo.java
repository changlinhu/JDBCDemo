package com.changlin.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * JDBC Mini Project
 */

public class JDBCDemo {
    public static void main(String[] args) throws Exception {
        // 1. 注册驱动 load the driver class
        // jar包中services/java.sql.Driver中已经传入
        //Class.forName("com.mysql.cj.jdbc.Driver");

        // 2. 获取连接
        String url = "jdbc:mysql://localhost:3306/db1";
        String username = "root";
        String password = "0520";
        Connection conn = DriverManager.getConnection(url, username, password);

        // 3. 定义sql语句
         String sql = "SELECT * FROM account";

        // 4. 获取执行sql的对象 Statement
        Statement stmt = conn.createStatement();

        // 5. 执行sql
        int count = stmt.executeUpdate(sql); // 返回值为 affected rows

        // 6. 处理结果
        System.out.println(count);

        // 7. 释放资源
        stmt.close(); // 先释放stmt后释放conn
        conn.close();

    }
}
