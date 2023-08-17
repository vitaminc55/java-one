package com.itany.corejava.code07_面向对象.继承;

/**
 * @author 石小俊
 * @date 2023年08月17日 15:19
 */
public class Animate {

    private String name;
    int age;
    protected String gender;
    public double weight;

    private void test01() {
        System.out.println("这是private修饰的方法");
    }

    void test02() {
        System.out.println("这是没有修饰符的方法");
    }

    protected void test03() {
        System.out.println("这是protected修饰的方法");
    }

    public void test04() {
        System.out.println("这是public修饰的方法");
    }

}
