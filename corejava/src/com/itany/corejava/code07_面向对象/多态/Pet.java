package com.itany.corejava.code07_面向对象.多态;

import java.util.Scanner;

/**
 * @author 石小俊
 * @date 2023年08月18日 11:48
 */
public class Pet {

    private String name;
    private String gender;

    public void show() {
        System.out.println("我是一只宠物,我的名字叫做:" + name + ",性别:" + gender);
    }

    public Pet(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }

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
}

class Dog extends Pet {
    private int age;

    public void show() {
        System.out.println("我是一只宠物狗,我的名字叫做:" + getName() + ",性别:" + getGender() + "年龄:" + age);
    }

    public Dog(String name, String gender, int age) {
        super(name, gender);
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class Cat extends Pet {
    private String type;

    public void show() {
        System.out.println("我是一只宠物猫,我的名字叫做:" + getName() + ",性别:" + getGender() + "品种:" + type);
    }

    public Cat(String name, String gender, String type) {
        super(name, gender);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

class Pig extends Pet {
    private String hobby;

    public void show() {
        System.out.println("我是一只宠物猪,我的名字叫做:" + getName() + ",性别:" + getGender() + "爱好:" + hobby);
    }

    public Pig(String name, String gender, String hobby) {
        super(name, gender);
        this.hobby = hobby;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
}

class TestPet {
    public static void main(String[] args) {
        showMeun();
    }

    public static void showMeun() {
        Scanner sc = new Scanner(System.in);
        System.out.println("***********************欢迎来到有一家宠物店***********************");
        System.out.print("请选择想要领养的宠物类型(1.狗狗 2.猫咪 3.猪猪):");
        int choice = sc.nextInt();
        // 不管领养的宠物是什么,都通过父类Pet的引用去定义
        Pet pet = null;
        switch (choice) {
            case 1:
                System.out.print("请为您即将领养的宠物取一个昵称:");
                String name = sc.next();
                System.out.print("请输入您需要领养的宠物性别:");
                String gender = sc.next();
                System.out.print("请输入领养的狗狗的年龄:");
                int age = sc.nextInt();
                pet = new Dog(name, gender, age);
                pet.show();
                break;
            case 2:
                System.out.print("请为您即将领养的宠物取一个昵称:");
                name = sc.next();
                System.out.print("请输入您需要领养的宠物性别:");
                gender = sc.next();
                System.out.print("请输入领养的猫咪的品种:");
                String type = sc.next();
                pet = new Cat(name, gender, type);
                pet.show();
                break;
            case 3:
                System.out.print("请为您即将领养的宠物取一个昵称:");
                name = sc.next();
                System.out.print("请输入您需要领养的宠物性别:");
                gender = sc.next();
                System.out.print("请输入领养的猪猪的爱好:");
                String hobby = sc.next();
                pet = new Pig(name, gender, hobby);
                pet.show();
                break;
            default:
                System.out.println("您输入的选项有误,请重新输入");
                showMeun();
                break;
        }
    }
}
