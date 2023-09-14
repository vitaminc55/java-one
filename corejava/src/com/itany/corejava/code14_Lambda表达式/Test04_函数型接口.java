package com.itany.corejava.code14_Lambda表达式;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * @author 石小俊
 * @date 2023年09月14日 15:49
 */
public class Test04_函数型接口 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
        // 匿名内部类
        Integer length = testFunction(new Function<List<Integer>, Integer>() {
            @Override
            public Integer apply(List<Integer> list) {
                return list.size();
            }
        }, list);
        System.out.println(length);

        // Lambda表达式
        Integer length2 = testFunction(numbers -> numbers.size(), list);
        System.out.println(length2);
    }

    /**
     * 函数型接口Function<T,R>,方法:R apply(T t)
     * 其接口泛型类型与方法参数与返回值有关
     * 第一个泛型表示的是方法参数的类型,第二个泛型表示的是方法返回值类型
     * @param function
     * @param list
     * @return
     */
    public static Integer testFunction(Function<List<Integer>, Integer> function, List<Integer> list) {
        return function.apply(list);
    }

}
