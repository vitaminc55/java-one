package com.itany.corejava.code13_jdbc;

import java.io.Serializable;

/**
 * @author 石小俊
 * @date 2023年09月13日 9:11
 */
public class Student implements Serializable {
    private Integer id;
    private String no;
    private String name;
    private Integer age;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", no='" + no + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Student(Integer id, String no, String name, Integer age) {
        this.id = id;
        this.no = no;
        this.name = name;
        this.age = age;
    }

    public Student(String no, String name, Integer age) {
        this.no = no;
        this.name = name;
        this.age = age;
    }

    public Student() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
