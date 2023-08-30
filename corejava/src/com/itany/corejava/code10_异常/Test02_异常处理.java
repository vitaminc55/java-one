package com.itany.corejava.code10_异常;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 石小俊
 * @date 2023年08月30日 16:10
 */
public class Test02_异常处理 {

    public static void main(String[] args) throws Exception {
//        test01();
        test02("aaa");
//        test03(1,0);
    }

    public static void test01() {
        try {
            System.out.println("可能出现异常的代码");
            int i = 1 / 0;
            System.out.println("没有出现异常后执行的代码");
        } catch (ArithmeticException e) {
            System.out.println("捕获到ArithmeticException异常后执行的代码");
            // 异常对象包含了异常的详细信息
            // e.printStackTrace();
            // System.err.println("捕获到ArithmeticException异常后执行的代码");
            // System.err.println(e);
            // 获取异常信息
            // System.err.println(e.getMessage());
            // return表示退出方法,但是在异常处理代码中,必须整个异常代码全部结束才会退出
            // 即:return之后的finally代码照常执行
            // return;
            // 如果想要直接退出,通过System.exit(0)表示终止当前正在运行的JVM
            // 此时finally的代码不会被执行
            System.exit(0);
        } finally {
            System.out.println("不管是否存在异常都会执行的代码");
        }
        System.out.println("这是异常处理语句之后的代码");
    }

    public static void test02(String s) throws ParseException {
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(s);
        } catch (ParseException e) {
            // 此处表示捕获到对应异常,可以进行处理了
            System.out.println("日期字符串格式有误");
            // 在此处也可以通过关键字throw将异常抛出去,不进行处理
            // throw关键字后面必须跟异常对象
            // 如果没有异常对象, 则可以通过new 异常类型()来创建一个异常对象
            // 也可以直接抛出当前捕获到的异常对象
            // 当通过关键字throw抛出异常时,表示此处并没有对异常处理完成
            // 因此,在方法的声明处必须通过throws关键字抛出当前所抛出异常
            throw e;
        } finally {
            System.out.println("这是finally");
        }
    }

    public static void test03(int i, int j) throws Exception {
        // 使用throw关键字可以在任意位置进行使用
        // 并不是必须在异常处理代码中
        if (j == 0) {
            // 当除数为0时,会出现算术异常
            // 此处可以定义一个算术异常对象,通过throw关键字抛出去
            // ArithmeticException e = new ArithmeticException("第二个参数不能为空,否则无法进行除法运算");
            // 由于算术异常属于运行时异常,使用throw关键字抛出后可以不在方法声明中通过throws抛出
            // 只有检查异常必须抛出
            // throw e;

            // 简写方式
            // throw new ArithmeticException("第二个参数不能为空,否则无法进行除法运算");

            // 此时可以更换异常类型
            // 当前抛出的异常属于检查异常,此时的方法声明处必须通过throws抛出
            throw new Exception("这是检查异常");
            // throw关键字效果类似于return,表示方法结束,后面不能再有代码了
        }
    }

}
