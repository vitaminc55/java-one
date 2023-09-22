package com.itany.shop.controller;

import com.itany.shop.entity.Product;
import com.itany.shop.entity.User;
import com.itany.shop.exception.RequestParameterErrorException;
import com.itany.shop.exception.UserExistException;
import com.itany.shop.factory.ObjectFactory;
import com.itany.shop.service.ProductService;
import com.itany.shop.service.UserService;
import com.itany.shop.util.PageInfo;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.Scanner;

/**
 * @author 石小俊
 * @date 2023年09月19日 11:19
 */
public class UserController {
    private Scanner sc = new Scanner(System.in);
    private UserService userService= (UserService) ObjectFactory.getObject("userService");
    private ProductService productService= (ProductService) ObjectFactory.getObject("productService");

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
            userService.register(username,password,phone,address);
            System.out.println("注册成功");
        } catch (RequestParameterErrorException e) {
            System.out.println("注册失败,失败原因:" + e.getMessage());
        } catch (UserExistException e) {
            System.out.println("注册失败,失败原因:" + e.getMessage());
        }
        showMenu();
    }

    public void login() {
        System.out.print("请输入用户名:");
        String username = sc.next();
        System.out.print("请输入密码:");
        String password = sc.next();
        try {
            User user= userService.login(username,password);
            if (user==null){
                throw new UserPrincipalNotFoundException("用户名或密码错误");
            }
            System.out.println("登录成功");
            MainController mainController=new MainController(user);
            mainController.showMenu();
        } catch (RequestParameterErrorException e) {
            System.out.println("登录失败,失败原因:" + e.getMessage());
            showMenu();
        } catch (UserPrincipalNotFoundException e) {
            System.out.println("登录失败,失败原因:" + e.getMessage());
            showMenu();
        } catch (UserExistException e) {
            System.out.println("登录失败,失败原因:" + e.getMessage());
            showMenu();
        }
    }

    public void findAll() {
//        List<Product> products = productService.findAll();
//        if (!products.isEmpty()) {
//            System.out.println("--------------------------------------");
//            System.out.println("商品编号\t\t商品名称\t\t商品单价");
//            for (Product product : products) {
//                System.out.println(product.getId() + "\t\t" + product.getName() + "\t\t" + product.getPrice());
//            }
//            System.out.println("--------------------------------------");
//        }
        System.out.print("请输入查询第几页数据:");
        String pageNo = sc.next();
        System.out.print("请输入每页显示多少条数据:");
        String pageSize = sc.next();
        PageInfo<Product> pageProduct = productService.findPage(pageNo, pageSize);
        List<Product> products = pageProduct.getList();
        if (!products.isEmpty()) {
            System.out.println("--------------------------------------");
            System.out.println("商品编号\t\t商品名称\t\t商品单价");
            for (Product product : products) {
                System.out.println(product.getId() + "\t\t" + product.getName() + "\t\t" + product.getPrice());
            }
        }
        System.out.println("当前页:" + pageNo + ",上一页:" + pageProduct.getPrePage() + ",下一页:" + pageProduct.getNextPage());
        System.out.println("--------------------------------------");


        showMenu();
    }
}
