package com.itany.shop.controller;

import com.itany.shop.entity.User;

import java.util.Scanner;

/**
 * @author 石小俊
 * @date 2023年09月19日 11:18
 */
public class MainController {

    // 当前登录进来的用户
    private User user;
    private Scanner sc = new Scanner(System.in);

    public MainController(User user) {
        this.user = user;
    }

    public void showMenu(){
        System.out.println("***************欢迎成功登录网络商城***************");
        System.out.print("请选择服务(1.加入购物车 2.查看购物车 3.我的订单 4.修改密码 5.注销):");
        int choice = sc.nextInt();
        switch (choice){
            case 1:
                addCart();
                break;
            case 2:
                showCart();
                break;
            case 3:
                findMyOrders();
                break;
            case 4:
                modifyPassword();
                break;
            case 5:
                logout();
                break;
            default:
                System.out.println("您输入的选项有误,请重新输入!");
                showMenu();
                break;
        }
    }

    public void addCart(){

    }

    public void showCart(){
        // 查看

        System.out.print("请选择服务(1.删除商品 2.修改商品数量 3.清空购物车 4.结算 5.返回主菜单):");
    }

    public void findMyOrders(){

    }

    public void modifyPassword(){

    }

    public void logout(){

    }

}
