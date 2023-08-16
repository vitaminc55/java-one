package com.itany.corejava.code03_分支结构;

import java.util.Scanner;

/**
 * @author 石小俊
 * @date 2023年08月10日 15:00
 */
public class Test04_嵌套分支结构 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入今天星期几(1-7)?");
        int today = sc.nextInt();
        if (today >= 1 && today <= 7) {
            if (today > 5) {
                System.out.println("请告诉我您是否有对象?(1:有对象 0:单身狗)");
                int flag = sc.nextInt();
                if (flag == 1) {
                    System.out.println("今天休息,带上对象出去浪");
                } else if (flag == 0) {
                    System.out.println("今天休息,抓紧一切时间赶紧找对象");
                } else {
                    System.out.println("您输入的选项有误");
                }
            } else {
                System.out.println("代码虐我千百遍,我待代码如初恋");
            }
        } else {
            System.out.println("您输入的选项有误");
        }
    }
}
