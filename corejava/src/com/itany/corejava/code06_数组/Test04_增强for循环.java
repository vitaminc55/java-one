package com.itany.corejava.code06_数组;

/**
 * @author 石小俊
 * @date 2023年08月14日 14:50
 */
public class Test04_增强for循环 {

    public static void main(String[] args) {
        String[] hobbies = {"吃饭", "睡觉", "学java"};
        // 原始遍历方式
        for (int i = 0; i < hobbies.length; i++) {
            // hobby就是增强for循环中的循环变量名
            String hobby = hobbies[i];
            // 该方式可以通过变量i获取到遍历的元素的下标
            System.out.print("数组下标为" + i + "的元素值:" + hobby + "\t");
        }
        System.out.println();

        // 增强for循环
        for (String hobby : hobbies) {
            // 此处无法获取到遍历的数组下标
            System.out.print(hobby + "\t");
        }
    }

}
