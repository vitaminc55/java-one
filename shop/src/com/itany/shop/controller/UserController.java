package com.itany.shop.controller;

import java.util.Scanner;

/**
 * @author 石小俊
 * @date 2023年09月19日 11:19
 */
public class UserController {
    private Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        new UserController().showMenu();
    }

    public void showMenu() {
        System.out.println("***************欢迎访问网络商城***************");
        System.out.print("请选择服务(1.注册 2.登录 3.查看商品列表):");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                register();
                break;
            case 2:
                login();
                break;
            case 3:
                findAll();
                break;
            default:
                System.out.println("您输入的选项有误,请重新输入");
                showMenu();
                break;

        }
    }

    public void register() {

    }

    public void login() {

    }

    public void findAll() {

    }
}
