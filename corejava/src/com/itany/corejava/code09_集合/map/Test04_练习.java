package com.itany.corejava.code09_集合.map;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author 石小俊
 * @date 2023年08月30日 11:10
 * 控制台输入一个字符串,统计字符串中每个字符出现的次数,保存到HashMap集合中
 * 至少使用两种不同的方式实现
 */
public class Test04_练习 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入一个字符串:");
        String s = sc.nextLine();
        HashMap<Character, Integer> map = test01(s);
        System.out.println(map);
        HashMap<Character, Integer> map2 = test02(s);
        System.out.println(map2);
    }

    /**
     * 方式一:遍历字符串中所有的字符,每次遍历后遇到相同的字符则value+1
     * @param s
     * @return
     */
    public static HashMap<Character, Integer> test01(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        // 遍历字符串中所有的字符
        for (int i = 0; i < s.length(); i++) {
            // 取出当前迭代到的字符
            char c = s.charAt(i);
            // 判断当前Map集合中是否存在对应key的字符
            if (map.containsKey(c)) {
                // 如果存在,查询对应key的value值
                Integer value = map.get(c);
                // 修改集合中value的数据,其值在原有值的基础上+1
                map.put(c, value + 1);
            } else {
                // 如果没有,则新增一条数据
                // 其key为当前字符,其value为1
                map.put(c, 1);
            }
        }
        return map;
    }

    /**
     * 方式二:通过将字符串中的与第一个字符一致的所有字符均替换成空字符,出现的次数=原来的字符串长度-替换后的字符串长度
     * 以此类推,一直到字符串为空为止
     * @param s
     * @return
     */
    public static HashMap<Character, Integer> test02(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        while (!s.isEmpty()) {
            // 取出字符串中的第一个字符
            char c = s.charAt(0);
            // 将当前字符串中所有与第一个字符一致的所有字符全部替换成空字符
            String s2 = s.replace(c + "", "");
            // 替换的字符数量=原来的字符串-替换后的字符串
            map.put(c, s.length() - s2.length());
            // 将替换后的字符串赋值给原来的字符,继续循环下一个替换操作
            s = s2;
        }

        return map;
    }

}
