package com.itany.corejava.code08_常用类.string;

/**
 * @author 石小俊
 * @date 2023年08月23日 9:19
 */
public class Test01_创建方式 {
    public static void main(String[] args) {
        // 方式一:直接写字符串
        // 该方式本质上来说,不符合引用数据类型的特征。不符合面向对象的规范
        // 原则上来讲,所有的引用数据类型都是通过new关键字在堆中开辟空间进行存储
        // 只有基本数据类型存在的栈中,通过直接赋值的方式存储
        // 由于字符串太过于常用了,JVM特意为其做了优化
        // 使用直接赋值的方式存储的时候,其值没有存储到堆中,而是存储在常量池中
        String s1 = "hello";
        String s2 = "hello";
        // 常量池中数据进行比较的时候,如果值相同则公用同一个空间
        System.out.println(s1 == s2);   // true

        // 方式二:使用构造方法进行创建
        // 如果使用new的方式进行创建与其他引用数据类型没有区别
        String s3 = new String("hello");
        String s4 = new String("hello");
        System.out.println(s3 == s4);    // false

        String s5 = new String("admin");
        String s6 = "admin";
        System.out.println(s5 == s6);   // false
        System.out.println(s5.equals(s6));  // true

    }
}
