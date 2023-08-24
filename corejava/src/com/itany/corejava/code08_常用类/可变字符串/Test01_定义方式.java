package com.itany.corejava.code08_常用类.可变字符串;

/**
 * @author 石小俊
 * @date 2023年08月24日 11:29
 */
public class Test01_定义方式 {
    public static void main(String[] args) {
        // 两种可变字符串StringBuffer与StringBuilder定义方式一致
        // 创建一个可变字符串,其初始值为空
        StringBuffer buffer = new StringBuffer();
        // 创建一个可变字符串,其初始值为admin
        StringBuilder builder = new StringBuilder("admin");
    }
}
