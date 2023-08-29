package com.itany.corejava.code09_集合.set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author 石小俊
 * @date 2023年08月29日 13:44
 */
public class Test01_HashSet定义方式 {

    public static void main(String[] args) {
        // 定义方式一:使用默认初始容量16与默认加载因子0.75定义一个空set集合
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        System.out.println(set);

        // 定义方式二:将一个Collection集合转换成HashSet
        List<String> list = new ArrayList<>();
        list.add("admin");
        list.add("alice");
        list.add("jack");
        list.add("admin");
        list.add("tom");
        // List存储的数据是可以重复的
        System.out.println("转换前的List集合:" + list);
        // Set存储的数据是不可以重复的
        HashSet<String> set2 = new HashSet<>(list);
        // 因此,将List集合转换成Set集合之后,会自动去除List集合中重复的元素
        // 且由于Set是一个无序的集合,因此存储的元素没有顺序
        System.out.println("转换后的Set集合:" + set2);

        // 定义方式三:自定义初始容量
        HashSet<String> set3 = new HashSet<>(10);

        // 定义方式四:自定义初始容量与加载因子
        HashSet<Integer> set4 = new HashSet<Integer>(10, 0.5f);
    }

}
