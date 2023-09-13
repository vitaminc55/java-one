package com.itany.corejava.util;

/**
 * @author 石小俊
 * @date 2023年09月13日 9:35
 */
public class ParameterUtil {

    /**
     * 对字符串进行二次处理,将每一个字符前加一个/
     * 主要应用于模糊查询特殊字符的处理
     * @param s
     * @return
     */
    public static String escapeString(String s){
        // 将当前字符串转换成字符数组
        char[] chars = s.toCharArray();
        // 准备一个用于接收结果的字符串
        StringBuffer buffer = new StringBuffer();
        for(char c : chars){
            // 字符拼接,每一个字符前加一个/
            buffer.append("/"+c);
        }
        return buffer.toString();
    }

}
