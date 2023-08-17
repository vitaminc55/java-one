package com.itany.corejava.code07_面向对象;

/**
 * @author 石小俊
 * @date 2023年08月17日 9:31
 */
public class Employee {
    private int id;
    String name;
    protected double salary;
    public String gender;

    public Employee() {
    }

    public Employee(int id, String name, double salary, String gender) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.gender = gender;
    }

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

    public static void main(String[] args) {
        Employee emp = new Employee(1, "admin", 8000.0, "男");
        System.out.println(emp.id);
        System.out.println(emp.name);
        System.out.println(emp.salary);
        System.out.println(emp.gender);
        emp.test01();
        emp.test02();
        emp.test03();
        emp.test04();
    }
}
