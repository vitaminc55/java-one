package com.itany.corejava.code16_反射;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author 石小俊
 * @date 2023年09月15日 16:01
 */
public class Test05_操作Method {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class c = User.class;

        // 1.获取当前类以及其祖先类中所有public修饰的方法
        // 所有类都直接或者间接继承Object,因此该方法可以获取到Object中public修饰的方法
        Method[] methods = c.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        System.out.println("---------------------------");
        // 2.获取当前类以及其祖先类中public修饰的指定参数的方法
        // 当前类的
        Method sumMethod = c.getMethod("sum", int.class, int.class);
        System.out.println(sumMethod);

        // 父类的
        Method show = c.getMethod("show");
        System.out.println(show);

        // 无法访问private修饰的方法
        // Method test = c.getMethod("test");
        // System.out.println(test);

        System.out.println("---------------------------");
        // 3.获取当前类中所有方法,不区分修饰符
        Method[] declaredMethods = c.getDeclaredMethods();
        for (Method method : declaredMethods) {
            System.out.println(method);
        }

        // 4.获取当前类中指定参数的方法
        Method test = c.getDeclaredMethod("test");
        System.out.println(test);


        for (Method method : methods) {
            System.out.println(method.getName());
        }
        System.out.println("----------------------");
        User user = new User();
        System.out.println(user.sayHello());
        System.out.println(user.sum(1, 2));

        int sum = (int) sumMethod.invoke(user, 2, 3);
        System.out.println(sum);

        // 如果调用的是private修饰的方法,则报错
        // 可以通过取消权限控制检查的方式破坏封装原则
        test.setAccessible(true);
        test.invoke(user);


    }

}
