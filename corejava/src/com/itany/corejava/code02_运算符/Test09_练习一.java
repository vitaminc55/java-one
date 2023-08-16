package com.itany.corejava.code02_运算符;

import java.util.Scanner;

/**
 * @author 石小俊
 * @date 2023年08月11日 9:16
 * 在控制台输入三个数字,作为三角形的三个边长,判断这三条边是否可以组成一个三角形
 * 三角形: 任意两边之和大于第三边
 */
public class Test09_练习一 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入第一条边长:");
        int a = sc.nextInt();
        System.out.print("请输入第二条边长:");
        int b = sc.nextInt();
        System.out.print("请输入第三条边长:");
        int c = sc.nextInt();
        System.out.println(a + b > c && a + c > b && b + c > a ? "可以构成一个三角形" : "不能构成三角形");
    }
}
