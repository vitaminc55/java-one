package com.itany.corejava.code07_面向对象.bms;

import java.util.Scanner;

/**
 * @author 石小俊
 * @date 2023年08月21日 13:45
 * 系统入口
 */
public class Start {
    private Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Start start = new Start();
        start.showMenu();
        // new Start().showMenu();
    }

    public void showMenu() {

        System.out.println("*********************欢迎进入银行系统*********************");
        System.out.print("请选择对应的服务(1.开户 2.登录):");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                // 实现开户
                register();
                break;
            case 2:
                // 实现登录
                login();
                break;
            default:
                System.out.println("您输入的选项有误,请重新输入!");
                showMenu();
                break;
        }
    }

    public void register() {
        System.out.print("请选择开户的账户类型(1.储蓄账户 2.信用账户 3.贷款的储蓄账户 4.贷款的信用账户):");
        int choice = sc.nextInt();
        Account account = null;
        switch (choice) {
            case 1:
                account = new SavingAccount();
                break;
            case 2:
                account = new CreditAccount();
                break;
            case 3:
                account = new LoanSavingAccount();
                break;
            case 4:
                account = new LoanCreditAccount();
                break;
            default:
                System.out.println("您输入的选项有误,请重新输入");
                register();
        }
        // 输入姓名、密码、身份证号码、手机号码
        System.out.print("请输入开户户主姓名:");
        account.setName(sc.next());
        // 密码需要输入两次,两次必须一致
        // 如果两次输入的密码不一致,则重新输入,一直到一致为止
        while (true){
            System.out.print("请输入密码:");
            String password = sc.next();
            System.out.print("请再次输入密码:");
            String password2 = sc.next();
            // 判断两次输入的密码是否一致
            if(password.equals(password2)){
                // 如果一致,则设置密码
                account.setPassword(password);
                // 退出循环
                break;
            } else{
                // 如果不一致,则重新输入
                System.out.println("错误:两次输入的密码不一致,请重新输入!");
            }
        }

        System.out.print("请输入身份证号码:");
        account.setPersonId(sc.next());
        System.out.print("请输入手机号码:");
        account.setPhone(sc.next());
        // 账户余额初始为0
        // 账户中余额的默认值本身就是0.0,可以不设置

        // 如果是信用账户或者贷款的信用账户,需要设置透支额度
        // 向下转型
        if(account instanceof CreditAccount){
            // 设置信用额度
            // 信用额度的属性只有信用账户与贷款的信用账户存在
            // 可以将当前账户转换成信用账户,信用账户是贷款的信用账户的父类
            CreditAccount creditAccount = (CreditAccount) account;
            System.out.print("请输入信用额度:");
            creditAccount.setLimit(sc.nextDouble());
        }

        // 信息全部输入完成之后,需要保存到银行系统
        // 因此,调用银行类中提供的开户功能实现开户
        boolean flag = Bank.register(account);
        if(flag){
            // 成功
            System.out.println("提示:恭喜您,开户成功,您的账户号为:" + account.getId());
        } else{
            // 失败
            System.out.println("错误:对不起,开户失败!");
        }
        showMenu();
    }

    public void login() {
        // 输入卡号与密码
        System.out.print("请输入账户卡号:");
        int id = sc.nextInt();
        System.out.print("请输入账户密码:");
        String password = sc.next();
        // 根据银行提供的登录方法,判断是否登录成功
        Account account = Bank.login(id,password);
        if(account != null){
            // 如果登录成功,则进入到银行主菜单
            System.out.println("提示:恭喜您,成功成功,进入银行主菜单");
            new BankMenu(account).showMenu();
        }else{
            // 如果登录失败,返回系统入口重新登录
            System.out.println("错误:卡号或密码错误!");
            showMenu();
        }
    }

}
