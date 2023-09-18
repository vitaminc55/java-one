package com.itany.corejava.code17_设计模式.单例模式;

/**
 * @author 石小俊
 * @date 2023年09月18日 13:48
 */
public class Test01_单例模式 {

    public static void main(String[] args) {
        SomeBean someBean = SomeBean.getInstance();
        SomeBean someBean2 = SomeBean.getInstance();
        SomeBean someBean3 = SomeBean.getInstance();
        System.out.println(someBean == someBean2);
        System.out.println(someBean2 == someBean3);
    }

}
