package com.itany.corejava.code11_IO.字节流;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author 石小俊
 * @date 2023年08月31日 15:59
 */
public class Test01_文件字节输入流 {

    public static void main(String[] args) {
//        test01();
        test02();
    }

    /**
     * 基本用法:每次读取一个字节
     */
    public static void test01() {
        FileInputStream in = null;
        try {
            // 方式一:参数为读取的文件的路径名+文件名
            // in = new FileInputStream("E:\\itany\\a.txt");
            // 方式二:参数为读取的文件的File对象
            File file = new File("E:\\itany\\a.txt");
            in = new FileInputStream(file);

            // read():从此输入流中读取一个数据字节
            // 返回值:返回下一个数据字节。如果已到达文件末尾，则返回 -1
            // 由于返回值是int类型,对于字符,返回的是对应的ASCII码
            // int data = in.read();
            // System.out.println(data);

            // 可以强制转换成字符类型
            // char data = (char) in.read();
            // System.out.println(data);
//            System.out.println((char)in.read());
//            System.out.println((char)in.read());
//            System.out.println((char)in.read());
//            System.out.println((char)in.read());
//            System.out.println((char)in.read());
//            System.out.println((char)in.read());

            // 通过上述方式一致打印比较烦
            // 由于当读取不到数据后返回-1
            // 因此,可以使用while循环实现
//            int data = in.read();
//            while(data != -1){
//                System.out.print((char)data);
//                data = in.read();
//            }

            // 简写方式
            int data;
            while ((data = in.read()) != -1) {
                System.out.print((char) data);
            }

            // 但是此时如果文件中存在中文,会出现乱码
            // 乱码原因:中文根据编码不同占2-3个字节
            // 每次只读取一个字节,一定读不完整个中文


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭输入流,释放资源
            // 只要打开了外部资源,最终都必须释放
            // 例如:文件、数据库连接、网络连接
            // 遵循谁开谁关的原则
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 同时读取多个字节
     * 在JDK7中引入了一个新语法可以自动释放资源
     */
    public static void test02() {

        try (
                //JDK7引入了一个新的语法,叫做try-with-resource
                // 用于自动关闭外部资源,此时不需要通过finally进行关闭
                // 此处创建的对象最终会自动释放资源
                FileInputStream in = new FileInputStream("E:\\itany\\a.txt");
                // 在此处,只能使用实现了AutoCloseable接口的类
                // String s = new String("admin"); // 报错
        ) {
            // 由于文件中出现了中文,每次读取一个字节会导致出现乱码问题
            // 因此,可以考虑一次读取多个字节
//            byte[] b = new byte[3];
            // 方法返回值:存储到数据缓存区的字节数量,当没有读取到时返回-1
            // b:真正存储数据的缓冲区
//            int data = in.read(b);
//            System.out.println(data);
//            System.out.println(Arrays.toString(b));
//            System.out.println(new String(b));

            // 此时还存在一个小问题:当中文不是从头开始,而是中间开始,且不是3的倍数时
            // 依然会出现乱码
            // 此时将缓冲区的字节数组的长度定义的较大一点,尽可能超过整个文件内容的字节总数
            // 使得中文不会中途断开,避免断开后产生乱码问题
            byte[] b = new byte[1024];
            // 此时的方法返回值表示的是有效字符的长度
//            int data = in.read(b);
//            System.out.println(data);
//            System.out.println(new String(b));
            // 此时直接读取时,会读取到空白字符
            int data;
            while((data = in.read(b)) != -1){
                // 此时读取时需要将内容后面的空白去除掉
                // 参数一:需要转换的字节数组
                // 参数二:从哪一个索引位置开始转换
                // 参数三:转换多少个字节
                System.out.println(new String(b,0,data));;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
