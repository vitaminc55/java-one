package com.itany.corejava.code04_循环结构;

import java.util.Scanner;

/**
 * @author 石小俊
 * @date 2023年08月11日 11:49
 * 斐波那契数列: 1 1 2 3 5 8 13 ... N, 前两项之和等于第三项
 * 在控制输入需要打印几个数, 输出对应数量的数字
 */
public class Test07_斐波那契数列 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入斐波那契数列的数字数量:");
        int num = sc.nextInt();
        if(num > 0){
            if(num == 1){
                // 如果只有一个,则打印1
                System.out.println("1");
            }
            if(num >= 2){
                // 打印前两项之和
                System.out.print("1 1 ");
                // 打印第三项的值
                // 此时N-2项的值即为第一项
                int a = 1;
                // 此时N-1项的值即为第二项
                int b = 1;
                for(int i = 3; i <= num; i++){
                    // 第N项的值即为前两项之和
                    int n = a + b;
                    // 重新为N-2项赋值
                    // i的值每次自增1,再次进入循环,此时N-2项的值即为之前N-1项的值
                    a = b;
                    // 重新为N-1项赋值
                    // 此时N-1项的值即为之前N项的值
                    b = n;
                    System.out.print(n+" ");
                }
            }
        }else{
            System.out.println("您输入的选项有误,请输入一个正整数");
        }
    }
}
