package com.itany.corejava.code09_集合.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author 石小俊
 * @date 2023年08月29日 14:35
 */
public class Test03_遍历 {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(5);
        set.add(7);
        set.add(8);

        // 方式一:使用增强for循环进行遍历
        // 不支持添加与删除操作
        for (Integer num : set) {
            System.out.print(num + " ");
        }
        System.out.println();

        // 方式二:使用Iterator迭代器进行遍历
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) {
            Integer num = it.next();
            System.out.print(num + " ");
            if (num % 2 == 0) {
                // set.remove(num);
                // 支持迭代器删除
                it.remove();
            }
        }
        System.out.println(set);
    }

}
