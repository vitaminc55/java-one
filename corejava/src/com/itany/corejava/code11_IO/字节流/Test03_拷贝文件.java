package com.itany.corejava.code11_IO.字节流;

import com.itany.corejava.exception.FileCopyErrorException;
import com.itany.corejava.util.FileUtil;

/**
 * @author 石小俊
 * @date 2023年09月01日 11:29
 */
public class Test03_拷贝文件 {

    public static void main(String[] args) {
//        File src = new File("E:\\itany\\b.txt");
//        File target = new File("E:\\itany\\c.txt");
//        try {
//            FileUtil.copyFile(src,target);
//        } catch (FileCopyErrorException e) {
//            System.out.println(e.getMessage());
//        }

        try {
            FileUtil.copyFile("E:\\\\itany\\\\b.txt","E:\\\\itany\\\\d.txt");
        } catch (FileCopyErrorException e) {
            e.printStackTrace();
        }
    }

}
