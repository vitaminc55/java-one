package com.itany.corejava.code09_集合.List;

import java.util.ArrayList;
import java.util.Vector;

/**
 * @author 石小俊
 * @date 2023年08月29日 10:43
 */
public class Test10_性能对比 {

    public static void main(String[] args) {
        test01();
        test02();
    }

    public static void test01() {
        ArrayList<Integer> list = new ArrayList<>();
        long begin = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            list.add(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("ArrayList向末尾添加1000W条数据耗费了:" + (end - begin) + "毫秒");
    }
    public static void test02() {
        Vector<Integer> list = new Vector<>();
        long begin = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            list.add(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("Vector向末尾添加1000W条数据耗费了:" + (end - begin) + "毫秒");
    }


}
