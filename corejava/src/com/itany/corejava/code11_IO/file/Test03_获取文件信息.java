package com.itany.corejava.code11_IO.file;

import com.itany.corejava.util.DateUtil;

import java.io.File;
import java.net.URISyntaxException;
import java.util.Date;

/**
 * @author 石小俊
 * @date 2023年08月31日 13:31
 */
public class Test03_获取文件信息 {

    public static void main(String[] args) throws URISyntaxException {
        File file = new File("corejava/src/a.txt");
        // File file = new File("E:/one/corejava/src/a.txt");
        // File file = new File(Test03_获取文件信息.class.getClassLoader().getResource("a.txt").toURI());
        System.out.println("文件是否存在:" + file.exists());
        System.out.println("文件名:" + file.getName());
        // getPath():返回的是文件对象的参数路径
        System.out.println("文件的路径名:" + file.getPath());
        System.out.println("绝对路径名:" + file.getAbsolutePath());
        System.out.println("获取父目录:" + file.getParent());
        File parentFile = file.getParentFile();
        System.out.println("获取父目录对象:" + parentFile);
        System.out.println("获取父目录对象是否存在:" + parentFile.exists());
        // file = new File("E:\\itany\\ideaIU-2018.2.exe");
        // 即文件属性的大小,单位:字节
        System.out.println("文件长度:" + file.length());
        // lastModified():获取最后一次修改时间,返回值是一个日期毫秒数
        System.out.println("最后一次修改时间:" + DateUtil.toString(new Date(file.lastModified())));
        System.out.println("文件是否可读:" + file.canRead());
        System.out.println("文件是否可写:" + file.canWrite());
        System.out.println("file是否是文件:" + file.isFile());
        System.out.println("file是否是目录:" + file.isDirectory());
        System.out.println("是否是隐藏文件:" + file.isHidden());

        System.out.println("路径分隔符的常量字段:" + File.separator);
    }

}
