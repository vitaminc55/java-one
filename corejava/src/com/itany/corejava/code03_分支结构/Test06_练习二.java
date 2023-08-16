package com.itany.corejava.code03_分支结构;

import java.util.Scanner;

/**
 * @author 石小俊
 * @date 2023年08月10日 16:13
 * 在控制台输入指定的年份与月份
 * 计算出这一年的这个月共有多少天,考虑闰年
 */
public class Test06_练习二 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入一个年份:");
        int year = sc.nextInt();
        System.out.print("请输入一个月份:");
        int month = sc.nextInt();
        // 定义一个用来接收天数的变量
        int day = 0;
        if(year >= 1970 && month >= 1 && month <= 12){
            if(month == 2){
                if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0){
                    // 如果是闰年,二月份共29天
                    day = 29;
                }else{
                    // 如果不是闰年,则只有28天
                    day = 28;
                }
            }else if(month == 4 || month == 6 || month == 9 || month == 11){
                day = 30;
            } else{
                day = 31;
            }
            System.out.println(year+"年"+month+"月共有:"+day+"天");
        } else{
            System.out.println("您输入的年份或者月份不合法,请重新输入");
        }
    }
}
