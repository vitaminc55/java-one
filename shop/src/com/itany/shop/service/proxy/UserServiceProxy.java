package com.itany.shop.service.proxy;

import com.itany.shop.exception.RequestParameterErrorException;
import com.itany.shop.exception.UserExistException;
import com.itany.shop.factory.ObjectFactory;
import com.itany.shop.service.UserService;
import com.itany.shop.tran.TransactionManager;

/**
 * @author 石小俊
 * @date 2023年09月19日 14:26
 */
public class UserServiceProxy implements UserService {

    private TransactionManager tran = (TransactionManager) ObjectFactory.getObject("tran");
    private UserService userService = (UserService) ObjectFactory.getObject("userServiceTarget");

    @Override
    public void register(String username, String password, String phone, String address) throws RequestParameterErrorException, UserExistException {
        try {
            // 开启事务
            tran.begin();
            // 执行目标方法
            userService.register(username,password,phone,address);
            // 提交事务
            tran.commit();
        } catch (RequestParameterErrorException e) {
            tran.rollback();
            // 在交叉业务逻辑中,不改变目标方法的处理
            // 因此,接收到什么异常,抛出去的还是原来的异常
            throw e;
        } catch (UserExistException e) {
            tran.rollback();
            throw e;
        }
    }
}
