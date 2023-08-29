package com.itany.corejava.code09_集合.set;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author 石小俊
 * @date 2023年08月29日 16:11
 */
public class Test07_Comparator {
    public static void main(String[] args) {
        Set<User> users = new TreeSet<>(new UserComparator());
        users.add(new User("admin", 18));
        users.add(new User("alice", 21));
        users.add(new User("jack", 18));
        users.add(new User("tom", 20));
        System.out.println(users);
    }
}
