package com.itany.corejava.code04_循环结构;

/**
 * @author 石小俊
 * @date 2023年08月11日 11:47
 * 找出所有的水仙花数
 * 水仙花数指的是一个三位数,它的每一个位置上的数字的三次幂之和等于它本身
 */
public class Test06_水仙花数 {
    public static void main(String[] args) {
        for (int i = 100; i < 1000; i++) {
            // 个位数的值
            int a = i % 10;
            // 十位数的值
            int b = (i / 10) % 10;
            // 百位数的值
            int c = i / 100;
            if (a * a * a + b * b * b + c * c * c == i) {
                System.out.println("水仙花数:" + i);
            }
        }
    }
}
