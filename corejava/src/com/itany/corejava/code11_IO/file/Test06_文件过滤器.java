package com.itany.corejava.code11_IO.file;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

/**
 * @author 石小俊
 * @date 2023年08月31日 15:22
 */
public class Test06_文件过滤器 {
    public static void main(String[] args) {
        File file = new File("E:\\itany");
        String[] arr = file.list(new FilenameFilter() {

            /**
             * 定义过滤规则
             * @param dir   表示被找到的文件所在的目录
             * @param name  文件名
             * @return 方法返回值控制该文件是否添加到返回值的数组中
             */
            @Override
            public boolean accept(File dir, String name) {
                if (name.endsWith(".jpg") || name.endsWith(".txt")) {
                    // 将所有.jpg的文件存放到返回值数组中
                    return true;
                }
                return false;
            }
        });
        System.out.println(Arrays.toString(arr));
    }
}
