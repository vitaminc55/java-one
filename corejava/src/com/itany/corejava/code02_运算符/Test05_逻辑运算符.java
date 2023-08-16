package com.itany.corejava.code02_运算符;

/**
 * @author 石小俊
 * @date 2023年08月10日 11:17
 */
public class Test05_逻辑运算符 {

    public static void main(String[] args) {
        System.out.println(3 < 5 & 5 < 7);
        System.out.println(3 < 5 & 5 > 7);
        System.out.println(3 < 5 && 5 < 7);
        System.out.println(3 < 5 && 5 > 7);

        // 在Java中,只要代码1/0 == 0执行了,则一定是报错的
        // 但是此时发现,如果使用false && 1 / 0 == 0,则最终结果是没有报错的
        // 说明1 / 0 == 0代码没有被执行
        System.out.println(false && 1 / 0 == 0);

        System.out.println(true || 1 / 0 == 0);

        System.out.println(true);
        System.out.println(!true);
        System.out.println(!false);
    }

}
