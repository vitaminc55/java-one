package com.itany.corejava.code06_数组;

import java.util.Arrays;

/**
 * @author 石小俊
 * @date 2023年08月15日 11:06
 */
public class Test10_二维数组 {
    public static void main(String[] args) {
        System.out.println("************方式一************");
        int[][] nums = new int[3][2];
        nums[0][0] = 1;
        nums[0][1] = 2;
        nums[1][0] = 3;
        nums[1][1] = 4;
        nums[2][0] = 5;
        nums[2][1] = 6;
        for (int i = 0; i < nums.length; i++) {
            System.out.println(Arrays.toString(nums[i]));
        }
        System.out.println("************方式二************");
        int[][] arr = new int[3][];
        arr[0] = new int[2];
        arr[0][0] = 1;
        arr[0][1] = 2;
        arr[1] = new int[3];
        arr[1][0] = 3;
        arr[1][1] = 4;
        arr[1][2] = 5;
        arr[2] = new int[5];
        arr[2][0] = 6;
        arr[2][1] = 7;
        arr[2][2] = 8;
        arr[2][3] = 9;
        arr[2][4] = 10;
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }

        System.out.println("************方式三************");
        int[][] numbers = new int[][]{
                {1, 2, 3},
                {4, 5},
                {6, 7, 8, 9},
                {10, 11, 12, 13, 14, 15, 16}
        };
        System.out.println(numbers.length);
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(Arrays.toString(numbers[i]));
        }
        System.out.println("************简写方式************");
        int[][] arr2 = {
                {1, 2, 3},
                {4, 5},
                {6, 7, 8, 9},
                {10, 11, 12, 13, 14, 15, 16}
        };
        for (int i = 0; i < arr2.length; i++) {
            System.out.println(Arrays.toString(arr2[i]));
        }
    }
}
