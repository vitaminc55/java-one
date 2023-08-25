package com.itany.corejava.code08_常用类.泛型;

/**
 * @author 石小俊
 * @date 2023年08月25日 15:44
 */
public class Test03_泛型方法 {
    public static void main(String[] args) {
        Student<Integer> student = new Student<>();
        student.setNo(1);
        System.out.println(test(student));

        test02(student);
    }

    public static <T> T test(Student<T> student) {
        T t = student.getNo();
        return t;
    }

    public static <K> void test02(Student<K> student) {
        K k = student.getNo();
        System.out.println(k);
    }
}
