package com.itany.corejava.code08_常用类.其他类;

import java.util.Random;

/**
 * @author 石小俊
 * @date 2023年08月28日 9:40
 */
public class Test04_练习 {

    public static void main(String[] args) {
//        int day = DateUtil.getDay2(2023, 2);
//        System.out.println(day);
        getCode();
    }

    public static void getCode() {
        String s = "0123456789qwertyuiopasdfghjklzxcvbnm";
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < 4; i++) {
            buffer.append(s.charAt(new Random().nextInt(s.length())));
        }
        System.out.println("随机数为:" + buffer);
    }

}
