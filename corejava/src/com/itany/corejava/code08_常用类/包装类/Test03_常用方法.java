package com.itany.corejava.code08_常用类.包装类;

/**
 * @author 石小俊
 * @date 2023年08月24日 14:53
 */
public class Test03_常用方法 {
    public static void main(String[] args) {
        // 常用方法
        // 进制转换
        // 将一个十进制数转换成常用进制
        System.out.println("二进制:" + Integer.toBinaryString(88));
        System.out.println("八进制:" + Integer.toOctalString(88));
        System.out.println("十六进制:" + Integer.toHexString(88));

        // 将一个字符串转换成int类型
        int i = Integer.parseInt("123");
        System.out.println(i);
        // 将一个字符串转换成Double类型
        double d = Double.parseDouble("3.14");
        System.out.println(d);

        // 将一个字符串作为进制的数据转换成int类型
        // 即:将一个指定进制的数转换成十进制
        // 参数一:需要转换的字符串
        // 参数二:当前字符串所表示的数字的进制数
        // 返回值:返回对应的十进制数
        System.out.println(Integer.parseInt("1011000", 2));
        System.out.println(Integer.parseInt("130", 8));
        System.out.println(Integer.parseInt("58", 16));
        System.out.println(Integer.parseInt("120", 3));
        System.out.println(Integer.parseInt("345", 6));

        // 常量
        System.out.println("int最大值:" + Integer.MAX_VALUE);
        System.out.println("int最小值:" + Integer.MIN_VALUE);
        System.out.println("byte最大值:" + Byte.MAX_VALUE);
        System.out.println("byte最小值:" + Byte.MIN_VALUE);
        System.out.println("double最大值:" + Double.MAX_VALUE);
        System.out.println("double最小值:" + Double.MIN_VALUE);
    }
}
