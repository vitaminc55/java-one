package com.itany.corejava.code13_jdbc;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 石小俊
 * @date 2023年09月14日 9:33
 */
public class ClassBean implements Serializable {

    private Integer id;
    private String no;
    private String major;
    private List<StudentBean> students = new ArrayList<>();

    @Override
    public String toString() {
        return "ClassBean{" +
                "id=" + id +
                ", no='" + no + '\'' +
                ", major='" + major + '\'' +
                ", students=" + students +
                '}';
    }


    public void addStudent(StudentBean student){
        students.add(student);
    }

    public List<StudentBean> getStudents() {
        return students;
    }

    public void setStudents(List<StudentBean> students) {
        this.students = students;
    }

    public ClassBean() {
    }

    public ClassBean(String no, String major) {
        this.no = no;
        this.major = major;
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

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
