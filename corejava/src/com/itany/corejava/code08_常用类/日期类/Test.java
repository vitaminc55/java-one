package com.itany.corejava.code08_常用类.日期类;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 黄鹏程
 * @date 2023年10月07日09:43
 */
public class Test {
    public static void main(String[] args) {
        Date date=new Date();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dates = df.format(date);
        System.out.println(dates);
        try (InputStream in=new FileInputStream("a.txt");
             OutputStream out=new FileOutputStream("b.txt")
        ){
            byte[] b=new byte[1024];
            int data;
            while ((data=in.read(b))!=-1){
                out.write(b,0,data);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
