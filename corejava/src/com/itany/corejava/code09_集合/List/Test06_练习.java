package com.itany.corejava.code09_集合.List;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author 石小俊
 * @date 2023年08月29日 9:15
 */
public class Test06_练习 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 提示用户输入5名学生的学号和成绩,然后放到ArrayList集合中
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            System.out.println("*******************录入第" + (i + 1) + "名学生信息*******************");
            Student student = new Student();
            System.out.print("请输入学号:");
            student.setNo(sc.next());
            System.out.print("请输入成绩:");
            student.setScore(sc.nextDouble());
            // 将刚刚录入的学生信息添加到集合中
            students.add(student);
        }
        System.out.println("添加后的集合数据:" + students);

        // 1.遍历集合,删除学号为2的学生
        for (int i = 0; i < students.size(); i++) {
            // 取出当前迭代的学生信息
            Student student = students.get(i);
            // 判断该学生的学号是否为2
            if ("2".equals(student.getNo())) {
                // 如果当前学生学号为2,删除该学生
                students.remove(i);
            }
        }
        System.out.println("删除学号为2的学生后的集合数据:" + students);

        // 2.不遍历集合,删除学号为3的学生
        Student student = new Student();
        student.setNo("3");
        // 删除与参数相等的学生信息
        // 在学生类中,重写的equals方法只比较了学号
        // 对于学生而言,只要学号相等,则表示是同一个学生
        students.remove(student);
        System.out.println("删除学号为3的学生后的集合数据:" + students);

        // 3.不遍历集合,判断集合中是否包含学号为5的学生
        Student student5 = new Student();
        student5.setNo("5");
        System.out.println("集合中是否包含学号为5的学生信息:" + students.contains(student5));

    }

}
