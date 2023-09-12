package com.itany.corejava.code13_jdbc;

import java.io.Serializable;

/**
 * @author 石小俊
 * @date 2023年09月12日 10:09
 * 实体类
 * 实现JDBC操作的时候,如果要操作对应的某张表
 * 一般会创建一个与表对应的实体类
 * 该类的属性与表中的字段一一对应
 */
public class User implements Serializable {
    private Integer id;
    private String username;
    private String password;
    private String phone;
    private String address;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public User(Integer id, String username, String password, String phone, String address) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.address = address;
    }

    public User(String username, String password, String phone, String address) {
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.address = address;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
