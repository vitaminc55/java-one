package com.itany.shop.entity;

import java.io.Serializable;

/**
 * @author 黄鹏程
 * @date 2023年09月20日09:50
 */
public class Product implements Serializable {
    private Integer id;
    private String name;
    private Double price;

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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
