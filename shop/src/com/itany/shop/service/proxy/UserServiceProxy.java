package com.itany.shop.service.proxy;

import com.itany.shop.exception.RequestParameterErrorException;
import com.itany.shop.exception.UserExistException;
import com.itany.shop.factory.ObjectFactory;
import com.itany.shop.service.UserService;
import com.itany.shop.tran.TransactionManager;

/**
 * @author 黄鹏程
 * @date 2023年09月19日21:22
 */
public class UserServiceProxy implements UserService {
    private TransactionManager tran = (TransactionManager) ObjectFactory.getObject("tran");
    private UserService userService= (UserService) ObjectFactory.getObject("userServiceTarget");
    @Override
    public void register(String username, String password, String phone, String address) throws RequestParameterErrorException, UserExistException {
        try {
            tran.begin();
            userService.register(username,password,phone,address);
            tran.commit();
        } catch (RequestParameterErrorException e) {
            tran.rollback();
            throw e;
        } catch (UserExistException e) {
            tran.rollback();
            throw e;
        }
    }
}
