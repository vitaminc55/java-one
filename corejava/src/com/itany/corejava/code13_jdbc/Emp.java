package com.itany.corejava.code13_jdbc;

/**
 * @author 石小俊
 * @date 2023年09月13日 13:32
 */
public class Emp {
    private Integer id;
    private String name;
    private Double salary;
    private Integer deptId;

    public Emp() {
    }

    public Emp(Integer id, String name, Double salary, Integer deptId) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.deptId = deptId;
    }

    public Emp(String name, Double salary, Integer deptId) {
        this.name = name;
        this.salary = salary;
        this.deptId = deptId;
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

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }
}
