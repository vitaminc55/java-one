package com.itany.corejava.code04_循环结构;

import java.util.Scanner;

/**
 * @author 石小俊
 * @date 2023年08月11日 14:41
 */
public class Test10_打印正方形 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入正方形边长:");
        int length = sc.nextInt();
        // 外层循环控制总行数
        for (int i = 1; i <= length; i++) {
            // 内层循环控制每一行打印的内容
            for (int j = 1; j <= length; j++) {
                // 每循环一次,打印一个*
                // 内层循环没结束时不需要换行
                System.out.print("* ");
            }
            // 当内层循环结束后即将进入下一行,执行换行操作
            System.out.println();
        }
    }

}
