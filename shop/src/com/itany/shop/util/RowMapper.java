package com.itany.shop.util;

import java.sql.ResultSet;

/**
 * @author 石小俊
 * @date 2023年09月19日 13:54
 * 行映射接口
 */
public interface RowMapper<T> {

    /**
     * 行映射方法
     * 将查询结果的结果集映射成Java对象
     * 每一行数据映射一个Java对象
     * 该操作可能会有异常
     * @param rs
     * @return
     */
    public T mapRow(ResultSet rs) throws Exception;

}
