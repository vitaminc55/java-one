package com.itany.corejava.code17_设计模式.静态代理;

/**
 * @author 石小俊
 * @date 2023年09月18日 16:49
 */
public class SomeServiceProxy implements SomeSerivce {

    private SomeSerivce someSerivce = new SomeServiceImpl();

    @Override
    public void doSome() {
        System.out.println("即将执行doSome");
        someSerivce.doSome();
        System.out.println("成功执行doSome");
    }

    @Override
    public void doOther() {

    }
}
