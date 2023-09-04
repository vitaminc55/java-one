package com.itany.corejava.code12_线程;

/**
 * @author 石小俊
 * @date 2023年09月04日 16:14
 */
public class Test07_线程间的通信 {
    public static void main(String[] args) {
        Object obj = new Object();
        WaitThread t1 = new WaitThread(obj, "线程1");
        WaitThreadTwo t2 = new WaitThreadTwo(obj, "线程2");
        t1.start();
        t2.start();

        NotifyThread notifyThread = new NotifyThread(obj, "notify线程");
        // notifyThread.start();

        Object obj2 = new Object();
        NotifyAllThread notifyAllThread = new NotifyAllThread(obj2, "notifyAll线程");
        notifyAllThread.start();

    }

}

class WaitThread extends Thread {

    private Object obj;
    private String name;

    public WaitThread(Object obj, String name) {
        this.obj = obj;
        this.name = name;
    }

    @Override
    public void run() {
        synchronized (obj) {
            try {
                // 设置线程等待时间
                // obj.wait(2000);
                // 如果没有参数,表示只能等待其他线程唤醒
                obj.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + "执行完成");
        }
    }
}

class WaitThreadTwo extends Thread {

    private Object obj;
    private String name;

    public WaitThreadTwo(Object obj, String name) {
        this.obj = obj;
        this.name = name;
    }

    @Override
    public void run() {
        synchronized (obj) {
            try {
                obj.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + "执行完成");
        }
    }
}

class NotifyThread extends Thread {
    private Object obj;
    private String name;

    public NotifyThread(Object obj, String name) {
        this.obj = obj;
        this.name = name;
    }

    @Override
    public void run() {
        synchronized (obj) {
            obj.notify();
            System.out.println(name + "已经随机唤醒等待池中的某一个线程");
        }
    }
}

class NotifyAllThread extends Thread {
    private Object obj;
    private String name;

    public NotifyAllThread(Object obj, String name) {
        this.obj = obj;
        this.name = name;
    }

    @Override
    public void run() {
        synchronized (obj) {
            obj.notifyAll();
            System.out.println(name + "唤醒所有等待池中的线程");
        }
    }
}