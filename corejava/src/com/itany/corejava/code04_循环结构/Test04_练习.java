package com.itany.corejava.code04_循环结构;

/**
 * @author 石小俊
 * @date 2023年08月11日 10:37
 * 打印1-200之间能被7整除但是不能被4整除的所有整数
 * 按照每行打印5个数的方式打印处理
 * 统计符合条件的所有数字的数量
 */
public class Test04_练习 {
    public static void main(String[] args) {
        int num = 1;
        // 定义符合条件的数字的总数量
        int count = 0;
        do {
            if (num % 7 == 0 && num % 4 != 0) {
                // 当遇到了符合条件的数字时,数量+1
                count++;
                System.out.print(num + "\t");
                // 每5个数字在一行
                // 每隔5个数字需要换一行,即总数量的值能被5整除则换行
                if (count % 5 == 0) {
                    System.out.println();
                }
            }
            num++;
        } while (num <= 200);
        System.out.println("\n符合条件的数字总数量为:" + count);
    }
}
