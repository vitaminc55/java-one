package com.itany.shop.service.impl;

import com.itany.shop.exception.RequestParameterErrorException;
import com.itany.shop.exception.UserExistException;
import com.itany.shop.service.UserService;

/**
 * @author 黄鹏程
 * @date 2023年09月19日17:15
 */
public class UserServiceIml implements UserService {
    @Override
    public void register(String username, String password, String phone, String address) throws RequestParameterErrorException, UserExistException {

    }
}
