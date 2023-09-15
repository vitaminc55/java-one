package com.itany.corejava.code16_反射;

/**
 * @author 石小俊
 * @date 2023年09月15日 14:04
 */
public class Person {
    private Integer id;
    private String phone;
    private String address;

    public Person() {
    }

    public Person(Integer id, String phone, String address) {
        this.id = id;
        this.phone = phone;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
