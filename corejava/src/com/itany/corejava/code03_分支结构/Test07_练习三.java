package com.itany.corejava.code03_分支结构;

import java.util.Scanner;

/**
 * @author 石小俊
 * @date 2023年08月10日 16:18
 * 在控制台输入三个数字,作为三角形的三条边,判断该三角形的类型
 * 1.等边三角形: 三条边相等
 * 2.等腰三角形: 任意两边相等
 * 3.直角三角形: 任意两边的平方和等于第三边的平方
 * 4.普通三角形: 任意两边之和都大于第三边
 */
public class Test07_练习三 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入第一条边长:");
        int a = sc.nextInt();
        System.out.print("请输入第二条边长:");
        int b = sc.nextInt();
        System.out.print("请输入第三条边长:");
        int c = sc.nextInt();
        if (a + b > c && a + c > b && b + c > a) {
            if (a == b && b == c) {
                System.out.println("等边三角形");
            } else if (a == b || b == c || c == a) {
                System.out.println("等腰三角形");
            } else if (a * a + b * b == c * c || b * b + c * c == a * a || a * a + c * c == b * b) {
                System.out.println("直角三角形");
            } else {
                System.out.println("普通三角形");
            }
        } else {
            System.out.println("您输入的三条边长无法构成三角形");
        }
    }
}
