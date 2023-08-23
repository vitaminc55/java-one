package com.itany.corejava.code08_常用类.string;

import java.util.Scanner;

/**
 * @author 石小俊
 * @date 2023年08月23日 11:41
 */
public class Test03_练习 {

    public static void main(String[] args) {
        test01();
        System.out.println("-------------------------");
        test02();
        System.out.println("-------------------------");
        test03();
    }

    /**
     * 将字符串Hello World转换成dlroW olleH
     */
    public static void test01() {
        String s = "Hello World";
        String result = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            result += s.charAt(i);
        }
        System.out.println(result);
    }

    /**
     * 将字符串Hello World转换为WORLD_HELLO
     */
    public static void test02() {
        String s = "Hello World";
        s = s.toUpperCase();
        String[] arr = s.split(" ");
        // String result = arr[1] + "_" + arr[0];
        String result = "";
        for (int i = arr.length - 1; i >= 0; i--) {
            result = result + arr[i] + "_";
        }
        // 此时的结果末尾会多出一个下划线
        // 可以通过截取字符串的方式去除末尾的下划线
        result = result.substring(0, result.length() - 1);
        System.out.println(result);
    }

    /**
     * 在控制台输入任意一个字符串
     * 将字符串每4个字符后添加一个短横线‐
     * 并将所有大写字母变成小写字母,小写变成大写字母
     */
    public static void test03() {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入任意一个字符串:");
        String s = sc.nextLine();
        String result = "";
        // 遍历当前字符串中所有的字符
        for (int i = 0; i < s.length(); i++) {
            // 取出当前迭代的字符
            char c = s.charAt(i);
            // 如果当前字符是一个大写英文字母
            if (c >= 'A' && c <= 'Z') {
                // 将其转换成小写英文字母拼接到result中
                result += (c + "").toLowerCase();
            } else if (c >= 'a' && c <= 'z') {
                // 如果是小写英文子母,则转换成大写
                result += (c + "").toUpperCase();
            } else {
                // 其他直接拼接到result中
                result += c;
            }

            // 每四个字符后添加一个短横杠,但是末尾不加
            // 当(i+1)能被4整除且i不是最后一个索引位置
            if ((i + 1) % 4 == 0 && i != s.length() - 1) {
                // 追加一个短横杠
                result += "-";
            }
        }
        System.out.println(result);
    }
}
