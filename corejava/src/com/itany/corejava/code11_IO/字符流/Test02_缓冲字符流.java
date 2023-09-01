package com.itany.corejava.code11_IO.字符流;

import java.io.*;

/**
 * @author 石小俊
 * @date 2023年09月01日 15:47
 */
public class Test02_缓冲字符流 {

    public static void main(String[] args) {
        try (
                BufferedReader br = new BufferedReader(new FileReader("E:\\itany\\a.txt"));
                BufferedWriter bw = new BufferedWriter(new FileWriter("E:\\itany\\aa.txt"));
                PrintWriter out = new PrintWriter("E:\\itany\\aaa.txt");
        ) {
            // 按行读取数据
            // System.out.println(br.readLine());
            // System.out.println(br.readLine());
            // System.out.println(br.readLine());
            // 当某一行没有数据,则读取的数据返回值为null
            // System.out.println(br.readLine());
            String data;
            // 通过循环进行判断,如果没有读取到数据,则返回null
            // 即:当值为null时说明读取结束了
            while ((data = br.readLine()) != null) {
                System.out.println(data);
                // 将读取的内容写入到指定文件中
                // 此时发现写入到文件中的数据是没有换行的
                // bw.write(data);
                // 因此,需要手动换行,使用bw提供的换行方法,表示写入一个行分隔符
                // bw.newLine();
                // PrintWriter提供了自带换行的方法
                // print():写入数据后不会换行
                // println():写入数据后自动换行
                out.println(data);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
