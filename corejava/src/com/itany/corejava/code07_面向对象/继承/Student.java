package com.itany.corejava.code07_面向对象.继承;

/**
 * @author 石小俊
 * @date 2023年08月17日 15:28
 */
public class Student {

    String name;
    int age;

    public void test() {
        System.out.println("这是父类中的测试方法");
    }

    public Student() {
        System.out.println("这是父类构造方法");
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student(String name) {
        this.name = name;
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

class College extends Student {
    private String phone;

    public College() {
        super(); // 可以省略
        System.out.println("这是子类构造方法");
    }

    public College(String name, int age, String phone) {
        super(name, age);
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

class TestCollege {
    public static void main(String[] args) {
        College college = new College();
    }
}

class Middle extends Student {
    private String name;
    private String gender;

    public Middle() {
    }

    public Middle(String name, int age, String gender) {
        super(name, age);
        this.gender = gender;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void test() {
        System.out.println("这是子类中的测试方法");
    }

    public void show() {
        System.out.println("name:" + super.name);
        // 当子类属性没有与父类属性重名时,super可以省略
        System.out.println("age:" + age);
        // 当重名时,默认访问的是子类的属性
        System.out.println("name:" + name);
        System.out.println("gender:" + gender);

        // 调用父类方法,如果没有重名的,直接写方法名
        this.test();
        super.test();
    }
}

class TestMiddle {
    public static void main(String[] args) {
        Middle middle = new Middle("学生", 18, "男");
        middle.setName("中学生");
        middle.show();

    }
}

