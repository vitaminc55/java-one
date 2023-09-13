package com.itany.corejava.code13_jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author 石小俊
 * @date 2023年09月13日 16:10
 */
public class Test09_批处理 {

    public static void main(String[] args) throws DataAccessException, SQLException {
        test01();
        System.out.println("------------------");
        test02();
    }


    public static void test01() throws DataAccessException {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = JDBCUtil.getConnection();
            String sql = new StringBuffer()
                    .append(" insert into ")
                    .append(" t_user ")
                    .append("   (username,password,phone,address)")
                    .append(" values ")
                    .append("   (?,?,?,?)")
                    .toString();
            long begin = System.currentTimeMillis();
            for (int i = 0; i < 1000; i++) {
                ps = conn.prepareStatement(sql);
                ps.setString(1, "test");
                ps.setString(2, "123456");
                ps.setString(3, "13812345678");
                ps.setString(4, "江苏-南京");
                ps.executeUpdate();
            }
            long end = System.currentTimeMillis();
            System.out.println("正常添加1000条数据共耗费了:" + (end - begin) + "毫秒");
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

    public static void test02() throws DataAccessException, SQLException {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = JDBCUtil.getConnection();
            conn.setAutoCommit(false);
            String sql = new StringBuffer()
                    .append(" insert into ")
                    .append(" t_user ")
                    .append("   (username,password,phone,address)")
                    .append(" values ")
                    .append("   (?,?,?,?)")
                    .toString();
            long begin = System.currentTimeMillis();
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < 1000; i++) {
                ps.setString(1, "test");
                ps.setString(2, "123456");
                ps.setString(3, "13812345678");
                ps.setString(4, "江苏-南京");

                // 将状态集对象添加到缓冲区
                ps.addBatch();
            }
            // 批量执行
            ps.executeBatch();
            conn.commit();
            long end = System.currentTimeMillis();
            System.out.println("批处理添加1000条数据共耗费了:" + (end - begin) + "毫秒");
        } catch (DataAccessException e) {
            e.printStackTrace();
            conn.rollback();
            throw e;
        } catch (SQLException e) {
            e.printStackTrace();
            conn.rollback();
            throw new DataAccessException("数据访问失败");
        } finally {
            JDBCUtil.close(conn, ps, null);
        }
    }

}
