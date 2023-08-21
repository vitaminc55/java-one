package com.itany.corejava.code07_面向对象.bms;

/**
 * @author 石小俊
 * @date 2023年08月21日 13:31
 * 账户类 抽象类
 */
public abstract class Account {

    // 定义一个初始的账户卡号值
    // 要求所有账户共用该变量,因此设置为静态变量
    private static int currentId = 1000;

    private int id;
    private String name;
    private String password;
    private String personId;
    private String phone;
    private double balance;

    /**
     * 存款方法,不允许被子类重写
     * @param money
     */
    public final void deposit(double money){

    }

    public abstract boolean withdrawMoney(double money);

    public Account() {
        // 自动生成。初始值1000,每次新开户的卡号自增1。例如:1000、1001、1002...
        // 在构造方法中去生成账户编号
        this.id = currentId++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
