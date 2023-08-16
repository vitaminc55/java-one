package com.itany.corejava.code01_基础;

/**
 * @author 石小俊
 * @date 2023年08月10日 9:30
 */
public class Test09_进制转换 {
    public static void main(String[] args) {
        // 0b0110 1101
        System.out.println(1 + 0 + 1 * 4 + 1 * 8 + 0 + 1 * 32 + 1 * 64);
        // 01024
        System.out.println(4 * 1 + 2 * 8 + 0 + 1 * 64 * 8);
        // 0x12ab
        System.out.println(11 + 10 * 16 + 2 * Math.pow(16, 2) + 1 * Math.pow(16, 3));

        // 练习
        // 0b1011 1110
        System.out.println(0 + 2 + 4 + 8 + 16 + 32 + 128);
        // 04567
        System.out.println(7 + 6 * 8 + 5 * 64 + 4 * Math.pow(8, 3));
        // 0x123abc
        System.out.println(12 + 11 * 16 + 10 * Math.pow(16, 2) + 3 * Math.pow(16, 3) + 2 * Math.pow(16, 4) + 1 * Math.pow(16, 5));

        // 十二进制123ab --> 十进制
        System.out.println(11 + 10 * 12 + 3 * Math.pow(12, 2) + 2 * Math.pow(12, 3) + 1 * Math.pow(12, 4));

        // 365
    }
}
