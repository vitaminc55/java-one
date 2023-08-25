package com.itany.corejava.code08_常用类.泛型;

/**
 * @author 石小俊
 * @date 2023年08月25日 15:02
 */
public class Test02_泛型接口 {

    public static void main(String[] args) {
        Person person = new Person("admin", 18);
        Person person2 = new Person("jack", 20);

        int result = person.compareTo(person2);
        if (result > 0) {
            System.out.println(person.getName() + "比" + person2.getName() + "大");
        } else if (result == 0) {
            System.out.println(person.getName() + "与" + person2.getName() + "一样大");
        } else {
            System.out.println(person.getName() + "比" + person2.getName() + "小");
        }

        System.out.println("***************************");

        User user = new User("admin", 18);
        User user2 = new User("jack", 20);
        result = user.compareTo(user2);
        if (result > 0) {
            System.out.println(user.getName() + "比" + user2.getName() + "大");
        } else if (result == 0) {
            System.out.println(user.getName() + "与" + user2.getName() + "一样大");
        } else {
            System.out.println(user.getName() + "比" + user2.getName() + "小");
        }
    }

}

