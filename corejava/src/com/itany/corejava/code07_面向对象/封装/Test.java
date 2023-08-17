package com.itany.corejava.code07_面向对象.封装;

/**
 * @author 石小俊
 * @date 2023年08月17日 11:15
 */
public class Test {
    public static void main(String[] args) {
        User user = new User();
        // 赋值
        user.setId(1);
        user.setUsername("admin");
        user.setPassword("123456");
        user.setStatus(true);

        // 取值
        System.out.println(user.getId());
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getStatus());
        System.out.println(user.isStatus());
    }
}
