package com.itany.corejava.code11_IO.字节流;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author 石小俊
 * @date 2023年09月01日 11:12
 */
public class Test02_文件字节输出流 {
    public static void main(String[] args) throws FileNotFoundException {
        try (
                // 在使用文件字节输出流时,如果文件不存在,会自动创建
                // 如果文件存在,会创建一个新的文件覆盖原有的文件
                // 即:不管指定的文件是否存在,都会创建一个新的
                // FileOutputStream out = new FileOutputStream("E:\\itany\\b.txt");
                // 可以选择创建一个不会覆盖原有的文件的文件字节输出流
                // 可以通过指定第二个boolean类型的参数来实现
                // true:表示文件内容的末尾追加内容
                // false:默认值,配置false与没有第二个参数效果一致
                FileOutputStream out = new FileOutputStream("E:\\itany\\b.txt", true);
        ) {
            // 向文件中写入数据
            // 将指定的字节数组的数据写入到文件中
            byte[] data = "Hello World".getBytes();
            out.write(data);
            // 在写入数据的时候,只是将数据写入到内存的缓冲区中,并没有真正写入到文件
            // 需要刷新输出流,才能将缓冲区的数据真正的写入到文件中,完成数据的传输
            // 刷新输出流的操作,在关闭流操作之后会自动调用该方法
            // 即:刷新操作可以省略
            out.flush();
            System.out.println("数据写入成功");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
