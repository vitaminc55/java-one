package com.itany.corejava.code09_集合.map;

import java.util.HashMap;

/**
 * @author 石小俊
 * @date 2023年08月29日 16:54
 */
public class Test02_常用方法 {

    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        System.out.println(map);
        System.out.println("集合是否为空:" + map.isEmpty());

        map.put(1, "admin");
        map.put(2, "alice");
        map.put(3, "jack");
        map.put(4, "jack");
        map.put(5, "admin");
        System.out.println(map);
        // 如果key重复了,会覆盖原有的数据,相当于修改
        map.put(2, "lily");
        System.out.println(map);
        // 理论上key与value均可以为null
        // 但是实际开发中不建议出现
        map.put(null, null);
        System.out.println(map);

        System.out.println("key为1的数据:" + map.get(1));
        System.out.println("key为2的数据:" + map.get(2));
        System.out.println("key为null的数据:" + map.get(null));

        // 删除key为2的数据
        map.remove(3);
        // 删除key为null的数据
        map.remove(null);
        System.out.println(map);

        System.out.println("集合中是否包含key为3的元素:" + map.containsKey(3));
        System.out.println("集合中是否包含value为admin的元素:" + map.containsValue("admin"));
        System.out.println("集合是否为空:" + map.isEmpty());

        System.out.println("集合中键值对的数量:" + map.size());

        map.clear();
        System.out.println("集合是否为空:" + map.isEmpty());

    }

}
