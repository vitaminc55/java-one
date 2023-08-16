package com.itany.corejava.code06_数组;

import java.util.Arrays;

/**
 * @author 石小俊
 * @date 2023年08月14日 15:11
 */
public class Test06_数组工具类 {
    public static void main(String[] args) {
        sortTest();
    }

    public static void toStringTest() {
        int[] nums = {1, 3, 5};
        System.out.println("[" + nums[0] + ", " + nums[1] + ", " + nums[2] + "]");
        // 返回的数据格式:[元素1, 元素2, 元素3]
        System.out.println(Arrays.toString(nums));
    }

    public static void sortTest() {
        int[] nums = {8, 4, 3, 9, 11, 13, 21, 15, 2, 1};
        System.out.println("排序前:" + Arrays.toString(nums));
        Arrays.sort(nums);
        System.out.println("排序后:" + Arrays.toString(nums));

        String[] names = {"tom", "root", "jack", "alice", "admin", "lily"};
        System.out.println("排序前:" + Arrays.toString(names));
        Arrays.sort(names);
        System.out.println("排序后:" + Arrays.toString(names));

        String[] numbers = {"13", "11", "2", "7", "21", "1", "15"};
        System.out.println("排序前:" + Arrays.toString(numbers));
        Arrays.sort(numbers);
        System.out.println("排序后:" + Arrays.toString(numbers));
    }
}
