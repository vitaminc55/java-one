package com.itany.corejava.code07_面向对象.多态;

/**
 * @author 石小俊
 * @date 2023年08月18日 9:40
 */
public class Test01_多态简介 {

    public static void main(String[] args) {
        int i = 10;
        long l = 20;
        long l2 = 30L;

        // 对象的多态性,父类Person的引用指向了子类的Man对象
        // 此时的Person是编译时类型,Man是运行时类型
        // Person属于Man的父类
        // 当编译时类型属于运行时类型的父类时,这种场景称之为向上转型,会进行自动类型转换
        Person person = new Man("admin", 18, 9000.0);
        System.out.println(person);
        person.show();

        // 此时,对象无法直接调用子类Man中的独有方法
        // 因此此时对象的引用是属于父类的引用,只能引用父类中存在的方法
        // person.work();
        // 如果想要调用子类独有的方法,必须以子类的类型去执行
        // 即:需要将其转换成子类去执行
        if (person instanceof Man) {
            System.out.println("将person转换成了Man");
            Man man = (Man) person;
            man.work();
        }


        // 此时的person实际类型是Man
        // Man无法转换成WoMan,抛出异常
        // WoMan woMan = (WoMan) person;

        // 重新为person赋值,此时赋值为WoMan可以转换
        person = new WoMan("alice", 20, 99);

        // 向下转型时,转换前需要先进行判断是否可以转换
        // 通过instanceof关键字进行类型判断
        if (person instanceof WoMan) {
            System.out.println("将person转换成了WoMan");
            WoMan woMan = (WoMan) person;
            woMan.shopping();
        }
    }

}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void show() {
        System.out.println("我是一个人,姓名:" + name + ",年龄:" + age);
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

class Man extends Person {
    private double salary;

    public Man(String name, int age, double salary) {
        super(name, age);
        this.salary = salary;
    }

    public void show() {
        System.out.println("我是一个男人,我的名字:" + getName() + ",年龄:" + super.getAge() + ",工资:" + salary);
    }

    public void work() {
        System.out.println("我是一个男人,我需要赚钱养家,每个月收入:" + salary);
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

class WoMan extends Person {
    private int appearance;

    public WoMan(String name, int age, int appearance) {
        super(name, age);
        this.appearance = appearance;
    }

    public void show() {
        System.out.println("我是一个女人,我的姓名:" + getName() + ",年龄:" + getAge() + ",颜值:" + appearance);
    }

    public void shopping() {
        System.out.println("我是一个女人,负责貌美如花,没事逛逛街,购购物");
    }

    public int getAppearance() {
        return appearance;
    }

    public void setAppearance(int appearance) {
        this.appearance = appearance;
    }
}
