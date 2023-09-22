package com.itany.shop.util;

import com.itany.shop.exception.DataAccessException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 石小俊
 * @date 2023年09月19日 13:45
 * JDBC模板方法:对JDBC访问数据库的操作进行封装
 */
public class JDBCTemplate<T> {

    /**
     * 执行一个DML操作。即:insert、delete、update
     * 对于DML操作,使用的都是ps.executeUpdate()执行sql
     * 对于整个方法而言,不同的地方主要有两块:1.sql不同 2.sql参数不同
     * 将不同的部分作为当前方法的参数存在
     * 由于sql参数不定长,因此可以使用不定长参数或者数组来表示
     * @param sql    执行的sql语句
     * @param params 执行的sql语句中的参数
     */
    public void update(String sql, Object... params) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = JDBCUtil.getConnection();
            ps = conn.prepareStatement(sql);
            // 设置参数
            // 方法参数中的params是用于接收sql参数的
            // 因此,可以对params进行遍历,每一个元素表示一个参数
            for (int i = 0; i < params.length; i++) {
                // 取出当前遍历的参数
                Object param = params[i];
                // 设置参数时,需要根据参数类型选择对应的setXxx方法
                // 而此时我们无法得知调用者的参数类型,怎么办?
                // 可以通过向下转型进行判断
                // if(param instanceof String){
                //     ps.setString(i+1,(String)param);
                // } else if(xxxx){}
                // 由于参数类型过多,也可以直接通过Object表示
                ps.setObject(i + 1, param);
            }
            // 执行DML操作
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataAccessException("数据访问异常");
        } finally {
            // 在业务层操作中需要使用到连接
            // 因此,此时释放资源时不释放连接
            // 所有不想要释放资源传递null即可
            JDBCUtil.close(null, ps, null);
        }
    }

    /**
     * 执行一个查询操作
     * 查询操作会返回一个结果集,其结果可以是一条,也可以是多条
     * 可以将结果集转换成一个Java对象或者是Java对象集合
     * 由于模板中无法确定转换的是哪一个Java对象
     * 通过模板方法设计映射接口,作为当前方法的参数
     * @param sql    执行的sql语句
     * @param rm     行映射接口
     * @param params 执行的sql语句的参数
     * @return 转换后的Java对象集合
     */
    public List<T> query(String sql, RowMapper rm, Object... params) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<T> list = new ArrayList<>();
        try {
            conn = JDBCUtil.getConnection();
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                ps.setObject(i + 1, params[i]);
            }
            rs = ps.executeQuery();
            while (rs.next()) {
                T t = (T) rm.mapRow(rs);
                list.add(t);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataAccessException("数据访问异常");
        } finally {
            JDBCUtil.close(null, ps, rs);
        }
    }

    /**
     * 执行DML操作,用于保存数据的同时返回生成的主键值
     * 此时生成PreparedStatement的方式与之前的不一样,可以定义一个接口由调用者做具体实现
     * 返回的主键值可能只有一个,也可以存在多个,定义一个KeyHolder类用于接收所有保存的主键值
     * @param psc
     * @param keyHolder
     */
    public void update(PreparedStatementCreator psc, KeyHolder keyHolder) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtil.getConnection();
            // 调用者在调用方法时做具体的实现
            // 在实现的时候,会提供构建状态集时所需要的sql与参数
            ps = psc.createPreparedStatement(conn);
            ps.executeUpdate();

            // 保存后数据库中自动生成对应的主键
            // 获取生成的主键的值
            rs = ps.getGeneratedKeys();
            // 准备一个集合,用于存储所有自动生成的主键的值
            List<Object> list = new ArrayList<>();

            // 通过结果集元数据取获取生成的主键值
            ResultSetMetaData rsmd = rs.getMetaData();
            // 获取生成的列的总数
            int columnCount = rsmd.getColumnCount();
            if (rs.next()) {
                // 在按行读取数据的时候,遍历所有列的值
                // 将每一列的值存放到对应集合中
                // 每一列对应一个主键值
                for (int i = 1; i <= columnCount; i++) {
                    list.add(rs.getObject(i));
                }
            }
            keyHolder.setKeyList(list);
        } catch (Exception e) {
            e.printStackTrace();
            throw new DataAccessException("数据访问异常");
        } finally {
            JDBCUtil.close(null, ps, rs);
        }
    }
}
