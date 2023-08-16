package com.itany.corejava.code04_循环结构;

/**
 * @author 石小俊
 * @date 2023年08月11日 9:46
 * 假设1+2+3+...+N > 3000,求N的最小值
 */
public class Test02_练习 {
    public static void main(String[] args) {
        int num = 1;
        int sum = 0;
        while (sum <= 3000) {
            // 当num的值为77时,此时结果总和超过了3000
            // 循环条件的值为false,退出循环
            sum += num;
            // 在退出循环之前会执行完代码块的所有内容
            // 此时对num又执行了自增操作
            // 此时的num的值从原本最小满足场景的值77变成了78
            // 因此,最终获取最小值时需要将此时自增的1减去
            num++;
        }
        System.out.println("N的最小值为:" + (--num));
    }
}
