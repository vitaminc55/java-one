package com.itany.corejava.code06_数组;

import java.util.Arrays;

/**
 * @author 石小俊
 * @date 2023年08月14日 16:44
 */
public class Test08_值传递与引用传递 {
    public static void main(String[] args) {
        // 值传递
        int i = 1;
        int i2 = i;

        // 修改i2的值
        i2 = 2;
        System.out.println(i);
        System.out.println(i2);

        // 引用传递
        int[] arr = {1,2,3};
        int[] arr2 = arr;

        // 修改arr2的值
        arr2[2] = 5;
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr2));
    }
}
