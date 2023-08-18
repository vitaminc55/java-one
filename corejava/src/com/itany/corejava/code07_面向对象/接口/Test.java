package com.itany.corejava.code07_面向对象.接口;

/**
 * @author 石小俊
 * @date 2023年08月18日 15:08
 */
public class Test {

    public static void main(String[] args) {
        System.out.println(SomeInterface.age);
        // SomeInterface.age = 18; // 常量不能被修改,报错

        // 接口的引用指向实现类的对象,面向接口编程
        SomeInterface s = new SomeClass();
        s.doSome();
        s.doOther();
    }

}
