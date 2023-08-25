package com.itany.corejava.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
        return new SimpleDateFormat(pattern).format(date);
    }


    /**
     * 将日期格式转换成字符串格式
     * 此时转换后的日期格式使用默认格式
     * @param date 需要转换的日期值
     * @return
     * @see DateConstant
     */
    public static String toString(Date date) {
        return toString(date, DateConstant.DATE_DEFAULT_PATTERN);
    }

    /**
     * 将一个指定格式的字符串转换成日期
     * @param s       需要转换的字符串
     * @param pattern 指定字符串的格式
     * @return
     */
    public static Date toDate(String s, String pattern) throws ParseException {
        return new SimpleDateFormat(pattern).parse(s);
    }

    /**
     * 使用默认格式将一个字符串转换成日期
     * @param s 需要转换的字符串
     * @return
     * @see DateConstant
     */
    public static Date toDate(String s) throws ParseException {
        return toDate(s, DateConstant.DATE_DEFAULT_PATTERN);
    }

    /**
     * 获取指定日期的前一天
     * @param date 指定日期
     * @return
     */
    public static Date getYesterday(Date date) {
        return new Date(date.getTime() - DateConstant.ONE_DAY_MILLISECOND);
    }

    /**
     * 获取指定日期的下一天
     * @param date 指定日期
     * @return
     */
    public static Date getTomorrow(Date date) {
        return new Date(date.getTime() + DateConstant.ONE_DAY_MILLISECOND);
    }

    /**
     * 计算两个日期之间相差的天数
     * @param startDay 开始日期
     * @param endDate  结束日期
     * @return
     */
    public static int getDuringDay(Date startDay, Date endDate) {
        // 计算两个日期之间相差的毫秒数
        long time = endDate.getTime() - startDay.getTime();
        // 通过该毫秒数除以一天的毫秒数,不满一天的不算一天,直接截取掉
        int day = (int) (time / DateConstant.ONE_DAY_MILLISECOND);
        return day;
    }

    /**
     * 获取日期中指定的年、月、日、时、分、秒的值
     * @param date  指定日期
     * @param field 指定需要获取哪一部分的值
     * @return
     */
    public static int get(Date date, int field) {
        // 将一个日期转换成默认格式的字符串
        String s = toString(date);
        // 当前字符串格式为:yyyy-MM-dd HH:mm:ss
        // 可以对日期字符串进行分割,将年月日时分秒的值存储到一个数组中
        String[] arr = s.split("[-\\s:]");
        // 此时数组中存储的即为日期各个部分的值
        // 对于参数field是通过常量定义的
        // 而常量的值我们是按照顺序从0开始定义的
        // 其值与下标正好重合
        return Integer.parseInt(arr[field]);
    }
}
