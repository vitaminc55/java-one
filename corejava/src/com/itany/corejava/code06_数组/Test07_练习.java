package com.itany.corejava.code06_数组;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 石小俊
 * @date 2023年08月14日 15:48
 * 定义一个double类型的数组,用于存放某个班级中所有学生的成绩,在控制台输入共有几名学生
 * 学生的成绩也由控制台进行输入
 * 求:学生成绩的最大值、最小值、平均值
 */
public class Test07_练习 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入学生数量:");
        int num = sc.nextInt();

        // 定义一个double类型的数组,用于存放所有学生的成绩
        double[] scores = new double[num];
        // 定义一个用于接收总成绩的变量
        double sum = 0.0;
        for (int i = 0; i < scores.length; i++) {
            System.out.print("请输入第" + (i + 1) + "个学生的成绩:");
            scores[i] = sc.nextDouble();
            sum += scores[i];
        }

        // 对数组进行升序排序
        Arrays.sort(scores);
        System.out.println("最大值:" + scores[num - 1]);
        System.out.println("最小值:" + scores[0]);
        System.out.println("平均值:" + sum / num);

    }
}
