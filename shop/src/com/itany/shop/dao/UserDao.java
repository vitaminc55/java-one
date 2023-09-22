package com.itany.shop.dao;

import com.itany.shop.entity.User;

/**
 * @author 石小俊
 * @date 2023年09月19日 14:04
 */
public interface UserDao {

    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    User selectByUsername(String username);

    /**
     * 插入用户信息
     * @param user
     */
    void insertUser(User user);
    User selectUser(String username,String password);
    void modifyPassword(String username,String password);
}
