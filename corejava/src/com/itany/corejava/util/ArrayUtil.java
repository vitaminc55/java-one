package com.itany.corejava.util;

import java.util.Arrays;

/**
 * @author 石小俊
 * @date 2023年08月14日 16:55
 * 数组工具类
 */
public class ArrayUtil {
    public static void main(String[] args) {
        int[] arr = createArray(5, 1, 7);
        System.out.println(Arrays.toString(arr));
        System.out.println("*********************");
        int[] src = {1, 3, 5, 6, 7};
        int[] dist = new int[5];
        copyArray(src, dist);
        System.out.println(Arrays.toString(dist));
        System.out.println("*********************");
        show(src);
        System.out.println("\n*********************");
        change(src, 2, 4);
        show(src);
        System.out.println("\n*********************");
        reverse(src);
        show(src);
    }

    /**
     * 随机生成一个int类型的数组,通过方法的参数控制数组的长度、以及取值范围
     * 其值为指定范围x-y之间的整数,且不能重复。参数有三个:数组长度、最小值、最大值
     * @param length 随机生成的数组的长度
     * @param min    数组元素取值的最小值
     * @param max    数组元素取值的最大值
     * @return 一个int类型的数组
     */
    public static int[] createArray(int length, int min, int max) {
        int[] arr = new int[length];
        // 遍历数组,为数组中每一个元素进行赋值操作
        for (int i = 0; i < arr.length; i++) {
            // 随机生成一个min-max的整数
            arr[i] = (int) (Math.random() * (max - min + 1) + min);
            // 此时随机生成的元素可能存在重复的值,我们需要其不能重复
            // 需要将当前生成的元素与已经存储的数组元素进行判断,判断是否存在相同的值
            // 只有不重复,才需要添加到数组中
            for (int j = 0; j < i; j++) {
                if (arr[j] == arr[i]) {
                    // 由于arr[i]已经赋值,且此时赋的值已经存在了
                    // 因此,对于下标为i的元素需要重新赋值
                    i--;
                    break;
                }
            }
        }
        return arr;
    }

    /**
     * 实现复制数组的方法,将源数组的所有元素复制到目标数组中。两个参数:源数组,目标数组
     * @param src  源数组
     * @param dist 目标数组
     */
    public static void copyArray(int[] src, int[] dist) {
        // 保证两个数组的长度要完全一致
        if (src.length != dist.length) {
            System.out.println("目标数组与原数组长度不一致,无法复制!");
            return;
        }
        for (int i = 0; i < src.length; i++) {
            dist[i] = src[i];
        }
    }

    /**
     * 实现输出数组中元素的功能,要求数组的元素以短横杠-分隔
     * @param arr 需要输出的数组
     */
    public static void show(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // 需要将所有元素通过短横杠拼接,但是最后一个元素不需要
            if (i != arr.length - 1) {
                // 如果当前遍历的元素不是最后一个元素,则拼接短横杠
                System.out.print(arr[i] + "-");
            } else {
                // 如果当前遍历的元素是最后一个元素,则直接输出元素值
                System.out.print(arr[i]);
            }
        }
    }

    /**
     * 实现交换指定数组中指定位置的两个元素的值
     * @param arr 需要交换元素位置的数组
     * @param i   交换的索引位置一
     * @param j   交换的索引位置二
     */
    public static void change(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 将指定数组的所有元素颠倒过来,倒序
     * @param arr
     */
    public static void reverse(int[] arr) {
        // 在交换时,只交换到中间一个元素
        // 如果元素个数为奇数个,则中间一个不动,下标:arr.length/2
        // 如果元素个数为偶数个,则最中间两个需要交换,此时中间元素的下标:arr.length/2 - 1与arr.length/2
        for (int i = 0; i < arr.length / 2; i++) {
            // 将第一个与最后一个交换
            // 第二个与倒数第二个交换
            // ...
            // 定义一个下标变量,获取倒数第i个元素
            int j = arr.length - 1 - i;
            change(arr, i, j);
        }
    }
}
