package com.itany.corejava.entity;

import com.itany.corejava.code17_设计模式.工厂模式.ObjectFactory;

/**
 * @author 石小俊
 * @date 2023年09月18日 15:38
 */
public class User {
    private Integer id;
    private String username;
    private String password;
    private Address address = (Address) ObjectFactory.getObject("address");


    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
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
}
