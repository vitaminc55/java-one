package com.itany.corejava.code11_IO.file;

import java.io.File;

/**
 * @author 石小俊
 * @date 2023年08月31日 15:14
 * 获取指定目录中所有的文件,包含子目录中的文件
 */
public class Test05_递归操作 {

    public static void main(String[] args) {
        File file = new File("E:\\one");
        try {
            display(file);
        } catch (FileNotExistException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void display(File file) throws FileNotExistException {
        // 判断该目录是否存在
        if (!file.exists()) {
            throw new FileNotExistException("该目录不存在");
        }

        // 判断当前文件是否是目录
        if (file.isDirectory()) {
            // 展示当前目录中所有的子文件与子目录
            File[] files = file.listFiles();
            for (File f : files) {
                // 判断当前迭代的元素是否是一个文件
                if (f.isFile()) {
                    // 如果是文件,展示该文件的绝对路径名
                    System.out.println(f.getAbsolutePath());
                } else {
                    // 如果不是文件,说明是一个目录,递归操作
                    display(f);
                }
            }
        } else {
            // 如果是文件,,展示该文件的绝对路径名
            System.out.println(file.getAbsolutePath());
        }
    }

}
