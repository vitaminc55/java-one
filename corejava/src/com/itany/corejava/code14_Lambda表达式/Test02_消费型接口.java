package com.itany.corejava.code14_Lambda表达式;

import java.util.function.Consumer;

/**
 * @author 石小俊
 * @date 2023年09月14日 14:20
 */
public class Test02_消费型接口 {


    public static void main(String[] args) {
        // 匿名内部类
        testConsumer(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("学习Lambda表达式太累了,准备出去歇会,买杯" + s + "咖啡放松下");
            }
        }, "星巴克");

        // Lambda表达式
        testConsumer(s -> System.out.println("学习Lambda表达式太累了,准备出去歇会,买杯" + s + "咖啡放松下"), "瑞幸");


        MyClass aa = new MyClass();
        testConsumer(aa, "aa");

    }

    /**
     * 消费型接口Consumer,接口方法:void accept(T t)
     * 接口的泛型类型与实际调用的accept方法传递的参数类型必须一致
     * 由于该方法并不是真实的实际调用者,该方法会被其他方法所调用
     * 因此,accept方法中的参数可以设置为形参
     * @param consumer
     * @param param
     */
    public static void testConsumer(Consumer<String> consumer, String param) {
        consumer.accept(param);
    }

    public static void testConsumer(MyClass aaa, String param) {
        aaa.accept("aaa");
    }
}

class MyClass {
    void accept(String s) {
        // 此处的方法是由该类做了具体实现,方法调用者无法决定其具体实现方案
        // 如果使用接口,具体实现由最终的方法调用者进行实现
        System.out.println("学习Lambda表达式太累了,准备出去歇会,买杯" + s + "咖啡放松下");
    }
}

