package com.itany.corejava.code09_集合.List;

import java.util.ArrayList;

/**
 * @author 石小俊
 * @date 2023年08月28日 14:46
 */
public class Test02_常用方法 {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        System.out.println(list.isEmpty());
        System.out.println(list.size() == 0);
        list.add("admin");
        list.add("alice");
        list.add("jack");
        list.add("admin");
        list.add("alice");
        list.add("jack");
        // 向集合中索引为1的位置添加一个元素
        list.add(1, "tom");
        list.add(4, "tom");
        System.out.println(list);
        System.out.println(list.set(3, "root"));
        ;
        System.out.println(list);

        System.out.println(list.remove("tom"));

        System.out.println(list);

        System.out.println(list.remove(4));
        System.out.println(list);

        System.out.println(list.get(4));
        System.out.println(list.isEmpty());

        System.out.println("alice第一次出现的索引位置:" + list.indexOf("alice"));
        System.out.println("alice最后一次出现的索引位置:" + list.lastIndexOf("alice"));
        System.out.println("lily第一次出现的位置:" + list.indexOf("lily"));
        System.out.println("lily最后一次出现的位置:" + list.lastIndexOf("lily"));

        System.out.println("集合中是否存在admin:" + list.contains("admin"));
        System.out.println("集合中是否存在lily:" + list.contains("lily"));
    }

}
