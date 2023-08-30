package com.itany.corejava.code09_集合.map;

import java.io.IOException;
import java.util.Properties;
import java.util.Set;

/**
 * @author 石小俊
 * @date 2023年08月30日 14:06
 */
public class Test07_读取配置文件 {

    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.load(
                // 获取当前类的Class对象
                Test07_读取配置文件.class
                        // 获取当前类的类加载器,用于加载类加载器路径下的资源
                        // 此时的类加载路径的根目录相当于当前项目的src目录
                        .getClassLoader()
                        // 指定需要加载器的资源,并返回对应的InputStream流
                        // 其参数是需要加载的配置文件所在的相对路径名+文件名
                        // 相对路径相对的是src目录下的路径
                        // .getResourceAsStream("beans.properties"));
                        // 非properties文件只要内容的格式正确,同样可以加载
                        // 但是在实际开发中建议使用properties属性文件进行配置
                        .getResourceAsStream("beans.txt"));
        System.out.println(properties);
        Set<Object> objects = properties.keySet();
        for (Object key : objects) {
            String value = properties.getProperty((String) key);
            System.out.println("key:" + key + ",value:" + value);
        }
    }

}
