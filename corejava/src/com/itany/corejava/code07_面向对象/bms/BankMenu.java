package com.itany.corejava.code07_面向对象.bms;

import java.util.Scanner;

/**
 * @author 石小俊
 * @date 2023年08月21日 15:53
 */
public class BankMenu {
    private Scanner sc = new Scanner(System.in);
    // 银行主菜单要求用户必须成功登录后才能访问
    // 创建一个有参构造方法,参数为Account对象,覆盖默认的无参
    private Account account;

    public BankMenu(Account account) {
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void showMenu() {
        System.out.println("************************欢迎" + account.getName() + "进入银行主菜单************************");
        System.out.print("请选择服务功能(1.存款 2.取款 3.查询余额 4.转账 5.贷款 6.还贷 7.修改密码 8.退出登录):");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                // 存款
                deposit();
                break;
            case 2:
                // 取款
                withdraw();
                break;
            case 3:
                // 查询余额
                queryBalance();
                break;
            case 4:
                // 转账
                transfer();
                break;
            case 5:
                // 贷款
                break;
            case 6:
                // 还贷
                break;
            case 7:
                // 修改密码
                break;
            case 8:
                // 退出登录
                logout();
                break;
            default:
                System.out.println("请输入的选项有误,请重新输入");
                showMenu();
        }
    }

    public void deposit(){
        System.out.println("*******************开始存款*******************");
        System.out.print("请输入存款金额:");
        double money = sc.nextDouble();
        // 调用账户类中的存款方法
        account.deposit(money);
        System.out.println("提示:存款成功!");
        showMenu();
    }

    public void withdraw(){
        System.out.println("*******************开始存款*******************");
        System.out.print("请输入取款金额:");
        double money = sc.nextDouble();
        // 调用取款方法
        boolean flag = account.withdrawMoney(money);
        if(flag){
            System.out.println("提示:取款成功!");
        } else{
            System.out.println("错误:余额不足,取款失败!");
        }
        showMenu();
    }

    public void queryBalance(){
        System.out.println("*******************查询余额*******************");
        System.out.println("您当前账户余额为:"+account.getBalance());
        showMenu();
    }

    public void transfer(){
        System.out.println("*******************开始转账*******************");
        System.out.print("请输入要转入的目标账户的卡号:");
        int id = sc.nextInt();

        // 判断目标账户是否存在
        // 与账户相关的操作由银行实现
        Account targetAccount = Bank.findById(id);
        if(targetAccount == null){
            System.out.println("错误:目标账户不存在!");
        } else{
            // 如果目标账户是存在的,则进行转账功能
            System.out.print("请输入转账的金额:");
            double money = sc.nextDouble();
            // 只有账户余额高于转账金额,才可以转账
            if(account.getBalance() >= money){
                // 当前账户余额减少
                account.setBalance(account.getBalance() - money);
                // 目标账户余额增加
                targetAccount.setBalance(targetAccount.getBalance()+money);
                System.out.println("提示:恭喜您,转账成功!");
            } else{
                System.out.println("错误:对不起,转账失败,您的账户余额不足!");
                System.out.println("您的当前账户余额为:"+account.getBalance());
            }
        }
        showMenu();
    }

    public void logout(){
        System.out.println("提示:成功退出登录!");
        new Start().showMenu();
    }
}
