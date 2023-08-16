package com.itany.corejava.code03_分支结构;

import java.util.Scanner;

/**
 * @author 石小俊
 * @date 2023年08月10日 16:11
 * 在控制台输入一个成绩,判断成绩的等级
 * 优秀:90-100 良好 80-90 及格 60-80 不及格 0-60, 不在范围内的成绩认为不合法
 */
public class Test05_练习一 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入一个成绩:");
        double score = sc.nextDouble();
        if(score >= 0 && score <= 100){
            if(score >= 90){
                System.out.println("您的成绩等级为:优秀");
            } else if(score >= 80){
                System.out.println("您的成绩等级为:良好");
            } else if(score >= 60){
                System.out.println("您的成绩等级为:及格");
            } else{
                System.out.println("您的成绩等级为:不及格");
            }
        } else{
            System.out.println("您输入的成绩不合法,请重新输入");
        }
    }
}
