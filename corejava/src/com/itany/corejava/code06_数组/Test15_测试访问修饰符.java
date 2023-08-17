package com.itany.corejava.code06_数组;

import com.itany.corejava.code07_面向对象.Employee;

/**
 * @author 石小俊
 * @date 2023年08月17日 9:36
 */
public class Test15_测试访问修饰符 extends Employee{

    public void test(){
        Employee emp = new Employee(1,"admin",8000.0,"男");
        // 不同包且是子类的情况下,public与protected修饰的变量与方法才能访问
        // protected访问时必须通过super关键直接调用父类中的属性与方法
        // System.out.println(emp.id);
        // System.out.println(emp.name);
        System.out.println(super.salary);
        System.out.println(emp.gender);
        // emp.test01();
        // emp.test02();
        super.test03();
        emp.test04();
    }
}
