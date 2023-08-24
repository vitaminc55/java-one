package com.itany.corejava.code08_常用类.可变字符串;

import java.util.Scanner;

/**
 * @author 石小俊
 * @date 2023年08月24日 13:47
 * 控制台输入一个字符串,删除字符串下标为偶数的所有字符
 */
public class Test04_练习 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入一个字符串:");
        String s = sc.nextLine();
        StringBuffer buffer = new StringBuffer(s);
        System.out.println("删除前:" + buffer);

//        for(int i =0; i < buffer.length(); i++){
//            if(i % 2 == 0){
//                buffer.deleteCharAt(i);
//            }
//        }
//        System.out.println("删除后:"+buffer);

        // 当我们执行删除的时候,删除一个字符后字符串整体发生变化
        // 其下标也会随之改变,此时会导致删除混乱
        // 可以选择使用倒序遍历
        for (int i = buffer.length() - 1; i >= 0; i--) {
            if (i % 2 == 0) {
                buffer.deleteCharAt(i);
            }
        }
        System.out.println("删除后:" + buffer);
    }

}
