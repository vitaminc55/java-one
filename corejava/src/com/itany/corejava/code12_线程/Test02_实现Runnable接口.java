package com.itany.corejava.code12_线程;

/**
 * @author 石小俊
 * @date 2023年09月04日 11:40
 */
public class Test02_实现Runnable接口 {
    public static void main(String[] args) {
        // 创建一个实现类的实例,这不是线程
        SomeRunnable sr = new SomeRunnable();
        // 创建Thread类的一个实现,将当前Runnable接口的实例传递进来
        // 此时表示分配一个新的Thread对象,这是线程
        Thread t1 = new Thread(sr);
        Thread t2 = new Thread(sr);
        Thread t3 = new Thread(sr);

        t1.start();
        t2.start();
        t3.start();
    }
}

class SomeRunnable implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            // 可以通过Thread类来获取当前默认线程名
            // Thread.currentThread():获取当前正在执行的线程
            Thread t = Thread.currentThread();
            System.out.println(t.getName() + "线程正在执行,打印:" + i);
        }
    }
}
