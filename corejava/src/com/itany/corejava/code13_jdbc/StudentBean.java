package com.itany.corejava.code13_jdbc;

import java.io.Serializable;

/**
 * @author 石小俊
 * @date 2023年09月14日 9:34
 */
public class StudentBean implements Serializable {

    private Integer id;
    private String no;
    private String name;
    private Integer age;
    private ClassBean classBean;

    @Override
    public String toString() {
        return "StudentBean{" +
                "id=" + id +
                ", no='" + no + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", classBean=" + classBean +
                '}';
    }

    public StudentBean() {
    }

    public StudentBean(String no, String name, Integer age) {
        this.no = no;
        this.name = name;
        this.age = age;
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

    public ClassBean getClassBean() {
        return classBean;
    }

    public void setClassBean(ClassBean classBean) {
        this.classBean = classBean;
    }
}
