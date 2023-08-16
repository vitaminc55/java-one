package com.itany.corejava.code06_数组;

/**
 * @author 石小俊
 * @date 2023年08月14日 14:12
 */
public class Test02_遍历数组 {

    public static void main(String[] args) {
        int[] numbers = new int[10];
        // 通过遍历的方式为数组的元素赋值
        // 数组的下标从0开始,遍历时起始值为0
        for (int i = 0; i < numbers.length; i++) {
            // 为数组元素赋值
            numbers[i] = i + 1;
        }

        // 通过遍历打印数组中所有元素的值
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + "\t");
        }

        System.out.println();

        String hobbies[] = {"吃饭", "睡觉", "打豆豆"};
        for (int i = 0; i < hobbies.length; i++) {
            System.out.print(hobbies[i] + "\t");
        }
    }

}
