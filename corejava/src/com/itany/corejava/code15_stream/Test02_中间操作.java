package com.itany.corejava.code15_stream;

import java.util.Arrays;
import java.util.List;

/**
 * @author 石小俊
 * @date 2023年09月15日 10:13
 */
public class Test02_中间操作 {

    private static List<Integer> list = Arrays.asList(1, 3, 6, 9, 14, 1, 9, 12, 17, 6, 15, 3, 18);

    public static void main(String[] args) {
//        filterTest();
//        distinctTest();
//        limitTest();
//        skipTest();
//        findPage(3,5);
//        mapTest();
//        sortedTest();
        sortedComparatorTest();
    }

    public static void filterTest() {
        // 过滤操作,过滤集合中所有的偶数
        // 过滤方法的参数是一个断言型接口
        // 在断言型接口中指定过滤规则
        list.stream()
                // 过滤所有的偶数
                .filter(i -> i % 2 == 0)
                // 通过终止操作执行中间操作
                .forEach(System.out::println);
    }

    public static void distinctTest() {
        list.stream()
                // 去重
                .distinct()
                .forEach(System.out::println);
    }

    public static void limitTest() {
        list.stream()
                .limit(8)
                .forEach(System.out::println);
    }

    public static void skipTest() {
        list.stream()
                .skip(50)
                .forEach(System.out::println);
    }

    /**
     * 模拟分页
     *
     * @param pageNo   第几页
     * @param pageSize 每页几条数据
     */
    public static void findPage(Integer pageNo, Integer pageSize) {
        list.stream()
                // 其规律与MySQL一致
                .skip((pageNo - 1) * pageSize)
                .limit(pageSize)
                .forEach(System.out::println);
    }

    public static void mapTest() {
        list.stream()
                // 将每一个元素的值翻倍
                .map(i -> i * 2)
                .forEach(System.out::println);
    }

    public static void sortedTest() {
        list.stream()
                .sorted()
                .forEach(System.out::println);
        List<String> names = Arrays.asList("admin", "jack", "tom", "lily", "root", "alice");
        names.stream()
                .sorted()
                .forEach(System.out::println);
    }

    public static void sortedComparatorTest() {
        list.stream()
                // 降序
                .sorted((i1, i2) -> i2 - i1)
                .forEach(System.out::println);

        List<String> names = Arrays.asList("admin", "jack", "tom", "lily", "root", "alice");
        names.stream()
                // 根据字符串长度进行升序
                .sorted((s1, s2) -> s1.length() - s2.length())
                .forEach(System.out::println);
    }
}
