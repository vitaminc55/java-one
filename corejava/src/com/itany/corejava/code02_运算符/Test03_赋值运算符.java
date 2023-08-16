package com.itany.corejava.code02_运算符;

/**
 * @author 石小俊
 * @date 2023年08月10日 10:52
 */
public class Test03_赋值运算符 {
    public static void main(String[] args) {
        int num;
        num = 5; // 直接赋值
        System.out.println(num); // 5
        num += 4; // 加法赋值,相当于num = num + 4
        System.out.println(num); // 9
        num -= 5; // 减法赋值,相当于num = num - 5
        System.out.println(num); // 4
        num *= 2; // 乘法赋值,相当于num = num * 2
        System.out.println(num); // 8
        num /= 3; // 除法赋值,相当于num = num / 3
        System.out.println(num); // 2
        num %= 2; // 取余赋值,相当于num = num % 2
        System.out.println(num); // 0
    }
}
