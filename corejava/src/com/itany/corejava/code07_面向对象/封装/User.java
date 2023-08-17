package com.itany.corejava.code07_面向对象.封装;

/**
 * @author 石小俊
 * @date 2023年08月17日 11:14
 */
public class User {

    private int id;
    private String username;
    private String password;
    // 用户是否有效
    private boolean status;

    // 赋值方法
    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    // 取值方法
    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean getStatus() {
        return status;
    }

    public boolean isStatus() {
        return status;
    }
}
