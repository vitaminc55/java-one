package com.itany.corejava.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
     * 不足一天的直接去除
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
     * 计算两个日期之间相差的天数
     * 不足一天的直接算一天
     * @param startDay 开始日期
     * @param endDay   结束日期,其值必须在开始日期之后
     * @return
     */
    public static int getDuringDay2(Date startDay, Date endDay) {
        // 定义一个用于统计相差天数的变量
        int day = 0;
        while (startDay.before(endDay)) {
            // 如果startDay在endDay之前
            // 取startDay的下一天
            // 一直到startDay不再endDay之前
            startDay = getTomorrow(startDay);
            day++;
        }
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

    /**
     * 根据指定年份与月份获取这个月共有多少天
     * 此时使用Calendar的方式进行实现
     * @param year  指定年份
     * @param month 指定月份
     * @return 返回这一年这个月共有多少天
     */
    public static int getDay(int year, int month) {
        Calendar calendar = Calendar.getInstance();
        // 设置日期的年份
        calendar.set(Calendar.YEAR, year);
        // 设置日期的月份,month取值比真实月份少1
        calendar.set(Calendar.MONTH, month - 1);
        // 给定此日历对象对应部分字段可能拥有的最大值
        return calendar.getActualMaximum(Calendar.DATE);
    }

    /**
     * 根据指定年份与月份获取这个月共有多少天
     * @param year
     * @param month
     * @return
     */
    public static int getDay2(int year, int month) {
        // 将日期设置为year年month月的最后一天
        // 在这一天获取当前属于本月第几天
        // 返回的值即为这一个这个月共有多少天
        // 如果将日期设置为这一年这个月的最后一天?
        // 没法直接设置,但是可以间接设置,在设置日期时,支持日期的运算的
        // 可以设置下个月的第一天,这一天的前一天即属于这个月的最后一天
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        // 这个月的值为month-1,下一个月为month
        calendar.set(Calendar.MONTH, month);
        // 设置下个月的第一天,这一天的前一天即为这个月的最后一天
        calendar.set(Calendar.DATE, 0);
        // 在这个月的最后一天获取当前日期属于本月第几天
        // 返回的值即为这个月共有多少天
        return calendar.get(Calendar.DATE);
    }
}
