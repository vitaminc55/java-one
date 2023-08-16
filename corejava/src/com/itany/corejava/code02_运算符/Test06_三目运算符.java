package com.itany.corejava.code02_运算符;

import java.util.Scanner;

/**
 * @author 石小俊
 * @date 2023年08月10日 11:43
 */
public class Test06_三目运算符 {
    public static void main(String[] args) {
        int age = 20;
        System.out.println(age < 18 ? "您尚未成年" : "您已经成年了");

        // 控制台输入一个数字,判断其是奇数还是偶数
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入一个正整数:");
        int num = sc.nextInt();
        System.out.println(num % 2 == 0 ? num + "是一个偶数" : num + "是一个奇数");

    }
}
