package com.itany.corejava.code08_常用类.string;

import java.util.Arrays;

/**
 * @author 石小俊
 * @date 2023年08月23日 15:59
 */
public class Test07_正则表达式 {

    public static void main(String[] args) {
        // 判断指定字符数是否是一个英文字母a
        System.out.println("a".matches("a"));
        // 匹配0或1次a
        System.out.println("".matches("a?"));
        // 匹配0或多次a
        System.out.println("aaaaaaaaa".matches("a*"));
        System.out.println("".matches("a*"));
        // 匹配1或多次a
        System.out.println("aaaaaaaaa".matches("a+"));
        System.out.println("".matches("a+"));
        // 匹配3次a
        System.out.println("aaa".matches("a{3}"));
        // 匹配至少3次a
        System.out.println("aaaaaaaaaaaaaaaaaaa".matches("a{3,}"));
        System.out.println("aa".matches("a{3,}"));
        // 匹配至少3~6次a
        System.out.println("aaa".matches("a{3,6}"));
        System.out.println("aaaaaa".matches("a{3,6}"));
        System.out.println("aaaaaaa".matches("a{3,6}"));
        // 匹配abc123六种字符出现至少一次
        System.out.println("aabc12a3".matches("[abc123]+"));
        System.out.println("abcd123".matches("[abc123]+"));
        // 匹配abc
        System.out.println("abc".matches("[a-c]+"));
        System.out.println("abc,".matches("[a,b,c]+"));
        // 匹配所有英文字母与数字
        System.out.println("123adMin".matches("[0-9a-zA-Z]+"));
        // 匹配所有数字
        System.out.println("123".matches("[0-9]+"));
        System.out.println("1234567890".matches("\\d+"));
        // 匹配所有非数字
        System.out.println("asd@!#@!$".matches("\\D+"));
        // 匹配所有英文字母数字下划线
        System.out.println("123_adMin".matches("[0-9a-zA-Z_]+"));
        System.out.println("123_adMin".matches("\\w+"));
        // 匹配所有除了英文字母数字下划线以外的字符
        System.out.println("!@#$".matches("\\W+"));

        // 匹配除了换行符以外的所有字符
        System.out.println("\n".matches(".+"));
        System.out.println("asd123!@#$$#@!$".matches(".+"));
        // 匹配点.
        System.out.println(".1".matches("\\.+"));
        // 匹配空格
        System.out.println(" ".matches("\\s+"));
        System.out.println("Hello World".matches("\\s+"));
        System.out.println("asdas".matches("\\S+"));
        // 匹配空格或者英文字母
        System.out.println("Hello World".matches("[a-zA-Z ]+"));
        System.out.println("a".matches("[a-zA-Z]|\\s"));
        System.out.println(" ".matches("[a-zA-Z]|\\s"));
        // 匹配3位数字或者5位数字
        System.out.println("123".matches("\\d{3}|\\d{5}"));
        System.out.println("1234".matches("\\d{3}|\\d{5}"));
        System.out.println("12345".matches("\\d{3}|\\d{5}"));
        System.out.println("123".matches("\\d{3}(\\d{2})?"));
        System.out.println("1234".matches("\\d{3}(\\d{2})?"));
        System.out.println("12345".matches("\\d{3}(\\d{2})?"));

        System.out.println("*****************replaceAll方法*****************");
        String s = "Hello123World22I5314am123123admin";
        // 将所有连续的数字替换成一个空格
        System.out.println(s.replaceAll("\\d+", " "));
        // 将每一个数字替换成一个空格
        System.out.println(s.replaceAll("\\d", " "));

        System.out.println("*****************replaceFirst方法*****************");
        System.out.println(s.replaceFirst("\\d+", " "));

        System.out.println("*****************split方法*****************");
        s = "Hello123World_I@am#admin";
        String[] arr = s.split("[0-9_@#]+");
        System.out.println(Arrays.toString(arr));
    }

}
