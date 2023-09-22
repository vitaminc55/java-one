package com.itany.shop.util;

import java.util.Date;
import java.util.Random;

/**
 * @author 石小俊
 * @date 2023年09月19日 14:03
 */
public class ParameterUtil {

    public static boolean isNull(String s){
        return null == s || "".equals(s);
    }

    public static String createNo() {
        String s = "qwertyuiopsdfghjkzxcvbnml";
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < 4; i++) {
            buffer.append(s.charAt(new Random().nextInt(s.length())));
        }
        return buffer.toString() + new Date().getTime();
    }
}
