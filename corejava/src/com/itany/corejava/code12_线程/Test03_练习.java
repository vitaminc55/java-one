package com.itany.corejava.code12_线程;

import java.util.Scanner;

/**
 * @author 石小俊
 * @date 2023年09月04日 13:30
 * 使用线程实现售票功能,共有三个售票窗口,共出售100张票
 */
public class Test03_练习 {
    public static void main(String[] args) {
//        TicketThread t1 = new TicketThread("窗口1");
//        TicketThread t2 = new TicketThread("窗口2");
//        TicketThread t3 = new TicketThread("窗口3");
//        // 此时运行后,发现每个窗口都有100张票
//        // 每一个线程都是实例化了一个对象
//        // 而每个对象都拥有num属性,其值都是100
//        // 因此,实际上每个线程都拥有独立的100张票
//        // 该方式无法实现
//        t1.start();
//        t2.start();
//        t3.start();

        TicketRunnable tr = new TicketRunnable();
        // 可以通过参数二指定线程名
        Scanner sc = new Scanner(System.in);
        Thread t1 = new Thread(tr, "窗口1");
        Thread t2 = new Thread(tr, "窗口2");
        Thread t3 = new Thread(tr, "窗口3");
        t1.start();
        t2.start();
        t3.start();
    }
}

class TicketRunnable implements Runnable {
    // 定义100张票
    private int num = 100;
    private String name;

    @Override
    public void run() {
        while (num > 0) {
            System.out.println(Thread.currentThread().getName() + "正在出票,票号为:" + num--);
        }
    }
}

class TicketThread extends Thread {
    // 定义100张票
    private int num = 100;
    private String name;

    public TicketThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (num > 0) {
            System.out.println(name + "正在出票,票号为:" + num--);
        }
    }
}
