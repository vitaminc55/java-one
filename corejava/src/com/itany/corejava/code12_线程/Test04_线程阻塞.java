package com.itany.corejava.code12_线程;

/**
 * @author 石小俊
 * @date 2023年09月04日 14:05
 */
public class Test04_线程阻塞 {

    public static void main(String[] args) {
        OtherThread ot = new OtherThread();
        Thread t1 = new Thread(ot, "线程1");
        t1.start();

        // main线程
        for (int i = 0; i < 100; i++) {
//            if(i == 10){
//                try {
//                    t1.join();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
            System.out.println(Thread.currentThread().getName() + "正在打印:" + i);
        }
        // 主线程执行完毕之后中断t1
        // 中断后立刻结束休眠状态,进入就绪状态
        t1.interrupt();
    }

}

class OtherThread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i == 10) {
//                Scanner sc = new Scanner(System.in);
//                System.out.println("请输入:");
//                i = sc.nextInt();
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                }
            }
            System.out.println(Thread.currentThread().getName() + "正在打印:" + i);
        }
    }
}
