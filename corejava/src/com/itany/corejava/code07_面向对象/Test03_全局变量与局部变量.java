package com.itany.corejava.code07_面向对象;

import java.util.Scanner;

/**
 * @author 石小俊
 * @date 2023年08月16日 13:35
 */
public class Test03_全局变量与局部变量 {
    public static void main(String[] args) {
//        System.out.println("**************第一个对象**************");
//        Account account = new Account();
//        account.name = "admin";
//        account.money = 5000;
//        account.show("alice");
//        System.out.println("全局变量name:" + account.name);
//        System.out.println("全局变量money:" + account.money);
//
//        System.out.println("**************第二个对象**************");
//        Account account2 = new Account();
//        account2.name = "jack";
//        account2.money = 8000;
//        account2.show("tom");
//        System.out.println("全局变量name:" + account2.name);
//        System.out.println("全局变量money:" + account2.money);

        Account account = new Account();
        account.name = "admin";
        account.money = 5000;
        account.showMenu();
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

    /**
     * 查询余额,打印出户主姓名与账户余额
     */
    public void queryMoney() {
        System.out.println("姓名:" + name + ",当前账户余额:" + money);
    }

    /**
     * 存钱,打印存储了多少钱,存储后账户余额
     * @param money
     */
    public void saveMoney(double money) {
        this.money += money;
        System.out.println("您存储了" + money + "元,当前账户余额:" + this.money);
    }

    /**
     * 转账,打印谁给你转账,转了多少钱,转账后账户余额是多少
     * @param name
     * @param money
     */
    public void transfer(String name, double money) {
        this.money += money;
        System.out.println(name + "向您转换" + money + "元,转账后余额为:" + this.money);
    }

    /**
     * 取钱,打印取出了多少钱,剩余的账户余额是多少
     * @param money
     */
    public void getMoney(double money) {
        if (money > this.money) {
            System.out.println("您当前账户余额不足,取款失败!");
        } else {
            this.money -= money;
            System.out.println("您提取了" + money + "元,剩余账户余额为:" + this.money);
        }
    }

    public void showMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("********************************************");
        System.out.println("欢迎使用账户管理系统,系统将提供以下功能:1.查询余额 2.存款 3.转账 4.取款 5.退出");
        while (true) {
            System.out.println("********************************************");
            System.out.print("请选择您需要办理的业务(1-5):");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    queryMoney();
                    break;
                case 2:
                    System.out.print("请输入您需要存储的金额:");
                    double money = sc.nextDouble();
                    saveMoney(money);
                    break;
                case 3:
                    System.out.print("谁正在办理转账:");
                    String name = sc.next();
                    System.out.print("请输入转账金额:");
                    money = sc.nextDouble();
                    transfer(name, money);
                    break;
                case 4:
                    System.out.print("请输入取款金额:");
                    money = sc.nextDouble();
                    getMoney(money);
                    break;
                case 5:
                    System.out.println("您已经退出,欢迎下次光临");
                    return;
                default:
                    System.out.println("您选择的选项有误,请重新输入");
                    break;
            }
        }
    }
}
