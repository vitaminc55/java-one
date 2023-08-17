package com.itany.corejava.code07_面向对象.封装;

import java.util.EnumMap;

/**
 * @author 石小俊
 * @date 2023年08月17日 11:45
 */
public class Employee {
    private String name;
    private double salary;
    private String gender;
    private int age;

    public Employee() {

    }

    public Employee(String gender) {
        this.gender = gender;
    }

    public Employee(String name, double salary, String gender, int age) {
        this.name = name;
        this.salary = salary;
        this.gender = gender;
        this.age = age;
    }

    // 赋值方法
    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // 取值方法
    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        if (age < 18) {
            return 18;
        }
        return age;
    }

    public void show() {
        System.out.println("姓名:" + name + ",工资:" + salary + ",性别:" + gender + ",年龄:" + age);
    }

    public void work() {
        System.out.println(name + "正在努力的工作");
    }
}
