package com.itany.corejava.code17_设计模式.模板模式;

import java.util.Arrays;

/**
 * @author 石小俊
 * @date 2023年09月18日 14:34
 */
public abstract class SortUtil {

    public static void main(String[] args) {
        int[] arr = {6, 3, 17, 12, 5, 2, 10, 1};
        SortUtilDesc desc = new SortUtilDesc();
        int[] result = desc.sort(arr);
        System.out.println(Arrays.toString(result));

        int[] arr2 = {6, 3, 17, 12, 5, 2, 10, 1};
        SortUtilSrc src = new SortUtilSrc();
        int[] result2 = src.sort(arr2);
        System.out.println(Arrays.toString(result2));
    }

    public int[] sort(int[] arr) {
        // 制定顶层架构
        // 外层循环控制比较的轮数
        for (int i = 0; i < arr.length - 1; i++) {
            // 内层循环控制每一轮比较的次数
            for (int j = 0; j < arr.length - 1 - i; j++) {
                int result = compareTo(arr[j], arr[j + 1]);
                if (result > 0) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    public abstract int compareTo(int i, int j);

}

class SortUtilDesc extends SortUtil {

    @Override
    public int compareTo(int i, int j) {
        return j - i;
    }
}

class SortUtilSrc extends SortUtil {

    @Override
    public int compareTo(int i, int j) {
        return i - j;
    }
}
