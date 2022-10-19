package com.changlin.jdbc;


import java.sql.*;

/**
 * API详解：PreparedStatement
 */

public class JDBCDemo_PreparedStatement {

    public static void main(String[] args) throws Exception {
        // 1. 注册驱动 load the driver class
        // jar包中services/java.sql.Driver中已经传入
        //Class.forName("com.mysql.cj.jdbc.Driver");


        String url = "jdbc:mysql://localhost:3306/db1";
        String username = "root";
        String password = "0520";
        Connection conn = DriverManager.getConnection(url, username, password);


        String name = "sdadss";
        String pwd = "' or '1' = '1";


        String sql = "SELECT * FROM tb_user WHERE username = ? and password = ?";

        // 获取PreparedStatement方法防止sql注入
        PreparedStatement pstmt = conn.prepareStatement(sql);

        // 设置？的值
        pstmt.setString(1, name);
        pstmt.setString(2, pwd);


        ResultSet rs = pstmt.executeQuery(); //注意此处executeQuery()方法不要再传入sql参数


        
        if (rs.next()) {
            System.out.println("登陆成功!");
        } else {
            System.out.println("登陆失败!");
        }

        // 7. 释放资源
        rs.close();
        pstmt.close();
        conn.close();
    }
}
