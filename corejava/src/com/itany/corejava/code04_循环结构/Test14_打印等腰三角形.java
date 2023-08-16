package com.itany.corejava.code04_循环结构;

import java.util.Scanner;

/**
 * @author 石小俊
 * @date 2023年08月14日 9:17
 * 用户输入一个数字,在控制台通过星号*打印等腰三角形
 * 输入的数字表示图形的行数
 *     *
 *   * * *
 * * * * * *
 */
public class Test14_打印等腰三角形 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入等腰三角形的行数:");
        int rows = sc.nextInt();
        // 外层循环控制每一行的内容,每循环一次,打印一行内容
        for (int i = 1; i <= rows; i++) {
            // 内层循环控制某一行的每一列的内容
            // 每一行的内容由空格与星号组成
            // 先打印空格
            // 每一行空格数量=总行数-当前所属的行数
            // 打印几个空格就是内层循环循环几次
            for (int j = 1; j <= rows - i; j++) {
                System.out.print("  ");
            }

            // 再打印星号
            // 星号数量分别为:1、3、5、7、9...
            // 规律:2 * 行数 - 1
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("* ");
            }
            // 内层循环全部结束之后换行
            System.out.println();
        }
    }
}
