package com.itany.corejava.code08_常用类.string;

import java.util.Arrays;

/**
 * @author 石小俊
 * @date 2023年08月23日 13:31
 */
public class Test04_与其他类型的转换 {

    public static void main(String[] args) {
        System.out.println("*********************字符串转char数组*********************");
        String s = "Hello World";
        char[] cs = s.toCharArray();
        System.out.println(Arrays.toString(cs));

        System.out.println("*********************char数组转字符串*********************");
        char[] cs2 = {'H', 'e', 'l', 'l', 'o', ' ', 'S', 't', 'r', 'i', 'n', 'g'};
        s = new String(cs2);
        System.out.println(s);

        System.out.println("*********************字符串转byte数组*********************");
        byte[] bs = s.getBytes();
        System.out.println(Arrays.toString(bs));

        System.out.println("*********************byte数组转字符串*********************");
        byte[] bytes = {66, 78, 87, 45, 97, 101, 111, 32, 88};
        s = new String(bytes);
        System.out.println(s);

        System.out.println("*********************字符串转int*********************");
        s = "123a";  // 报错
        s = "123.45"; // 报错
        s = "123";  // 成功
        int i = Integer.parseInt(s);
        System.out.println(i);

        System.out.println("*********************int转字符串*********************");
        i = 100;
        // 方式一: 任意类型与字符串拼接后都会自动转换为字符串类型
        s = i + "";
        System.out.println(s);
        // 方式二: 字符串提供了静态方法valueOf 用于将基本数据类型转换成字符串。包含int类型
        s = String.valueOf(i);
        System.out.println(s);

        System.out.println("*********************字符串转double*********************");
        s = "123a"; // 报错
        s = "123.45.67"; // 报错
        s = "123.45";   // 成功
        s = "123.";     // 成功
        double d = Double.parseDouble(s);
        System.out.println(d);

        System.out.println("*********************double转字符串*********************");
        d = 3.14;
        // 方式一: 任意类型与字符串拼接后都会自动转换为字符串类型
        s = d + "";
        System.out.println(s);
        // 方式二: 字符串提供了静态方法valueOf 用于将基本数据类型转换成字符串。包含double类型
        s = String.valueOf(d);
        System.out.println(s);
    }

}
