package com.itany.corejava.code11_IO.file;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author 石小俊
 * @date 2023年08月31日 14:04
 */
public class Test04_其他方法 {
    public static void main(String[] args) throws IOException {
        File file = new File("E:/itany/b.txt");
        // 创建一个文件,该文件是当前file对象所表示的文件
        // 如果当前file文件不存在,则创建一个新的文件并返回true
        // 如果当前file文件已经存在了,则不再进行创建返回false
        boolean flag = file.createNewFile();
        System.out.println("是否创建了新文件:" + flag);

        flag = file.renameTo(new File("E:/itany/c.txt"));
        System.out.println("文件重命名是否成功:" + flag);
        file = new File("E:/itany/a.txt");
        // 同一个目录中不能存在同名的文件
        flag = file.renameTo(new File("E:/itany/c.txt"));
        System.out.println("文件重命名是否成功:" + flag);

        file = new File("E:/itany/c.txt");
        flag = file.delete();
        System.out.println("文件是否删除成功:" + flag);

        file = new File("E:/itany/aa");
        flag = file.mkdir();
        System.out.println("aa目录是否创建成功:" + flag);

        file = new File("E:/itany/a/b/c");
        // mkdir():只能创建一层目录
        flag = file.mkdir();
        System.out.println("a、b、c三层目录是否创建成功:" + flag);

        // mkdir():递归创建,不限层次
        flag = file.mkdirs();
        System.out.println("a、b、c三层目录是否创建成功:" + flag);

        file = new File("E:/itany");
        String[] arr = file.list();
        System.out.println(Arrays.toString(arr));

        File[] files = file.listFiles();
        System.out.println(Arrays.toString(files));

        for (File f : files) {
            if (f.isFile()) {
                System.out.println(f.getName() + "是一个文件");
            }
            if (f.isDirectory()) {
                System.out.println(f.getName() + "是一个目录");
            }
        }

    }
}
