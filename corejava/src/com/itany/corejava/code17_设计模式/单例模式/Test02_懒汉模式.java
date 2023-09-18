package com.itany.corejava.code17_设计模式.单例模式;

/**
 * @author 石小俊
 * @date 2023年09月18日 14:12
 */
public class Test02_懒汉模式 {
    public static void main(String[] args) {
        OtherBean otherBean = OtherBean.getInstance();
        OtherBean otherBean2 = OtherBean.getInstance();
        OtherBean otherBean3 = OtherBean.getInstance();
        System.out.println(otherBean == otherBean2);
        System.out.println(otherBean2 == otherBean3);
    }
}
