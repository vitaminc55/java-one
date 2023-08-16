package com.itany.corejava.code06_数组;

import java.util.Scanner;

/**
 * @author 石小俊
 * @date 2023年08月14日 14:44
 * 有一个保存学生姓名的数组,在控制台输入学生数量
 * 根据所输入的学生数量创建对应数组,并通过控制台输入的方式为每一个元素赋值
 * 打印出所有学生姓名
 */
public class Test03_练习 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入学生数量:");
        int num = sc.nextInt();
        String[] names = new String[num];
        for (int i = 0; i < names.length; i++) {
            System.out.print("请输入第" + (i + 1) + "个学生的姓名:");
            names[i] = sc.next();
        }

        for (int i = 0; i < names.length; i++) {
//            System.out.print(names[i] + "\t");
            String name = names[i];
            System.out.print(name+"\t");
        }
    }
}
