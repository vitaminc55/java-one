package com.itany.corejava.code07_面向对象.租车系统;

/**
 * @author 石小俊
 * @date 2023年08月21日 9:24
 */
public class Customer {
    private String name;
    private String phone;

    public Customer() {
    }

    public Customer(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
