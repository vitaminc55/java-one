package com.itany.corejava.code08_常用类.日期类;

import com.itany.corejava.util.DateUtil;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

/**
 * @author 石小俊
 * @date 2023年08月28日 9:31
 * 中国有句俗话叫做:三天打渔两天晒网。假设从2000年1月1日开始执行三天打渔两天晒网
 * 在控制台输入一个日期格式的字符串,格式为:yyyy-MM-dd,判断这一天是打渔还是晒网
 */
public class Test05_练习 {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入一个2000年1月1日之后的日期字符串(格式:yyyy-MM-dd):");
        String s = sc.next();
        // 开始进行三天打鱼两天晒网的日期
        Date startDay = DateUtil.toDate("2000-01-01", "yyyy-MM-dd");
        // 将这个字符串转换成日期,即为结束日期
        Date endDay = DateUtil.toDate(s, "yyyy-MM-dd");
        // 计算两个日期之间相差的天数,不足一天的以一天计算
        int day = DateUtil.getDuringDay2(startDay, endDay);
        // 由于三天打鱼两天晒网是5天一个循环
        // 由于第四天和第五天属于晒网,此时对5取余,余数为4或者0表示晒网
        if (day % 5 == 4 || day % 5 == 0) {
            System.out.println("今天该晒网了");
        } else {
            // 否则这一天打渔
            System.out.println("今天需要出海打渔");
        }
    }
}
