package com.itany.corejava.code04_循环结构;

import java.util.Scanner;

/**
 * @author 石小俊
 * @date 2023年08月11日 13:51
 * 某次计算机技能大赛,共有两个班级参加,每个班级选择三明学生参加
 * 通过控制台输入的方式输入所有学生的成绩,并统计每个班级的平均分,只统计80分以上的学生
 */
public class Test09_双重循环 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 外层循环控制班级
        for (int i = 1; i <= 2; i++) {
            System.out.println("********************开始统计第" + i + "个班级的学生信息********************");
            // 内层循环控制当前遍历的班级的所有学生
            // 针对每个班级求其平均分
            // 因此,每个班级的总成绩与总人数需要定义
            // 在此处定义的变量,每次外层循环重新执行时,此处的变量将会被重新定义
            double sum = 0;
            int count = 0;
            for (int j = 1; j <= 3; j++) {
                System.out.print("请输入第" + j + "个学生的成绩:");
                double score = sc.nextDouble();

                // 只统计成绩在80以上的学生
                if (score < 80) {
                    // 如果成绩低于80,则结束本次循环,不考虑本次循环中学生的信息
                    continue;
                }
                sum += score;
                count++;
            }
            // 当内层循环循环结束后,统计内层循环中所有学生的平均分
            double avg = sum / count;
            System.out.println("第" + i + "个班级学生的平均分为:" + avg);
        }
    }
}
