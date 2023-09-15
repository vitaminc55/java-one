package com.itany.corejava.code16_反射;

import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * @author 石小俊
 * @date 2023年09月15日 15:48
 */
public class Test04_操作Field {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Class c = User.class;

        // 1.获取当前类以及其父类中所有public修饰的属性
        Field[] fields = c.getFields();
        System.out.println(Arrays.toString(fields));

        // 2.获取当前类以及其父类中public修饰的指定属性
        // 当前类的
        Field usernameFiled = c.getField("username");
        System.out.println(usernameFiled);
        // 父类的
        Field phoneFiled = c.getField("phone");
        System.out.println(phoneFiled);

        // 如果不是public修饰的属性,则报错
        // Field passwordFiled = c.getField("password");
        // System.out.println(passwordFiled);

        // 3.获取当前类中所有的属性,不区分修饰符
        Field[] declaredFields = c.getDeclaredFields();
        System.out.println(Arrays.toString(declaredFields));

        // 4.获取当前类中指定属性,不区分修饰符
        Field passwordFiled = c.getDeclaredField("password");
        System.out.println(passwordFiled);

        // 无法获取父类的
        // Field addressField = c.getDeclaredField("address");
        // System.out.println(addressField);

        User user = new User();
        usernameFiled.set(user, "admin");
        passwordFiled.setAccessible(true);
        passwordFiled.set(user, "123456");
        System.out.println(user);

        System.out.println(usernameFiled.get(user));
        User user2 = new User("alice", "111111");
        System.out.println(usernameFiled.get(user2));
        System.out.println(passwordFiled.get(user2));

    }

}
