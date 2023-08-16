package com.itany.corejava.code05_方法;

/**
 * @author 石小俊
 * @date 2023年08月11日 15:59
 */
public class SomeClass {
    /**
     * 计算1-n之间整数之和
     * @param n
     * @return
     */
    public static int sum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }
}
