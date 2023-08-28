package com.itany.corejava.code08_常用类.内部类;

/**
 * @author 石小俊
 * @date 2023年08月28日 10:09
 */
public class Test01_成员内部类 {

    public static void main(String[] args) {
        // 在非外部类中实例化内部类
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
        outer.show();
        inner.show();
        System.out.println(inner.getName());
        System.out.println(inner.gender);
    }

}

class Outer {
    private String name = "admin";
    private int age = 20;

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

    public void show() {
        System.out.println("这是外部类的方法");
        // 在外部类中实例化内部类,直接进行实例化操作即可
        Inner inner = new Inner();
        inner.setGender("女");
        System.out.println(inner.name);
        System.out.println(inner.gender);
        inner.test();
    }

    private void test() {
        System.out.println("这是外部类private修饰的方法");
    }

    private void test02() {
        System.out.println("这是外部类private修饰的方法");
    }

    // 在一个类中定义一个成员内部类
    class Inner {
        private String name = "alice";
        protected String gender;

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
            System.out.println("这是内部类的方法");
            // 内部类访问外部类属性,可以直接访问
            // 但是如果存在重名属性,默认访问的是内部类属性
            System.out.println(name);
            System.out.println(age);
            // 如果想要直接访问外部类属性,需要通过外部类对象来访问
            Outer outer = new Outer();
            System.out.println("外部类name:" + outer.name);
            // 还可以通过类名.this.属性名来访问
            System.out.println("外部类name:" + Outer.this.name);
            // 访问方法
            test();
            test02();
            outer.test();
            Outer.this.test();
        }

        private void test() {
            System.out.println("这是内部类中private修饰的方法");
        }
    }

}
