package com.itany.corejava.code07_面向对象.继承;

/**
 * @author 石小俊
 * @date 2023年08月17日 15:22
 */
public class Cat extends Animate {

    public void test() {
        // 同一个包中的子类
        // 被private修饰的属性无法访问
        // System.out.println("name:" + name); // 报错
        System.out.println("age:" + age);
        System.out.println("gender:" + gender);
        System.out.println("weight:" + weight);

        // 被private修饰的方法无法访问
        // test01(); // 报错
        test02();
        test03();
        test04();
    }
}
