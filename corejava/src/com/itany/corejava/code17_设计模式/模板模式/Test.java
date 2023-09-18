package com.itany.corejava.code17_设计模式.模板模式;

import java.util.Arrays;

/**
 * @author 石小俊
 * @date 2023年09月18日 14:47
 */
public class Test {
    public static void main(String[] args) {
        Integer[] arr = {6, 4, 1, 18, 15, 11, 9, 2};
        SortTemplate.sort(arr, new SortComparator<Integer>() {
            @Override
            public int compareTo(Integer t1, Integer t2) {
                return t1 - t2;
            }
        });
        System.out.println(Arrays.toString(arr));

        SortTemplate.sort(arr, new SortComparator<Integer>() {
            @Override
            public int compareTo(Integer t1, Integer t2) {
                return t2 - t1;
            }
        });
        System.out.println(Arrays.toString(arr));

        String[] names = {"jack", "tom", "alice", "admin"};
        SortTemplate.sort(names, new SortComparator<String>() {
            @Override
            public int compareTo(String t1, String t2) {
                return t2.length() - t1.length();
            }
        });
        System.out.println(Arrays.toString(names));

    }

}
