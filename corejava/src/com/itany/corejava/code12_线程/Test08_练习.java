package com.itany.corejava.code12_线程;

/**
 * @author 石小俊
 * @date 2023年09月04日 17:06
 * 定义两个线程分别打印不同的内容,要求两个线程之间交替执行10次
 * 例如第一个线程打印Hello,第二个线程打印World
 * 其结果为HelloWorldHelloWorldHelloWorldHelloWorld....
 * 或者WorldHelloWorldHelloWorldHelloWorldHello...
 */
public class Test08_练习 {
    public static void main(String[] args) {
        Object obj = new Object();
        HelloThread helloThread = new HelloThread(obj);
        WorldThread worldThread = new WorldThread(obj);
        Thread t1 = new Thread(helloThread);
        Thread t2 = new Thread(worldThread);
        t1.start();
        t2.start();
    }
}

class HelloThread implements Runnable {
    private Object obj;

    public HelloThread(Object obj) {
        this.obj = obj;
    }

    @Override
    public void run() {
        synchronized (obj) {
            for (int i = 0; i < 10; i++) {
                System.out.print("Hello");
                obj.notifyAll();
                try {
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class WorldThread implements Runnable {
    private Object obj;

    public WorldThread(Object obj) {
        this.obj = obj;
    }

    @Override
    public void run() {
        synchronized (obj) {
            for (int i = 0; i < 10; i++) {
                System.out.print("World");
                obj.notifyAll();
                try {
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
