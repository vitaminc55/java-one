package com.itany.corejava.code08_常用类.包装类;

/**
 * @author 石小俊
 * @date 2023年08月24日 13:53
 */
public class Test01_定义方式 {
    public static void main(String[] args) {
        // 定义方式一:通过构造方法来定义包装类
        byte b = 1;
        Byte b1 = new Byte(b);
        Byte b2 = new Byte("1");
        System.out.println(b1 == b2);

        short s = 1;
        Short s1 = new Short(s);
        Short s2 = new Short("1");

        Boolean flag = new Boolean(true);
        Boolean flag1 = new Boolean("true");
        System.out.println(flag1);
        Boolean flag2 = new Boolean("admin");
        System.out.println(flag2);

        System.out.println("***********************");

        // 定义方式二:通过valueOf方法定义包装类
        Byte b3 = Byte.valueOf(b);
        Byte b4 = Byte.valueOf("1");
        System.out.println(b3 == b4);   // true

        Integer i1 = Integer.valueOf(1);
        Integer i2 = Integer.valueOf("1");

        // 对于字符类型,其参数必须是char类型,不能是字符串
        // Character c = new Character("a"); // 报错
        Character c1 = new Character('a');
        Character c2 = Character.valueOf('a');

        Integer i3 = Integer.valueOf(100);
        Integer i4 = Integer.valueOf("100");
        System.out.println(i3 == i4);   // true

        // 查看方法源码,其中low的值是-128,high是127
        // 即:当参数值范围在[-128,127]之内时,没有通过new创建新对象
        // 只有超出范围才会创建新的对象
        Integer i5 = Integer.valueOf(128);
        Integer i6 = Integer.valueOf("128");
        System.out.println(i5 == i6);   // false

        Double d1 = Double.valueOf(3.14);
        Double d2 = Double.valueOf("3.1415926");
        System.out.println(d1 == d2);

        System.out.println(i3.getClass());
        System.out.println(d1.getClass());
        System.out.println(c1.hashCode());
    }
}