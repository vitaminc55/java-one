package com.itany.corejava.code08_常用类.泛型;

/**
 * @author 石小俊
 * @date 2023年08月25日 15:09
 */
public class User implements CompareInterface<User> {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(User user) {
        if (this.name.length() > user.getName().length()) {
            return 1;
        } else if (this.name.length() == user.getName().length()) {
            return 0;
        } else {
            return -1;
        }
    }
}
