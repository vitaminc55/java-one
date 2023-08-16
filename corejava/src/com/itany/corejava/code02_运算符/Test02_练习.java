package com.itany.corejava.code02_运算符;

import java.util.Scanner;

/**
 * @author 石小俊
 * @date 2023年08月10日 10:48
 * 从控制台输入三门课程Java、Web、MySQL的成绩,计算三门课程的总分与平均分
 */
public class Test02_练习 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入Java课程的成绩:");
        double javaScore = sc.nextDouble();
        System.out.print("请输入Web课程的成绩:");
        double webScore = sc.nextDouble();
        System.out.print("请输入MySQL课程的成绩:");
        double mysqlScore = sc.nextDouble();

        double sum = javaScore + webScore + mysqlScore;
        double avg = sum / 3;
        System.out.println("三门课程总分:" + sum + ",平均分:" + avg);
    }
}
