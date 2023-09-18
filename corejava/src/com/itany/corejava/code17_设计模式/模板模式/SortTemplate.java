package com.itany.corejava.code17_设计模式.模板模式;

/**
 * @author 石小俊
 * @date 2023年09月18日 14:45
 */
public class SortTemplate {
    public static <T> void sort(T[] arr, SortComparator sc) {
        // 制定顶层架构
        // 外层循环控制比较的轮数
        for (int i = 0; i < arr.length - 1; i++) {
            // 内层循环控制每一轮比较的次数
            for (int j = 0; j < arr.length - 1 - i; j++) {
                // 此时使用接口中定义的抽象方法
                // 将具体的实现留给方法的调用者
                // 对于排序而言,根据调用者传递的参数不同实现不同方式的交换
                int result = sc.compareTo(arr[j], arr[j + 1]);
                if (result > 0) {
                    T temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
