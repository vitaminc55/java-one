package com.itany.corejava.code10_异常;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author 石小俊
 * @date 2023年09月01日 9:24
 */
public class Test07_练习 {

    static List<User> users = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        showMenu();
    }

    public static void showMenu() {
        System.out.println("****************欢迎来到用户管理系统****************");
        System.out.print("请选择服务的功能(1.注册 2.登录 3.修改密码 4.退出):");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                // 注册
                try {
                    register();
                    System.out.println("提示:恭喜您,注册成功");
                } catch (UserExistException e) {
                    System.err.println(e.getMessage());
                } catch (PasswordErrorException e) {
                    System.err.println(e.getMessage());
                } finally {
                    showMenu();
                }
                break;
            case 2:
                // 登录
                try {
                    User user = login();
                    System.out.println("提示:欢迎您:" + user.getUsername() + "用户");
                } catch (UserNotExistException e) {
                    System.err.println(e.getMessage());
                } catch (PasswordErrorException e) {
                    System.err.println(e.getMessage());
                } finally {
                    showMenu();
                }
                break;
            case 3:
                // 修改密码
                try {
                    modifyPassword();
                    System.out.println("提示:恭喜您,密码修改成功");
                } catch (UserNotExistException e) {
                    System.err.println(e.getMessage());
                } catch (PasswordErrorException e) {
                    System.err.println(e.getMessage());
                } finally {
                    showMenu();
                }
                break;
            case 4:
                // 退出
                System.out.println("提示:您已经成功退出,欢迎下次光临!");
                break;
            default:
                System.out.println("错误:您输入的选项有误,请重新输入!");
                showMenu();
                break;
        }
    }

    /**
     * 注册,注册时用户名不能重复,注册时密码需要输入两次,两次的密码必须一致
     */
    public static void register() throws UserExistException, PasswordErrorException {
        System.out.println("****************开始注册****************");
        User user = new User();
        System.out.print("请输入用户名:");
        String username = sc.next();
        User selectUser = findByUsername(username);
        if (selectUser != null) {
            throw new UserExistException("错误:此用户名太受欢迎,请更换一个!");
        }
        // 如果没有被注册,则继续注册流程
        user.setUsername(username);
        System.out.print("请输入密码:");
        String password = sc.next();
        System.out.print("请再次输入密码:");
        String password2 = sc.next();
        if (!password.equals(password2)) {
            throw new PasswordErrorException("错误:两次输入的密码不一致,请重新输入!");
        }
        user.setPassword(password);
        System.out.print("请输入手机号码:");
        user.setPhone(sc.next());
        System.out.print("请输入地址:");
        user.setAddress(sc.next());

        // 添加用户到集合中
        users.add(user);

    }

    /**
     * 登录,根据用户名与密码进行登录,登录的用户必须是注册过的用户
     * 登录成功返回:欢迎您:xxx用户
     */
    public static User login() throws UserNotExistException, PasswordErrorException {
        System.out.println("****************开始登录****************");
        System.out.print("请输入用户名:");
        String username = sc.next();
        User user = findByUsername(username);
        if (user == null) {
            throw new UserNotExistException("错误:该用户不存在,请检查用户名是否正确!");
        }
        System.out.print("请输入密码:");
        String password = sc.next();
        if (!password.equals(user.getPassword())) {
            throw new PasswordErrorException("错误:您输入的密码不正确,请重新输入!");
        }
        return user;
    }

    /**
     * 修改密码,控制台输入一个需要修改密码的用户名,修改指定用户的密码
     * 修改密码时指定的用户必须存在
     * 修改密码时需要输入原密码,只有原密码正确才能修改
     * 修改密码时输入的两次新密码必须一致
     */
    public static void modifyPassword() throws UserNotExistException, PasswordErrorException {
        System.out.println("****************修改密码****************");
        System.out.print("请输入需要哪个用户的密码:");
        String username = sc.next();
        // 判断该用户是否存在
        User user = findByUsername(username);
        if (user == null) {
            throw new UserNotExistException("错误:您指定的用户不存在,请重新输入");
        }

        // 修改密码时需要先验证原密码是否正确
        System.out.print("请输入原密码:");
        String oldPassword = sc.next();
        if (!oldPassword.equals(user.getPassword())) {
            throw new PasswordErrorException("错误:原密码不正确!");
        }

        System.out.print("请输入新密码:");
        String password = sc.next();
        System.out.print("请再次输入新密码:");
        String password2 = sc.next();
        if (!password.equals(password2)) {
            throw new PasswordErrorException("错误:两次输入的密码不一致,请重新输入!");
        }
        user.setPassword(password);
    }

    /**
     * 根据用户名查询用户信息
     *
     * @param username 用户名
     * @return 返回的用户信息, 如果没有查询到结果, 则返回null
     */
    public static User findByUsername(String username) {
        for (User user : users) {
            if (username.equals(user.getUsername())) {
                return user;
            }
        }
        return null;
    }

}
