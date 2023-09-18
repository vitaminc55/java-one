package com.itany.corejava.code17_设计模式.静态代理;

/**
 * @author 石小俊
 * @date 2023年09月18日 16:42
 * 目标类,做具体的业务逻辑
 */
public class OtherServiceImpl implements OtherService {
    @Override
    public void doSome() {
        System.out.println("OtherServiceImpl.doSome");
    }

    @Override
    public void doOther() {
        System.out.println("OtherServiceImpl.doOther");
    }
}
