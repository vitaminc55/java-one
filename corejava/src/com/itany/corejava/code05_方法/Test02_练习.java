package com.itany.corejava.code05_方法;

/**
 * @author 石小俊
 * @date 2023年08月14日 9:40
 */
public class Test02_练习 {

    public static void main(String[] args) {
        System.out.println(sum(9));
        System.out.println(sum2(2, 3, 20));
        System.out.println(pow(2, 2));
        System.out.println(pow(2, -2));
        System.out.println(pow(2, 0));
    }

    /**
     * 根据传递的参数值进行判断
     * 如果n是一个奇数,则求n以内的奇数之和
     * 如果n是一个偶数,则求n以内的偶数之和
     * @param n
     * @return
     */
    public static int sum(int n) {
        // 定义接收奇数之和与偶数之和的变量
        int oddSum = 0, evenSum = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                // 如果是偶数,加到偶数之和中
                evenSum += i;
            } else {
                // 否则加到奇数之和中
                oddSum += i;
            }
        }
        // 如果是奇数,则返回奇数之和
        if (n % 2 != 0) {
            return oddSum;
        }
        // 否则返回偶数之和
        return evenSum;
    }

    /**
     * 求1‐n之内能被num1和num2整除的数字之和
     * @param num1
     * @param num2
     * @param n
     */
    public static int sum2(int num1, int num2, int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (i % num1 == 0 && i % num2 == 0) {
                sum += i;
            }
        }
        return sum;
    }

    /**
     * 计算x的y次方,定义方法实现,不允许使用Math提供的方法
     * @param x
     * @param y
     * @return
     */
    public static double pow(int x, int y) {
        // 定义一个变量用于接收结果,默认是1次方,即原本变量值
        double result = x;
        if (y > 0) {
            for (int i = 2; i <= y; i++) {
                // 每多一次方,则乘以一次x
                result = result * x;
            }
        } else if (y == 0) {
            result = 1;
        } else {
            // 如果小于0,实际上就是分母进行运算
            for (int i = 2; i <= -y; i++) {
                result = result * x;
            }
            result = 1.0 / result;
        }
        return result;
    }


}
