package com.itany.corejava.code14_Lambda表达式;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author 石小俊
 * @date 2023年09月14日 16:58
 */
public class Test06_构造方法引用 {
    public static void main(String[] args) {
        // 调用无参构造方法
        // User user = new User();
        // 类名::new表示指定对应类的构造方法
        // 根据指向的不同函数式接口表示不同的构造方法
        // 此时表示供给型接口指向的是无参构造方法
        Supplier<User> s = User::new;
        // 调用构造方法创建一个对象
        User user = s.get();
        System.out.println(user);

        // 调用一个参数的构造方法
        Function<String, User> f = User::new;
        User user2 = f.apply("admin");
        System.out.println(user2);

        // 调用两个参数的构造方法
        // 四大核心函数式接口无法实现
        // 可以使用BiFunction进行实现
        BiFunction<String, String, User> bf = User::new;
        User user3 = bf.apply("admin", "123456");
        System.out.println(user3);

        // 内置的函数式接口中最多只能调用两个参数的构造方法
        // 如果想要更多参数的,可以自定义函数式接口
    }
}
