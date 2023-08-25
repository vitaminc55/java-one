package com.itany.corejava.code08_常用类.泛型;

/**
 * @author 石小俊
 * @date 2023年08月25日 15:06
 */
public class Person implements CompareInterface<Person> {
    private String name;
    private int age;

    public Person(String name, int age) {
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
     * 实现比较规则
     * @param person
     * @return
     */
    @Override
    public int compareTo(Person person) {
        // 通过两个人的年龄大小进行比较
        if (this.age > person.getAge()) {
            return 1;
        } else if (this.age == person.getAge()) {
            return 0;
        } else {
            return -1;
        }
    }
}
