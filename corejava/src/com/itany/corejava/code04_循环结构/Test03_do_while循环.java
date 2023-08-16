package com.itany.corejava.code04_循环结构;

/**
 * @author 石小俊
 * @date 2023年08月11日 10:12
 */
public class Test03_do_while循环 {

    public static void main(String[] args) {
        // 求1-100之间偶数之和
        int num = 1;
        int sum = 0;
        do {
            if (num % 2 == 0) {
                sum += num;
            }
            num++;
        } while (num <= 100);
        System.out.println("1-100之间偶数之和为:" + sum);
    }

}
