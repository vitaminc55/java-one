package com.itany.corejava.code07_面向对象.接口;

/**
 * @author 石小俊
 * @date 2023年08月18日 15:03
 */
public interface SomeInterface {

    // 所有属性默认被public static final修饰
    // public static final int age = 20;
    int age = 20;

    // 所有方法默认被public abstract修饰
    public abstract void doSome();
    void doOther();
}
