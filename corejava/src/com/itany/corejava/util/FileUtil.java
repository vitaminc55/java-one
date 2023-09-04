package com.itany.corejava.util;

import com.itany.corejava.exception.FileCopyErrorException;

import java.io.*;

/**
 * @author 石小俊
 * @date 2023年09月01日 11:22
 * 文件操作工具类
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

    /**
     * 将一个目录中所有的文件拷贝到指定目录中
     * @param src    源目录
     * @param target 目标目录
     */
    public static void copyDirectory(String src, String target) throws FileCopyErrorException {
        // 获取源目录
        File srcFile = new File(src);
        // 获取源目录中所有的文件
        File[] files = srcFile.listFiles();

        // 获取目标目录
        File targetFile = new File(target);
        // 创建对应的目标目录
        targetFile.mkdirs();
        // 遍历源目录中所有内容
        for (File file : files) {
            // 如果源目录中的子File是一个文件
            if (file.isFile()) {
                // 则将该文件拷贝到对应的目标目录中
                // 拷贝的目标文件为:目标目录+分隔符+文件名
                copyFile(file, new File(target + File.separator + file.getName()));
            }
        }
    }

    /**
     * 将一个目录中的文件与子目录递归拷贝到一个指定的目录中
     * @param src    源目录
     * @param target 目标目录
     */
    public static void recursiveCopy(String src, String target) throws FileCopyErrorException {
        // 获取源目录
        File srcFile = new File(src);
        // 获取源目录中所有的子文件
        File[] files = srcFile.listFiles();

        // 创建目标目录
        File targetFile = new File(target);
        targetFile.mkdirs();

        // 遍历源目录中所有子文件
        for (File file : files) {
            // 如果是文件
            if (file.isFile()) {
                copyFile(file, new File(target, file.getName()));
            } else {
                // 如果是子目录,需要递归操作
                // 此时传递的源目录:当前file的地址
                // 此时传递的目标目录:当前目标目录+当前子目录名
                recursiveCopy(file.getAbsolutePath(), target + File.separator + file.getName());
            }
        }
    }

    /**
     * 拆分文件,将一个文件按照指定大小拆分成多个文件,每一个文件名字为:原名字_index,index从1开始,每次自增1
     * 一个输入流,多个输出流,在输出时,每循环一次,输出一个子文件
     * @param path
     * @param length
     */
    public static void splitFile(String path, int length) {
        try (
                FileInputStream in = new FileInputStream(path);
        ) {
            // 设置每次读取的字节数
            byte[] b = new byte[length];
            int data;
            int index = 1;
            while ((data = in.read(b)) != -1) {
                // 每次读取生成一个新的输出流
                FileOutputStream out = new FileOutputStream(path + "_" + index++);
                out.write(b, 0, data);
                // 每次输出完成,关闭当前输出流
                out.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 合并文件,将之前拆分的文件合并为一个文件,将子文件的_index部分删除作为文件名
     * 传入的参数表示的是第一个文件名,按照该文件名的格式将所有格式相同的文件进行合并
     * 所有需要合并的文件名均为:文件名_索引号
     * 一个输出流,多个输入流
     * @param path 传入的需要合并的第一个文件
     */
    public static void mergeFile(String path) {
        // 将传入的文件路净值_包含后面的索引号清除
        path = path.substring(0, path.lastIndexOf("_"));
        try (
                // 指定一个输出流,用于接收输出的数据
                FileOutputStream out = new FileOutputStream(path);
        ) {
            // 读取所有需要合并的文件,其文件名为:path_索引号
            int index = 1;
            File file = null;
            while ((file = new File(path + "_" + index)).exists()) {
                // 定义多个输入流
                FileInputStream in = new FileInputStream(file);
                copyStream(in, out);
                // 关闭输入流
                in.close();
                System.out.println(path + "_" + index + "合并成功");
                index++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void copyStream(FileInputStream in, FileOutputStream out) throws IOException {
        // 将当前文件内容写入到指定输出流中
        byte[] b = new byte[1024 * 1024];
        int data;
        while ((data = in.read(b)) != -1) {
            out.write(b, 0, data);
        }
    }

    /**
     * 文件加密,读取文件中的每一个字节,根据指定的密码对其进行加密,加密后的文件添加.sec后缀
     * 加密与解密均通过异或操作实现
     * a.txt --> a.txt.sec
     * @param file     需要加密的文件
     * @param password 密码
     */
    public static void encoded(File file, int password) {
        try (
                FileInputStream in = new FileInputStream(file);
                FileOutputStream out = new FileOutputStream(file.getAbsoluteFile() + ".sec");
        ) {
            int data;
            while ((data = in.read()) != -1) {
                // 每次读取一个字节,对于读取的字节通过异或操作进行加密
                // 将加密后的数据写入到新文件中
                out.write(data ^ password);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 文件解密,读取加密后的文件中的每一个字节,根据指定的密码对其进行解密,解密后的文件去除.sec后缀
     * @param file     需要加密的文件
     * @param password 密码
     */
    public static void decoded(File file, int password) {
        String path = file.getAbsolutePath();
        path = path.substring(0, path.lastIndexOf("."));
        try (
                FileInputStream in = new FileInputStream(file);
                FileOutputStream out = new FileOutputStream(path);
        ) {
            int data;
            while ((data = in.read()) != -1) {
                out.write(data ^ password);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws FileCopyErrorException {
//        copyDirectory("E:\\itany\\aa","E:\\itany\\bb");
//        recursiveCopy("E:\\itany\\a","E:\\itany\\b");
//        splitFile("E:\\itany\\JDK-API-1.6.CHM", 1024*1024*10);
//        mergeFile("E:\\itany\\ideaIU-2018.2.exe_1");
//        File file = new File("E:\\itany\\a.txt");
//        encoded(file,123456);
        File file = new File("E:\\itany\\a.txt.sec");
        decoded(file, 123456);
    }
}
