package com.itany.shop.util;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @author 黄鹏程
 * @date 2023年09月21日15:28
 */
public interface PreparedStatementCreator {

    /**
     * 根据调用者的实际需求创建对应的PreparedStatement
     * @param conn
     * @return
     * @throws Exception
     */
    public PreparedStatement createPreparedStatement(Connection conn) throws Exception;

}