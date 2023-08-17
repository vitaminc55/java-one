package com.itany.corejava.code06_数组;

import com.itany.corejava.code07_面向对象.Employee;

/**
 * @author 石小俊
 * @date 2023年08月17日 9:40
 */
public class Test16_测试访问修饰符 {
    public static void main(String[] args) {
        Employee emp = new Employee(1,"admin",8000.0,"男");
        // 不同包且不是子类的情况下,只有public修饰的变量与方法才能访问
        // System.out.println(emp.id);
        // System.out.println(emp.name);
        // System.out.println(emp.salary);
        System.out.println(emp.gender);
        // emp.test01();
        // emp.test02();
        // emp.test03();
        emp.test04();
    }
}
