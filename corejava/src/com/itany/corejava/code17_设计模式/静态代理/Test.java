package com.itany.corejava.code17_设计模式.静态代理;

/**
 * @author 石小俊
 * @date 2023年09月18日 16:47
 */
public class Test {

    public static void main(String[] args) {
        UserService userService = new UserServiceProxy();
        userService.login("admin","123456");
        System.out.println("-----------------");

        SomeSerivce someSerivce = new SomeServiceProxy();
        someSerivce.doSome();
        System.out.println("-----------------");
        someSerivce.doOther();
    }

}
