package com.itany.corejava.code13_jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author 石小俊
 * @date 2023年09月13日 15:45
 */
public class Test08_事务操作 {

    public static void main(String[] args) throws DataAccessException {
        User user = new User("root2", "111111", "13912345679", "江苏-常州");
        insertUser(user);
    }

    public static void insertUser(User user) throws DataAccessException {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = JDBCUtil.getConnection();
            // 开启事务
            conn.setAutoCommit(false);
            String sql = new StringBuffer()
                    .append(" insert into ")
                    .append(" t_user ")
                    .append("   (username,password,phone,address)")
                    .append(" values ")
                    .append("   (?,?,?,?)")
                    .toString();
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getPhone());
            ps.setString(4, user.getAddress());
            ps.executeUpdate();

            int i = 1 / 0;

            // 业务全部处理完成之后,提交事务
            conn.commit();
        } catch (DataAccessException e) {
            e.printStackTrace();
            try {
                // 当业务执行遇到了异常,则回滚
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
                throw new DataAccessException("事务回滚失败");
            }
            throw e;
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
                throw new DataAccessException("事务回滚失败");
            }
            throw new DataAccessException("数据访问异常");
        }
    }

}
