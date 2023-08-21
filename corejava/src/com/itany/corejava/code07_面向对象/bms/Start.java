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

    public void register(){
        System.out.print("请选择开户的账户类型(1.储蓄账户 2.信用账户 3.贷款的储蓄账户 4.贷款的信用账户):");
        int choice = sc.nextInt();
        Account account = null;
        switch (choice){

        }
        // 输入姓名、密码、身份证号码、手机号码
        // 密码需要输入两次,两次必须一致
        // 如果两次输入的密码不一致,则重新输入,一直到一致为止
        // 账户余额初始为0

        // 如果是储蓄账户,直接开户
        // 如果是信用账户,需要设置透支额度

        // 信息全部输入完成之后,需要保存到银行系统
        // 因此,调用银行类中提供的开户功能实现开户
        showMenu();
    }

    public void login(){
        // 输入卡号与密码
        // 根据银行提供的登录方法,判断是否登录成功
        // 如果登录成功,则进入到银行主菜单
        // 如果登录失败,返回系统入口重新登录
    }

}
