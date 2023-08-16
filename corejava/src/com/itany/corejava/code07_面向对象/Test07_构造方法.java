package com.itany.corejava.code07_面向对象;

/**
 * @author 石小俊
 * @date 2023年08月16日 16:11
 */
public class Test07_构造方法 {
    public static void main(String[] args) {
        User user = new User(1,"admin","123456");
        user.show();
    }
}
class User{
    int id;
    String username;
    String password;
    public User(){
        System.out.println("调用无参构造方法");
    }
    public User(int id){
        this.id = id;
        System.out.println("调用有参构造方法");
    }

    public User(String username,String password){
        this.username = username;
        this.password = password;
    }

    public User(int id,String username,String password){
        this(username,password);
        this.id = id;
    }

    public void show(){
        System.out.println("id:"+id+",username:"+username+",password:"+password);
    }
}
