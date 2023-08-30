package com.itany.corejava.code09_集合.map;

import java.util.*;

/**
 * @author 石小俊
 * @date 2023年08月30日 10:09
 */
public class Test03_遍历 {

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "admin");
        map.put(2, "alice");
        map.put(3, "jack");
        map.put(4, "lily");
        map.put(5, "tom");

        // 方式一:通过keySet遍历key
        // keySet是将Map集合中所有的key提取出来存放到一个Set集合中
        Set<Integer> keys = map.keySet();
        // 遍历所有的key
        for (Integer key : keys) {
            // System.out.println("key:"+key+",value:"+map.get(key));
            System.out.print(key + "-" + map.get(key) + " ");
        }
        System.out.println();

        // 方式二:通过values遍历value
        Collection<String> values = map.values();
        for (String value : values) {
            System.out.print(value + " ");
        }
        System.out.println();

        // 方式三:通过entrySet将Map集合转换成泛型为Map.Entry的Set集合
        // Entry中的泛型必须与Map的泛型一致
        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        Iterator<Map.Entry<Integer, String>> it = entries.iterator();
        while (it.hasNext()) {
            // 取出当前迭代的Entry
            Map.Entry<Integer, String> entry = it.next();
            // 获取对应的key
            Integer key = entry.getKey();
            // 获取对应的value
            String value = entry.getValue();
            System.out.print(key + "-" + value + " ");
        }

    }


}
