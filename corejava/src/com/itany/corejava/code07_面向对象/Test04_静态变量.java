package com.itany.corejava.code07_面向对象;

/**
 * @author 石小俊
 * @date 2023年08月16日 14:58
 */
public class Test04_静态变量 {
    public static void main(String[] args) {
        SomePerson father = new SomePerson();
        // father.name = "爸爸";
        SomePerson.name = "爸爸";
        SomePerson son = new SomePerson();
        // son.name = "儿子";
        SomePerson.name = "儿子";
        son.age = 8;

        System.out.println(SomePerson.name);
        System.out.println(father.age);
        System.out.println(SomePerson.name);
        System.out.println(son.age);
    }
}

class SomePerson {
    // 静态变量,类变量
    static String name;
    // 实例变量
    int age;
}
