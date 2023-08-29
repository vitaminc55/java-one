package com.itany.corejava.code09_集合.set;

import java.util.Objects;

/**
 * @author 石小俊
 * @date 2023年08月29日 14:39
 */
public class Student {

    private String no;
    private Double score;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(no, student.no);
    }

    @Override
    public int hashCode() {
        return Objects.hash(no);
    }

    @Override
    public String toString() {
        return "Student{" +
                "no='" + no + '\'' +
                ", score=" + score +
                '}';
    }

    public Student() {
    }

    public Student(String no, Double score) {
        this.no = no;
        this.score = score;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}
