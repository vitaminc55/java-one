package com.itany.corejava.code07_面向对象;

/**
 * @author 石小俊
 * @date 2023年08月16日 13:31
 */
public class Test02_练习 {
    public static void main(String[] args) {
        Student student = new Student();
        student.name = "admin";
        student.age = 18;
        student.gender = "男";
        student.major = "计算机科学与技术";
        student.classNo = "wbs23071";

        student.record();
    }
}

class Student {
    String name;
    int age;
    String gender;
    String major;
    String classNo;

    public void record() {
        System.out.println("学生姓名:" + name + ",年龄:" + age + ",性别:" + gender + ",专业:" + major + ",班级:" + classNo);
    }
}
