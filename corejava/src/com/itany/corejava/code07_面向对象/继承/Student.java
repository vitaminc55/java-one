package com.itany.corejava.code07_面向对象.继承;

/**
 * @author 石小俊
 * @date 2023年08月17日 15:28
 */
public class Student {

    private String name;
    private int age;

    public Student() {
        System.out.println("这是父类构造方法");
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class College extends Student {
    private String phone;

    public College() {
        super(); // 可以省略
        System.out.println("这是子类构造方法");
    }

    public College(String name, int age, String phone) {
        super(name, age);
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

class TestCollege {
    public static void main(String[] args) {
        College college = new College();
    }
}
