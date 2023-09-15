package com.itany.corejava.code16_反射;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

/**
 * @author 石小俊
 * @date 2023年09月15日 14:43
 */
public class Test03_操作Constructor {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class c = User.class;
        // 1.获取当前类中所有的public修饰的构造方法
        Constructor[] constructors = c.getConstructors();
        System.out.println(Arrays.toString(constructors));

        // 2.根据传递的参数不同,返回public修饰的指定参数的构造方法
        // 获取public修饰的单参数构造方法
        Constructor constructor = c.getConstructor(String.class);
        System.out.println(constructor);

        // 3.获取当前类中所有的构造方法
        // 对修饰符没有要求
        Constructor[] constructors2 = c.getDeclaredConstructors();
        System.out.println(Arrays.toString(constructors2));

        // 4.根据传递的参数不同,返回指定参数的构造方法
        // 获取两个字符串参数的构造方法
        Constructor constructor2 = c.getDeclaredConstructor(String.class, String.class);
        System.out.println(constructor2);


        // 通过反射调用指定构造方法创建对象
        User user = (User) constructor.newInstance("admin");
        System.out.println(user);

        // 当前调用的构造方法由private所修饰,外部无法访问
        // 因此,此时调用构造方法创建对象时会报错
        // User user2 = (User) constructor2.newInstance("admin","123456");
        // System.out.println(user2);
        // 如果想要使用该构造方法创建对象,必须破坏原有的封装原则,使得private失效
        constructor2.setAccessible(true);
        User user2 = (User) constructor2.newInstance("admin", "123456");
        System.out.println(user2);
    }

}
