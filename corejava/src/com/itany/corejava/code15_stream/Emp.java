package com.itany.corejava.code15_stream;

import java.util.Arrays;
import java.util.List;

/**
 * @author 石小俊
 * @date 2023年09月15日 16:19
 */
public class Emp {

    private Integer id;
    private String name;
    private Double salary;
    private Dept dept;

    public static List<Emp> getData(){
        Dept d1 = new Dept(1,"董事部");
        Dept d2 = new Dept(2,"研发部");
        Dept d3 = new Dept(3,"市场部");
        Dept d4 = new Dept(4,"财务部");
        Dept d5 = new Dept(5,"安保部");
        Dept d6 = new Dept(6,"人事部");
        Dept d7 = new Dept(7,"后勤部");
        return Arrays.asList(
                new Emp(1,"admin",20000.0,d1),
                new Emp(2,"alice",10000.0,d2),
                new Emp(3,"jack",12000.0,d2),
                new Emp(4,"tom",15000.0,d3),
                new Emp(5,"lily",10000.0,d3),
                new Emp(6,"root",8000.0,d3),
                new Emp(7,"abel",6000.0,d4),
                new Emp(8,"andy",6000.0,d5),
                new Emp(9,"zhangsan",8000.0,d5),
                new Emp(10,"lisi",7000.0,d6),
                new Emp(11,"wangwu",5000.0,d6)
        );
    }

    public Emp(Integer id, String name, Double salary, Dept dept) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.dept = dept;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }
}
