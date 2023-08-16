package com.itany.corejava.code05_方法;

/**
 * @author 石小俊
 * @date 2023年08月14日 11:11
 */
public class Test03_递归方法 {

    public static void main(String[] args) {
        System.out.println(sum(100));
    }

    public static int sum(int n) {
        // 递
        // 此处需要的是求1-n之间所有整数之和
        // 即:1+2+3+...+(n-1)+n
        // 前n-1项之和+n
        // sum(n-1)+n;
        // 前n-2项之和+(n-1)+n
        // sum(n-2)+(n-1)+n
        // ...
        // 前两项之和+...+(n-1)+n
        // 第一项+...+(n-1)+n
        // sum(n) = sum(n-1)+n =sum(n-2)+n-1+n...
        // n = n-1
        // sum(n-1) = sum(n-2) +n-1
        // sum(n-2) = sum(n-3) + n-2;
        // ..
        // sum(2) = sum(1) + 2
        // sum(1) = sum(0)+1 ×
        // sum(1) = 1;

        // 归,设置终止条件
        // 终止条件即为什么时候递归结束
        // 当n的值为1时,不再分为子问题,而是直接返回1
        if (n == 1) {
            return 1;
        }
        return sum(n - 1) + n;
    }

}
