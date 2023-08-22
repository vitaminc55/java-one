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
        System.out.print("请选择服务功能(1.存款 2.取款 3.查询余额 4.转账 5.贷款 6.还贷 7.查询贷款 8.修改密码 9.退出登录):");
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
                providerLoan();
                break;
            case 6:
                // 还贷
                payLoan();
                break;
            case 7:
                // 查询贷款
                queryLoan();
                break;
            case 8:
                // 修改密码
                modifyPassword();
                break;
            case 9:
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


    public void providerLoan(){
        System.out.println("*******************开始贷款*******************");
        // 只有贷款账户能够实现贷款的相关功能
        // 贷款账户只有两种:贷款的储蓄账户、贷款的信用账户
        // 这两种账户均实现了Loanable接口
        // 在进行判断时,可以直接使用Loanable进行判断
        // Loanable loanable = new LoanSavingAccount();
        // Loanable loanable2 = new LoanCreditAccount();
        if(account instanceof Loanable){
            System.out.print("请输入贷款金额:");
            double money = sc.nextDouble();
            // 贷款方法只有Loanable接口对应的实现类可以调用
            // 因此,需要先将当前账户向下转型,转换成Loanable
            Loanable loanable = (Loanable) account;
            // 调用贷款方法
            loanable.providerLoan(money);
            System.out.println("提示:恭喜您,贷款成功!");
        } else{
            System.out.println("错误:对不起,您的账户不是贷款账户类型,无法申请贷款!");
        }
        showMenu();
    }

    public void payLoan(){
        System.out.println("*******************开始还款*******************");
        // 只有贷款相关账户可以操作还贷功能
        if(account instanceof Loanable){
            Loanable loanable = (Loanable) account;
            System.out.print("请输入需要还贷的金额:");
            double money = sc.nextDouble();
            // 调用还贷方法
            boolean flag = loanable.payLoan(money);
            if(flag){
                System.out.println("提示:恭喜您,还贷成功!");
            } else{
                System.out.println("错误:对不起,您的账户余额不足,还贷失败,您的当前余额为:"+ account.getBalance());
            }
        }else{
            System.out.println("错误:对不起,您的账户不是贷款账户类型,无法申请还贷!");
        }
        showMenu();
    }

    public void queryLoan(){
        System.out.println("*******************查询贷款*******************");
        // 只有贷款账户可以操作贷款相关功能
        if(account instanceof Loanable){
            Loanable loanable = (Loanable) account;
            System.out.println("提示:您的贷款总金额为:"+loanable.queryLoan());
        } else{
            System.out.println("错误:对不起,您的账户不是贷款账户类型,无法查询贷款!");
        }
        showMenu();
    }

    public void modifyPassword(){
        System.out.println("*******************修改密码*******************");
        System.out.print("请输入原密码:");
        String oldPassword = sc.next();
        // 判断原密码是否正确
        if(oldPassword.equals(account.getPassword())){
            // 如果原密码输入正确,则可以修改密码
            System.out.print("请输入新密码:");
            String password = sc.next();
            System.out.print("请再次输入新密码:");
            String password2 = sc.next();
            // 判断两次输入的新密码是否一致
            if(password.equals(password2)){
                // 如果两次密码输入一致,则修改密码
                account.setPassword(password);
                System.out.println("提示:密码修改成功,请重新登录");
                new Start().login();
            } else{
                System.out.println("错误:两次密码输入不一致,请重新输入");
            }
        }else{
            System.out.println("错误:您输入的原密码不正确!");
        }
        showMenu();
    }

    public void logout(){
        System.out.println("提示:成功退出登录!");
        new Start().showMenu();
    }


}
