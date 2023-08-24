package com.itany.corejava.code08_常用类.可变字符串;

/**
 * @author 石小俊
 * @date 2023年08月24日 11:32
 */
public class Test02_常用方法 {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
//        StringBuffer builder = new StringBuffer();
        System.out.println(builder);
        builder.append("Hello");
        builder.append(123);
        builder.append(true);
        System.out.println(builder);
        builder.insert(5, " World");
        System.out.println(builder);
        builder.delete(11, 14);
        System.out.println(builder);
        builder.deleteCharAt(11);
        System.out.println(builder);
        builder.setLength(11);
        System.out.println(builder);
        builder.setLength(15);
        System.out.println(builder);
        builder.reverse();
        System.out.println(builder);
        System.out.println(builder.toString());


    }
}
