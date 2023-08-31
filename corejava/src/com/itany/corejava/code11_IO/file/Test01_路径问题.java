package com.itany.corejava.code11_IO.file;

import java.io.File;

/**
 * @author 石小俊
 * @date 2023年08月31日 11:24
 */
public class Test01_路径问题 {

    public static void main(String[] args) {
        // 通过绝对路径创建一个File对象
        File file = new File("E:\\one\\a.txt");
        // 判断该文件是否存在
        System.out.println(file.exists());
        // 通过相对路径创建一个File对象
        // File file2 = new File("a.txt");
        File file2 = new File("./a.txt");
        System.out.println(file2.exists());

        File file3 = new File("E:/one/corejava/src/beans.txt");
        System.out.println(file3.exists());

        // File file4 = new File("corejava/src/beans.txt");
        File file4 = new File("./corejava/src/beans.txt");
        System.out.println(file4.exists());

        File file5 = new File("E:/b.txt");
        System.out.println(file5.exists());

        File file6 = new File("../b.txt");
        System.out.println(file6.exists());
    }

}
