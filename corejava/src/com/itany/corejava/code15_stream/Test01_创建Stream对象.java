package com.itany.corejava.code15_stream;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

/**
 * @author 石小俊
 * @date 2023年09月15日 9:08
 */
public class Test01_创建Stream对象 {

    public static void main(String[] args) {
        System.out.println("*************Collection体系集合*************");
        // Collection体系集合
        List<Integer> list = Arrays.asList(1, 2, 4, 6, 9, 11, 15);
        // 获取对应集合的Stream
        Stream<Integer> stream = list.stream();
        System.out.println(stream);
        // forEach是一个终止操作,用于遍历Stream中所有的元素
        // 其参数是一个消费型接口Consumer
        stream.forEach(System.out::println);

        System.out.println("*************Map体系集合*************");
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "admin");
        map.put(2, "alice");
        map.put(3, "jack");
        // 将Map中所有的key存放到Set集合中进行转换
        Stream<Integer> keyStream = map.keySet().stream();
        keyStream.forEach(System.out::println);
        // 将Map的key-value使用Entry的方式存放到Set集合中进行转换
        Stream<Map.Entry<Integer, String>> entryStream = map.entrySet().stream();
        entryStream.forEach(System.out::println);

        System.out.println("*************数组*************");
        String[] hobbies = {"吃饭", "睡觉", "学java"};
        Stream<String> s = Arrays.stream(hobbies);
        s.forEach(System.out::println);

        // 也可以通过Stream提供的静态方法进行获取
        String[] addresses = {"南京", "北京", "苏州", "常州", "泰州", "徐州", "无锡", "杭州"};
        Stream<String> s2 = Stream.of(addresses);
        s2.forEach(System.out::println);

        System.out.println("*************可变长参数*************");
        Stream<String> s3 = Stream.of("合肥", "杭州", "扬州", "连云港", "盐城", "南通");
        s3.forEach(System.out::println);

        System.out.println("*************无限流*************");
        // 创建一元运算符对象,使用其默认实现规则
        // 默认规则:传递进来的参数即为返回值
        UnaryOperator operator = UnaryOperator.identity();
        // 如果使用默认方法的实现,则表示该无限流中所有元素都是初始元素
        // Stream<Integer> s4 = Stream.iterate(1,operator);
        // s4.forEach(System.out::println);

        // 由于该参数是一个函数式接口。因此,我们可以使用Lambda表达式自定义实现规则
        // Lambda表达式中参数表示当前元素的值, 返回值表示下一个元素的值
        // Stream<Integer> s5 = Stream.iterate(1, t -> t + 1);
        // Stream<Integer> s5 = Stream.iterate(0, t -> t + 2);
        Stream<Integer> s5 = Stream.iterate(10, t -> t + 10);
        s5.forEach(System.out::println);
    }

}
