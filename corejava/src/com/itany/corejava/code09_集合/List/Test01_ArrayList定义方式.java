package com.itany.corejava.code09_集合.List;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 石小俊
 * @date 2023年08月28日 14:08
 */
public class Test01_ArrayList定义方式 {

    public static void main(String[] args) {
        // 定义一个没有指定类型的集合
        ArrayList list = new ArrayList();
        System.out.println("list集合中元素的数量:" + list.size());
        list.add(1);
        list.add("admin");
        list.add(3.14);
        System.out.println("list集合中元素的数量:" + list.size());

        // 定义一个指定类型的集合
        ArrayList<String> list2 = new ArrayList<>(2);
        list2.add("admin");
        list2.add("alice");
        list2.add("jack");
        System.out.println("list2集合中元素的数量:" + list2.size());

        // 通过Collection创建一个ArrayList
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);

        ArrayList<Integer> list3 = new ArrayList<Integer>(numbers);
        System.out.println("list3集合中元素的数量:" + list3.size());
    }

}
