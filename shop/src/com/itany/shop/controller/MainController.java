package com.itany.shop.controller;

import com.itany.shop.entity.Item;
import com.itany.shop.entity.Order;
import com.itany.shop.entity.Product;
import com.itany.shop.entity.User;
import com.itany.shop.exception.ProductNotExistException;
import com.itany.shop.exception.RequestParameterErrorException;
import com.itany.shop.exception.UserNotLoginException;
import com.itany.shop.factory.ObjectFactory;
import com.itany.shop.service.CartService;
import com.itany.shop.service.OrderService;
import com.itany.shop.service.ProductService;
import com.itany.shop.service.UserService;
import com.itany.shop.vo.Cart;

import java.util.List;
import java.util.Scanner;

/**
 * @author 石小俊
 * @date 2023年09月19日 11:18
 */
public class MainController {

    // 当前登录进来的用户
    private User user;
    private Scanner sc = new Scanner(System.in);
    public Cart cart = new Cart();
    private UserController userController=new UserController();
    UserService userService= (UserService) ObjectFactory.getObject("userService");
    ProductService productService= (ProductService) ObjectFactory.getObject("productService");
    CartService cartService= (CartService) ObjectFactory.getObject("cartService");
    OrderService orderService= (OrderService) ObjectFactory.getObject("orderService");
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
        List<Product> products= productService.findAll();
        if (!products.isEmpty()){
            System.out.println("--------------------------------------");
            System.out.println("商品编号\t\t商品名称\t\t商品单价");
            for (Product product : products) {
                System.out.println(product.getId() + "\t\t" + product.getName() + "\t\t" + product.getPrice());
            }
            System.out.println("--------------------------------------");
        }
        System.out.print("请输入要添加的商品编号");
        String id=sc.next();
        try {
            cartService.addCart(cart,id);
            System.out.println("加入成功");
        } catch (UserNotLoginException e) {
            System.out.println("加入失败,失败原因:" + e.getMessage());
        } catch (RequestParameterErrorException e) {
            System.out.println("加入失败,失败原因:" + e.getMessage());
        } catch (ProductNotExistException e) {
            System.out.println("加入失败,失败原因:" + e.getMessage());
        }
        showMenu();
    }

    public void showCart(){
        // 查看
        System.out.println("商品编号"+"\t\t"+"商品名"+"\t\t"+"数量"+"\t\t"+"价格");
        for (Item item: cart.getItems()){
            System.out.println(item.getProduct().getId()+"\t\t"+item.getProduct().getName()+"\t\t"+item.getNum()+"\t\t"+item.getPrice());
        }
        System.out.println("-------------------------------------------");
        System.out.println("总价格"+cart.getPrice());
        System.out.println("-------------------------------------------");
        System.out.print("请选择服务(1.删除商品 2.修改商品数量 3.清空购物车 4.结算 5.返回主菜单):");
        int choice=sc.nextInt();
        switch (choice) {
            case 1:
                System.out.print("请输入需要删除的商品编号");
                String id=sc.next();
                try {
                    cartService.delete(cart,id);
                    System.out.println("删除成功");
                } catch (UserNotLoginException e) {
                    System.out.println("删除失败,失败原因:" + e.getMessage());
                } catch (RequestParameterErrorException e) {
                    System.out.println("删除失败,失败原因:" + e.getMessage());
                } catch (ProductNotExistException e) {
                    System.out.println("删除失败,失败原因:" + e.getMessage());
                }
                showMenu();
                break;
            case 2:
                System.out.print("请输入需要修改的商品编号");
                String id1=sc.next();
                System.out.print("请输入需要修改的商品编数量");
                String num=sc.next();
                try {
                    cartService.update(cart,id1,num);
                    System.out.println("修改成功");
                } catch (UserNotLoginException e) {
                    System.out.println("修改失败,失败原因:" + e.getMessage());
                } catch (RequestParameterErrorException e) {
                    System.out.println("修改失败,失败原因:" + e.getMessage());
                } catch (ProductNotExistException e) {
                    System.out.println("修改失败,失败原因:" + e.getMessage());
                }
                showMenu();
                break;
            case 3:
                try {
                    cartService.deleteAll(cart);
                    System.out.println("清空成功");
                } catch (UserNotLoginException e) {
                    System.out.println("清空失败,失败原因:" + e.getMessage());
                }
                showMenu();
                break;
            case 4:
                createOrder();
                break;
            case 5:
                showMenu();
                break;
            default:
                System.out.println("您输入选项有误,请重新输入!");
                showCart();
                break;
        }

    }
    public void createOrder(){
        System.out.println("请确认生成订单:输入1");
        int c=sc.nextInt();
        if (c==1){
            try {
                orderService.createOrder(cart,user);
                cart=new Cart();
                System.out.println("成功");
            } catch (UserNotLoginException e) {
                System.out.println("错误:结算失败,失败原因:" + e.getMessage());
            }
            showMenu();
        }else{
            System.out.println("您输入的有误，请重新输入");
            createOrder();
        }
    }
    public void findMyOrders(){
        try {
            System.out.println("您的订单表如下：");
            List<Order> orders = orderService.selectAllOrder(user);
            System.out.println("订单ID\t\t"+"订单编号\t\t"+"订单价格\t\t"+"用户ID");
            for (Order order:orders){
                System.out.println(order.getId()+"\t\t"+order.getNo()+"\t\t"+order.getPrice()+"\t\t"+order.getUser().getId());
            }
            System.out.println("1.查看订单详情 2.返回主菜单");
        } catch (UserNotLoginException e) {
            System.out.println("错误:查询失败,失败原因:" + e.getMessage());
        }
        // 详情控制台展示下面效果,且涉及到的所有数据通过一条sql语句获取
//        用户名:xxx
//        手机号:xxx
//        ------------------------------------
//        编号  商品名   数量     总价
//        1	    aaa		2		5.0
//        2	    bbb		1		4.0
//        3	    ccc		3		12.0
//        -----------------------------------
//        共:21.0元	总计:3条

        int choice=sc.nextInt();
        switch (choice){
            case 1:
                try {
                    System.out.print("请输入需要查看的订单ID");
                    Long id=sc.nextLong();
                    Order order = orderService.selectByOrderId(id);
                    System.out.println("用户名："+order.getUser().getUsername());
                    System.out.println("手机号："+order.getUser().getPhone());
                    System.out.println("---------------------------------------");
                    System.out.println("编号"+"\t\t"+"商品名"+"\t\t"+"数量"+"\t\t"+"总价");
                    List<Item> items = order.getItems();
                    for (Item item:items){
                        System.out.println(item.getProduct().getId() + "\t\t" + item.getProduct().getName() + "\t\t" + item.getNum() + "\t\t" + item.getPrice());
                    }
                    System.out.println("---------------------------------------");
                    System.out.println("共："+order.getPrice()+"元"+"\t\t"+"总计："+items.size()+"条");
                } catch (RequestParameterErrorException e) {
                    System.out.println("失败");
                }
                showMenu();
                break;
            case 2:
                showMenu();
                break;
            default:
                System.out.println("您输入选项有误,请重新输入!");
                findMyOrders();
                break;
        }
    }

    public void modifyPassword(){
        try {
            System.out.print("请输入修改后的密码");
            String password=sc.next();
            userService.modifyPassword(user.getUsername(),password);
            System.out.println("修改成功");
        } catch (RequestParameterErrorException e) {
            System.out.println("错误" + e.getMessage());
        }
        userController.showMenu();
    }

    public void logout(){
        userController.showMenu();
    }

}
