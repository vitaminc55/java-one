package com.itany.corejava.code16_反射;

/**
 * @author 石小俊
 * @date 2023年09月18日 9:40
 */
@SomeAnnotation(age = 18)
@OtherAnnotation
public class Student {

    private Integer id;
    @SomeAnnotation
    private String name;
    @SomeAnnotation
    private int age;

    @SomeAnnotation(age = 18)
    @OtherAnnotation(methods = {"get", "post"})
    public void study() {
        System.out.println("id:" + id + ",name:" + name + ",age:" + age);
    }

}
