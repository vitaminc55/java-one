package com.itany.corejava.code06_数组;

import java.util.Arrays;

/**
 * @author 石小俊
 * @date 2023年08月15日 13:39
 */
public class Test12_不定长参数 {

    public static void main(String[] args) {
        test(1, 2, 3, 4, 5, 6);
    }

    public static void test(int i, int j, int... nums) {
        System.out.println(i);
        System.out.println(j);
        System.out.println(Arrays.toString(nums));
    }

}
