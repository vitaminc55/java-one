package com.itany.corejava.code08_常用类.string;

/**
 * @author 石小俊
 * @date 2023年08月23日 14:18
 */
public class Test05_join方法 {
    public static void main(String[] args) {
        String s = String.join("-", "admin", "alice", "jack", "tom");
        System.out.println(s);

        String[] arr = {"Hello", "World", "I", "am", "String"};
        s = String.join("_", arr);
        System.out.println(s);

    }
}
