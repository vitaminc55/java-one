package com.itany.corejava.code03_分支结构;

import java.util.Scanner;

/**
 * @author 石小俊
 * @date 2023年08月10日 14:54
 */
public class Test03_多分支结构 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入一个合法的年龄:");
        int age = sc.nextInt();
        if (age < 5) {
            System.out.println("你正处于婴儿年代");
        } else if (age < 18) {
            System.out.println("你还是从前那个少年");
        } else if (age < 30) {
            System.out.println("您已经处于青年时代,准备成家立业");
        } else if (age < 60) {
            System.out.println("人到中年,已经习惯了996,不敢轻易跳槽,需要养家糊口");
        } else if (age < 150) {
            System.out.println("您已经老了,可以躺平摆烂了");
        } else {
            System.out.println("您成仙了");
        }
    }

}
