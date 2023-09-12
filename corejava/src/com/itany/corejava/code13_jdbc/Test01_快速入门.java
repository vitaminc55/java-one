package com.itany.corejava.code13_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author 石小俊
 * @date 2023年09月12日 10:11
 */
public class Test01_快速入门 {

    public static void main(String[] args) {
        User user = new User("admin","123456","13812345678","江苏-南京");
        insertUser(user);
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
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jdbc", "root", "");

            // 3.获取状态集
            st = conn.createStatement();

            // 4.执行sql
            // 准备一个需要执行的sql语句
            String sql = "insert into t_user(username,password,phone,address) values('" + user.getUsername() + "','" + user.getPassword() + "','" + user.getPhone() + "','" + user.getAddress() + "')";
            // 执行DML操作。即:增删改操作
            // 方法返回值为受到影响的数据行数
            int rows = st.executeUpdate(sql);
            System.out.println("Query Ok,"+rows+" rows affected");

            // 如果是查询,存在第五步
            // 5.处于结果集,仅限查询操作
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.err.println("找不到驱动");
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("数据库访问失败");
        } finally {
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.err.println("释放资源出错");
                }
            }
            if(st != null){
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
