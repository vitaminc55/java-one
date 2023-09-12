package com.itany.corejava.code13_jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 石小俊
 * @date 2023年09月12日 14:50
 */
public class Test02_SQL注入 {

    public static void main(String[] args) {
        // List<User> users = login("admin","123456");
        // List<User> users = login("aaa","11");
//        List<User> users = login("1' or '1' = '1", "1' or '1' = '1");

        // 此时执行的sql如下
        // select * from t_user where username = '1\' or \'1\' = \'1' and password = '1\' or \'1\' = \'1'
        // 即username的值为1\' or \'1\' = \'1
        // password的值为1\' or \'1\' = \'1
        List<User> users = login2("1' or '1' = '1", "1' or '1' = '1");
        System.out.println(users);
    }

    public static List<User> login(String username, String password) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        List<User> users = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jdbc?useUnicode=true&characterEncoding=utf-8", "root", "");
            st = conn.createStatement();
            String sql = "select * from t_user where username = '" + username + "' and password = '" + password + "'";
            rs = st.executeQuery(sql);

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setPhone(rs.getString("phone"));
                user.setAddress(rs.getString("address"));
                users.add(user);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public static List<User> login2(String username, String password) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<User> users = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jdbc?useUnicode=true&characterEncoding=utf-8", "root", "");
            String sql = "select * from t_user where username = ? and password = ?";

            ps = conn.prepareStatement(sql);
            // 每一个?表示一个参数的值
            // 此时需要为参数赋值
            // ps.setXxx(index,value):为指定的sql参数赋值
                // Xxx表示传递的参数value的类型
                // index表示第几个?,值从1开始
                // value是具体的值
            ps.setString(1, username);
            ps.setString(2, password);

            rs = ps.executeQuery();

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setPhone(rs.getString("phone"));
                user.setAddress(rs.getString("address"));
                users.add(user);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}
