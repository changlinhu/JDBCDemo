package com.changlin.jdbc;


import com.changlin.pojo.Account;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * JDBC Mini Project
 */

public class JDBCDemo_ResultSet {
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
        ResultSet rs = stmt.executeQuery(sql);

        // 创建集合
        List<Account> list = new ArrayList<>(); // 多态性，左父类右子类 List list = new ArrayList()

        // 6.查询数据,光标向下移动一行，判断当前行是否有数据
        while (rs.next()) {
            // 每查询一个数据，创建一个对象
            Account account = new Account();

            // 获取数据
            int id = rs.getInt("id");
            String name = rs.getString("name");
            double money = rs.getDouble("money");

            //给对象赋值
            account.setId(id);
            account.setName(name);
            account.setMoney(money);

            // 存入集合
            list.add(account);

        }

        System.out.println(list);
        // 7. 释放资源
        rs.close();
        stmt.close();
        conn.close();
    }
}
