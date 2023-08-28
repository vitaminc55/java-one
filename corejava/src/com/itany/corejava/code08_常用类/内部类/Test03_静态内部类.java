package com.itany.corejava.code08_常用类.内部类;


import com.itany.corejava.code08_常用类.内部类.SomeOuter.SomeInner;

/**
 * @author 石小俊
 * @date 2023年08月28日 11:25
 */
public class Test03_静态内部类 {

    public static void main(String[] args) {
        // 方式一: 将外部类.内部类 当做一个类名进行实例化
        // SomeOuter.SomeInner someInner = new SomeOuter.SomeInner();
        // 方式二:手动导包, 将外部类.内部类 作为类名进行导包, 然后直接使用内部类
        SomeInner someInner = new SomeInner();
        someInner.show();
    }

}

class SomeOuter {
    private String name = "admin";
    private int age = 18;
    private static String phone = "13812345678";

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

    private void test() {
        System.out.println("这是private修饰的test方法");
    }

    private static void test2() {
        System.out.println("这是private修饰的test2静态方法");
    }

    public void show() {
        System.out.println("***************外部类方法***************");
        SomeInner someInner = new SomeInner();
        System.out.println(someInner.name);
        System.out.println(someInner.gender);
    }

    // 定义静态内部类
    static class SomeInner {
        private String name = "alice";
        private String gender = "女";

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public void show() {
            System.out.println("***************内部类方法***************");
            System.out.println(name);
            // 无法访问外部类的普通属性。只能访问static修饰的属性
            // System.out.println(age); // 报错
            System.out.println(phone);
            SomeOuter outer = new SomeOuter();
            System.out.println(outer.age);
            outer.test();
            test2();
        }
    }
}