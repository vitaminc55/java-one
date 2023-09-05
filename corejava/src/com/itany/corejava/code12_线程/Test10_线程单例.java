package com.itany.corejava.code12_线程;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 石小俊
 * @date 2023年09月05日 11:14
 */
public class Test10_线程单例 {

    public static void main(String[] args) {
        MyThreadLocal<String> local = new MyThreadLocal<>();
        // ThreadLocal<String> local = new ThreadLocal<>();


        // 通过MyThreadLocal操作线程数据
        Map<Thread, String> map = new HashMap<>();
        map.put(Thread.currentThread(), "admin");
        local.setMap(map);
        System.out.println("当前线程数据:" + local.getMap().get(Thread.currentThread()));
        map.put(Thread.currentThread(), "alice");
        local.setMap(map);
        System.out.println("当前线程数据:" + local.getMap().get(Thread.currentThread()));
        map.put(Thread.currentThread(), "jack");
        local.setMap(map);
        System.out.println("当前线程数据:" + local.getMap().get(Thread.currentThread()));

        new Thread() {
            @Override
            public void run() {
                Map<Thread, String> map = new HashMap<>();
                map.put(Thread.currentThread(), "admin");
                local.setMap(map);
                System.out.println("当前线程数据:" + local.getMap().get(Thread.currentThread()));
            }
        }.start();
        System.out.println("当前线程数据:" + local.getMap().get(Thread.currentThread()));
    }
}

class MyThreadLocal<T> {
    // 实现线程单例,表示同一个线程获取的是同一个对象
    // 在属性中设置一个Map集合,其key对应线程,同一个线程只能存放一个对象
    private Map<Thread, T> map = new HashMap<>();

    public Map<Thread, T> getMap() {
        return map;
    }

    public void setMap(Map<Thread, T> map) {
        this.map = map;
    }

    // 模拟的ThreadLocal代码
    /**
     * 向当前线程中存储一个数据
     * key为当前线程
     * value为存储的数据
     * @param t
     */
    public void set(T t) {
        map.put(Thread.currentThread(), t);
    }

    /**
     * 获取对应线程所存储的值
     * @return
     */
    public T get() {
        return map.get(Thread.currentThread());
    }
}