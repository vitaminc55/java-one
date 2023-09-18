package com.itany.corejava.code17_设计模式.静态代理;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 石小俊
 * @date 2023年09月18日 16:42
 * 代理类,对目标方法做一些额外的处理,但是这些处理不允许改变原有的结果
 */
public class UserServiceProxy implements UserService {

    private UserService userService = new UserServiceImpl();
    // private UserService userService = (UserService) ObjectFactory.getObject("userServiceTarget");

    @Override
    public String login(String username, String password) {
        System.out.println("静态代理:在" + new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss").format(new Date()) + "即将执行login方法");
        // 在代理方法中必须调用目标方法
        // 如果不调用目标方法,当前代理方法毫无意义
        String result = userService.login(username, password);
        System.out.println("静态代理:在" + new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss").format(new Date()) + "成功执行了login方法,方法的返回值:" + result);
        // 并将当前方法的返回值设置目标方法的返回值
        return result;
    }

    @Override
    public String register(String username, String password, String phone, String address) {
        System.out.println("静态代理:在" + new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss").format(new Date()) + "即将执行register方法");
        String result = userService.register(username, password, phone, address);
        System.out.println("静态代理:在" + new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss").format(new Date()) + "成功执行了register方法,方法的返回值:" + result);
        return result;
    }
}
