package com.itany.corejava.code14_Lambda表达式;

import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author 石小俊
 * @date 2023年09月14日 16:40
 */
public class Test05_方法引用 {

    public static void main(String[] args) {
        // 获取Consumer接口的实例
        // Consumer<String> c = s -> System.out.println(s);
        // 对象::实例方法
        Consumer<String> c = System.out::println;
        // 上述代码可以使用简写方式
        c.accept("Hello Consumer");

        User user = new User();
        // user.setUsername("admin");
        // 获取Consumer实例,此时该对象指向的是setUsername这个方法
        Consumer<String> c2 = user::setUsername;
        c2.accept("admin");
        System.out.println(user.getUsername());

        // 通过函数式接口执行get方法
        Supplier<String> s = user::getUsername;
        System.out.println(s.get());

        // 类名::静态方法
        System.out.println(User.sayHello());
        ;
        Supplier s2 = User::sayHello;
        System.out.println(s2.get());

        System.out.println("aa".equals("aa"));
        String str = new String("aa");
        str.equals("bb");
        // 此时相当于字符串aa调用了equals方法
        // 断言型接口中方法参数即为调用的equals方法的参数
        // 那么此时调用者的字符串被写死了,不太合适
        Predicate<String> p = str::equals;
        System.out.println(p.test("aa"));
        // 我们可以使用其他函数式接口实现类似的操作
        // BiPredicate函数式接口可以传递两个参数,返回值是boolean类型
        // 第一个参数表示方法调用者,第二个参数表示方法参数
        // 此时在定义时无法确定具体的调用者是谁,但是我们可以知道一个是一个字符串
        // 此时可以通过类名::实例方法名进行定义
        BiPredicate<String, String> p2 = String::equals;
        System.out.println(p2.test("admin", "admin"));
    }

}
