package com.itany.corejava.code08_常用类.string;

import java.util.Arrays;

/**
 * @author 石小俊
 * @date 2023年08月23日 9:29
 */
public class Test02_常用方法 {
    public static void main(String[] args) {
        String s = " Hello World, I am admin Hello World Hello World Hello World ";
        System.out.println("字符串长度:" + s.length());
        s = s.trim();
        System.out.println("字符串长度:" + s.length());
        System.out.println("World第一次出现的索引位置:" + s.indexOf("World"));
        System.out.println("World最后一次出现的索引位置:" + s.lastIndexOf("World"));
        // 此时查找时不是从头开始找,而是从索引位置10开始查找
        System.out.println("World在索引位置10之后第一次出现的索引位置:" + s.indexOf("World", 10));
        // 从索引位置10一直查找到最后一个字符,然后继续重头开始找,一直找到索引位置10为止
        System.out.println("World在索引位置10之后最后一次出现的索引位置:" + s.lastIndexOf("World", 31));

        // 截取字符串,索引位置大于等于6小于11
        // [6,11)
        System.out.println(s.substring(6, 11));
        System.out.println(s.substring(6));

        // 拼接字符串
        s = "Hello";
        System.out.println(s.concat(" World"));
        System.out.println(s + " World");

        // 在字符串中,值为空表示长度为0
        // null属于非正常数据,不属于字符串类型
        // 如果值为null,调用字符串的任意方法都报错
        String s2 = "";
        System.out.println("s2长度:" + s2.length());
        System.out.println("s2是否为空:" + s2.isEmpty());
        System.out.println("s2是否为空:" + (s2.length() == 0));
        String s3 = null;
        // s3.isEmpty(); // 报错,空指针
        String s4 = new String();
        System.out.println("s4长度:" + s4.length());
        System.out.println("s4是否为空:" + s4.isEmpty());

        s = "Hello World";
        System.out.println("获取索引位置为5的字符:" + s.charAt(6));
        System.out.println("是否以Hello开头:" + s.startsWith("Hello"));
        System.out.println("是否以World结尾:" + s.endsWith("World"));
        System.out.println("是否包含Hello:" + s.contains("Hello"));

        String s5 = "hello";
        String s6 = "hello";
        String s7 = "Hello";
        System.out.println(s5.equals(s6));
        System.out.println(s5.equalsIgnoreCase(s7));

        System.out.println("大写:" + s7.toUpperCase());
        System.out.println("小写:" + s7.toLowerCase());

        s = "Hello World I am admin";
        System.out.println(s.replace(" ", "-"));
        System.out.println(s);

        String[] arr = s.split(" ");
        System.out.println(Arrays.toString(arr));


    }
}
