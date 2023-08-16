package com.itany.corejava.code04_循环结构;

/**
 * @author 石小俊
 * @date 2023年08月11日 14:45
 */
public class Test11_随机数 {
    public static void main(String[] args) {
        // 生成大于等于0,小于1的浮点数
        System.out.println(Math.random());

        // 生成大于等于0,小于10的浮点数
        System.out.println(Math.random() * 10);

        // 生成0-9的整数
        System.out.println((int) (Math.random() * 10));

        // 生成0-1的整数
        System.out.println((int) (Math.random() * 2));

        // 生成23-24的整数
        // [23,25)  [0,1) * 2  --> [0,2) + 23 -->[23,25)
        System.out.println((int) (Math.random() * 2 + 23));

        // 随机生成x-y的随机数
        // Math.random() * (y - x + 1) + x

        // 随机生成35~78的整数
        System.out.println((int) (Math.random() * (78 - 35 + 1) + 35));

        // 随机生成A-D的字符
        // 可以直接写运算
        System.out.println((char) (Math.random() * ('D' - 'A' + 1) + 'A'));
        // 也可以直接使用ASCII码进行运算
        System.out.println((char) (Math.random() * 4 + 65));
    }
}
