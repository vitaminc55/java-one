package com.itany.corejava.code11_IO.字符流;

import java.io.*;

/**
 * @author 石小俊
 * @date 2023年09月01日 16:00
 */
public class Test03_转换流 {

    public static void main(String[] args) {
        try (
                // 定义转换流,其参数是一个字节流
                // InputStreamReader in = new InputStreamReader(new FileInputStream("E:\\itany\\a.txt"));
                // 定义转换流的时候可以指定字符集,如果不指定则使用默认字符集
                // InputStreamReader in = new InputStreamReader(new FileInputStream("E:\\itany\\a.txt"),"GBK");

                // 转换流只是用于实现转换操作,不做任何读写操作
                // 所有的读写操作仍然使用对应的文件流
                // BufferedReader br = new BufferedReader(in);

                // 简写方式
                BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("E:\\\\itany\\\\a.txt"), "GBK"));

                // 定义一个PrintWriter,用于写入文件
                PrintWriter out = new PrintWriter("E:\\itany\\abc.txt", "GBK");

        ) {
            String data;
            while ((data = br.readLine()) != null) {
                System.out.println(data);
                out.println(data);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
