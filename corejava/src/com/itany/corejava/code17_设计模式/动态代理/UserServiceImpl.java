package com.itany.corejava.code17_设计模式.动态代理;

/**
 * @author 石小俊
 * @date 2023年09月18日 16:41
 * 目标类,做具体的业务逻辑
 */
public class UserServiceImpl implements UserService {
    @Override
    public String login(String username, String password) {
        System.out.println("UserServiceImpl.login");
        if ("admin".equals(username) && "123456".equals(password)) {
            return "登录成功";
        }
        return "用户名或密码错误";
    }

    @Override
    public String register(String username, String password, String phone, String address) {
        System.out.println("UserServiceImpl.register");
        if ("admin".equals(username)) {
            return "该用户已经被注册";
        }
        return "注册成功";
    }
}
