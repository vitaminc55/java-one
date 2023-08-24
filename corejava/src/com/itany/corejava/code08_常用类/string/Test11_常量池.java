package com.itany.corejava.code08_常用类.string;

/**
 * @author 石小俊
 * @date 2023年08月24日 10:30
 */
public class Test11_常量池 {

    public static void main(String[] args) {
        // 通过构造方法创建的字符串,存储在堆内存中
        String s = new String("admin");
        // 当修改字符串的值的时候
        // 此时表示在堆中重新开辟了一块空间,空间存储的值为alice
        // 此时的变量指向了新的空间,原来空间的引用被取消
        // 在被gc回收之前,当前堆内存中有两块空间
        s = new String("alice");

        // 此处新创建了一个字符串,其值与原来创建的字符串的值相同
        // 此时新开辟了一块空间,其值是admin
        String s2 = new String("admin");

        // 在常量池中开辟了一块空间,其值是admin
        String s3 = "admin";
        // 在常量池中新开辟了一块空间,其值是alice
        s3 = "alice";
        // 由于常量池中已经存在了值为admin的空间
        // 此时的变量并没有重新开辟空间,而是直接指向了已有的空间
        String s4 = "admin";

        String s5 = new String("admin");
        // s2与s5虽然值相等,但是在堆中处于不同空间
        System.out.println(s2 == s5);   // false

        String s6 = "admin";
        // s4与s6的值相等,在常量池中处于同一块空间
        System.out.println(s4 == s6);   // true

        String s7 = "a";
        String s8 = "aa";
        String s9 = "aaa";
        String s10 = s7 + s8;
        // s10不是字符常量,并不是存储在常量池中的,而是存储在堆中
        // 通过运行时确定的变量不会存储在常量池中
        // 只有运行前能够确定的值才会存放到常量池中
        // 即:变量运算时其结果存储到堆中
        System.out.println(s9 == s10);  // false

        // 常量运算时其值属于已经能够确定的值了
        // 此时的结果存储在常量池中
        String s11 = "a" + "aa";
        System.out.println(s9 == s11);  // true

        // 只要有不确定类型,则都存放在堆中
        String s12 = s7 + "aa";
        System.out.println(s9 == s12); // false

    }

}
