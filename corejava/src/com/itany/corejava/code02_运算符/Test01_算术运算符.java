package com.itany.corejava.code02_运算符;

/**
 * @author 石小俊
 * @date 2023年08月10日 10:28
 */
public class Test01_算术运算符 {

    public static void main(String[] args) {
        int num1 = 3;
        int num2 = 2;
        System.out.println(num1 + num2); // 5
        System.out.println(num1 - num2); // 1
        System.out.println(num1 * num2); // 6
        System.out.println(num1 / num2); // 1
        System.out.println(num1 % num2); // 1

        // 先执行当前代码,然后对变量的值+1
        System.out.println(num1++); // 3
        // 上述代码相当于
        System.out.println(num1);
        num1 = num1 + 1;

        // 先对变量值+1,再执行当前代码
        System.out.println(++num2);

        int a = 5;
        int b = 10;
        System.out.println(a--);
        System.out.println(--b);

        double d1 = 5;
        double d2 = 2;
        System.out.println(d1 / d2);
    }

}
