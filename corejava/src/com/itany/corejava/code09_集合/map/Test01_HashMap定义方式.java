package com.itany.corejava.code09_集合.map;

import java.util.HashMap;

/**
 * @author 石小俊
 * @date 2023年08月29日 16:50
 */
public class Test01_HashMap定义方式 {
    public static void main(String[] args) {
        // 定义方式一:初始容量16,加载因子0.75
        HashMap<Integer, String> map = new HashMap<>();
        // 定义方式二:初始容量10,加载因子0.75
        HashMap<String, Integer> map2 = new HashMap<>(10);
        // 定义方式三:初始容量10,加载因子0.5
        HashMap<String, String> map3 = new HashMap<>(10, 0.5f);
        // 定义方式四:将另一个Map转换成HashMap
        HashMap<String, String> map4 = new HashMap<>(map3);
    }
}
