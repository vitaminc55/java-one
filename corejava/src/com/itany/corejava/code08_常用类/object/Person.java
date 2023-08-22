package com.itany.corejava.code08_常用类.object;

import java.util.Objects;

/**
 * @author 石小俊
 * @date 2023年08月22日 14:42
 */
public class Person implements Cloneable{
    private String name;
    private int age;
    private Address address;

    @Override
    protected void finalize() throws Throwable {
        System.out.println("正在回收垃圾");
        super.finalize();
    }

    public Person(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address=" + address +
                '}';
    }
//    @Override
//    public String toString() {
//        return "Person{name=" + name + ",age=" + age + "}";
//    }

    //    /**
//     * 重写equals方法,用于比较Person对象的name属性值与age属性值是否相等
//     * 如果比较的是Person中的name属性值与age属性值,那么比较的方法的参数必须是Person类型
//     * 如果类型不同,直接返回false即可
//     * @param obj
//     * @return
//     */
//    @Override
//    public boolean equals(Object obj) {
//        // 判断当前方法参数是否是Person类型
//        // if(obj.getClass() == Person.class){}
//        if (obj instanceof Person) {
//            // 如果参数是Person,则向下转型为Person类型
//            Person person = (Person) obj;
//            // 当name属性与age属性值都相等时返回true
//            return this.name.equals(person.getName()) && this.age == person.getAge();
//        }
//        // 如果参数不是Person,类型不一致,直接返回false
//        return false;
//    }


    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void show() {
        System.out.println("我是一个人");
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