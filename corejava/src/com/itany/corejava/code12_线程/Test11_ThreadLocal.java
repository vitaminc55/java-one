package com.itany.corejava.code12_线程;

/**
 * @author 石小俊
 * @date 2023年09月05日 11:34
 */
public class Test11_ThreadLocal {
    public static void main(String[] args) {
        ThreadLocal<String> local = new ThreadLocal<String>();
        // MyThreadLocal<String> local = new MyThreadLocal<String>();
        local.set("admin");
        System.out.println("当前线程:"+local.get());
        local.set("alice");
        System.out.println("当前线程:"+local.get());
        local.set("jack");
        System.out.println("当前线程:"+local.get());

        new Thread(){
            @Override
            public void run() {
                local.set("admin");
                System.out.println("当前线程:"+local.get());
            }
        }.start();
        System.out.println("当前线程:"+local.get());
    }
}
