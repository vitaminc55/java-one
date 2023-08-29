package com.itany.corejava.code09_集合.List;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author 石小俊
 * @date 2023年08月29日 10:28
 */
public class Test08_性能对比 {
    public static void main(String[] args) {
        test01();
        test02();
        test03();
        test04();
    }

    public static void test01() {
        ArrayList<Integer> list = new ArrayList<>();
        long begin = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            list.add(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("ArrayList向末尾添加100W条数据耗费了:" + (end - begin) + "毫秒");
    }

    public static void test02() {
        LinkedList<Integer> list = new LinkedList<>();
        long begin = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            list.add(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("LinkedList向末尾添加100W条数据耗费了:" + (end - begin) + "毫秒");
    }

    public static void test03() {
        ArrayList<Integer> list = new ArrayList<>();
        long begin = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            list.add(0, i);
        }
        long end = System.currentTimeMillis();
        System.out.println("ArrayList插入10W条数据耗费了:" + (end - begin) + "毫秒");
    }

    public static void test04() {
        LinkedList<Integer> list = new LinkedList<>();
        long begin = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            list.add(0, i);
        }
        long end = System.currentTimeMillis();
        System.out.println("LinkedList插入10W条数据耗费了:" + (end - begin) + "毫秒");
    }
}
