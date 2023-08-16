package com.itany.corejava.code01_基础;

/**
 * @author 石小俊
 * @date 2023年08月09日 11:15
 */
public class Test01_变量的定义 {

    public static void main(String[] args) {
        int age; // 变量了一个变量名字叫做age,int表示当前变量是一个整数类型
        age = 18; // 为age赋值,其值为18
        // 打印语句,将括号中的内容在控制台打印出来
        // 括号中可以是具体的某一个值,也可以是一个变量
        // 如果是具体的某一个值,则直接打印值的内容
        // 如果是某一个变量,则打印变量的值
        age = 20;
        System.out.println(age);
        // 声明一个变量age2,并同时为该变量赋值一个值22
        int age2 = 22;
        System.out.println(age2);

        int num1 = 1, num2 = 2, num3 = 3;
        System.out.println(num1);
        System.out.println(num2);
        System.out.println(num3);
    }

}
