package com.itany.corejava.code06_数组;

/**
 * @author 石小俊
 * @date 2023年08月14日 13:37
 */
public class Test01_定义方式 {

    public static void main(String[] args) {
        // 只声明数组,不对数组的元素赋值
        int[] numbers = new int[5];
        System.out.println(numbers.length);
        System.out.println(numbers[0]);
        numbers[0] = 1;
        numbers[2] = 3;
        numbers[4] = 5;
        // numbers[5] = 5; 超出下标范围运行报错
        System.out.println(numbers[1]);

        String names[] = new String[3];
        names[0] = "admin";
        names[1] = "jack";
        System.out.println(names[2]);

        // 声明的同时为数组元素赋值
        String[] hobbies = new String[]{"吃饭", "睡觉", "打豆豆"};
        hobbies[2] = "学Java";
        System.out.println(hobbies.length);
        // 简写方式
        String[] hobbies2 = {"吃饭", "睡觉", "打豆豆"};

        double[] ds = new double[5];
        System.out.println(ds[1]);

        char[] cs = new char[4];
        System.out.println(cs[1]);

        boolean[] bs = new boolean[4];
        System.out.println(bs[1]);

        System.out.println(numbers[0]);
        System.out.println(numbers[2]);
        System.out.println(names[0]);
        System.out.println(hobbies[0]);
        System.out.println(hobbies[1]);
        System.out.println(hobbies[2]);
    }

}
