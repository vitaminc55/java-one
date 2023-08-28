package com.itany.corejava.code09_集合.List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 石小俊
 * @date 2023年08月28日 15:15
 */
public class Test03_与数组的转换 {

    public static void main(String[] args) {
//        listToArray();
        arrayToList();
    }

    public static void listToArray() {
        ArrayList list = new ArrayList();
        list.add("admin");
        list.add(1);
        list.add(3.14);
        list.add(true);
        list.add('a');
        System.out.println(list);

        // 通过toArray方法将一个集合转换成数组
        Object[] arr = list.toArray();
        System.out.println(Arrays.toString(arr));
    }

    public static void arrayToList() {
        String[] arr = {"admin", "alice", "lily", "jack", "tom"};

        // 将一个数组转换成List集合
        List<String> list = Arrays.asList(arr);
        System.out.println(list);
        // list.remove("admin"); // 报错,该对象不是ArrayList

        // 参数支持可变长参数
        List<Integer> list2 = Arrays.asList(1, 2, 3, 4, 5, 6);
        System.out.println(list2);

        // 将List转换成ArrayList
        ArrayList<String> list3 = new ArrayList<>(list);
        System.out.println(list3);

    }
}
