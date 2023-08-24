package com.itany.corejava.code08_常用类.可变字符串;

/**
 * @author 石小俊
 * @date 2023年08月24日 11:48
 */
public class Test03_性能比较 {

    public static void main(String[] args) {
        testString();
        System.out.println("***********************");
        testStringBuffer();
        System.out.println("***********************");
        testStringBuilder();
    }

    public static void testStringBuffer() {
        long begin = System.currentTimeMillis();

        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < 1000000; i++) {
            buffer.append("admin");
        }

        long end = System.currentTimeMillis();

        System.out.println("StringBuffer操作100W次共耗费了" + (end - begin) + "毫秒");
    }

    public static void testStringBuilder() {
        long begin = System.currentTimeMillis();

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 1000000; i++) {
            builder.append("admin");
        }

        long end = System.currentTimeMillis();

        System.out.println("StringBuilder操作100W次共耗费了" + (end - begin) + "毫秒");
    }

    public static void testString() {
        long begin = System.currentTimeMillis();

        String s = new String();
        for (int i = 0; i < 10000; i++) {
            s += "admin";
        }

        long end = System.currentTimeMillis();

        System.out.println("String操作1W次共耗费了" + (end - begin) + "毫秒");
    }

}
