package com.itany.corejava.code09_集合.Collections工具类;

import java.util.*;

/**
 * @author 石小俊
 * @date 2023年08月30日 14:50
 */
public class Test01_常用方法 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println(list);

        Collections.addAll(list, 8, 6, 7, 9, 15, 13, 11, 1, 1, 1);
        System.out.println(list);

        System.out.println("集合中元素的最大值:" + Collections.max(list));
        System.out.println("集合中元素的最大值:" + Collections.min(list));
        Collections.sort(list);
        System.out.println(list);
        // 自定义降序排序
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                if (i1 > i2) {
                    return -1;
                } else if (i1 < i2) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        System.out.println(list);
        Collections.reverse(list);
        System.out.println(list);
        // 将1替换成10
        Collections.replaceAll(list, 1, 10);
        System.out.println(list);
        Collections.swap(list, 2, 8);
        System.out.println(list);
        Collections.fill(list, 1);
        System.out.println(list);


        List<String> list2 = new ArrayList<>(Arrays.asList("tom", "jack", "alice", "11", "1", "2", "12"));
        System.out.println("集合中元素的最大值:" + Collections.max(list2));
        System.out.println("集合中元素的最大值:" + Collections.min(list2));
        Collections.sort(list2);
        System.out.println(list2);
        Collections.sort(list2, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1.length() > s2.length()) {
                    return 1;
                } else if (s1.length() < s2.length()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        System.out.println(list2);
        Collections.reverse(list2);
        System.out.println(list2);
    }
}
class Test02{
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        System.out.println(list.get(0));
    }
}
