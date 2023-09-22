package com.itany.shop.vo;

import com.itany.shop.entity.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 黄鹏程
 * @date 2023年09月20日16:58
 */
public class Cart {
    private List<Item> items;

    private Double price;

    public Cart() {
        items=new ArrayList<>();
        price=0.0;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void addItem(Item item) {
        items.add(item);
    }
    public void delete(Item item){
        items.remove(item);
    }
    public void deleteAll(){
        items.clear();
    }
}
