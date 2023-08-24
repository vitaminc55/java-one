package com.itany.corejava.code08_常用类.日期类;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 石小俊
 * @date 2023年08月24日 16:38
 */
public class Test03_格式化日期 {

    public static void main(String[] args) throws ParseException {
//        dateToString();
        stringToDate();
    }


    /**
     * 将日期转换成字符串
     */
    public static void dateToString() {
        Date date = new Date();
        System.out.println(date);

        // 将一个日期对象转换字符串,共分两步
        // 1.获取SimpleDateFormat类
        // 构造函数的参数表示转换后的日期格式
        // 需要使用由SimpleDateFormat所提供的标志
        // 父类中提供了直接将日期转换成字符串的方法
        // 此处可以使用父类引用指向子类对象的定义方式
        // 每个标记表示对应含义的一位数
        // 如果只写一个标记,当高于一位数时正常显示,只有一位数就只显示一位
        // 可以通过写多个标记,要求其返回的值必须保持多位
        // 例如:MM表示月份必须两位数,不足两位的高位补0
        DateFormat df = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss SSS E");
        // 2.调用format方法进行转换
        String format = df.format(date);
        System.out.println(format);

        // 简写方式
        format = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss E").format(date);
        System.out.println(format);

    }

    /**
     * 将一个字符串转换成日期
     */
    public static void stringToDate() throws ParseException {
        // 此时的字符串必须符合一定的格式
        // 其格式必须与SimpleDateFormat构造方法中的参数格式一致
        // 例如:SimpleDateFormat的参数为yyyy-MM-dd
        // 那么字符串的数据格式必须满足yyyy-MM-dd
        // String s = "2023-08-08";
        // 如果日期某一个选项超过了最大的选项,会向上一个选项进一
        // 例如:2023-02-31,2023年2月份共有28天
        // 此时的日期值表示的就是:2023-03-03
        String s = "2023-02-31";
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date = df.parse(s);
        System.out.println(date);

        // 简写方式
        date = new SimpleDateFormat("yyyy-MM-dd").parse(s);
        System.out.println(date);
    }
}
