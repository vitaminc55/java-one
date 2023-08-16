package com.itany.corejava.code04_循环结构;

/**
 * @author 石小俊
 * @date 2023年08月14日 9:08
 * 打印九九乘法表
 * 1*1=1
 * 1*2=2 2*2=4
 * 1*3=3 2*3=6 3*3=9
 * ...
 */
public class Test12_九九乘法表 {
    public static void main(String[] args) {
        // 外层循环控制第一个数
        for (int i = 1; i <= 9; i++) {
            // 内层循环控制第二个数
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "*" + i + "=" + (i * j) + "\t");
            }
            // 内层循环循环与遍结束后换行
            System.out.println();
        }
    }
}
