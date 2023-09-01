package com.itany.corejava.code11_IO.字节流;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 石小俊
 * @date 2023年09月01日 14:06
 */
public class Test05_对象输入输出流 {

    public static void main(String[] args) {
        test01();
        test02();
    }

    /**
     * 序列化:将对象转换成二进制数据。可以通过一个文件来保存序列化后的二进制数据
     * ObjectOutputStream
     */
    public static void test01() {
        User user = new User(1, "admin", "123456");
        User user2 = new User(2, "alice", "111111");
        User user3 = new User(3, "jack", "222222");
        User user4 = new User(4, "tom", "333333");
        List<User> users = new ArrayList<>(Arrays.asList(user, user2, user3, user4));
        List list = new ArrayList();

        try (
                // 创建一个对象输出流,其参数是一个OutputStream
                // 可以指定一个文件,用于接收二进制流,写入的文件格式无所谓。因为二进制流文件打开后看不懂
                OutputStream out = new FileOutputStream("E:\\itany\\users.data");
                ObjectOutputStream oos = new ObjectOutputStream(out);
        ) {
            // 写入对象
            // 写入的对象可以是任意类型
            // 只要是Java的类型,均支持
            // oos.writeObject(1);
            // oos.writeObject("admin");
            // oos.writeObject(true);
            // oos.writeObject(user);
            // oos.writeObject(users);
            list.add(1);
            list.add("admin");
            list.add(true);
            list.add(user);
            list.add(users);
            oos.writeObject(list);

            // 刷新流
            oos.flush();

            System.out.println("对象序列化成功");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 反序列化:从流中读取Java对象
     * ObjectInputStream
     */
    public static void test02() {
        try (
                ObjectInputStream in = new ObjectInputStream(new FileInputStream("E:\\itany\\users.data"));
        ) {
            // 由于写入的数据可以是任意类型
            // 取的时候要求取出的也是任意类型,即Object类型
            // 每次读取读取的是第一个写入的数据
//            Object obj = in.readObject();
//            System.out.println(obj);
//            System.out.println(in.readObject());
//            System.out.println(in.readObject());
//            System.out.println(in.readObject());
            // 如果读取的次数超过了写入的次数,则报错
//            System.out.println(in.readObject());

            // 在写入数据的时候,可以将所有的数据全部存放到一个集合中
            // 此时在读取的时候只需要读取一次即可
            // 读取到集合数据后遍历这个集合即可
            Object obj = in.readObject();
            List list = (List) obj;
            for (Object o : list) {
                System.out.println(o);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
