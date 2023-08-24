package com.itany.corejava.code08_常用类.string;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 石小俊
 * @date 2023年08月24日 9:22
 */
public class Test09_练习 {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        test04();
    }

    /**
     * 1.控制台输入一个字符串,统计字符串包含多少个数字、英文字母以及其他字符
     */
    public static void test01() {
        System.out.print("请输入一个字符串:");
        String s = sc.nextLine();
        // 由于字符串中可能存在大小写的英文字母,但是统计时不区分大小写
        // 因此为了方便,可以统一将所有字母改为大写或者小写
        s = s.toUpperCase();
        // 准备三个变量用于接收三种字符的数量
        int count1 = 0, count2 = 0, count3 = 0;
        // 遍历字符串中所有的字符
        for (int i = 0; i < s.length(); i++) {
            // 取出当前迭代的字符
            char c = s.charAt(i);
            // 判断取出的字符类型
            if (c >= '0' && c <= '9') {
                // 则数字的总数量+1
                count1++;
            } else if (c >= 'A' && c <= 'Z') {
                // 则字母数量+1
                count2++;
            } else {
                // 其他字符数量+1
                count3++;
            }
        }
        System.out.println("该字符串中数字出现了:" + count1 + "次,英文字母出现了:" + count2 + "次,其他字符出现了:" + count3 + "次");
    }

    /**
     * 2.控制台输入一个字符串,统计每个字母出现的次数(忽略大小写)并输出
     */
    public static void test02() {
        System.out.print("请输入一个字符串:");
        String s = sc.nextLine();
        // 由于统计时忽略大小写,可以统一改为大写或者小写
        s = s.toLowerCase();
        // 可以先将字符串转换成字符数组
        char[] arr = s.toCharArray();
        // 然后通过双重for循环对数组中的每一个元素进行判断
        // 外层循环控制所有要统计的字母
        for (char i = 'a'; i <= 'z'; i++) {
            // 在内层循环遍历之前定义一个变量
            // 用于接收外层循环当前迭代的字符在内层循环数组中出现的次数
            int count = 0;
            // 内层循环遍历字符数组中所有字符
            for (char c : arr) {
                // 如果当前数组中迭代的元素与外层循环迭代的元素一致
                if (i == c) {
                    // 则数量+1
                    count++;
                }
            }
            // 如果字母没有出现过不打印
            if (count > 0) {
                System.out.println("字母" + i + "出现了" + count + "次");
            }
        }
    }

    /**
     * 3.控制台输入一个字符串,对字符串中字符进行自然顺序的排序,将排序后的字符串展示出来
     */
    public static void test03() {
        System.out.print("请输入一个字符串:");
        String s = sc.nextLine();
        // 将字符串转换成字符数组
        char[] arr = s.toCharArray();
        // 直接调用数组工具类Arrays中提供的排序方法
        Arrays.sort(arr);
        // 将字符数组转换成字符串
        String result = new String(arr);
        System.out.println(result);
    }

    /**
     * 4.控制台输入两个字符串,计算第二个字符串在第一个字符串中出现的次数
     */
    public static void test04() {
        System.out.print("请输入第一个字符串:");
        String s1 = sc.next();
        System.out.print("请输入第二个字符串:");
        String s2 = sc.next();
        if (s1.length() >= s2.length()) {
            // 定义一个变量,用于接收出现的次数
            int count = 0;
            // 准备一个变量,用于接收第二个字符串在第一个字符串中出现位置的索引号
            // 便于截取字符串时直到从哪开始截取
            int index = 0;
            while ((index = s1.indexOf(s2)) != -1) {
                // 只要进入到while循环中,则表示找到了
                // 因此,每进来一次,出现次数+1
                count++;
                // 由于字符串如果不发生变化,每次找到的都是同一个位置
                // 因此,为了便于查找下一次出现的索引位置
                // 可以将已经查找过的部分截取掉
                // 从剩下的字符串中进行继续查找
                // 每次找到都将找到的部分截取掉即可,一直到找不到为止
                s1 = s1.substring(index + s2.length());
            }
            System.out.println("第二个字符串在第一个字符串中出现了" + count + "次");
        } else {
            System.out.println("第二个字符串没有在第一个字符串中出现");
        }
    }
}
