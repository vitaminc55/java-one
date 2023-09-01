package com.itany.corejava.code11_IO.字符流;

import java.io.*;

/**
 * @author 石小俊
 * @date 2023年09月01日 15:04
 */
public class Test01_文件字符流 {

    public static void main(String[] args) {
        test02();
    }

    /**
     * FileReader
     */
    public static void test01() {
        try (
                Reader reader = new FileReader("E:\\itany\\a.txt");
        ) {
            // 读取一个字符
//            System.out.println((char)reader.read());
//            System.out.println((char)reader.read());
//            System.out.println((char)reader.read());
//            System.out.println((char)reader.read());

            // 读取多个字符
            char[] cs = new char[1024];
            int data;
            while ((data = reader.read(cs)) != -1) {
                System.out.println(new String(cs, 0, data));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * FileWriter
     */
    public static void test02() {
        try (
                Reader reader = new FileReader("E:\\itany\\a.txt");
                Writer writer = new FileWriter("E:\\itany\\b.txt");
        ) {
            char[] c = new char[1024];
            int data;
            while ((data = reader.read(c)) != -1) {
                writer.write(c, 0, data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
