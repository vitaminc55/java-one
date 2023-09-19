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
 * @author 石小俊
 * @date 2023年09月19日 14:14
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao = (UserDao) ObjectFactory.getObject("userDao");

    @Override
    public void register(String username, String password, String phone, String address) throws RequestParameterErrorException, UserExistException {
        // 非空校验
        if(ParameterUtil.isNull(username) || ParameterUtil.isNull(password) || ParameterUtil.isNull(phone) || ParameterUtil.isNull(address)){
            throw new RequestParameterErrorException("请求参数有误");
        }
        // 判断该用户名是否已经被注册
        // 根据用户名查询用户信息
        User selectUser = userDao.selectByUsername(username);
        // 如果查询到对应用户,则表示已经被注册,抛出异常
        if(selectUser != null){
            throw new UserExistException("该用户已经被注册");
        }
        // 如果没有查询到,则表示没有被注册,可以使用
        // 进行注册,注册时密码需要加密
        User user = new User(username, MD5Util.md5(password),phone,address);
        // 调用持久层方法执行插入操作
        userDao.insertUser(user);
    }
}
