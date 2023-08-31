package com.itany.corejava.code09_集合.Collections工具类;

import java.util.*;
import java.util.Map.Entry;

/**
 * @author 石小俊
 * @date 2023年08月31日 9:05
 * 控制台输入一个字符串,统计字符串中每个字符出现的次数,保存到HashMap集合中
 * 通过排序,打印输出次数最多的前三个字符及次数
 */
public class Test02_练习 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入一个字符串:");
        String s = sc.nextLine();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
        }
        System.out.println(map);

        // 使用Collections工具类的排序方法,参数要求是List
        // 因此,先将当前Map转换成Set,再将Set转换成List
        // 将当前Map转换成Set
        Set<Entry<Character, Integer>> set = map.entrySet();
        // 将Set转换成List
        List<Entry<Character, Integer>> list = new ArrayList<>(set);

        // 调用Collections工具类的排序方法实现自定义排序
        Collections.sort(list, new Comparator<Entry<Character, Integer>>() {
            @Override
            public int compare(Entry<Character, Integer> o1, Entry<Character, Integer> o2) {
                if (o1.getValue() > o2.getValue()) {
                    return -1;
                } else if (o1.getValue() < o2.getValue()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        System.out.println(list);

        // 打印前三个数据的key与value
        System.out.println("出现次数最多的前三个字符以及其出现次数");
        for (int i = 0; i < 3; i++) {
            Entry<Character, Integer> entry = list.get(i);
            System.out.println("字符:" + entry.getKey() + ",出现次数:" + entry.getValue());
        }

    }

}
