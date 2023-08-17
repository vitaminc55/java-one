package com.itany.corejava.code07_面向对象.继承;

/**
 * @author 石小俊
 * @date 2023年08月17日 14:47
 */
public class Person {
    private String name;
    private int age;
    private String gender;

    public void show() {
        System.out.println("我是一个人,我的姓名:" + name + ",年龄:" + age + ",性别:" + gender);
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}

class Man extends Person {
    private double salary;

    public void work() {
        System.out.println("我的一个男人,我需要负责赚钱养家,每个月能赚" + salary + "元");
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

class WoMan extends Person {
    private int appearance; // 颜值范围:0-100

    public void shopping() {
        System.out.println("我是一个女人,我的颜值为:" + appearance + ",我只需要负责貌美如花,没事逛逛街,购购物");
    }

    public int getAppearance() {
        return appearance;
    }

    public void setAppearance(int appearance) {
        this.appearance = appearance;
    }
}

// 使用Cat继承Person,在语法上没有问题,但是两者没有逻辑关系
// 因此在实际开发中不建议出现
class Cat extends Person {
}

class Son extends Man {

}

class SomeClass {

}

class TestPerson {
    public static void main(String[] args) {
        Man man = new Man();
        // 通过父类set方法赋值
        man.setName("张三");
        man.setAge(40);
        man.setGender("男");
        // 调用父类方法
        man.show();

        // 通过子类set方法为子类独有的属性赋值
        man.setSalary(8000.0);
        // 调用子类独有的方法
        man.work();

        System.out.println("******************************");

        WoMan woMan = new WoMan();
        woMan.setName("alice");
        woMan.setAge(30);
        woMan.setGender("女");
        woMan.show();
        woMan.setAppearance(95);
        woMan.shopping();

        System.out.println("******************************");

        // Son继承了Man,Man继承了Person
        // 此时的Son既可以使用Man中的属性与方法
        // 也可以使用Person中的属性与方法
        Son son = new Son();
        son.setName("儿子");
        son.setAge(18);
        son.setGender("男");
        son.setSalary(5000.0);
        son.show();
        son.work();

        System.out.println("******************************");

        // 当一个类没有继承任何类的时候, 默认继承java.lang.Object
        SomeClass sc = new SomeClass();
        System.out.println(sc.hashCode());
        System.out.println(sc.getClass());
    }
}