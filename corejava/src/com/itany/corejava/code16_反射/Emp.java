package com.itany.corejava.code16_反射;

/**
 * @author 石小俊
 * @date 2023年09月18日 10:34
 */
public class Emp {
    @Value("id")
    private String id;
    @Value("name")
    private String name;
    @Value("salary")
    private String salary;

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
