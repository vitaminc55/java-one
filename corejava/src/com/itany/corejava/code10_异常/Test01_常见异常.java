package com.itany.corejava.code10_异常;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 石小俊
 * @date 2023年08月30日 15:48
 */
public class Test01_常见异常 {

    public static void main(String[] args) throws ClassNotFoundException {
        String[] arr = new String[5];
        // 数组下标越界
         System.out.println(arr[5]);

        // NumberFormatException
        // int i = Integer.parseInt("admin");

        // ClassCastException
        Object obj = new Object();
        // String s = (String) obj;

        // NullPointerException
        String s2 = null;
        // s2.equals("admin");

        // ConcurrentModificationException
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        for (Integer num : list) {
            // list.remove(num);
        }

        // ClassNotFoundException
        // Class.forName("aaa");

        // ArithmeticException
        int i = 1 / 0;

    }


}
