package com.itany.corejava.code07_面向对象;

/**
 * @author 石小俊
 * @date 2023年08月16日 15:06
 */
public class Test05_静态方法 {
    public static void main(String[] args) {
        SomeClass sc = new SomeClass();
        sc.show();
        SomeClass.show2();
        sc.show2();
    }
}

class SomeClass {

    static String name;
    int age;

    public void show() {
        // 实例方法既可以访问静态变量,也可以访问实例变量
        System.out.println("姓名:" + name + ",年龄:" + age);
        // 实例方法可以调用静态方法,也可以调用实例方法
        print();
        print2();
    }

    public static void show2() {
        // 静态方法只能访问静态变量,无法访问实例变量
        System.out.println("静态变量name:" + name);
        // System.out.println("实例变量age:" + age); // 报错
        // 静态方法不能访问实例方法
        // print(); // 报错
        // 可以访问静态方法
        print2();
    }

    public void print() {
        System.out.println("这是实例方法");
    }

    public static void print2() {
        System.out.println("这是静态方法");
    }
}
