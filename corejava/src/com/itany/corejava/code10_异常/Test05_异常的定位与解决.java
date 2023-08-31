package com.itany.corejava.code10_异常;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 石小俊
 * @date 2023年08月31日 10:07
 */
public class Test05_异常的定位与解决 {

    public static void main(String[] args) throws DateConvertException {
        ClassA a = new ClassA();
        a.login();
    }

}

class ClassA {
    public void login() throws DateConvertException {
        ClassB b = new ClassB();
        b.select();
    }
}

class ClassB {
    public void select() throws DateConvertException {
        ClassC c = new ClassC();
        try {
            c.select();
        } catch (ParseException e) {
            e.printStackTrace();
            // 将ParseException异常转换成了自定义异常
            throw new DateConvertException("日期字符串格式有误,异常原因:" + e.getMessage());
        }
    }
}

class ClassC {
    public void select() throws ParseException {
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse("2023/02/03");
    }
}
