package com.itany.corejava.code04_循环结构;

import java.util.Scanner;

/**
 * @author 石小俊
 * @date 2023年08月14日 9:24
 * 用户输入一个数字,在控制台通过星号*打印倒等腰三角形
 * 输入的数字表示图形的行数
 * * * * * * * *
 *   * * * * *
 *     * * *
 *       *
 */
public class Test15_打印倒等腰三角形 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入倒等腰三角形的行数:");
        int rows = sc.nextInt();
        // 外层循环控制打印的行数
        for (int i = 1; i <= rows; i++) {
            // 内层循环控制打印的每一行的内容
            // 先打印空格
            // 空格规律:0、1、2、3、4...
            // 即:行数-1
            for(int j = 1; j <= i - 1; j++){
                System.out.print("  ");
            }
            // 再打印星号
            // * * * * * * *		7	2 * (4-1) + 1
            //   * * * * *			5	2 * (4-2) + 1
            //     * * *			3	2 * (4-3) + 1
            //       *				1	2 * (4-4) + 1
            // 规律:2 * (总行数-当前行数) + 1
            for(int j = 1; j <= 2 * (rows - i) + 1; j++){
                System.out.print("* ");
            }
            // 内层循环结束之后换行
            System.out.println();
        }
    }
}
