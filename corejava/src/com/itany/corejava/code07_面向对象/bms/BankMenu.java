package com.itany.corejava.code07_面向对象.bms;

/**
 * @author 石小俊
 * @date 2023年08月21日 15:53
 */
public class BankMenu {
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

    public void showMenu(){
        System.out.println("************************欢迎"+account.getName()+"进入银行主菜单************************");
        System.out.print("请选择服务功能(1.存款 2.取款 3.查询余额 4.转账 5.贷款 6.还贷 7.修改密码 8.退出登录):");
    }



}
