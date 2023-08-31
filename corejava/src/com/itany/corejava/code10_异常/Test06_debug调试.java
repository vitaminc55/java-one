package com.itany.corejava.code10_异常;

/**
 * @author 石小俊
 * @date 2023年08月31日 10:25
 */
public class Test06_debug调试 {

    public static void main(String[] args) {
        UserController userController = new UserController();
        userController.register("aaa", "123456");
    }

}

class UserDao {
    public void insertUser(String username, String password) {
        System.out.println("添加成功");
    }
}

class UserService {
    public void register(String username, String password) throws UserExistException {
        UserDao userDao = new UserDao();
        if ("admin".equals(username)) {
            throw new UserExistException("该用户已经被注册");
        }
        userDao.insertUser(username, password);
    }
}

class UserController {
    public void register(String username, String password) {
        UserService userService = new UserService();
        try {
            userService.register(username, password);
            for (int i = 0; i < 5; i++) {
                System.out.println(i);
            }
        } catch (UserExistException e) {
            System.err.println("错误:" + e.getMessage());
        }
    }
}