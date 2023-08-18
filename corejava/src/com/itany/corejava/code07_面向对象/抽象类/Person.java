package com.itany.corejava.code07_面向对象.抽象类;

/**
 * @author 石小俊
 * @date 2023年08月18日 14:36
 */
public abstract class Person {
    private String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void show();

}
class Man extends Person{
    private double salary;

    public Man(String name, double salary) {
        super(name);
        this.salary = salary;
    }

    public void show(){
        System.out.println("我是一个男人");
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
abstract class WoMan extends Person{

}
class TestPerson{
    public static void main(String[] args) {
//        Person person = new Person();
        Person person = new Man("admin",8000.0);
    }
}