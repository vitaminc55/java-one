package com.itany.corejava.code09_集合.set;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author 石小俊
 * @date 2023年08月29日 15:08
 */
public class Test05_TreeSet {

    public static void main(String[] args) {
        // 对于数值类型,其顺序是按照数值大小进行排序的
        // 不管放入的元素顺序是什么,进入到集合中的顺序都是按照数值大小存放的
        // 如果遇到重复的元素,会自动去除
        Set<Integer> set = new TreeSet<>();
        set.add(6);
        set.add(9);
        set.add(5);
        set.add(3);
        set.add(11);
        set.add(21);
        set.add(14);
        set.add(1);
        set.add(11);
        System.out.println(set);

        // 对于字符串类型,按照字典顺序进行排序
        // 如果存在数字与字符,数字排在前面
        // 比较时按照先比较第一个字符,第一个字符串相同再比较第二个字符的方式以此类推
        Set<String> set2 = new TreeSet<>();
        set2.add("1");
        set2.add("11");
        set2.add("12");
        set2.add("2");
        set2.add("22");
        set2.add("admin");
        set2.add("jack");
        set2.add("alice");
        System.out.println(set2);
    }

}
