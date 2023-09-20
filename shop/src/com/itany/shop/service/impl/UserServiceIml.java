package com.itany.shop.service.impl;

import com.itany.shop.dao.UserDao;
import com.itany.shop.entity.User;
import com.itany.shop.exception.RequestParameterErrorException;
import com.itany.shop.exception.UserExistException;
import com.itany.shop.factory.ObjectFactory;
import com.itany.shop.service.UserService;
import com.itany.shop.util.MD5Util;
import com.itany.shop.util.ParameterUtil;

/**
 * @author 黄鹏程
 * @date 2023年09月19日17:15
 */
public class UserServiceIml implements UserService {
    private UserDao userDao= (UserDao) ObjectFactory.getObject("userDao");
    @Override
    public void register(String username, String password, String phone, String address) throws RequestParameterErrorException, UserExistException {
        if (ParameterUtil.isNull(username) ||ParameterUtil.isNull(password)||ParameterUtil.isNull(password)||ParameterUtil.isNull(address)){
           throw new RequestParameterErrorException("请求参数有误") ;
        }
        User selectUser= userDao.selectByUsername(username);
        if (selectUser!=null){
            throw new UserExistException("该用户已经被注册");
        }
        User user=new User(username, MD5Util.md5(password),phone,address);
        userDao.insertUser(user);
    }
}
