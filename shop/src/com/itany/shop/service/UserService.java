package com.itany.shop.service;

import com.itany.shop.exception.RequestParameterErrorException;
import com.itany.shop.exception.UserExistException;

/**
 * @author 石小俊
 * @date 2023年09月19日 14:02
 */
public interface UserService {

    /**
     * 用户注册
     * 用户名不能重复
     * @param username
     * @param password
     * @param phone
     * @param address
     */
    void register(String username,String password,String phone,String address) throws RequestParameterErrorException, UserExistException;

}
