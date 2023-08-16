package com.itany.corejava.code07_面向对象;

/**
 * @author 石小俊
 * @date 2023年08月16日 13:35
 */
public class Test03_全局变量与局部变量 {
    public static void main(String[] args) {
        System.out.println("**************第一个对象**************");
        Account account = new Account();
        account.name = "admin";
        account.money = 5000;
        account.show("alice");
        System.out.println("全局变量name:" + account.name);
        System.out.println("全局变量money:" + account.money);

        System.out.println("**************第二个对象**************");
        Account account2 = new Account();
        account2.name = "jack";
        account2.money = 8000;
        account2.show("tom");
        System.out.println("全局变量name:" + account2.name);
        System.out.println("全局变量money:" + account2.money);
    }
}

class Account {
    // 全局变量
    String name;
    double money;

    // 方法的参数name属于局部变量
    // 该变量只能在当前方法中使用
    public void show(String name) {
        // 方法中定义的变量也属于局部变量
        // 该变量只能在当前方法中使用
        double money = 10000;
        // 当全局变量与局部变量重名时
        // 此时默认访问的是局部变量
        System.out.println("局部变量name:" + name);
        System.out.println("局部变量money:" + money);
        // 访问全局变量
        System.out.println("全局变量name:" + this.name);
        System.out.println("全局变量money:" + this.money);
    }
}
