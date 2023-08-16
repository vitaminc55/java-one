package com.itany.corejava.code01_基础;

/**
 * @author 石小俊
 * @date 2023年08月09日 13:41
 */
public class Test03_数据类型 {
    public static void main(String[] args) {
        byte b1 = 10;
        // [-128,127]
        byte b2 = -128;
        System.out.println(2.147483648E9);
        System.out.println(20000000000l);
        System.out.println(3.14F); // float
        System.out.println(3.14); // double
        // float f = 3.14; // 报错,默认是double类型,float必须以f或者F结尾
        float f2 = 3.14f;
        double d = 3.14;
        char c1 = '1';
        char c2 = 'a';
        char c3 = '中';
        System.out.print("这是开始");
        char c4 = '\n';
        c4 = '\t';
        System.out.print(c4);
        System.out.print("这是结束");
        char c5 = '\u0061';
        System.out.println(c5);
        boolean flag = true;
        boolean flag2 = false;
        System.out.println(flag);
        System.out.println(flag2);
        int age = 20;
        System.out.println(age < 18);
        System.out.println(age >= 18);

        String name = "张三";
        String phone = "13812345678";
        String address = "江苏省南京市";
        System.out.println("姓名:" + name + ",电话:" + phone + ",地址:" + address + ",年龄:" + age);
    }
}
