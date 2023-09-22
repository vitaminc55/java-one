package com.itany.shop.tran.impl;

import com.itany.shop.exception.DataAccessException;
import com.itany.shop.tran.TransactionManager;
import com.itany.shop.util.JDBCUtil;

import java.sql.SQLException;

/**
 * @author 黄鹏程
 * @date 2023年09月19日21:25
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
            if (!JDBCUtil.getConnection().getAutoCommit()){
                JDBCUtil.getConnection().commit();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new DataAccessException("事务提交失败");
        }finally {
            JDBCUtil.close();
        }
    }

    @Override
    public void rollback() {
        try {
            if (!JDBCUtil.getConnection().getAutoCommit()){
                JDBCUtil.getConnection().rollback();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new DataAccessException("事务提交失败");
        }finally {
            JDBCUtil.close();
        }
    }
}
