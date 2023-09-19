package com.itany.shop.tran.impl;

import com.itany.shop.exception.DataAccessException;
import com.itany.shop.tran.TransactionManager;
import com.itany.shop.util.JDBCUtil;

import java.sql.SQLException;

/**
 * @author 石小俊
 * @date 2023年09月19日 14:27
 */
public class TransactionManagerImpl implements TransactionManager {
    @Override
    public void begin() {
        try {
            JDBCUtil.getConnection().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DataAccessException("事务开启失败");
        }
    }

    @Override
    public void commit() {
        try {
            // 只有当手动事务时才需要提交
            if (!JDBCUtil.getConnection().getAutoCommit()) {
                JDBCUtil.getConnection().commit();
                ;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DataAccessException("事务提交失败");
        } finally {
            // 事务结束之后,释放线程池的连接
            JDBCUtil.close();
        }
    }

    @Override
    public void rollback() {
        try {
            if (!JDBCUtil.getConnection().getAutoCommit()) {
                JDBCUtil.getConnection().rollback();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DataAccessException("事务提交失败");
        } finally {
            JDBCUtil.close();
        }
    }
}
