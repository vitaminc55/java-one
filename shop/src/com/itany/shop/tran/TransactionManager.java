package com.itany.shop.tran;

/**
 * @author 黄鹏程
 * @date 2023年09月19日21:24
 */
public interface TransactionManager {
    public void begin();

    public void commit();

    public void rollback();
}
