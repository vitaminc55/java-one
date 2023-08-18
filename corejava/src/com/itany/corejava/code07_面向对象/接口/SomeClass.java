package com.itany.corejava.code07_面向对象.接口;

/**
 * @author 石小俊
 * @date 2023年08月18日 15:11
 */
public class SomeClass implements SomeInterface {
    @Override
    public void doSome() {
        System.out.println("SomeClass.doSome");
    }

    @Override
    public void doOther() {
        System.out.println("SomeClass.doOther");
    }
}
