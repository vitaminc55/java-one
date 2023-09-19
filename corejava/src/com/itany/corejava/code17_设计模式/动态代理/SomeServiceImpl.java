package com.itany.corejava.code17_设计模式.动态代理;

/**
 * @author 石小俊
 * @date 2023年09月18日 16:39
 * 目标类,做具体的业务逻辑
 */
public class SomeServiceImpl implements SomeSerivce {
    @Override
    public void doSome() {
        System.out.println("SomeServiceImpl.doSome");
    }

    @Override
    public void doOther() {
        System.out.println("SomeServiceImpl.doOther");
    }
}
