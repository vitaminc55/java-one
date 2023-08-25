package com.itany.corejava.code08_常用类.其他类;

import com.itany.corejava.util.DateConstant;
import com.itany.corejava.util.DateUtil;

import java.util.Calendar;
import java.util.Date;

/**
 * @author 石小俊
 * @date 2023年08月25日 10:08
 */
public class Test01_日历类 {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);

        // 当前时间
        Date date = calendar.getTime();
        System.out.println(DateUtil.toString(date));

        // setTime
        // 设置为前一天
        calendar.setTime(DateUtil.getYesterday(new Date()));
        System.out.println(DateUtil.toString(calendar.getTime()));

        // 设置后一天
        calendar.setTime(DateUtil.getTomorrow(new Date()));
        System.out.println(DateUtil.toString(calendar.getTime()));

        // 设置当前时间的12小时后
        date = new Date(new Date().getTime() + DateConstant.ONE_DAY_MILLISECOND / 2);
        calendar.setTime(date);

        // get
        System.out.println(calendar.get(Calendar.YEAR) + "年");
        // 对于月份,其取值范围为:0-11
        // 因此,真实的月份为返回值+1
        System.out.println((calendar.get(Calendar.MONTH) + 1) + "月");
        System.out.println(calendar.get(Calendar.DATE) + "日");
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH) + "日");
        // 十二小时制
        System.out.println(calendar.get(Calendar.HOUR) + "时");
        // 二十四小时制
        System.out.println(calendar.get(Calendar.HOUR_OF_DAY) + "时");
        System.out.println(calendar.get(Calendar.MINUTE) + "分");
        System.out.println(calendar.get(Calendar.SECOND) + "秒");
        System.out.println(calendar.get(Calendar.MILLISECOND) + "毫秒");
        // 按照国际标准时间,星期日是一周的第一天,星期六是一周的最后一天
        System.out.println("一个星期的第" + calendar.get(Calendar.DAY_OF_WEEK) + "天");

        // 当前日历表示的时间
        System.out.println(DateUtil.toString(calendar.getTime()));

        // set
        // 设置去年
        calendar.set(Calendar.YEAR, 2022);
        // 设置上个月,月份取值:0-11
        calendar.set(Calendar.MONTH, 6);
        // 设置的月份超出了范围后会自动进行运算
        // 如果超出范围,会对上一级的日期产生影响
        // 例如:月份超出范围,则对年份产生影响
        calendar.set(Calendar.MONTH, 13);
        calendar.set(Calendar.DAY_OF_MONTH, 31);
        System.out.println(DateUtil.toString(calendar.getTime()));

        // add
        calendar.add(Calendar.YEAR, 1);
        calendar.add(Calendar.MONTH, -1);
        calendar.add(Calendar.DAY_OF_MONTH, 0);
        calendar.add(Calendar.DAY_OF_MONTH, 2);
        calendar.add(Calendar.HOUR_OF_DAY, 12);
        calendar.add(Calendar.DATE, -5);
        System.out.println(DateUtil.toString(calendar.getTime()));

        System.out.println("日历毫秒数:" + calendar.getTimeInMillis());
        System.out.println("日期毫秒数:" + calendar.getTime().getTime());


        System.out.println("年份最大值:" + calendar.getActualMaximum(Calendar.YEAR));
        System.out.println("月份最大值:" + calendar.getActualMaximum(Calendar.MONTH));
        System.out.println("天数最大值:" + calendar.getActualMaximum(Calendar.DATE));

        calendar.clear();
        System.out.println(DateUtil.toString(calendar.getTime()));


    }
}
