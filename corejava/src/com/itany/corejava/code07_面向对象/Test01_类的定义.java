package com.itany.corejava.code07_面向对象;

import java.util.Arrays;

/**
 * @author 石小俊
 * @date 2023年08月16日 11:24
 */
public class Test01_类的定义 {
    public static void main(String[] args) {
        System.out.println("******************第一个对象******************");
        Person person = new Person();
        // 访问属性
        // 赋值操作
        person.name = "张三";
        person.age = 18;
        person.gender = "男";
        person.hobbies = new String[]{"吃饭", "睡觉", "学Java"};
        // 取值操作
        System.out.println(person.name);
        System.out.println(person.age);
        System.out.println(person.gender);
        System.out.println(Arrays.toString(person.hobbies));

        // 访问方法
        person.eat();
        person.sleep();
        person.show();

        System.out.println("******************第二个对象******************");
        Person person2 = new Person();
        person2.name = "李四";
        person2.age = 18;
        person2.gender = "女";
        person2.hobbies = new String[]{"吃饭", "睡觉", "打豆豆"};
        person2.show();
    }
}

class Person {
    // 成员属性
    String name; // 姓名
    int age; // 年龄
    String gender; // 性别
    String[] hobbies; // 兴趣爱好

    public void eat() {
        System.out.println(name + "饿了,想要吃饭");
    }

    public void sleep() {
        System.out.println(name + "困了,想要睡觉");
    }

    public void show() {
        System.out.println("我是" + name + ",今年" + age + "岁,是一个" + gender + "性,兴趣爱好为:" + Arrays.toString(hobbies));
    }

}