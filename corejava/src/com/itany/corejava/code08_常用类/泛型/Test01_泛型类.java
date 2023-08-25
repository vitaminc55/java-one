package com.itany.corejava.code08_常用类.泛型;

/**
 * @author 石小俊
 * @date 2023年08月25日 14:54
 */
public class Test01_泛型类 {

    public static void main(String[] args) {
        Student<String> student = new Student<String>();
        student.setNo("1");

        Student<Integer> student2 = new Student<>();
        student2.setNo(1);

        Stu stu = new Stu();
        // 当使用Object代替泛型时也可以指定任意类型
        // 但是该方式存在类型转换,缺乏类型安全
        // 有了泛型之后该方式不建议使用
        stu.setNo(1);
        stu.setNo("1");
    }

}

class Student<T> {

    private T no;
    private String name;

    public T getNo() {
        return no;
    }

    public void setNo(T no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Stu {
    private Object no;
    private String name;

    public Object getNo() {
        return no;
    }

    public void setNo(Object no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
