package com.itany.corejava.code07_面向对象;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * @author 石小俊
 * @date 2023年08月17日 10:10
 */
public class Test10_对象的初始化顺序 {
    public static void main(String[] args) {
        System.out.println("**************对象所在的类被加载**************");
        System.out.println(Product.price);
        System.out.println("**************对象被创建**************");
        Product product = new Product();
        System.out.println(product.name);
        product.price = 7000.0;
        System.out.println(product.price);
        System.out.println("**************第二个对象被创建**************");
        Product product2 = new Product("alice");
        System.out.println(product2.name);
        System.out.println(product2.price);
        System.out.println("**************方法被调用**************");
        product.show();
        Product.print();
    }
}

class Product {
    String name;
    static double price;

    public Product() {
        System.out.println("这是无参构造方法");
    }

    public Product(String name) {
        this.name = name;
        System.out.println("这是有参构造方法");
    }

    {
        System.out.println("代码块");
        name = "admin";
        price = 5000.0;
    }

    static {
        System.out.println("静态代码块");
        // name = "jack"; // 静态代码块无法初始化实例属性
        price = 6000.0;
    }

    public void show() {
        System.out.println("这是一个实例方法");
    }

    public static void print() {
        System.out.println("这是静态方法");
    }

}
