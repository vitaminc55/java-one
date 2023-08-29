package com.itany.corejava.code09_集合.set;

import java.util.HashSet;

/**
 * @author 石小俊
 * @date 2023年08月29日 14:09
 */
public class Test02_常用方法 {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        System.out.println("集合是否为空:" + set.isEmpty());
        System.out.println("集合是否为空:" + (set.size() == 0));
        set.add(1);
        set.add(new Integer(2));
        set.add(3);
        System.out.println(set);
        System.out.println("集合元素数量:" + set.size());
        System.out.println("集合是否为空:" + set.isEmpty());
        System.out.println("集合是否为空:" + (set.size() == 0));

        System.out.println(set.remove(2));
        System.out.println(set);

        System.out.println("集合中是否存在元素1:" + set.contains(1));

        set.clear();
        System.out.println(set);
    }
}
