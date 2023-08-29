package com.itany.corejava.code09_集合.List;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

/**
 * @author 石小俊
 * @date 2023年08月29日 10:33
 */
public class Test09_Vector {

    public static void main(String[] args) {
        Vector<Integer> list = new Vector<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        System.out.println(list);

        // 普通for循环遍历
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();

        // 增强for循环遍历
        for (Integer num : list) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Iterator迭代器遍历
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            Integer num = it.next();
            System.out.print(num + " ");
        }
        System.out.println();

        // Enumeration遍历
        // 该方式适用于Vector、Hashtable、Properties等集合
        // ArrayList不支持该方式
        Enumeration<Integer> en = list.elements();
        // hasMoreElements():判断是否有下一个元素,相当于it.hasNext()
        while (en.hasMoreElements()) {
            // nextElement():取出迭代器中的下一个元素,相当于it.next()
            Integer num = en.nextElement();
            System.out.print(num + " ");
        }


    }

}
