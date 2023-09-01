package com.itany.corejava.code11_IO.字节流;


import java.io.*;

/**
 * @author 石小俊
 * @date 2023年09月01日 13:32
 */
public class Test04_字节数组输入输出流 {

    public static void main(String[] args) throws IOException {
//        test01();
        test02();
    }

    /**
     * 字节数组输入流
     * @throws IOException
     */
    public static void test01() throws IOException {
        // 定义一个字节数组
        byte[] data = "Hello World".getBytes();

        // 定义字节数组输入流
        // 其参数是数据原来的byte数组
        InputStream in = new ByteArrayInputStream(data);

        // 读取操作与之前操作文件完全一致
        // int i = in.read();
        // System.out.println((char)i);
        byte[] b = new byte[1024];
        int i;
        while ((i = in.read(b)) != -1) {
            System.out.println(new String(b, 0, i));
        }
    }

    /**
     * 字节数组输出流
     * @throws IOException
     */
    public static void test02() throws IOException {
        // 定义一个字节数组输出流
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        // 将数据写入到内置的字节数组中
        // 将数据写入到数据缓冲区中
        // out.write("Hello World".getBytes());
        out.write("你好 世界".getBytes());
        // 当刷新后,写入到文件中
        out.flush();

        // 获取内置的字节数组的数据
        // 在内存中创建一个新的字节数组的空间,并且缓冲区的有效内容已经写入到该数组中
        byte[] data = out.toByteArray();
        // 从内存中提取数据
        System.out.println(new String(data));
        // 从缓冲区提取数据
        System.out.println(out.toString());
    }

}
