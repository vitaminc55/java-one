package com.itany.corejava.code08_常用类.其他类;

/**
 * @author 石小俊
 * @date 2023年08月25日 11:16
 */
public class Test02_Math类 {

    public static void main(String[] args) {
        // 获取[0,1)的随机数
        System.out.println(Math.random());
        // 获取x-y随机数的规律:Math.random() * (y - x + 1) + x
        // 取9-13的随机整数
        System.out.println((int) (Math.random() * (13 - 9 + 1) + 9));
        // 获取C-H的随机字符
        System.out.println((char) (Math.random() * ('H' - 'C' + 1) + 'C'));

        // 绝对值
        System.out.println(Math.abs(1));
        System.out.println(Math.abs(0));
        System.out.println(Math.abs(-1));

        // round
        System.out.println(Math.round(3.14));
        System.out.println(Math.round(5.67));

        // floor
        System.out.println(Math.floor(3.14));   // 3.0
        System.out.println(Math.floor(-3.14));  // -4.0

        // ceil
        System.out.println(Math.ceil(5.67));    // 6
        System.out.println(Math.ceil(-5.67));   // -5

        System.out.println(Math.pow(200,3));    // 800W.0
        System.out.println(Math.pow(-2,2));    // 4
        System.out.println(Math.pow(2,-2));    // 1/4
        System.out.println(Math.pow(0,2));     // 0
        System.out.println(Math.pow(-2,0));    // 1

        System.out.println(Math.max(3.14,3.15));
        System.out.println(Math.min(3.14,3.15));

        System.out.println(Math.sqrt(400));
        System.out.println(Math.sqrt(2));

        // 常量
        System.out.println(Math.PI);
        System.out.println(Math.E);

    }

}
