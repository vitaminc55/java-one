package com.itany.corejava.code07_面向对象.常量;

/**
 * @author 石小俊
 * @date 2023年08月18日 13:32
 */
public class Test01_final关键字 {
    public static void main(String[] args) {
        final int i = 10;
        // 当没有被final修饰时,变量i的值可以被修改
        // 但是如果被final修饰了,则i的值不可更改
        // 强制更改会报错
        // i = 20; // 报错
    }
}

class Person {
    public final void show() {
        System.out.println("这是父类方法");
    }

    public int sum(final int i, int j) {
        // i++; // 被final修饰的方法参数不能被修改
        j++;
        return i + j;
    }
}

class Man extends Person {

    // 由于父类中show方法被final修饰了,则子类不能重写该方法
//    public void show(){
//        System.out.println("这是子类重写的方法");
//    }
}

final class Pet {

}
// 当类被final修饰,不能被继承,因此Dog继承时父类报错
// class Dog extends Pet{ }
