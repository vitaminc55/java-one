package com.itany.corejava.code08_常用类.日期类;

import java.util.Date;

/**
 * @author 石小俊
 * @date 2023年08月24日 15:55
 */
public class Test02_常用方法 {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date.getTime());
        System.out.println(date);

        Date date2 = new Date(1692863767672L);
        System.out.println(date2);

        // 通过毫秒数创建一个与date一致的日期
        Date date3 = new Date(date.getTime());
        System.out.println(date3);

        // 将日期修改为与date2一致
        date3.setTime(date2.getTime());
        System.out.println(date3);

        // 将date2修改为date前一天的日期
        date2.setTime(date.getTime() - 24 * 60 * 60 * 1000);
        // 将date3修改为date后一天的日期
        date3.setTime(date.getTime() + 24 * 60 * 60 * 1000);
        // 此时时间先后顺序:date2->date->date3
        System.out.println("date是否在date2之后:" + date.after(date2));
        System.out.println("date是否在date3之后:" + date.after(date3));

        System.out.println("date是否在date2之前:" + date.before(date2));
        System.out.println("date是否在date之前:" + date.before(date));
        System.out.println("date是否在date3之前:" + date.before(date3));

        System.out.println(date.compareTo(date2));
        System.out.println(date.compareTo(date));
        System.out.println(date.compareTo(date3));
    }
}
