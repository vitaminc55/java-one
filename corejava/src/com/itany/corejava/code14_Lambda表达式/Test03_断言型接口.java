package com.itany.corejava.code14_Lambda表达式;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author 石小俊
 * @date 2023年09月14日 15:42
 */
public class Test03_断言型接口 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("南京", "北京", "上海", "苏州", "常州", "泰州", "徐州", "杭州"));
        // 匿名内部类
        testPredicate(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                // 定义断言规则,规则的返回值是boolean类型
                return s.contains("京");
            }
        }, list);

        System.out.println("******************************");
        // Lambda表达式
        testPredicate(s -> s.contains("州"), list);
    }


    /**
     * 断言型接口Predicate<T>,方法:boolean test(T t)
     * 其接口泛型类型与方法的参数类型一致
     * 方法返回值是一个布尔类型,一般用于判断给定的参数是否符合指定的规则
     * 具体规则由方法调用者做具体实现
     * @param predicate
     * @param list
     */
    public static void testPredicate(Predicate<String> predicate, List<String> list) {
        for (String s : list) {
            if (predicate.test(s)) {
                // 当断言型接口方法的返回值为true时,则打印内容
                System.out.println(s);
            }
        }
    }

}
