package com.itany.corejava.code01_基础;

/**
 * @author 石小俊
 * @date 2023年08月09日 15:01
 */
public class Test05_强制类型转换 {
    public static void main(String[] args) {
        // 当转换前的数据在目标类型的范围中,且转换前后的类型都属于整数或者小数
        int num = 10;
        byte num2 = (byte) num;
        System.out.println(num2);

        double d = 3.14;
        float f = (float) d;
        System.out.println(f);

        // 精度损失场景一
        // 当转换前的数据不再目标类型的范围中时,存在数据丢失的问题
        int i2 = 1000;
        byte b = (byte) i2;
        System.out.println(b);

        // 精度损失场景二
        // 当将一个小数强制转换成整数时,存在数据丢失的问题
        // 如果整数部分的值在目标类型范围中
        // 此时会直接截取掉小数部分的值,只保留整数部分的值
        int i = (int)d;
        System.out.println(i);

        // 精度损失场景三
        // 如果整数类型的值不再目标类型的范围中,会根据二进制转换机制,生成最终的值
        double d2 = 1000.12;
        byte b2 = (byte) d2;
        System.out.println(b2);
    }
}
