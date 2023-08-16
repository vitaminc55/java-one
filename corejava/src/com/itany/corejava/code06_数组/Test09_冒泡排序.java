package com.itany.corejava.code06_数组;

import com.itany.corejava.util.ArrayUtil;

import java.util.Arrays;

/**
 * @author 石小俊
 * @date 2023年08月15日 10:16
 */
public class Test09_冒泡排序 {
    public static void main(String[] args) {
        int[] arr = {11, 21, 5, 13, 9, 31, 4, 1, 2};
        // 外层循环控制比较的轮数
        for (int i = 0; i < arr.length - 1; i++) {
            // 内层循环控制每一轮比较的次数
            for (int j = 0; j < arr.length - 1 - i; j++) {
                // 比较相邻的两个元素的大小
                // 如果前一个元素大于后一个元素,则交换两者的位置
                // 此时大于表示升序,小于表示降序
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            System.out.println("第" + (i + 1) + "轮比较的结果:" + Arrays.toString(arr));
        }
        System.out.println("最终冒泡排序后的结果:" + Arrays.toString(arr));
    }
}
