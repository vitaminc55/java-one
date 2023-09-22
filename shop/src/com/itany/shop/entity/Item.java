package com.itany.shop.entity;

import java.io.Serializable;

/**
 * @author 黄鹏程
 * @date 2023年09月20日16:50
 */
public class Item implements Serializable {

    private Integer id;
    private Product product;
    private Integer num;
    private Double price;
    private Order order;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
