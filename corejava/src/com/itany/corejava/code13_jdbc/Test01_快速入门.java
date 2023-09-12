package com.itany.corejava.code13_jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 石小俊
 * @date 2023年09月12日 10:11
 */
public class Test01_快速入门 {

    public static void main(String[] args) {
//        User user = new User("jack", "111111", "13812345678", "江苏-苏州");
//        insertUser(user);
        List<User> users = selectAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    public static void updateUser(User user){

    }

    public static void deleteById(Integer id){

    }

    public static User selectById(Integer id){
        return null;
    }

    /**
     * 查询所有用户信息
     * @return
     */
    public static List<User> selectAll() {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        List<User> users = new ArrayList<>();
        try {
            // 1.注册驱动
            Class.forName("com.mysql.jdbc.Driver");

            // 2.获取连接
            // 在Java访问数据库的时候,可能会产生乱码
            // 为了解决JDBC导致的乱码,需要在url地址末尾添加一个后缀
            // ?useUnicode=true&characterEncoding=utf-8
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc?useUnicode=true&characterEncoding=utf-8", "root", "");

            // 3.获取状态集
            st = conn.createStatement();

            // 4.执行sql
            String sql = "select id,username,password,phone,address from t_user";
            // 执行查询操作
            rs = st.executeQuery(sql);

            // 5.处理结果集
            // 将数据库查询的结果集映射成Java对象
            // 查询的结果集中的每一行数据映射成一个Java对象
            // executeQuery方法的返回值ResultSet表示数据库的结果集
            // 在映射时,根据ResultSet提供的next方法判断是否有下一行数据
            // 返回值为true表示有数据,则需要映射
            // 返回值为false表示没有数据,则不需要映射
            while (rs.next()) {
                // 只要结果集中有尚未映射的数据,则需要映射成对象
                // 每次读取一行,映射一个Java对象
                User user = new User();
                // 将结果集中的列的数据映射成Java对象属性的值
                // 在ResultSet中提供了获取列的数据的方法
                // getXxxx(int columIndex):获取第几列的数据,参数表示第几列
                // 其值从1开始
                user.setId(rs.getInt(1));
                // 开发中字段可能会比较多,如果使用第几列的方式进行获取的话可能比较混乱
                // 因此,建议使用指定列名的方式进行获取
                // getXxx(String columnLabel):获取哪一列的数据,参数表示列名
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setPhone(rs.getString("phone"));
                user.setAddress(rs.getString("address"));

                // 此时映射完成之后只是映射了一个对象
                // 但是结果集中可能包含无数行数据,每一行数据都需要映射成一个Java对象
                // 因此,可以通过一个对象集合来接收这些对象
                // 每映射一次,生成一个Java对象,添加到对应的对象集合中
                users.add(user);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.err.println("找不到驱动");
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("数据库访问失败");
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.err.println("释放资源出错");
                }
            }
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.err.println("释放资源出错");
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.err.println("释放资源出错");
                }
            }
        }
        return users;
    }


    /**
     * 添加用户信息
     *
     * @param user
     */
    public static void insertUser(User user) {
        Connection conn = null;
        Statement st = null;
        try {
            // 1.注册驱动
            // 注册由数据库厂商所提供的驱动
            // 根据数据库类型不同、版本不同, 驱动类所在的包名与类名都有可能不同
            // 此处以MySQL为例
            // 注册驱动是通过后面的反射来实现的,目前尚未学习,请照抄
            // Class.forName("包名.类名")
            // MySQL5的驱动类的地址:com.mysql.jdbc.Driver
            // MySQL8的驱动类的地址:com.mysql.cj.jdbc.Driver
            Class.forName("com.mysql.jdbc.Driver");

            // 2.获取连接
            // 连接到指定的数据库服务器,由数据库厂商提供了连接方式
            // 参数一:连接到数据库的url地址
            // 对于MySQL而言,其url地址格式为
            // jdbc:mysql://mysql服务的ip地址:端口号/库名
            // ip地址可以用服务器地址,也可以用本地地址
            // 所有计算机的本地地址都是127.0.0.1或者localhost
            // 端口号默认使用3306
            // 参数二:数据库用户名
            // 参数三:该用户对应的密码
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jdbc?useUnicode=true&characterEncoding=utf-8", "root", "");

            // 3.获取状态集
            st = conn.createStatement();

            // 4.执行sql
            // 准备一个需要执行的sql语句
            String sql = "insert into t_user(username,password,phone,address) values('" + user.getUsername() + "','" + user.getPassword() + "','" + user.getPhone() + "','" + user.getAddress() + "')";
            // 执行DML操作。即:增删改操作
            // 方法返回值为受到影响的数据行数
            int rows = st.executeUpdate(sql);
            System.out.println("Query Ok," + rows + " rows affected");

            // 如果是查询,存在第五步
            // 5.处于结果集,仅限查询操作
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.err.println("找不到驱动");
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("数据库访问失败");
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.err.println("释放资源出错");
                }
            }
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.err.println("释放资源出错");
                }
            }
        }
    }

}
