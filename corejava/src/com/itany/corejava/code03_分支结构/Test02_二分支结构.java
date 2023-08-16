package com.itany.corejava.code03_分支结构;

import java.util.Scanner;

/**
 * @author 石小俊
 * @date 2023年08月10日 14:49
 */
public class Test02_二分支结构 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入一个合法的年份:");
        int year = sc.nextInt();
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            System.out.println(year + "是闰年");
        } else {
            System.out.println(year + "不是闰年");
        }
    }
}
