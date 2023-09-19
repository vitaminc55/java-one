package com.itany.shop.tran;

/**
 * @author 石小俊
 * @date 2023年09月19日 14:26
 */
public interface TransactionManager {

    public void begin();

    public void commit();

    public void rollback();

}
