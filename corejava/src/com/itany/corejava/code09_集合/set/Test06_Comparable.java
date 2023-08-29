package com.itany.corejava.code09_集合.set;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author 石小俊
 * @date 2023年08月29日 15:42
 */
public class Test06_Comparable {
    public static void main(String[] args) {
        User user = new User("admin", 18);
        User user2 = new User("alice", 20);
        User user3 = new User("jack", 19);
        User user4 = new User("tom", 18);
        User user5 = new User("alice", 18);
        Set<User> users = new TreeSet<>();
        users.add(user);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
        System.out.println(users);
    }
}
