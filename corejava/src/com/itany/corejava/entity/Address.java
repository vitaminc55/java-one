package com.itany.corejava.entity;

import com.itany.corejava.code17_设计模式.工厂模式.ObjectFactory;

import java.util.Date;

/**
 * @author 石小俊
 * @date 2023年09月18日 15:39
 */
public class Address {
    private String province;
    private String city;
    private Date date = (Date) ObjectFactory.getObject("date");

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
