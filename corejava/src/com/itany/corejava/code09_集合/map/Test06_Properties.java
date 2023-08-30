package com.itany.corejava.code09_集合.map;

import java.util.*;

/**
 * @author 石小俊
 * @date 2023年08月30日 13:32
 */
public class Test06_Properties {

    public static void main(String[] args) {
        Properties properties = new Properties();
        // 由于Properties继承自Hashtable
        // 因此其方法中支持非字符串的存储
        // 但是开发中如果使用Properties,一般不会存储除了字符串以外的数据
        // properties.put(1,"admin");

        // 为了便于区分,在添加时不再使用继承自Hashtable的put方法进行添加
        // setProperty(key,value):向Properties集合中存储一组键值对数据
        properties.setProperty("id", "1");
        properties.setProperty("username", "admin");
        properties.setProperty("password", "123456");
        System.out.println(properties);

        // getProperty(String key):根据指定的key获取对应的value
        System.out.println(properties.getProperty("id"));
        System.out.println(properties.getProperty("username"));
        System.out.println(properties.getProperty("password"));

        // 遍历
        // 方式一:keySet()
        // 获取Properties集合中所有的key的数据,存放到Set集合中
        Set<Object> keys = properties.keySet();
        for (Object key : keys) {
            System.out.print(key + "-" + properties.getProperty((String) key) + "\t");
        }
        System.out.println();

        // 方式二:values()
        Collection<Object> values = properties.values();
        for (Object value : values) {
            System.out.print(value + "\t");
        }
        System.out.println();


        // 方式三:entrySet()
        Set<Map.Entry<Object, Object>> entries = properties.entrySet();
        Iterator<Map.Entry<Object, Object>> it = entries.iterator();
        while (it.hasNext()) {
            Map.Entry<Object, Object> entry = it.next();
            System.out.print(entry.getKey() + "-" + entry.getValue() + "\t");
        }
        System.out.println();

        // 方式四:Enumeration遍历key
        Enumeration<Object> keys2 = properties.keys();
        while (keys2.hasMoreElements()) {
            String key = (String) keys2.nextElement();
            String value = properties.getProperty(key);
            System.out.print("key:" + key + ",value:" + value + "\t");
        }
        System.out.println();

        // 方式五:Enumeration遍历value
        Enumeration<Object> values2 = properties.elements();
        while (values2.hasMoreElements()) {
            System.out.print(values2.nextElement() + "\t");
        }
    }

}
