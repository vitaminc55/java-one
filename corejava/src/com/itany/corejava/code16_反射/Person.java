package com.itany.corejava.code16_反射;

/**
 * @author 石小俊
 * @date 2023年09月15日 14:04
 */
public class Person {
    private Integer id;
    public String phone;
    private String address;

    public Person() {
    }

    public Person(Integer id, String phone, String address) {
        this.id = id;
        this.phone = phone;
        this.address = address;
    }

    public void show() {
        System.out.println("这是Person中public修饰的方法");
    }

    private int add(int i, int j) {
        return i + j;
    }
}
