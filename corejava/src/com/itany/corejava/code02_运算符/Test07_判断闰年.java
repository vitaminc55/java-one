package com.itany.corejava.code02_运算符;

import java.util.Scanner;

/**
 * @author 石小俊
 * @date 2023年08月10日 13:29
 */
public class Test07_判断闰年 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入一个合法的年份:");
        int year = sc.nextInt();
        System.out.println(year % 4 == 0 && year % 100 != 0 || year % 400 == 0 ? year + "是闰年" : year + "不是闰年");
    }

}
