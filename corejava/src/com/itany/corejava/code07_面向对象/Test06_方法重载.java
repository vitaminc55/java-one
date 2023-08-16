package com.itany.corejava.code07_面向对象;

/**
 * @author 石小俊
 * @date 2023年08月16日 15:46
 */
public class Test06_方法重载 {

    public static void main(String[] args) {
        Calculator c = new Calculator();
        System.out.println(c.add(1, 2));
        System.out.println(c.add(1, 2, 3));
        System.out.println(c.add(1.2, 2.3));
        System.out.println(c.add(1.2, 2));
        System.out.println(c.add(1, 2.1));
    }


}

class Calculator {
    public int add(int i, int j) {
        return i + j;
    }

    public int add(int i, int j, int k) {
        return i + j + k;
    }

    public double add(double i, double j) {
        return i + j;
    }

    public double add(double i, int j) {
        return i + j;
    }

    public double add(int j, double i) {
        return i + j;
    }

    public double add(double i, int j, int k) {
        return i + j + k;
    }
}
