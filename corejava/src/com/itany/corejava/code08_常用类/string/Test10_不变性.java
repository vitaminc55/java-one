package com.itany.corejava.code08_常用类.string;

/**
 * @author 石小俊
 * @date 2023年08月24日 10:24
 */
public class Test10_不变性 {
    public static void main(String[] args) {
        // 在堆中开辟了一块空间,空间中存储的值为admin
        String s = new String("admin");

        // 当修改字符串的值的时候
        // 此时表示在堆中重新开辟了一块空间,空间存储的值为alice
        // 此时的变量指向了新的空间,原来空间的引用被取消
        // 在被gc回收之前,当前堆内存中有两块空间
        s = new String("alice");
    }
}
