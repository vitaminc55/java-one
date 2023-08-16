package com.itany.corejava.code01_基础;

/**
 * @author 石小俊
 * @date 2023年08月09日 14:49
 */
public class Test04_自动类型转换 {

    public static void main(String[] args) {
        byte b = 1;
        short s = 10;
        int i = 100;
        long l = 1000L;

        int sum = b + s;
        float sum2 = b + i + 3.14f;

        char c = '1';

        int sum3 = b + c;
        sum3 = 1 + 'a';
        System.out.println(sum3);

    }

}
