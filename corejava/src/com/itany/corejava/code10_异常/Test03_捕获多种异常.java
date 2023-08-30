package com.itany.corejava.code10_异常;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 石小俊
 * @date 2023年08月30日 16:59
 */
public class Test03_捕获多种异常 {
    public static void main(String[] args) {

    }

    public static void test01() {
        try {
            // int i = 1 / 0;
            String name = null;
            name.equals("admin");
            String[] arr = new String[5];
            System.out.println(arr[5]);
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse("2022");
        } catch (ArithmeticException e) {
            // 在try语句中存在多种异常,可以定义多个catch进行捕获
            // 并且捕获时是根据catch定义的顺序从上向下进行捕获的
            // 如果定义了多种异常,且这些异常中存在父子关系
            // 当第一个catch捕获到之后,后面的将不会被执行
            // 如果先捕获大的,大的会包含小的异常,此时下面捕获小的异常的代码将永远不会生效
            // 代码会直接提示错误
            // 因此,在捕获异常时,要求先捕获小的异常,再捕获大的异常
            System.out.println("这是算术异常");
        } catch (NullPointerException e) {
            System.out.println("这是空指针异常");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("这是数组下标越界异常");
        } catch (Exception e) {
            System.out.println("这是检查异常");
        }
    }

    public static void test02() {
        try {
            // int i = 1 / 0;
            String name = null;
            name.equals("admin");
            String[] arr = new String[5];
            System.out.println(arr[5]);
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse("2022");
        } catch (ArithmeticException | NullPointerException | ArrayIndexOutOfBoundsException e) {
            // 在捕获时可以通过异常类型 | 异常类型2表示捕获多种异常
            // 此处会同时对捕获到的所有异常进行处理
            // 但是这些异常最好是同级的,如果存在父子关系的异常,子异常属于多余的,会报错
            System.out.println("这是算术异常");
        } catch (Exception e) {
            System.out.println("这是检查异常");
        }
    }
}
