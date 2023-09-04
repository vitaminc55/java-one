package com.itany.corejava.code12_线程;

/**
 * @author 石小俊
 * @date 2023年09月04日 11:18
 */
public class Test01_继承Thread类 {

    // main方法也属于一个线程,这个线程是JVM启动时自动创建的线程
    // 实际上,Java在程序运行期间至少会自动启动两个线程:main线程、gc垃圾回收线程
    public static void main(String[] args) {
        // 创建线程类的实例
        SomeThread t1 = new SomeThread("t1");
        SomeThread t2 = new SomeThread("t2");
        SomeThread t3 = new SomeThread("t3");
        // 在执行线程时,并不是手动调用run方法
        // 而是通过启动线程的方式,自动调用run方法
        // 此时的线程并不会立刻执行,而是多个线程需要争抢CPU时间片
        // 谁先抢到谁就执行
        t1.start();
        t2.start();
        t3.start();
    }
}

class SomeThread extends Thread {

    private String name;

    public SomeThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(name + "线程正在执行,打印数字:" + i);
        }
    }
}
