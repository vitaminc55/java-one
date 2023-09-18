package com.itany.corejava.code17_设计模式.工厂模式;

import com.itany.corejava.entity.Address;
import com.itany.corejava.entity.User;

import java.util.Date;

/**
 * @author 石小俊
 * @date 2023年09月18日 15:50
 */
public class Test {
    public static void main(String[] args) {
        User user = (User) ObjectFactory.getObject("user");
        User user2 = (User) ObjectFactory.getObject("user");
        System.out.println(user);
        System.out.println(user == user2);  // true
        Address address = (Address) ObjectFactory.getObject("address");
        System.out.println(address);
        Date date = (Date) ObjectFactory.getObject("date");
        Date date2 = (Date) ObjectFactory.getObject("date");
        System.out.println(date == date2);  // true
    }
}
