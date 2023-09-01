package com.itany.corejava.util;

import com.itany.corejava.exception.FileCopyErrorException;

import java.io.*;

/**
 * @author 石小俊
 * @date 2023年09月01日 11:22
 */
public class FileUtil {

    /**
     * 拷贝文件,将源文件内容拷贝到目标文件中
     * @param src    源文件
     * @param target 目标文件
     */
    public static void copyFile(File src, File target) throws FileCopyErrorException {
        try (
                InputStream in = new FileInputStream(src);
                OutputStream out = new FileOutputStream(target);
        ) {
            // 先将src中的内容读取出来,然后将读取出来的数据写入到target中
            byte[] b = new byte[1024];
            int data;
            while ((data = in.read(b)) != -1) {
                // 每次读取完对应字节后,将读取到的字节写入到目标文件中
                // 但是由于读取所有的字节数组的数据时,存在空数据
                // 因此,写入数据时只能写入有效数据
                // 有效数据对应的数组下标从0开始读取,读取data个字节
                out.write(b, 0, data);
            }
            System.out.println("成功将" + src.getAbsolutePath() + "中的资源拷贝到了" + target.getAbsolutePath() + "中");
        } catch (FileNotFoundException e) {
            throw new FileCopyErrorException("文件拷贝出错");
        } catch (IOException e) {
            throw new FileCopyErrorException("文件拷贝出错");
        }
    }

    /**
     * 拷贝文件,将src路径中的内容拷贝到target路径所在的文件中
     * @param src
     * @param target
     */
    public static void copyFile(String src, String target) throws FileCopyErrorException {
        copyFile(new File(src), new File(target));
    }

}
