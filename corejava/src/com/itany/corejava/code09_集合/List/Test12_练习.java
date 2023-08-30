package com.itany.corejava.code09_集合.List;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author 石小俊
 * @date 2023年08月30日 9:21
 * 定义一个用户类User,属性:id、name、age,实现以下功能,每个功能一个方法
 * 1.添加用户信息,提示用户循环输入用户的信息,存储到ArrayList集合中
 * 2.查询所有用户信息,输出集合中所有用户的信息
 * 3.根据编号查询指定用户信息
 * 4.根据编号修改指定用户信息
 * 5.根据编号删除指定用户信息
 */
public class Test12_练习 {

    static Scanner sc = new Scanner(System.in);
    static List<User> users = new ArrayList<>();

    public static void main(String[] args) {
        showMenu();
    }


    public static void showMenu() {
        System.out.println("*******************欢迎来到用户管理系统*******************");
        System.out.print("请选择对应功能(1.添加用户信息 2.查询所有用户信息 3.根据编号查询用户 4.根据编号修改用户信息 5.根据编号删除指定用户 6.退出系统):");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                addUser();
                break;
            case 2:
                findAll();
                break;
            case 3:
                findById();
                break;
            case 4:
                modifyUser();
                break;
            case 5:
                deleteUser();
                break;
            case 6:
                System.out.println("您已经退出系统!");
                break;
            default:
                System.out.println("您输入的选项有误,请重新输入!");
                showMenu();
                break;
        }
    }

    /**
     * 添加用户信息,提示用户循环输入用户的信息,存储到ArrayList集合中
     */
    public static void addUser() {
        System.out.println("****************添加用户信息****************");
        User user = new User();
        System.out.print("请输入用户编号:");
        user.setId(sc.nextInt());
        System.out.print("请输入用户姓名:");
        user.setName(sc.next());
        System.out.print("请输入用户年龄:");
        user.setAge(sc.nextInt());
        // 将用户添加到集合中
        users.add(user);
        showMenu();
    }

    /**
     * 查询所有用户信息,输出集合中所有用户的信息
     */
    public static void findAll() {
        System.out.println("****************用户列表****************");
        System.out.println("编号\t姓名\t年龄");
        for (User user : users) {
            System.out.println(user.getId() + "\t" + user.getName() + "\t" + user.getAge());
        }
        showMenu();
    }

    /**
     * 根据编号查询指定用户信息
     */
    public static void findById() {
        System.out.println("****************根据编号查询指定用户信息****************");
        System.out.print("请输入需要查询的用户编号:");
        int id = sc.nextInt();

        User user = find(id);
        if (user == null) {
            System.out.println("错误:您查询的用户不存在,请检查编号是否正确!");
        } else {
            System.out.println("用户编号:" + user.getId() + ",用户姓名:" + user.getName() + ",用户年龄:" + user.getAge());
        }
        showMenu();
    }

    /**
     * 根据编号修改指定用户信息
     */
    public static void modifyUser() {
        System.out.println("****************根据编号修改指定用户信息****************");
        System.out.print("请输入需要查询的用户编号:");
        int id = sc.nextInt();

        User user = find(id);
        if (user == null) {
            System.out.println("错误:您想要修改的用户不存在,请检查编号是否正确!");
        } else {
            // 执行修改
            System.out.print("请输入用户姓名:");
            user.setName(sc.next());
            System.out.print("请输入用户年龄:");
            user.setAge(sc.nextInt());
            System.out.println("提示:修改成功!");
        }
        showMenu();
    }

    /**
     * 根据编号删除指定用户信息
     */
    public static void deleteUser() {
        System.out.println("****************根据编号修改指定用户信息****************");
        System.out.print("请输入需要查询的用户编号:");
        int id = sc.nextInt();

        User user = find(id);
        if (user == null) {
            System.out.println("错误:您想要删除的用户不存在,请检查编号是否正确!");
        } else {
            // 执行删除
            users.remove(user);
            System.out.println("提示:删除成功!");
        }
        showMenu();
    }

    public static User find(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }
}
