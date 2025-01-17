package com.itany.corejava.code13_jdbc;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author 石小俊
 * @date 2023年09月14日 11:25
 */
public class Test13_druid连接池 {

    public static void main(String[] args) throws Exception {
        test02();
    }

    public static void test01() throws SQLException {
        // 与commons-dbcp的区别在于连接池对象不一样
        // Druid使用的是:DruidDataSource
        // 其他完全一致
        // 创建连接池对象
        DruidDataSource ds = new DruidDataSource();

        // 设置连接池中连接数据库信息
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://127.0.0.1:3306/jdbc?useUnicode=true&characterEncoding=utf-8");
        ds.setUsername("root");
        ds.setPassword("");

        // 配置初始连接数:初始化连接池的时候建立的连接的数量
        ds.setInitialSize(1);
        // 最大活跃数:表示最多有多少个连接被使用
        ds.setMaxActive(2);
        // 最大空闲连接数:保证连接池中最多存在多少个空闲的连接
        ds.setMaxIdle(1);
        // 最小空闲连接数:保证连接池中最少存在多少个空闲的连接
        // 如果不够,可以自动开启。但是不能超出总数
        ds.setMinIdle(1);

        // 设置等待超时的时间,单位:毫秒
        // 等待获取连接池中连接的最大时间
        // 如果超过等待时间,则直接报错
        ds.setMaxWait(3000);

        // 获取连接
        Connection conn = ds.getConnection();
        System.out.println(conn);
        // 使用完毕后归还连接池
        // 等待下一个人使用
        // conn.close();

        // 第二个人获取连接
        Connection conn2 = ds.getConnection();
        System.out.println(conn2);

        // 第三个人获取连接
        Connection conn3 = ds.getConnection();
        System.out.println(conn3);
    }

    public static void test02() throws Exception {
        Properties p = new Properties();
        p.load(Test12_dbcp连接池.class.getClassLoader().getResourceAsStream("dataSource.properties"));

        // 与commons-dbcp的区别在于工厂类不一样
        // Druid使用的工厂类为:DruidDataSourceFactory
        // 其他完全一致
        DataSource ds = DruidDataSourceFactory.createDataSource(p);
        Connection conn = ds.getConnection();
        System.out.println(conn);
        conn.close();
        Connection conn2 = ds.getConnection();
        System.out.println(conn2);
    }

}
