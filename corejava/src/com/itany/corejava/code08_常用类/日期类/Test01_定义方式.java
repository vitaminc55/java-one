package com.itany.corejava.code08_常用类.日期类;

import java.util.Date;

/**
 * @author 石小俊
 * @date 2023年08月24日 15:45
 */
public class Test01_定义方式 {
    public static void main(String[] args) {
        // 创建一个表示当前时间的日期
        Date date = new Date();
        System.out.println(date);

        // 根据传递的毫秒数定义一个日期
        // 参数表示距离1970年1月1日0时0分0秒的毫秒数
        Date date2 = new Date(0);
        // 此时的结果是1970年1月1日8时0分0秒
        // 原因:我们所处的时区属于东八区
        // 东八区的时间比国际标准时间快8个小时
        System.out.println(date2);

        // 已过时方法
        // 年份在底层做了+1900
        // 月份在底层做了+1
        // 传递参数时,年份需要-1900,月份需要-1
        Date date3 = new Date(2023 - 1900, 8 - 1, 24);
        System.out.println(date3);
    }
}
