package com.itany.corejava.code09_集合.List;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * @author 石小俊
 * @date 2023年08月28日 16:54
 * 循环提示用户输入一个整数,存放到ArrayList集合中,输入0表示循环结束
 * 删除所有是3的倍数的元素,用两种遍历方式实现
 */
public class Test05_练习 {
    public static void main(String[] args) {
        test02();
    }

    public static void test01() {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while (true) {
            System.out.print("请输入一个整数:");
            int num = sc.nextInt();
            // 如果输入的数字为0,则结束循环
            if (num == 0) {
                break;
            }
            // 否则将输入的数字添加到集合中
            list.add(num);
        }
        System.out.println("删除前集合数据:" + list);

        // 删除所有3的倍数的元素
        for (int i = list.size() - 1; i >= 0; i--) {
            Integer num = list.get(i);
            if (num % 3 == 0) {
                list.remove(num);
            }
        }
        System.out.println("删除后集合数据:" + list);
    }

    public static void test02() {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while (true) {
            System.out.print("请输入一个整数:");
            int num = sc.nextInt();
            // 如果输入的数字为0,则结束循环
            if (num == 0) {
                break;
            }
            // 否则将输入的数字添加到集合中
            list.add(num);
        }
        System.out.println("删除前集合数据:" + list);

        // 删除所有3的倍数的元素
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            Integer num = it.next();
            if (num % 3 == 0) {
                it.remove();
            }
        }
        System.out.println("删除后集合数据:" + list);

    }
}
