package com.itany.corejava.code12_线程;

/**
 * @author 石小俊
 * @date 2023年09月04日 15:49
 */
public class Test06_死锁问题 {

    public static void main(String[] args) {
        Object obj1 = new Object();
        Object obj2 = new Object();
        ThreadA a = new ThreadA(obj1, obj2);
        ThreadB b = new ThreadB(obj1, obj2);
        Thread t1 = new Thread(a);
        Thread t2 = new Thread(b);
        t1.start();
        t2.start();
    }

}

class ThreadA implements Runnable {

    private Object obj1;
    private Object obj2;

    public ThreadA(Object obj1, Object obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    @Override
    public void run() {
        synchronized (obj1) {
            System.out.println("ThreadA get obj1");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (obj2) {
                System.out.println("ThreadA get obj2");
            }
        }
    }
}

class ThreadB implements Runnable {
    private Object obj1;
    private Object obj2;

    public ThreadB(Object obj1, Object obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    @Override
    public void run() {
        synchronized (obj2) {
            System.out.println("ThreadB get obj2");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (obj1) {
                System.out.println("ThreadB get obj1");
            }
        }
    }
}