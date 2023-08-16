package com.itany.corejava.code05_方法;

/**
 * @author 石小俊
 * @date 2023年08月14日 11:18
 * 斐波那契数列:1 1 2 3 5 8 13 21 34 55 ... n,后一项=前两项之和
 */
public class Test04_练习 {
    public static void main(String[] args) {
        System.out.println(fib(10));
    }

    public static int fib(int n) {
        // 1 1 2 3 5 8 ...n
        // 已知递归方法fib(n)求第n的项值
        // fib(n)=fib(n-1) + fib(n-2)
        // fib(n-1)=fib(n-2) + fib(n-3)
        // fib(n-2)=fib(n-3) + fib(n-4)
        // ...
        // fib(3) = fib(2) + fib(1);
        // fib(2) = fib(1) + fib(0); 无意义
        // 前两项的值一定都是1

        // 归
        if (n == 1 || n == 2) {
            return 1;
        }

        // 递
        return fib(n - 1) + fib(n - 2);
    }

}
