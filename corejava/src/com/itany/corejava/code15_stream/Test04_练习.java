package com.itany.corejava.code15_stream;

import java.util.List;

/**
 * @author 石小俊
 * @date 2023年09月15日 16:21
 */
public class Test04_练习 {

    private static List<Emp> emps = Emp.getData();

    /**
     * 找出所有员工,并按工资升序排序,打印出员工姓名与工资
     */
    public static void test01() {
        emps.stream()
                .sorted((a, b) -> (int) (a.getSalary() - b.getSalary()))
                .forEach(e -> System.out.println("姓名:" + e.getName() + ",工资:" + e.getSalary()));
    }

    /**
     * 找出所有研发部员工,按照工资降序排序,打印出员工姓名、工资、部门
     */
    public static void test02() {
        emps.stream()
                .filter(e -> e.getDept().getName().equals("研发部"))
                .sorted((a, b) -> (int) (b.getSalary() - a.getSalary()))
                .forEach(e -> System.out.println("姓名:" + e.getName() + ",工资:" + e.getSalary() + ",部门:" + e.getDept().getName()));
    }

    /**
     * 找出员工都属于哪些部门
     */
    public static void test03() {
        emps.stream()
                .map(e -> e.getDept().getName())
                .distinct()
                .forEach(System.out::println);
    }

    /**
     * 输出最高工资的员工信息
     */
    public static void test04() {
        Double maxSalary = emps.stream()
                .map(e -> e.getSalary())
                .max((a, b) -> (int) (a - b))
                .get();
        emps.stream()
                .filter(e -> e.getSalary() == maxSalary)
                .forEach(e -> System.out.println("姓名:" + e.getName() + ",工资:" + e.getSalary() + ",部门:" + e.getDept().getName()));
    }

    /**
     * 输出最低工资的员工信息
     */
    public static void test05() {
        Double minSalary = emps.stream()
                .map(e -> e.getSalary())
                .min((a, b) -> (int) (a - b))
                .get();
        emps.stream()
                .filter(e -> e.getSalary() == minSalary)
                .forEach(e -> System.out.println("姓名:" + e.getName() + ",工资:" + e.getSalary() + ",部门:" + e.getDept().getName()));
    }

    /**
     * 输出员工的平均工资
     */
    public static void test06() {
        // 先计算出所有员工的工资之和
        Double sumSalary = emps.stream()
                .map(e -> e.getSalary())
                .reduce(Double::sum)
                .get();

        // 计算员工总人数
        long count = emps.stream().count();
        System.out.println("员工平均工资:" + sumSalary / count);
    }

    /**
     * 在每一个员工姓名前加前缀itany_
     */
    public static void test07() {
        emps.stream()
                .map(e -> "itany_" + e.getName())
                .forEach(System.out::println);
    }
}
