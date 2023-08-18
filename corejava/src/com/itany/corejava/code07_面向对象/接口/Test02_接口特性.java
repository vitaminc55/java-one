package com.itany.corejava.code07_面向对象.接口;

/**
 * @author 石小俊
 * @date 2023年08月18日 15:46
 */
public class Test02_接口特性 {
    public static void main(String[] args) {
        C c = new C();
        c.show();
        A a = new D();
        a.show();
    }
}

interface A {
    void doSome();

    default void show() {
        System.out.println("这是一个普通方法");
    }
}

interface B {
    void doOther();
}

class C implements A, B {

    @Override
    public void doSome() {

    }

    @Override
    public void doOther() {

    }
}

class D implements A {

    @Override
    public void doSome() {
        System.out.println("D.doSome");
    }

    @Override
    public void show() {
        System.out.println("D重写了show方法");
    }
}

// 接口支持多继承
interface E extends A, B {

}
// 类不支持多继承
// class F extends C,D{ }
