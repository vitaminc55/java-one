package com.itany.corejava.code16_反射;

import java.io.Serializable;

/**
 * @author 石小俊
 * @date 2023年09月15日 13:46
 */
public class User extends Person implements Serializable {

    public String username;
    private String password;

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username) {
        this.username = username;
    }

    public String sayHello(){
        return "Hello World";
    }

    public int sum(int i, int j){
        return i + j;
    }

    private void test(){
        System.out.println("这是private修饰的测试方法");
    }

}
