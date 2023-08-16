package com.itany.corejava.code05_方法;

/**
 * @author 石小俊
 * @date 2023年08月11日 15:26
 */
public class Test01_定义方法 {

    public static void main(String[] args) {
        test();
        // 将add方法执行后的返回值赋值给变量sum
        int sum = add(1, 2);
        isAdult(16);
        test02("admin", 10, 3.14);
        int sum2 = SomeClass.sum(100);
        System.out.println(sum2);
    }

    /**
     * 计算两个int类型的数字之和
     */
    public static int add(int i, int j) {
        return i + j;
    }

    public static void test() {
        for (int i = 1; i < 10; i++) {
            if (i == 2) {
                return;
            }
            System.out.println("这是一个无参无返回值的方法");
        }
        System.out.println("这是循环外面的代码");
    }

    public static void isAdult(int age) {
        if (age < 18) {
            System.out.println("您尚未成年");
        } else {
            System.out.println("您已经成年了");
        }
    }

    public static void test02(String s, int i, double j) {
        System.out.println("第一个参数:" + s);
        System.out.println("第二个参数:" + i);
        System.out.println("第三个参数:" + j);
    }

}
