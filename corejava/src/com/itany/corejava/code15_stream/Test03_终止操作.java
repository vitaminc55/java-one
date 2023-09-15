package com.itany.corejava.code15_stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author 石小俊
 * @date 2023年09月15日 11:11
 */
public class Test03_终止操作 {

    private static List<Integer> list = Arrays.asList(1, 3, 4, 8, 3, 19, 12, 16, 14, 19, 5, 4);

    public static void main(String[] args) {
//        allMatchTest();
//        anyMatchTest();
//        noneMatchTest();
//        findFirstTest();
//        findAnyTest();
//        countTest();
//        maxTest();
//        minTest();
//        reduceTest();
        collectTest();
    }

    public static void allMatchTest() {
        boolean flag = list.stream()
                // 判断流中是否所有元素都是正数
                .allMatch(i -> i > 0);
        System.out.println("流中是否所有元素都是正数:" + flag);
        flag = list.stream()
                // 判断流中是否所有元素都是偶数
                .allMatch(i -> i % 2 == 0);
        System.out.println("流中是否所有元素都是偶数:" + flag);
    }

    public static void anyMatchTest() {
        boolean flag = list.stream()
                // 流中是否包含大于20的数字
                .anyMatch(i -> i > 20);
        System.out.println("流中是否包含大于20的数字:" + flag);
        flag = list.stream()
                // 判断流中是否包含偶数
                .anyMatch(i -> i % 2 == 0);
        System.out.println("流中是否包含偶数:" + flag);
    }

    public static void noneMatchTest() {
        boolean flag = list.stream()
                // 流中是都不比20大
                .noneMatch(i -> i > 20);
        System.out.println("流中是都不比20大:" + flag);
        flag = list.stream()
                // 判断流中是否都不是偶数
                .noneMatch(i -> i % 2 == 0);
        System.out.println("流中是否都不是偶数:" + flag);
    }

    public static void findFirstTest() {
        list = new ArrayList<>();
        // Optional是一个接收返回值的容器
        Optional<Integer> optional = list.stream()
                .findFirst();
        // isPresent():判断是否包含值,如果有值返回true,否则返回false
        System.out.println(optional.isPresent());
        Integer num = null;
        if (optional.isPresent()) {
            // 如果有值,可以通过get()方法取出对应的值
            num = optional.get();
        } else {
            // 如果没有值,自定义处理
            // 可以设置默认值
            num = -1;
        }
        System.out.println(num);
    }

    public static void findAnyTest() {
        Optional<Integer> optional = list.stream()
                .findAny();
        System.out.println(optional.get());
        Optional<Integer> optional2 = list.stream()
                .findAny();
        System.out.println(optional2.get());
        Optional<Integer> optional3 = list.stream()
                .findAny();
        System.out.println(optional3.get());

        new Thread() {
            @Override
            public void run() {
                // Optional<Integer> optional = list.stream()
                Optional<Integer> optional = list.parallelStream()
                        .findAny();
                System.out.println("多线程:" + optional.get());
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                // Optional<Integer> optional = list.stream()
                Optional<Integer> optional = list.parallelStream()
                        .findAny();
                System.out.println("多线程:" + optional.get());
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                // Optional<Integer> optional = list.stream()
                Optional<Integer> optional = list.parallelStream()
                        .findAny();
                System.out.println("多线程:" + optional.get());
            }
        }.start();
    }

    public static void countTest() {
        long count = list.stream().count();
        System.out.println("流中元素数量:" + count);
    }

    public static void maxTest() {
        Optional<Integer> max = list.stream().max((i1, i2) -> i1 - i2);
        System.out.println(max.get());
        Optional<Integer> max2 = list.stream().max((i1, i2) -> i2 - i1);
        System.out.println(max2.get());
    }

    public static void minTest() {
        Optional<Integer> min = list.stream().min((i1, i2) -> i1 - i2);
        System.out.println(min.get());
        Optional<Integer> min2 = list.stream().min((i1, i2) -> i2 - i1);
        System.out.println(min2.get());
    }

    public static void reduceTest() {
        // 返回集合中所有元素之和
        Optional<Integer> reduce = list.stream().reduce((a, b) -> a + b);
        System.out.println("所有元素之和:" + reduce.get());

        // 求1~100之间整数之和
        Optional<Integer> reduce2 = Stream.iterate(1, i -> i + 1)
                .limit(100)
                // .reduce((a, b) -> a + b);
                // 在Integer提供了sum方法,实现的功能即为: (a,b) -> a+b
                // 因此,可以直接使用Integer提供的sum方法
                .reduce(Integer::sum);
        System.out.println("1~100之间整数之和:" + reduce2.get());
    }

    public static void collectTest() {
        // 将一个Stream转换成List集合,且元素不重复
        List<Integer> list2 = list.stream().distinct().collect(Collectors.toList());
        System.out.println(list2);

        // 将一个Stream转换成Set集合
        // 转换成Set之后会自动去除重复的数据
        Set<Integer> set = list.stream().collect(Collectors.toSet());
        System.out.println(set);
    }
}
