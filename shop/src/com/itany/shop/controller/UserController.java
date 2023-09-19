package com.itany.shop.controller;

import com.itany.shop.exception.RequestParameterErrorException;
import com.itany.shop.exception.UserExistException;
import com.itany.shop.factory.ObjectFactory;
import com.itany.shop.service.UserService;

import java.util.Scanner;

/**
 * @author 石小俊
 * @date 2023年09月19日 11:19
 */
public class UserController {
    private Scanner sc = new Scanner(System.in);
    private UserService userService = (UserService) ObjectFactory.getObject("userService");

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
        System.out.print("请输入用户名:");
        String username = sc.next();
        System.out.print("请输入密码:");
        String password = sc.next();
        System.out.print("请输入电话:");
        String phone = sc.next();
        System.out.print("请输入地址:");
        String address = sc.next();

        try {
            // 调用业务层方法实现注册功能
            userService.register(username, password, phone, address);
            System.out.println("注册成功");
        } catch (RequestParameterErrorException e) {
            System.out.println("注册失败,失败原因:" + e.getMessage());
        } catch (UserExistException e) {
            System.out.println("注册失败,失败原因:" + e.getMessage());
        }
        showMenu();
    }

    public void login() {

    }

    public void findAll() {

    }
}
