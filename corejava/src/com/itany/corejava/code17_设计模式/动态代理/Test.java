package com.itany.corejava.code17_设计模式.动态代理;

import java.lang.reflect.Proxy;

/**
 * @author 石小俊
 * @date 2023年09月19日 9:06
 */
public class Test {

    public static void main(String[] args) {
        // 参数一:定义代理的类的类加载器。即:目标类的类加载器
        // 参数二:代理的类要实现的接口列表。即:目标类实现的接口列表
        // 参数三:指派方法调用的调用处理程序。即:代理类方法的具体实现
            // 参数是一个InvocationHandler接口,我们需要对这个接口进行实现
            // 并重写其invoke方法,相当于静态代理中实现的每一个方法
        UserService userService = (UserService) Proxy.newProxyInstance(
                UserServiceImpl.class.getClassLoader(),
                UserServiceImpl.class.getInterfaces(),
                new LogInvocationHandler(new UserServiceImpl())
        );

        String result = userService.login("admin", "123456");
        System.out.println(result);
        System.out.println("********************************");
        userService.register("admin", "123456", "13812345678", "江苏-南京");

        SomeSerivce someSerivce = (SomeSerivce) Proxy.newProxyInstance(
                SomeServiceImpl.class.getClassLoader(),
                SomeServiceImpl.class.getInterfaces(),
                new LogInvocationHandler(new SomeServiceImpl())
        );
        System.out.println("********************************");
        someSerivce.doSome();
        System.out.println("********************************");
        someSerivce.doOther();

    }

}
