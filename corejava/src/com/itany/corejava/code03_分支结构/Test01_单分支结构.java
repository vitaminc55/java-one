package com.itany.corejava.code03_分支结构;

import java.util.Scanner;

/**
 * @author 石小俊
 * @date 2023年08月10日 14:43
 */
public class Test01_单分支结构 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入一个合法的年龄:");
        int age = sc.nextInt();
        if(age >= 18){
            System.out.println("恭喜您,您已经成年了,可以找对象了");
            System.out.println("这是if分支中的代码块内容,只有满足分支条件才会执行");
        }
        System.out.println("这是if分支外的内容,此处内容一定会被执行");

        if(age >= 18)
            System.out.println("恭喜您,您已经成年了,可以找对象了");
            System.out.println("这不是if分支中的代码块内容,此处内容一定会被执行");
        System.out.println("这是if分支外的内容,此处内容一定会被执行");
    }

}
