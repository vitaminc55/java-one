package com.itany.corejava.code06_数组;

import java.util.Arrays;

/**
 * @author 石小俊
 * @date 2023年08月16日 9:03
 * 定义一个4*4的二维数组,在控制台打印出来
 * 然后将第一行与第四行的数据交换,第二行与第三行的数据交换
 */
public class Test13_练习 {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        System.out.println("***************交换前***************");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
        System.out.println("***************交换后***************");
        int[] temp = arr[0];
        arr[0] = arr[3];
        arr[3] = temp;
        temp = arr[1];
        arr[1] = arr[2];
        arr[2] = temp;
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }
}
