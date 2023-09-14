package com.itany.corejava.code14_Lambda表达式;

/**
 * @author 石小俊
 * @date 2023年09月14日 13:34
 */
public class Test01_基本用法 {

    public static void main(String[] args) {
        // 使用匿名内部类实现接口
        SomeInterface someInterface = new SomeInterface() {
            @Override
            public int sum(int i, int j) {
                return i + j;
            }
        };

        int sum = someInterface.sum(1, 2);
        System.out.println(sum);

        // Lambda表达式用法
        // SomeInterface someInterface2 = (int i, int j) -> {return i + j;};
        // 参数类型可以省略
        // SomeInterface someInterface2 = (i, j) -> {return i + j;};
        // 当方法体中只有一行代码, 且是return语句的时候, 那么大括号{} 与return 关键字都可以省略
        SomeInterface someInterface2 = (i, j) -> i + j;
        int sum2 = someInterface2.sum(2, 3);
        System.out.println(sum2);

        // 匿名内部类
        OtherInterface otherInterface = new OtherInterface() {
            @Override
            public void test() {
                System.out.println("Hello Lambda");
            }
        };

        // Lambda表达式
        // 如果没有参数,参数列表可以省略,直接写小括号即可
        // OtherInterface otherInterface2 = () -> {System.out.println("Hello Lambda");};
        // 当方法体中只有一行代码,且不是return语句的时候,大括号可以省略
        OtherInterface otherInterface2 = () -> System.out.println("Hello Lambda");
        otherInterface2.test();

        // 匿名内部类
        MyInterface myInterface = new MyInterface() {
            @Override
            public String test(String s) {
                return s;
            }
        };

        // Lambda表达式
        // MyInterface myInterface2 = (s) -> {return s;};
        // MyInterface myInterface2 = (s) -> s;
        // 当参数列表有且仅有一个参数的时候,小括号可以省略
        MyInterface myInterface2 = s -> s;
        String s = myInterface2.test("admin");
        System.out.println(s);
    }

}

interface SomeInterface {
    int sum(int i, int j);
}

interface OtherInterface {
    void test();
}

interface MyInterface {
    String test(String s);
}


