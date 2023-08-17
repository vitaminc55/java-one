package com.itany.corejava.code07_面向对象.封装;

/**
 * @author 石小俊
 * @date 2023年08月17日 15:24
 */
public class Dog extends Animate {
    public void test() {
        // 不同包中的子类
        // 被private修饰的或者没有修饰符的属性无法访问
        // System.out.println("name:" + name); // 报错
        // System.out.println("age:" + age); // 报错
        System.out.println("gender:" + gender);
        System.out.println("weight:" + weight);

        // 被private修饰的或者没有修饰符的方法无法访问
        // test01(); // 报错
        // test02(); // 报错
        test03();
        test04();
    }
}
