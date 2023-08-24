package com.itany.corejava.util;

import java.util.Date;

/**
 * @author 石小俊
 * @date 2023年08月24日 16:53
 * 日期工具类
 */
public class DateUtil {

    /**
     * 将日期格式转换成字符串格式
     * @param date    需要转换的日期值
     * @param pattern 转换后的字符串格式
     * @return
     */
    public static String toString(Date date, String pattern) {
        return null;
    }


    /**
     * 将日期格式转换成字符串格式
     * 此时转换后的日期格式使用默认格式
     * @param date 需要转换的日期值
     * @return
     * @see DateConstant
     */
    public static String toString(Date date) {
        return null;
    }

    /**
     * 将一个指定格式的字符串转换成日期
     * @param s       需要转换的字符串
     * @param pattern 指定字符串的格式
     * @return
     */
    public static Date toDate(String s, String pattern) {
        return null;
    }

    /**
     * 使用默认格式将一个字符串转换成日期
     * @param s 需要转换的字符串
     * @return
     * @see DateConstant
     */
    public static Date toDate(String s) {
        return null;
    }

    /**
     * 获取指定日期的前一天
     * @param date 指定日期
     * @return
     */
    public static Date getYesterday(Date date) {
        return null;
    }

    /**
     * 获取指定日期的下一天
     * @param date 指定日期
     * @return
     */
    public static Date getTomorrow(Date date) {
        return null;
    }

    /**
     * 计算两个日期之间相差的天数
     * @param startDay 开始日期
     * @param endDate  结束日期
     * @return
     */
    public static int getDuringDay(Date startDay, Date endDate) {
        return 0;
    }

    /**
     * 获取日期中指定的年、月、日、时、分、秒的值
     * @param date  指定日期
     * @param field 指定需要获取哪一部分的值
     * @return
     */
    public static int get(Date date, int field) {
        return 0;
    }
}
