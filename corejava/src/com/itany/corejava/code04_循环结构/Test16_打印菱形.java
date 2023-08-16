package com.itany.corejava.code04_循环结构;

import java.util.Scanner;

/**
 * @author 石小俊
 * @date 2023年08月14日 9:32
 * 用户输入一个奇数的数字,在控制台通过星号*打印菱形
 * 输入的数字表示图形的行数
 *       *
 *     * * *
 *   * * * * *
 * * * * * * * *
 *   * * * * *
 *     * * *
 *       *
 */
public class Test16_打印菱形 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入菱形的行数(必须是奇数):");
        int rows = sc.nextInt();
        if (rows % 2 == 0) {
            System.out.println("您输入的数字不是一个奇数,请重新输入");
        } else {
            // 可以将一个菱形拆分成两部分
            // 上半部分是一个等腰三角形,下半部分是一个倒等腰三角形
            // 先打印等腰三角形,上半部分的总行数为:rows/2 + 1
            int rows1 = rows / 2 + 1;
            for (int i = 1; i <= rows1; i++) {
                for (int j = 1; j <= rows1 - i; j++) {
                    System.out.print("  ");
                }
                for (int j = 1; j <= 2 * i - 1; j++) {
                    System.out.print("* ");
                }
                // 内层循环全部结束之后换行
                System.out.println();
            }
            // 在打印倒等腰三角形
            int rows2 = rows / 2;
            for (int i = 1; i <= rows2; i++) {
                // 打印空格,此时第一行存在一个空格,下面以此类推,规律:第几行就有几个空格
                for (int j = 1; j <= i; j++) {
                    System.out.print("  ");
                }
                for (int j = 1; j <= 2 * (rows2 - i) + 1; j++) {
                    System.out.print("* ");
                }
                // 内层循环结束之后换行
                System.out.println();
            }
        }
    }
}
