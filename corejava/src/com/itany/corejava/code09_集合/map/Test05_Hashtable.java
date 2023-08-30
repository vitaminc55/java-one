package com.itany.corejava.code09_集合.map;

import java.util.Enumeration;
import java.util.Hashtable;

/**
 * @author 石小俊
 * @date 2023年08月30日 11:23
 */
public class Test05_Hashtable {
    public static void main(String[] args) {
        Hashtable<Integer, String> map = new Hashtable<>();

        map.put(1, "admin");
        map.put(2, "alice");
        map.put(3, "jack");

        // Hashtable的key与value均不能为null
        // map.put(null,null); // 报错
        System.out.println(map);


        // 除了原HashMap中的遍历方式以外,还支持Enumeration遍历
        // 支持两种遍历:对key的枚举遍历、对value的枚举遍历
        // 1.对key的枚举遍历,遍历后可以根据key获取对应的value
        Enumeration<Integer> keys = map.keys();
        while (keys.hasMoreElements()) {
            Integer key = keys.nextElement();
            // 根据key获取到对应的value
            String value = map.get(key);
            System.out.print(key + "-" + value + "\t");
        }
        System.out.println();

        // 2.对value的枚举遍历
        Enumeration<String> values = map.elements();
        while (values.hasMoreElements()) {
            String value = values.nextElement();
            System.out.print(value + "\t");
        }

    }
}
