package com.itany.corejava.code07_面向对象;

/**
 * @author 石小俊
 * @date 2023年08月17日 9:30
 */
public class Test09_访问修饰符 {
    public static void main(String[] args) {
        Employee emp = new Employee(1, "admin", 8000.0, "男");
        // System.out.println(emp.id); // 无法访问private修饰的变量
        System.out.println(emp.name);
        System.out.println(emp.salary);
        System.out.println(emp.gender);
        // emp.test01(); // 无法访问private修饰的方法
        emp.test02();
        emp.test03();
        emp.test04();
    }
}

