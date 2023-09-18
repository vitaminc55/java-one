package com.itany.corejava.code17_设计模式.单例模式;

/**
 * @author 石小俊
 * @date 2023年09月18日 14:07
 * 懒汉模式:在需要使用的时候才创建对应的实例
 * 线程不安全
 */
public class OtherBean {
    // 1.构造方法私有化
    private OtherBean() {

    }

    // 2.在类加载时声明对象的唯一实例,但是不进行实例化
    private static OtherBean otherBean;

    // 3.提供外部访问的方法
    // 在该方法中进行实例化
    public static OtherBean getInstance() {
        // 在进行实例化之前先进行判断
        // 判断是否已经创建过对象
        // 只有尚未创建对象的时候才需要去创建新的对象
        if (otherBean == null) {
            otherBean = new OtherBean();
        }
        // 如果已经创建过对象了,则直接返回
        return otherBean;
    }
}
