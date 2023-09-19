package com.itany.shop.util;

import com.itany.shop.exception.DataAccessException;
import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author 石小俊
 * @date 2023年09月19日 13:31
 * 通过配置文件的方式读取数据库连接信息
 * 创建一个线程单例的数据库连接池
 */
public class JDBCUtil {

    private static DataSource ds;
    private static ThreadLocal<Connection> local;

    static {
        local = new ThreadLocal<>();
        Properties p = new Properties();
        try {
            p.load(JDBCUtil.class.getClassLoader().getResourceAsStream("dataSource.properties"));
            // commons-dbcp
            ds = BasicDataSourceFactory.createDataSource(p);
            // druid
            // ds = DruidDataSourceFactory.createDataSource(p);
        } catch (IOException e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError("JDBCUtil初始化失败");
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError("JDBCUtil初始化失败");
        }
    }

    /**
     * 获取连接
     * 使用数据库连接池获取一个线程单例的连接
     * @return
     */
    public static Connection getConnection() {
        // 从线程池中获取连接
        Connection conn = local.get();
        try {
            // 如果没有获取到连接,说明尚未获取过
            if (conn == null) {
                // 从连接池中取出一个连接
                conn = ds.getConnection();
                // 当拿到连接之后,将连接存放到线程池中
                // 如果下次再次使用连接,则直接可以从线程池中获取到
                local.set(conn);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DataAccessException("获取连接失败");
        }
        return conn;
    }

    /**
     * 释放持久层资源
     * 根据实际需求,传递需要释放的资源
     * 如果某个资源不能释放,则传递null即可
     * @param conn
     * @param ps
     * @param rs
     */
    public static void close(Connection conn, PreparedStatement ps, ResultSet rs) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new DataAccessException("释放连接失败");
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new DataAccessException("释放状态集失败");
            }
        }
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new DataAccessException("释放结果集失败");
            }
        }
    }

    /**
     * 释放业务层资源,一般用于事务执行完毕之后进行释放
     */
    public static void close() {
        // 从线程池中取出需要释放的连接
        Connection conn = local.get();
        try {
            // 如果获取到了连接,说明尚未释放
            if (conn != null) {
                // 释放连接
                conn.close();
                // 业务完毕之后,连接已经不需要了
                // 因此,可以从线程池中移除连接
                local.remove();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DataAccessException("释放连接失败");
        }
        // 如果线程池中没有获取到连接,则说明已经释放了,无需做任何操作
    }
}
