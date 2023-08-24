package com.itany.corejava.code08_常用类.string;

import java.util.Scanner;

/**
 * @author 石小俊
 * @date 2023年08月24日 9:09
 */
public class Test08_练习 {
    public static void main(String[] args) {
//      checkPhone();
//       checkPersonId();
//       checkEmail();
        checkUsername();
    }

    /**
     * 1.在控制台输入一个手机号码,判断手机号码格式是否正确
     * 手机号码格式如果正确,则返回手机号码格式正确
     * 手机号码格式如果不正确,手机号码格式不正确,请重新输入,且必须重新输入,直到正确为止
     * 手机号码由11位数字组成,必须以13、15、16、18、19开头
     */
    public static void checkPhone() {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入一个手机号码:");
        String phone = sc.next();
        if (phone.matches("1[35689]\\d{9}")) {
            System.out.println("手机号码格式正确");
        } else {
            System.out.println("手机号码格式不正确,请重新输入!");
            checkPhone();
        }
    }

    /**
     * 2.在控制台输入一个身份证号码,判断身份证号码格式是否正确
     * 身份证号码只能是15位或者18位字符
     * 如果是15位,要求必须全部是数字
     * 如果是18位,要求前17位必须全部是数字,最后一位可以是数字或者X
     */
    public static void checkPersonId() {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入一个身份证号码:");
        String personId = sc.next();
        if (personId.matches("\\d{15}(\\d{2}[0-9x])?")) {
            System.out.println("身份证号码格式正确");
        } else {
            System.out.println("身份证号码格式不正确,请重新输入!");
            checkPersonId();
        }
    }

    /**
     * 3.在控制台输入一个电子邮箱,判断电子邮箱格式是否正确
     * 要求邮箱必须以英文字母或者数字开头,后面可以跟英文字母数字或者下划线
     * 后面跟@符号,@符号后面跟英文字母或者数字
     * 以.com或者.com.cn结尾
     */
    public static void checkEmail() {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入一个电子邮箱号码:");
        String email = sc.next();
        if (email.matches("[a-zA-Z0-9]\\w+@[0-9a-zA-Z]+\\.com(\\.cn)?")) {
            System.out.println("电子邮箱号码格式正确");
        } else {
            System.out.println("电子邮箱号码格式不正确,请重新输入!");
            checkEmail();
        }
    }

    /**
     * 4.在控制台输入一个用户名,判断用户名格式是否正确
     * 用户名由字母、数字、下划线、点、减号组成,只能以数字字母开头和结尾,长度4-18位
     */
    public static void checkUsername() {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入一个用户名:");
        String username = sc.next();
        if (username.matches("[0-9a-zA-Z][0-9a-zA-Z_\\.-]{2,16}[0-9a-zA-Z]")) {
            System.out.println("用户名格式正确");
        } else {
            System.out.println("用户名格式不正确,请重新输入!");
            checkUsername();
        }
    }
}
