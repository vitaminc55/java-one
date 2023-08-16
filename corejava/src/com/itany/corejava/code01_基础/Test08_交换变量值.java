package com.itany.corejava.code01_基础;

import java.util.Scanner;

/**
 * @author 石小俊
 * @date 2023年08月10日 9:11
 * 在控制台输入两个int类型的数字, 分别赋值给两个变量
 * 通过一定的方式, 将这两个变量的值进行交换
 * 使用两种方式进行实现
 * 1.交换过程中可以存在第三个变量
 * 2.交换过程中不能存在第三个变量
 */
public class Test08_交换变量值 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入第一个int类型的变量值:");
        int num1 = sc.nextInt();
        System.out.print("请输入第二个int类型的变量值:");
        int num2 = sc.nextInt();

        System.out.println("*****************交换前的值*****************");
        System.out.println("num1:" + num1 + ",num2:" + num2);

        // 开始交换
        // 交换过程中可以存在第三个变量
        int num3 = num1;
        num1 = num2;
        num2 = num3;
        System.out.println("*****************方式一交换后的值*****************");
        System.out.println("num1:" + num1 + ",num2:" + num2);

        // 交换过程中不能存在第三个变量
        // 将两数之和赋值给其中一个变量
        num1 = num1 + num2;
        // 将原来的num1的值赋值给num2
        // 即:通过当前的num1 - 当前的num2的值
        num2 = num1 - num2;
        // 将原来的num2的值赋值给num1
        num1 = num1 - num2;
        System.out.println("*****************方式二交换后的值*****************");
        System.out.println("num1:" + num1 + ",num2:" + num2);
    }
}
