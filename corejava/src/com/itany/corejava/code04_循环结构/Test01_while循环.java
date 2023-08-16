package com.itany.corejava.code04_循环结构;

/**
 * @author 石小俊
 * @date 2023年08月11日 9:28
 */
public class Test01_while循环 {
    public static void main(String[] args) {
        // 计算1+2+3+...+100的和
        // 定义一个起始值的变量
        int num = 1;
        // 定义一个用来接收结果的变量
        int sum = 0;
        while (num <= 100) {
            sum += num;
            num++;
        }
        System.out.println("1-100之间整数之和为:" + sum);

    }
}
