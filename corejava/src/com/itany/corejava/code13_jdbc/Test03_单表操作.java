package com.itany.corejava.code13_jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 石小俊
 * @date 2023年09月12日 15:43
 */
public class Test03_单表操作 {

    public static void main(String[] args) throws DataAccessException {
        // User user = new User("jack","111111","13912345678","江苏-苏州");
        // insertUser(user);
        // deleteById(4);
        // User user = new User(2,"tom","222222","13612345678","江苏-泰州");
        // updateUser(user);
        // User user = selectById(1);
        // System.out.println(user);
        List<User> users = selectAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    public static void insertUser(User user) throws DataAccessException {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = JDBCUtil.getConnection();

            // String sql = "insert into t_user(username,password,phone,address) values(?,?,?,?)";
            // 开发中由于SQL过长,导致可读性会降低
            // 一般可以使用StringBuffer来进行字符串拼接
            // 提高代码的可读性
            String sql = new StringBuffer()
                    .append(" insert into ")
                    .append(" t_user")
                    .append("   (username,password,phone,address)")
                    .append(" values")
                    .append("   (?,?,?,?)")
                    .toString();
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getPhone());
            ps.setString(4, user.getAddress());
            // 执行DML操作
            ps.executeUpdate();
            System.out.println("添加成功");
        } catch (DataAccessException e) {
            e.printStackTrace();
            throw e;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DataAccessException("数据访问失败");
        } finally {
            JDBCUtil.close(conn, ps, null);
        }

    }

    public static void deleteById(Integer id) throws DataAccessException {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = JDBCUtil.getConnection();
            String sql = new StringBuffer()
                    .append(" delete from t_user ")
                    .append(" where id = ? ")
                    .toString();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("删除成功");
        } catch (DataAccessException e) {
            e.printStackTrace();
            throw e;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DataAccessException("数据访问失败");
        } finally {
            JDBCUtil.close(conn, ps, null);
        }
    }

    public static void updateUser(User user) throws DataAccessException {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = JDBCUtil.getConnection();

            String sql = new StringBuffer()
                    .append(" update t_user  ")
                    .append(" set ")
                    .append("   username = ?, ")
                    .append("   password = ?, ")
                    .append("   phone = ?, ")
                    .append("   address = ? ")
                    .append(" where id = ?")
                    .toString();
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getPhone());
            ps.setString(4, user.getAddress());
            ps.setInt(5, user.getId());
            // 执行DML操作
            ps.executeUpdate();
            System.out.println("修改成功");
        } catch (DataAccessException e) {
            e.printStackTrace();
            throw e;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DataAccessException("数据访问失败");
        } finally {
            JDBCUtil.close(conn, ps, null);
        }
    }

    public static User selectById(Integer id) throws DataAccessException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;

        try {
            conn = JDBCUtil.getConnection();

            String sql = new StringBuffer()
                    .append(" select id,username,password,phone,address ")
                    .append(" from t_user ")
                    .append(" where id = ? ")
                    .toString();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setPhone(rs.getString("phone"));
                user.setAddress(rs.getString("address"));
            }
        } catch (DataAccessException e) {
            e.printStackTrace();
            throw e;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DataAccessException("数据访问失败");
        } finally {
            JDBCUtil.close(conn, ps, rs);
        }
        return user;
    }

    public static List<User> selectAll() throws DataAccessException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<User> users = new ArrayList<>();

        try {
            conn = JDBCUtil.getConnection();

            String sql = new StringBuffer()
                    .append(" select id,username,password,phone,address ")
                    .append(" from t_user ")
                    .toString();
            ps = conn.prepareStatement(sql);
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
        } catch (DataAccessException e) {
            e.printStackTrace();
            throw e;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DataAccessException("数据访问失败");
        } finally {
            JDBCUtil.close(conn, ps, rs);
        }
        return users;
    }

}
