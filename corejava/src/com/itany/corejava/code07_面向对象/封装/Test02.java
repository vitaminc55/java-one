package com.itany.corejava.code07_面向对象.封装;

/**
 * @author 石小俊
 * @date 2023年08月17日 11:49
 */
public class Test02 {

    public static void main(String[] args) {
        Employee emp = new Employee("admin",5000.0,"男",8);
        emp.show();
        System.out.println(emp.getAge());
    }

}
