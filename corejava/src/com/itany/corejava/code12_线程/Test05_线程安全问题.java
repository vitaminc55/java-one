package com.itany.corejava.code12_线程;

/**
 * @author 石小俊
 * @date 2023年09月04日 14:54
 */
public class Test05_线程安全问题 {

    public static void main(String[] args) {
        MyTicket mt = new MyTicket();
        Thread t1 = new Thread(mt, "窗口1");
        Thread t2 = new Thread(mt, "窗口2");
        Thread t3 = new Thread(mt, "窗口3");
        t1.start();
        t2.start();
        t3.start();
        // 当每一个线程设置了休眠时间时,此时运行后出现了有问题的票号
        // 此时出现了票号为0与-1的异常票号
        // 假设此时的票卖到了最后一张,三个线程进来抢了
        // 第一个线程抢到了,发现票号为1,大于0满足条件,进入循环执行
        // 进入循环之后立刻进入休眠状态
        // 此时第二个线程进来,发现票号还是1,大于0满足条件,进入循环执行,接着休眠
        // 第三个线程进来,发现票号还是1,大于0满足条件,进入循环执行,接着休眠
        // 第一个线程休眠时间到,继续执行,票号为:1,将票号-1=0
        // 第二个线程休眠时间到,继续执行票号为:0,将票号-1=-1
        // 第三个线程休眠时间到,继续执行票号为:-1
        // 简单来讲:多个线程访问共享数据时,由于CPU时间片的切换,导致前面的线程只执行了部分关键代码,尚未全部执行完成
        // 但是另一个线程参与进来导致了共享数据发生异常
    }

}

class MyTicket implements Runnable {

    private static int num = 1000;

    @Override
    public void run() {
        while (true) {
//            synchronized (this) {
//                if (num > 0) {
//                    try {
//                        Thread.sleep(10);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println(Thread.currentThread().getName() + "正在出票,票号为:" + num--);
//                }
//            }
            sellTicket();
        }
    }

    public static synchronized void sellTicket(){
        if (num > 0) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "正在出票,票号为:" + num--);
        }
    }
}
