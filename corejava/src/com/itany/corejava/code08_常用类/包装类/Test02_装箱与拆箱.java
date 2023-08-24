package com.itany.corejava.code08_常用类.包装类;

/**
 * @author 石小俊
 * @date 2023年08月24日 14:39
 */
public class Test02_装箱与拆箱 {

    public static void main(String[] args) {
        int i = 1;
        // JDK5之前装箱
        // 手动装箱
        Integer integer = new Integer(i);
        // JDK5之后装箱
        Integer integer2 = i;

        // 拆箱
        // JDK5之前手动拆箱
        int i1 = integer.intValue();
        // JDK5自动拆箱
        int i2 = integer;

        int i3 = 10;
        int i4 = 10;
        System.out.println(i3 == i4);   // true

        Integer integer3 = new Integer(3);
        Integer integer4 = new Integer(3);
        System.out.println(integer3 == integer4); // false


        int i5 = 10;
        Integer integer5 = new Integer(10);
        // 在进行运算的时候自动执行了拆箱操作
        // 当基本数据类型与包装类型进行比较时
        // 会自动将包装类型拆箱为基本数据类型
        // 因此,此处相当于两个int类型在比较
        // 即:只比较值的大小
        System.out.println(i5 == integer5); // true

        // 通过自动拆箱的方式进行比较时
        // 最终运算比较的也只是值的大小
        Integer integer6 = 1;
        Integer integer7 = 1;
        System.out.println(integer6 == integer7);   // true

        // 下面代码包含了隐藏过程
        // 数字1默认属于int类型
        // int类型并不是Object子类
        // 首先将int类型进行装箱变为Integer
        // 然后通过父类引用指向子类对象的方式进行赋值
        Object obj = 1;
        // 其隐藏的完整代码如下
        // int i = 1;
        // Integer integer = new Integer(i);
        // Object obj = integer;

        // 直接写值的时候表示的是int类型
        // 所以此处传递的参数类型是int
        // 最终运行结果:调用了int
        test(1);
        // 如果需要传递Integer类型,此处必须得手动装箱
        test(new Integer(1));
    }

    // 方法重载
    public static void test(int i) {
        System.out.println("调用了int");
    }

    public static void test(Integer i) {
        System.out.println("调用了Integer");
    }

}
