package com.itany.corejava.code06_数组;

import java.util.Scanner;

/**
 * @author 石小俊
 * @date 2023年08月15日 13:30
 * 有三个班,每个班有5名学生,提示用户分别输入学生的成绩,将数据保存到二维数组中
 * 计算每个班的平均分,全校的最高分与最低分
 */
public class Test11_练习 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] scores = new double[3][5];

        // 定义用于接收全校最高分与最低分的变量
        double max = 0, min = 100;
        // 外层循环控制班级
        for (int i = 0; i < scores.length; i++) {
            System.out.println("***************录入第" + (i + 1) + "个班级的学生成绩***************");
            // 定义一个变量,用于接收每个班级的总成绩
            double sum = 0;
            // 内层循环控制班级中的每一名学生
            for (int j = 0; j < scores[i].length; j++) {
                System.out.print("请输入第" + (j + 1) + "名学生成绩:");
                scores[i][j] = sc.nextDouble();
                // 判断当前的学生成绩是否高于已知的最高分,如果高于则替换
                max = scores[i][j] > max ? scores[i][j] : max;
                // 判断当前的学生成绩是否低于已知的最低分,如果低于则替换
                min = scores[i][j] < min ? scores[i][j] : min;
                sum += scores[i][j];
            }
            // 班级学生信息全部录入完成之后计算当前班级的平均分
            System.out.println("第" + (i + 1) + "个班级的平均分为:" + sum / scores[i].length);
        }
        System.out.println("全校最高分:" + max);
        System.out.println("全校最低分:" + min);

    }
}
