package com.itany.corejava.code02_运算符;

/**
 * @author 石小俊
 * @date 2023年08月10日 11:13
 */
public class Test04_比较运算符 {
    public static void main(String[] args) {
        int num1 = 3;
        int num2 = 2;
        System.out.println(num1 > num2);
        System.out.println(num1 >= num2);
        System.out.println(num1 < num2);
        System.out.println(num1 <= num2);
        System.out.println(num1 == num2);
        System.out.println(num1 != num2);
        // 不支持num1<num<num2的语法
        // 后面提供的逻辑运算符可以实现这种效果

        // 对于字符比较,其比较的是ASCII码
        System.out.println('a' < 'z');
    }
}
