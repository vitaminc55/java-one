package com.itany.corejava.code17_设计模式.动态代理;

/**
 * @author 石小俊
 * @date 2023年09月18日 16:40
 */
public interface UserService {

    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    String login(String username, String password);

    /**
     * 用户注册
     * @param username
     * @param password
     * @param phone
     * @param address
     * @return
     */
    String register(String username, String password, String phone, String address);

}
