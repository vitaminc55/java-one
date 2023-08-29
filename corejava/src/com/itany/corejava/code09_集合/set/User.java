package com.itany.corejava.code09_集合.set;

/**
 * @author 石小俊
 * @date 2023年08月29日 15:42
 */
public class User implements Comparable<User> {
    private String name;
    private int age;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

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

    /**
     * 比较方法,自定义比较规则
     * 根据年龄进行升序比较
     * @param user
     * @return
     */
    @Override
    public int compareTo(User user) {
        if (this.age > user.getAge()) {
            return 1;
        } else if (this.age < user.getAge()) {
            return -1;
        } else {
            // 当年龄相等,还可以继续定义比较规则
            // 根据姓名的长度进行降序排序
            if (this.name.length() > user.getName().length()) {
                return -1;
            } else if (this.name.length() < user.getName().length()) {
                return 1;
            }
            return 0;
        }
    }
}
