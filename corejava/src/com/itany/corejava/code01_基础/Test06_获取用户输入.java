package com.itany.corejava.code01_基础;

import java.util.Scanner;

/**
 * @author 石小俊
 * @date 2023年08月09日 15:45
 */
public class Test06_获取用户输入 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入一个整数:");
        int num = sc.nextInt();
        System.out.println("您输入的整数为:" + num);
        System.out.print("请输入一个小数:");
        double num2 = sc.nextDouble();
        System.out.println("您输入的小数为:" + num2);
        System.out.print("请输入一个字符串:");
        String s = sc.next();
        System.out.println("您输入的字符串为:" + s);
        System.out.print("请输入一个字符串:");
        String s2 = sc.nextLine();
        System.out.println("您输入的字符串为:" + s2);
    }
}
