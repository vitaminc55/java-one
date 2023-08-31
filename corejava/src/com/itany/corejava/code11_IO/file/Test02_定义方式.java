package com.itany.corejava.code11_IO.file;

import java.io.File;
import java.net.URISyntaxException;

/**
 * @author 石小俊
 * @date 2023年08月31日 11:32
 */
public class Test02_定义方式 {

    public static void main(String[] args) throws URISyntaxException {
        // 定义方式一
        File file = new File("E:\\itany\\a.txt");
        System.out.println(file.exists());
        file = new File("..\\itany\\a.txt");
        System.out.println(file.exists());

        // 定义方式二
        File file2 = new File("E:\\itany", "a.txt");
        System.out.println(file2.exists());

        // 定义方式三
        File parent = new File("E:\\itany");
        System.out.println(parent.exists());
        File file3 = new File(parent, "a.txt");
        System.out.println(file3.exists());

        // 定义方式四
        // 可以通过当前类找到当前类所在的类加载路径
        // 然后根据类加载路径获取到对应URI地址
        // 此处可以认为URI就是相对于类加载路径的相对路径
        File file4 = new File(
                Test02_定义方式
                        .class
                        // 找到当前类的类加载器路径
                        // 用于加载classpath下的资源
                        .getClassLoader()
                        // 找到类加载路径的URL地址
                        // 此时的地址相当于资源所在的src目录
                        // 方法参数即为相对于src目录的资源的相对路径
                        .getResource("beans.properties")
                        // 将URL转换成对应的URI
                        .toURI());
        System.out.println(file4.exists());
        // 系统默认分隔符的常量
        System.out.println(File.separator);

    }

}
