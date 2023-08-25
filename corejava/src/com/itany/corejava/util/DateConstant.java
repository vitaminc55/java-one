package com.itany.corejava.util;

/**
 * @author 石小俊
 * @date 2023年08月24日 16:54
 * 日期工具类常量
 */
public interface DateConstant {

    /**
     * 日期默认格式
     */
    String DATE_DEFAULT_PATTERN = "yyyy-MM-dd HH:mm:ss";

    /**
     * 一天的毫秒数
     */
    int ONE_DAY_MILLISECOND = 24 * 60 * 60 * 1000;

    /**
     * 年份所表示的常量值
     */
    int YEAR = 0;

    /**
     * 月份所表示的常量值
     */
    int MONTH = 1;

    /**
     * 天数所表示的常量值
     */
    int DAY = 2;

    /**
     * 小时数所表示的常量值
     */
    int HOURS = 3;

    /**
     * 分钟数所表示的常量值
     */
    int MINUTE = 4;

    /**
     * 秒数所表示的常量值
     */
    int SECOND = 5;

}
