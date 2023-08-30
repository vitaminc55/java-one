package com.itany.corejava.code09_集合.map;

import java.util.Properties;
import java.util.Set;

/**
 * @author 石小俊
 * @date 2023年08月30日 14:45
 */
public class Test08_获取系统属性 {

    public static void main(String[] args) {
        Properties properties = System.getProperties();
        Set<Object> objects = properties.keySet();

        // 遍历所有的系统属性
        for (Object key : objects) {
            String value = properties.getProperty((String) key);
            System.out.println("key:" + key + ",value:" + value);
        }

        // 获取指定的系统属性
        System.out.println("java版本:" + System.getProperty("java.version"));
    }


}
