package com.itany.corejava.code10_异常;

/**
 * @author 石小俊
 * @date 2023年08月31日 9:41
 */
public class Test04_方法重写的异常问题 {
}

class A {
    public void show() throws Exception {
        Class.forName("aaa");
        int i = 1 / 0;
    }
}

class B extends A {
    @Override
    public void show() throws ClassNotFoundException {
        Class.forName("aaa");
    }
}
