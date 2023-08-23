package com.itany.corejava.code08_常用类.string;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Arrays;

/**
 * @author 石小俊
 * @date 2023年08月23日 15:00
 */
public class Test06_字符集 {

    public static void main(String[] args) throws UnsupportedEncodingException {
//        showEncoding();
//        encoded();
//        decoded();
//        garbled();
//        garbled2();
        garbled3();
    }

    public static void showEncoding() {
        // 当前系统所使用的字符集
        System.out.println("当前系统所使用的字符集:" + System.getProperty("file.encoding"));
        // JVM默认使用的字符集。即:当前系统所使用的字符集
        System.out.println("JVM默认使用的字符集:" + Charset.defaultCharset());
    }

    public static void encoded() throws UnsupportedEncodingException {
        String s = "你好";
        // 以当前系统默认字符集进行转换
        // 此时默认使用的是UTF-8
        byte[] bs = s.getBytes();
        // 返回值:[-28, -67, -96, -27, -91, -67]
        // 两个中文对应6个字节,一个中文占3个字节
        System.out.println(Arrays.toString(bs));
        // 使用指定字符集进行编码
        bs = s.getBytes("GBK");
        // 返回值:[-60, -29, -70, -61]
        // 2个中文对应4个字节,一个中文占2个字节
        System.out.println(Arrays.toString(bs));
    }

    public static void decoded() throws UnsupportedEncodingException {
        // 使用你好对应的UTF-8的数据
        byte[] bs = {-28, -67, -96, -27, -91, -67};
        // 如果使用默认字符集UTF-8进行转换
        String s = new String(bs);
        System.out.println(s);


        // 使用的是你好对应的GBK的字节数组数据
        byte[] bs2 = {-60, -29, -70, -61};
        // 如果使用指定字符集进行转换
        s = new String(bs2, "GBK");
        System.out.println(s);
    }

    public static void garbled() throws UnsupportedEncodingException {
        String s = "你好";
        // 编码 --> GBK
        byte[] bs = s.getBytes("GBK");
        System.out.println(Arrays.toString(bs));
        // 解码 --> ISO-8859-1
        String s2 = new String(bs,"ISO-8859-1");
        // 由于编码与解码的方式不一致,产生了乱码
        System.out.println(s2);

        // 解决乱码问题
        // 为什么乱码?
        // 编码使用了GBK,解码使用了ISO-8859-1
        // 可以将乱码的数据还原
        // 先使用ISO-8859-1进行编码
        byte[] bs2 = s2.getBytes("ISO-8859-1");
        // 此时获取的字节数组是第一次编码后的数组
        System.out.println(Arrays.toString(bs2));
        // 再使用第一次编码的字符集进行解码
        String s3 = new String(bs2,"GBK");
        System.out.println(s3);

        // 简写方式
        String s4 = new String(s2.getBytes("ISO-8859-1"),"GBK");
        System.out.println(s4);
    }

    /**
     * GBK不符合UTF-8的规则
     * 使用GBK编码,UTF-8解码后的数据无法再通过还原的方式解决乱码问题
     * @throws UnsupportedEncodingException
     */
    public static void garbled2() throws UnsupportedEncodingException {
        String s = "你好";
        byte[] bs = s.getBytes("GBK");
        System.out.println(Arrays.toString(bs));
        String s2 = new String(bs,"UTF-8");
        System.out.println(s2);
        String s3 = new String(s2.getBytes("UTF-8"),"GBK");
        System.out.println(s3);
    }

    public static void garbled3() throws UnsupportedEncodingException {
        String s = "你好";
        byte[] bs = s.getBytes("UTF-8");
        System.out.println(Arrays.toString(bs));
        String s2 = new String(bs,"GBK");
        System.out.println(s2);
        String s3 = new String(s2.getBytes("GBK"),"UTF-8");
        System.out.println(s3);
    }

}
