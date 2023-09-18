package com.itany.corejava.code17_设计模式.单例模式;

/**
 * @author 石小俊
 * @date 2023年09月18日 13:48
 * 饿汉模式:在类加载的时候创建实例,不管后期是否使用都进行创建
 */
public class SomeBean {

    // 1.构造方法私有化,确保外部不能创建对象
    private SomeBean() {

    }

    // 2.在类加载时创建实例,创建好的实例需要向外部提供
    // 此时通过静态属性来创建实例
    // 根据封装原则,属性也需要私有化
    private static SomeBean someBean = new SomeBean();

    // 3.提供外部访问到内部实例化的对象的方式
    // 由于创建好的实例需要向外部提供访问
    // 因此,创建一个供外部访问的方法,该方法返回内部实例化的对象
    // 由于外部无法创建对象,因此该方法必须是静态方法
    public static SomeBean getInstance() {
        return someBean;
    }
}
