package com.itany.corejava.code12_线程;

/**
 * @author 石小俊
 * @date 2023年09月05日 10:24
 */
public class Test09_生产者消费者问题 {
    public static void main(String[] args) {
        // 定义商品缓冲区
        ProductPool pool = new ProductPool();
        // 定义生产者线程
        Procedure p1 = new Procedure(pool, "生产者p1");
        Procedure p2 = new Procedure(pool, "生产者p2");
        Procedure p3 = new Procedure(pool, "生产者p3");
        // 定义消费者线程
        Consumer c1 = new Consumer(pool, "消费者c1");
        Consumer c2 = new Consumer(pool, "消费者c2");

        // 启动线程
        p1.start();
        p2.start();
        p3.start();
        c1.start();
        c2.start();
    }
}

/**
 * 商品缓冲区
 */
class ProductPool {
    // 当前缓冲区中商品的数量
    private int num;
    // 缓冲区商品数量的上限,定义为常量
    private static final int MAX_COUNT = 20;

    /**
     * 生产商品
     * 生产者生产商品后向商品缓冲区中存放商品
     * 每次存放只能存放一件商品
     *
     * @return 当前缓冲区中商品数量
     */
    public int put() {
        // 每存放一次,商品数量+1
        num++;
        return num;
    }

    /**
     * 消费商品
     * 消费者消费商品商品后从商品缓冲区中取出商品
     * 每次消费只能取出一件商品
     *
     * @return 当前缓冲区中商品数量
     */
    public int get() {
        num--;
        return num;
    }

    /**
     * 判断当前商品缓冲区中商品数量是否达到了上限
     *
     * @return
     */
    public boolean isFull() {
        return this.num == MAX_COUNT;
    }

    /**
     * 判断当前商品缓冲区中是否存在商品
     *
     * @return
     */
    public boolean isEmpty() {
        return this.num == 0;
    }
}

class Procedure extends Thread {
    private ProductPool pool;
    private String name;

    public Procedure(ProductPool pool, String name) {
        this.pool = pool;
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (pool) {
                // 根据当前商品缓冲区的商品数量决定是否需要生产
                if (pool.isFull()) {
                    // 如果当前商品缓冲区中商品数量达到了上限,则不再生产
                    // 等待消费者进行消费
                    try {
                        pool.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    // 如果当前商品缓冲区的商品没有达到上限,则生产商品
                    int num = pool.put();
                    System.out.println(name + "生产了一件商品,当前商品缓冲区商品数量为:" + num);
                    // 当生产了商品之后,唤醒等待的消费者
                    pool.notifyAll();
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer extends Thread {
    private ProductPool pool;
    private String name;

    public Consumer(ProductPool pool, String name) {
        this.pool = pool;
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (pool) {

                // 根据当前商品缓冲区的商品数量决定是否需要消费
                if (pool.isEmpty()) {
                    // 如果当前缓冲区中没有商品,则等待生产
                    try {
                        pool.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    // 如果当前缓冲区中有商品,则可以消费
                    int num = pool.get();
                    System.out.println(name + "消费了一件商品,当前商品缓冲区中商品数量为:" + num);
                    // 当消费者消费了商品之后,唤醒等待的生产者
                    pool.notifyAll();
                }
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}