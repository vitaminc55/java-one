package com.itany.corejava.code09_集合.set;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 石小俊
 * @date 2023年08月29日 14:40
 */
public class Test04_判断重复 {
    public static void main(String[] args) {
        Student student = new Student("01", 90.0);
        Student student2 = new Student("01", 80.0);
        Set<Student> students = new HashSet<>();
        students.add(student);
        students.add(student2);
        System.out.println(students);
        System.out.println(student.hashCode());
        System.out.println(student2.hashCode());
    }
}
