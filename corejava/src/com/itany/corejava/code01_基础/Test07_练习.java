package com.itany.corejava.code01_基础;

import java.util.Scanner;

/**
 * @author 石小俊
 * @date 2023年08月09日 16:15
 * 通过控制台输入的方式输入一个学生的信息,包含以下信息
 * 学生姓名(name)、年龄(age)、性别(gender)、专业(major)、课程(course)、成绩(score)
 */
public class Test07_练习 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("*********************输入学生信息*********************");
        System.out.print("请输入学生姓名:");
        String name = sc.nextLine();
        System.out.print("请输入学生年龄:");
        int age = sc.nextInt();
        System.out.print("请输入学生性别:");
        String gender = sc.next();
        System.out.print("请输入学生专业:");
        String major = sc.next();
        System.out.print("请输入学生课程:");
        String course = sc.next();
        System.out.print("请输入学生成绩:");
        double score = sc.nextDouble();
        System.out.println("学生姓名:" + name + ",年龄:" + age + ",性别:" + gender + ",专业:" + major + ",课程:" + course + ",成绩:" + score);
    }
}
