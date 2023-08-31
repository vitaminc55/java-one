package com.itany.corejava.code10_异常;

/**
 * @author 石小俊
 * @date 2023年08月31日 9:17
 */
public class Test04_自定义异常 {
    public static void main(String[] args) {
        try {
            register("admin","123456");
        } catch (UserExistException e) {
            System.err.println(e.getMessage());
        }
    }


    public static void register(String username,String password) throws UserExistException {
        if("admin".equals(username)){
            throw new UserExistException("此用户名太受欢迎,请更换一个");
        }
    }
}

