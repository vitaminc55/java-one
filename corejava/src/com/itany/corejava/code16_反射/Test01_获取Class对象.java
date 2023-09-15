package com.itany.corejava.code16_反射;

/**
 * @author 石小俊
 * @date 2023年09月15日 13:45
 */
public class Test01_获取Class对象 {

    public static void main(String[] args) throws ClassNotFoundException {
        // 方式一:类.class
        Class c1 = User.class;
        System.out.println(c1);

        // 方式二:对象.getClass()
        User user = new User();
        Class c2 = user.getClass();
        System.out.println(c2);

        // 方式三:Class.forName()
        Class c3 = Class.forName("com.itany.corejava.code16_反射.User");
        System.out.println(c3);

        User user2 = new User();
        Class c4 = user2.getClass();

        // 测试看是否是同一个对象
        System.out.println(c1 == c2);
        System.out.println(c2 == c3);
        System.out.println(c2 == c4);
    }

}
